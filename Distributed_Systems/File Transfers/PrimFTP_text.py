#! python

#PrimFTP text client

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
	# read a file name from standard input
	filename= sys.stdin.readline().rstrip( '\n' )
	# create a communicator object
	sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	sock.connect(('localhost', int(sys.argv[1])))
	# transmit the file name as bytes (which is what send/recv uses)
	sock.send( filename.encode() )
	# receive a message as to whether the file exists
	message= sock.recv( 1 ).decode()
	if message == '0':
		print( 'File does not exist or is empty' )
		sock.close()
		sys.exit()
	# receive the file lines returned from the server
	while True:
		line= sock.recv( 1024 )
		if line:
			print( line.decode(), end='' )
		else:
			break
	print()
