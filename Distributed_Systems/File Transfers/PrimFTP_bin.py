#! python3

# PrimFTP binary client

def receive_file( sock, filename ):
	# receive the file lines returned from the server
	file= open( filename, 'wb' )
	while True:
		file_bytes= sock.recv( 1024 )
		if file_bytes:
			file.write( file_bytes )
		else:
			break
	file.close()

def usage( script_name ):
    print( 'Usage: py ' + script_name + ' <port number>' )

if __name__ == "__main__":
	# get the command line arguments
	import sys, struct
	import socket
	argc= len( sys.argv )
	if argc != 2 :
		usage( sys.argv[0] )
		sys.exit()
	# read a file name from standard input
	filename= sys.stdin.readline().rstrip( '\n' )
	# create a communicator object
	sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	sock.connect(('localhost', int(sys.argv[1])))
	# transmit the file name
	sock.send( filename.encode() )
	# receive the file size; if empty, exit
	file_size_bytes= sock.recv( 4 )
	if file_size_bytes:
		file_size= struct.unpack( '!L', file_size_bytes[:4] )[0]
		if file_size:
			receive_file( sock, filename )
		else:
			print( 'File does not exist or is empty' )
	else:
		print( 'File does not exist or is empty' )
	sock.close()
