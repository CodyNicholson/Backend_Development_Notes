#! python

#Repeat Echo server

def usage( script_name ):
    print( 'Usage: py ' + script_name + ' <port number>' )

if __name__ == "__main__":
	# get the command line arguments
	import sys
	import socket
	argc= len( sys.argv )
	if argc != 2 :
		usage( sys.argv[0] )
		sys.exit()
	# create a communicator object
	serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	serversocket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
	#serversocket.bind(('localhost', int(sys.argv[1])))
	serversocket.bind(('', int(sys.argv[1]))) # binds to any available interface
	serversocket.listen(5)
	# wait for a connection and accept it
	sock, addr= serversocket.accept()
	# receive the first message
	msg_bytes= sock.recv(1024)
	while msg_bytes:		
		sock.send(msg_bytes) # send the message back
		msg_bytes= sock.recv(1024) # get a new message
	sock.close() # close the socket
	serversocket.close() # close the server socket
