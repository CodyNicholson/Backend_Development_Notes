#! python

# demo of command line arguments and standard input handling

# get the command line arguments
import sys
argc= len( sys.argv )
print( 'There are ' + str(argc) + ' command line arguments' )
for arg in sys.argv:
	print( arg )
# read from standard input
#text= input() # requires exception processing!
text= sys.stdin.readline() # leaves the newline char at the end
lines= []
while text:
	lines.append( text )
	#text= input() # requires exception processing!
	text= sys.stdin.readline()
for line in lines:
	print( line, end= '' )
