import socket

serverPort = 9008
serverSocket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
serverSocket.bind(('', serverPort))
buff = []

if __name__ == '__main__':
    print('PYTHON UDP SERVER')

    while True:

        buff, address = serverSocket.recvfrom(1024)
        print("python udp server received msg: " + str(buff, 'UTF-8'))

        if b'Java' in buff:
            serverSocket.sendto(bytes("Java Pong", 'UTF-8'),address)

        if b'Python' in buff:
            serverSocket.sendto(bytes("Python Pong", 'UTF-8'),address)       


