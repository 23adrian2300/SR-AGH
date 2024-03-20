import socket
import sys
from threading import Thread


# function for handling clients in TCP
def client_thread_tcp_fun():
    while True:
        try:
            data_tcp = client_socket_tcp.recv(1024)  # receive data from server
            data_tcp = str(data_tcp, 'utf-8')
            if data_tcp == "Server is closing":  # if server is closing
                print("Server is closing")
                global running  # set running to False
                running = False
                print("Please press enter to exit")
                sys.exit()
            if data_tcp:
                print("[Received]", data_tcp, "\n>>> ", end="")  # print received message
        except WindowsError:
            break

    client_socket_tcp.close()  # close connection with server
    client_socket_udp.close()  # close connection with server


# function for handling clients in UDP
def client_thread_udp_fun():
    while True:
        try:
            data_udp, addr = client_socket_udp.recvfrom(1024)  # receive data from server
            data_udp = str(data_udp, 'utf-8')
            print(f"[UDP] Received message from [{addr}]\n: {data_udp}")
            if data_udp:
                print("\n[Received]", data_udp, "\n>>> ", end="")  # print received message
        except WindowsError:
            break


if __name__ == '__main__':
    client_socket_tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # create TCP socket
    try:
        client_socket_tcp.connect(('localhost', 8001))
    except ConnectionRefusedError:
        print("Server is not running")
        sys.exit()

    client_thread_tcp = Thread(target=client_thread_tcp_fun)  # create new thread for client in TCP
    client_thread_tcp.daemon = True
    client_thread_tcp.start()
    running = True

    client_socket_udp = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)  # create UDP socket

    client_host_tcp, client_port_tcp = client_socket_tcp.getsockname()  # get client's port

    client_socket_udp.bind(('localhost', client_port_tcp))
    client_socket_udp.connect(('localhost', 8001))

    client_thread_udp = Thread(target=client_thread_udp_fun)
    client_thread_udp.daemon = True  # set server thread as daemon, so it will close when main thread closes
    client_thread_udp.start()

    nick = input("Enter your nickname: ")  # get nickname from user
    nick = f"-NICK_COMMAND {nick}"  # add -NICK_COMMAND to nickname
    client_socket_tcp.send(bytes(nick, 'utf-8'))  # send nickname to server

    while running:
        message = input(">>> ")  # get message from user
        if running is False:  # if server is closing
            sys.exit()
        if message == "U":  # if user wants to send ASCII ART
            print("Sending ASCII ART")
            try:
                with open("test.txt", "r") as file:
                    data = file.read()
                    client_socket_udp.sendto(bytes(data, 'utf-8'), ('localhost', 8001))
            except FileNotFoundError:
                print("File not found")
        elif message == "exit":  # if user wants to exit
            client_socket_tcp.send(bytes(message, 'utf-8'))  # send message to server to close connection
            sys.exit()
        elif message:
            try:
                client_socket_tcp.send(bytes(message, 'utf-8'))  # send message to server
            except WindowsError:
                sys.exit()
    sys.exit()
