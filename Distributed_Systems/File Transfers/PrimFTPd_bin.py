#! python3

# PrimFTP binary server

def send_file( sock, file_size, file ):
	print( 'File size is ' + str(file_size) )
	file_size_bytes= struct.pack( '!L', file_size )
	# send the number of bytes in the file
	sock.send( file_size_bytes )
	# read the file and transmit its contents
	while True:
		file_bytes= file.read( 1024 )
		if file_bytes:
			sock.send( file_bytes )
		else:
			break
	file.close()

def no_file( sock ):
	zero_bytes= struct.pack( '!L', 0 )
	sock.send( zero_bytes )
	
def usage( script_name ):
    print( 'Usage: py ' + script_name + ' <port number>' )

if __name__ == "__main__":
	# get the command line arguments
	import sys, os, struct
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
	# check whether the file exists; if it does, send back the file size
	try:
		file_stat= os.stat( file_name )
		if file_stat.st_size:
			file= open( file_name, 'rb' )
			send_file( sock, file_stat.st_size, file )
		else:
			no_file( sock )
	except OSError:
		no_file( sock )
	sock.close()