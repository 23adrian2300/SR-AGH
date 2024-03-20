import socket

serverIP = "127.0.0.1"
serverPort = 9008
msg_bytes = (300).to_bytes(4, byteorder='little') #------------


if __name__ == "__main__":
    print('PYTHON UDP CLIENT')
    client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    client.sendto(msg_bytes, (serverIP, serverPort))

    recived_bytes, _ = client.recvfrom(4)
    recived_number = int.from_bytes(recived_bytes, byteorder='little')
    print(f"Recived msg: {recived_number}")


