#! python

#Echo server

def usage( script_name ):
    print( 'Usage: py ' + script_name + ' <port number>' )

if __name__ == "__main__":
	# get the command line arguments
	import sys, os
	import socket
	argc= len( sys.argv )
	if argc != 2 :
		usage( sys.argv[0] )
		sys.exit()
	# create a listening object
	serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	serversocket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
	serversocket.bind(('localhost', int(sys.argv[1])))
	serversocket.listen(5)
	# wait for a connection and accept it
	sock, addr= serversocket.accept()
	# receive the message
	msg_bytes= sock.recv(1024)
	# convert the message into a string, which is the name of the desired file
	file_name= msg_bytes.decode()
	# check whether the file exists and send a message to client
	try:
		file_stat= os.stat( file_name )
		file_exists= True
	except FileNotFoundError:
		file_exists= False
	if (not file_exists) or (file_stat.st_size == 0):
		sock.send( '0'.encode() )
		sys.exit()
	sock.send( '1'.encode() )
	# open the file
	file= open( file_name )
	# read the file and transmit its contents
	for line in file:
		sock.send( line.encode() )
	# close the socket
	sock.close()
