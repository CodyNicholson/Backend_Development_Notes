def receive_data(soc):
    while True:
        mes = soc.recv(1024)
        if not mes: os._exit(0)
        print(mes.decode(), end='')

if __name__ == "__main__":
    import os
    import sys
    import socket
    from threading import Thread

    # Check for correct num arguments
    if len(sys.argv) != 2:
        sys.exit()

    # Create socket and attempt to connect
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.connect(('localhost', int(sys.argv[1])))

    # Get user name
    print("Please enter your name\n", end='')
    message = sys.stdin.readline()
    print("Sending name to server\n", end='')

    # Create and start thread
    thread = Thread(target=receive_data, args = (sock,))
    thread.start()

    # While user input is not null, send input
    while message:
        sock.send(message.encode())
        message = sys.stdin.readline()

    # Remove socket
    sock.shutdown(socket.SHUT_RDWR)
    sock.close()
