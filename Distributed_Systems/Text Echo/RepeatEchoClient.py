#! python

#Repeat Echo client

def usage( script_name ):
    print( 'Usage: py ' + script_name + ' <port number>' + '[<server address>]' )

if __name__ == "__main__":
	# get the command line arguments
	import sys
	import socket
	argc= len( sys.argv )
	if argc < 2 or argc > 3 :
		usage( sys.argv[0] )
		sys.exit()
	# create a communicator object
	sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	if argc == 3:
		server= sys.argv[2]
	else:
		server= 'localhost'
	sock.connect((server, int(sys.argv[1])))	
	message= sys.stdin.readline() # read a message from standard input
	while message:
		sock.send( message.encode() )
		return_msg= sock.recv( 1024 )
		if return_msg:
			print( return_msg.decode() )
		else:
			print( '[NOTHING RETURNED!]' )
		message= sys.stdin.readline() # read another message
	sock.close()
