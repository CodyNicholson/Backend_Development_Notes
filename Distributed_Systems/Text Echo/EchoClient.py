#! python

#Echo client

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
	# read a message from standard input
	message= sys.stdin.readline()
	# create a communicator object
	sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	if argc == 3:
		server= sys.argv[2]
	else:
		server= 'localhost'
	sock.connect((server, int(sys.argv[1])))
	# transmit the message as bytes (which is what send/recv uses)
	print( 'attempting to send message using utf-8 encoding ...' )
	sock.send( message.encode() )
	# receive the return message from the server
	return_msg= sock.recv( 1024 )
	# TESTING!
	if return_msg:
		print( 'message returned: ' + return_msg.decode() )
	else:
		print( 'NOTHING RETURNED!' )
