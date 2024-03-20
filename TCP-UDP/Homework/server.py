import socket
import sys
from threading import Thread


def search_nickname(address):
    for client_searching in available_clients:
        if client_searching[1] == address:
            return client_searching[2]


# function for handling clients in TCP
def client_thread_tcp_fun(client_socket, address):
    client_socket.send(" Welcome to the server".encode())
    my_nick = search_nickname(address)
    while True:
        try:
            data = client_socket.recv(1024)  # receive data from client
            data = str(data, 'utf-8')
            print(f"Received message from [{address}]: {data}")
            if data == "exit":  # if client wants to disconnect
                print(f"Client [{address}] disconnected")
                available_clients.remove((client_socket, address, my_nick))
                break
            if "-NICK_COMMAND" in data:  # if client wants to change nickname
                nick = data.split(" ")
                new_nick = nick[1]
                if new_nick not in [client_searching[2] for client_searching in
                                    available_clients]:  # if nickname is not in use
                    for a_client in available_clients:
                        if a_client[1] == address:  # change nickname of client
                            available_clients.remove((client_socket, address, a_client[2]))
                            available_clients.append((client_socket, address, new_nick))
                            my_nick = new_nick
                    print(f"Client [{address}] changed nick to {nick[1]}")
                else:
                    client_socket.send("Nick already in use".encode())  # if nickname is in use
                    client_socket.send("To change nick add '-NICK_COMMAND' to message".encode())
            if "-NICK_COMMAND" not in data:  # if client sends message
                for a_client in available_clients:
                    if a_client[1] != address:
                        if my_nick != "":
                            message = f"Message from [{my_nick}]: {data}"  # send message with nickname
                        else:
                            message = f"Message from [Id: {address[1]}]: {data}"  # send message without nickname
                        a_client[0].send(message.encode())
        except WindowsError:
            break
    client_socket.close()  # close connection with client


# function for handling clients in UDP
def client_thread_udp_fun(client_socket_udp):
    while True:
        try:
            data, address = client_socket_udp.recvfrom(1024)  # receive data from client
            data = str(data, 'utf-8')
            print(f"[UDP] Received message from [{address}]: {data}")
            if data:
                for a_client in available_clients:
                    if a_client[1] != address:
                        if len(a_client[2]) > 0 and a_client[2] != "":  # send message with nickname
                            message = f"(UDP) Message from [{search_nickname(address)}]:\n {data}"
                        else:
                            message = f"(UDP) Message from [Id: {address[1]}]:\n {data}"  # send message without nickname
                        a_client[0].sendto(message.encode(), a_client[1])
        except WindowsError:
            break


def server():
    while True:
        try:
            client_socket_tcp, address_tcp = server_socket_tcp.accept()  # accept new client
            available_clients.append((client_socket_tcp, address_tcp, ""))  # add client to list of available clients
            print(f"Connected with {address_tcp}")
            client_thread_tcp = Thread(target=client_thread_tcp_fun,
                                       args=(client_socket_tcp, address_tcp))  # create new thread for client in TCP
            client_thread_udp = Thread(target=client_thread_udp_fun,
                                       args=(server_socket_udp,))  # create new thread for client in UDP
            client_thread_tcp.start()  # start thread for client in TCP
            client_thread_udp.start()  # start thread for client in UDP
        except WindowsError:
            break  # if server is closing


if __name__ == '__main__':
    client_threads = []
    server_socket_tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # create TCP socket
    server_socket_tcp.bind(('localhost', 8001))
    server_socket_tcp.listen(100)  # listen for clients

    server_socket_udp = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)  # create UDP socket
    server_socket_udp.bind(('localhost', 8001))

    print("Server started")
    available_clients = []  # list of available clients (client_socket, address, nickname)

    server_thread = Thread(target=server)
    server_thread.daemon = True  # set server thread as daemon, so it will close when main thread closes (Ctrl+C is working properly)
    server_thread.start()

    # close server and all connections with clients when user types 'exit'
    while True:
        try:
            user_input = input("Type 'exit' to close the server")
        except KeyboardInterrupt:
            user_input = "exit"
            print("Closing server...")
        if user_input.strip().lower() == 'exit':
            print("Closing server...")
            server_socket_tcp.close()  # close TCP socket
            server_socket_udp.close()  # close UDP socket
            for client in available_clients:
                try:
                    client[0].sendall("Server is closing".encode())  # send message to client
                    client[0].close()  # close connection with client
                except WindowsError:
                    print(f"Client [{client[1]}] already disconnected")
            available_clients.clear()
            print("All connections closed")
            server_thread.join()  # close server thread
            sys.exit()
