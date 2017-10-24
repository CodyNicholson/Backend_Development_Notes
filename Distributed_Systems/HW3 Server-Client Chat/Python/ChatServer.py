# Only send data to other sockets, not your own
def send_data (sock, message):
    for socke in connection_list:
        if socke != server_socket and socke != sock:
            try:
                socke.send(message)
            except Exception as msg:
                print(type(msg).__name__)
                try:
                    connection_list.remove(socke)
                except ValueError as msg:
                    print("{}:{}".format(type(msg).__name__, msg))

if __name__ == "__main__":
    from threading import Thread
    import os
    import sys
    import socket
    import select
    import traceback

    # Exit if incorrect amount of arguments
    if len(sys.argv) != 2:
        usage(sys.argv[0])
        sys.exit()

    # Create arrays to hold sockets, client names, and client addresses
    connection_list = []
    name_list = []
    connection_name_list = []

    # Create server socket to listen for clients
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    server_socket.bind(('', int(sys.argv[1])))
    server_socket.listen(10)
    connection_list.append(server_socket)

    while True:
        # Wait until list is ready for reading and read
        read_sockets, write_sockets, error_sockets = select.select(connection_list,[],[])
        # For each socket
        for sock in read_sockets:
            # If you are the server, add socket to connection_list
            if sock == server_socket:
                sockfd, addr = server_socket.accept()
                connection_list.append(sockfd)
            # If you are a client...
            else:
                try:
                    # Receive data
                    data = sock.recv(1024)
                    # If data exists
                    if data:
                        # Get client address
                        clientAddr = str(sock.getpeername())
                        # If client address is new, add them to the connection name list and add their name to the name list
                        if(clientAddr not in connection_name_list):
                            connection_name_list.append(clientAddr)
                            name_list.append(str(data.decode()))
                        # If client address is not new, send data
                        else:
                            send_data(sock, (name_list[connection_name_list.index(clientAddr) ][:-1] + ': ' + data.decode()).encode())
                # If exception, close socket
                except Exception as msg:
                    print(type(msg).__name__, msg)
                    sock.shutdown(socket.SHUT_RDWR)
                    sock.close()
                    try:
                        connection_list.remove(sock)
                    except KeyboardInterrupt:
                        break
                    continue
    # Exit program, the users are done
    server_socket.close()
    os._exit(0)
