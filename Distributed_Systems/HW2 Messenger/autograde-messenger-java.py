#! python3

"""
Automated testing
Assignment: Messenger

1. Start the program with server command line args
2. Start the program with client command line args
3. Input data from standard input for the server and the client
4. Redirect standard output to files
5. Compare output files to input files

10 points total
"""

import os, time
from file_compare import FileCompare
points= 0
compare= FileCompare()

print( 'Executing server and client with a single message...' )

shell_command= 'py input-writer.py 2 2 server-msg.txt | java Messenger -l 6001 >server-recvd.txt &'
os.system( shell_command )

time.sleep( 1 )

shell_command= 'py input-writer.py 0 2 client-msg.txt | java Messenger 6001 >client-recvd.txt'
os.system( shell_command )

print( 'execution completed; grading...' )

differ= compare.textFiles( 'server-msg.txt', 'client-recvd.txt', True )
if differ is False:
	points+= 1
	
differ= compare.textFiles( 'client-msg.txt', 'server-recvd.txt', True )
if differ is False: 
	points+= 1

print( 'Executing server and client with multiple messages...' )

shell_command= 'py input-writer.py 2 2 server-msgs.txt | java Messenger -l 6001 >server-recvd.txt &'
os.system( shell_command )

time.sleep( 1 ) 

shell_command= 'py input-writer.py 0 2 client-msgs.txt | java Messenger 6001 >client-recvd.txt'
os.system( shell_command )

print( 'execution completed; grading...' )

differ= compare.textFiles( 'server-msgs.txt', 'client-recvd.txt', True )
if differ is False: 
	points+= 4
	
differ= compare.textFiles( 'client-msgs.txt', 'server-recvd.txt', True )
if differ is False: 
	points+= 4

print( 'Points: ' + str(points) );
