# open a file
# read each line
# output the line to standard input
# pace the timing of output

import sys
import time

argc= len( sys.argv )
if argc != 4 :
	print( 'Usage: py ' + sys.argv[0] + ' <initial delay> <pace> <input file>' )
	sys.exit()
		
initial_delay= int(sys.argv[1])
pace= int(sys.argv[2])
input_file= open( sys.argv[3] )
if initial_delay:
	time.sleep( initial_delay )
for line in input_file:
	try:
		print( line, end= '' )
		sys.stdout.flush()
		#print( line.rstrip() )
	except BrokenPipeError: # process receiving input ended
		sys.exit()
	if pace:
		time.sleep( pace )
if pace:
	time.sleep( pace )
sys.stderr.close() # eliminate message at end
