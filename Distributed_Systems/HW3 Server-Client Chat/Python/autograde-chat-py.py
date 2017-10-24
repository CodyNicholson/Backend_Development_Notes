#! python3

"""
Automated testing
Assignment: Chat

1. Start the server program
2. Start client programs
3. Input data from standard input for the clients
4. Redirect standard output to files
5. Compare output files to input files

17 points total
"""

import os, time, subprocess
from within_file import WithinFile
points= 0
withinFile= WithinFile()

print( 'Executing 2 clients with a single message...' )

args= ['py','-u','ChatServer.py','6001']
server_errors= open( 'server-errors.txt', 'w' )
server= subprocess.Popen( args, stderr= server_errors )

time.sleep( 1 ) 

shell_command= 'py input-writer.py 0 2 client1-msg.txt | py -u ChatClient.py 6001 >client1-recvd.txt 2>client1-errors.txt &'
os.system( shell_command )

shell_command= 'py input-writer.py 1 2 client2-msg.txt | py -u ChatClient.py 6001 >client2-recvd.txt 2>client2-errors.txt'
os.system( shell_command )

print( 'execution completed; grading...' )

found= withinFile.searchText( 'client1-recvd-single-ref.txt', 'client1-recvd.txt' )
if found:
	points+= 1

found= withinFile.searchText( 'client2-recvd-single-ref.txt', 'client2-recvd.txt' )
if found:
	points+= 1

server.kill()
try:
	server_errors.close()
except Exception:
	pass

print( 'Executing 2 clients with multiple messages...' )

args= ['py','-u','ChatServer.py','6001']
server_errors= open( 'server-errors.txt', 'w' )
server= subprocess.Popen( args, stderr= server_errors )

time.sleep( 1 ) 

shell_command= 'py input-writer.py 0 2 client1-msgs.txt | py -u ChatClient.py 6001 >client1-recvd.txt 2>>client1-errors.txt &'
os.system( shell_command )

shell_command= 'py input-writer.py 1 2 client2-msgs.txt | py -u ChatClient.py 6001 >client2-recvd.txt 2>>client2-errors.txt'
os.system( shell_command )

print( 'execution completed; grading...' )

found= withinFile.searchText( 'client1-recvd-multiple-ref.txt', 'client1-recvd.txt' )
if found:
	points+= 1

found= withinFile.searchText( 'client2-recvd-multiple-ref.txt', 'client2-recvd.txt' )
if found:
	points+= 1

server.kill()
try:
	server_errors.close()
except Exception:
	pass

print( 'Executing 3 clients with a single message...' )

args= ['py','-u','ChatServer.py','6001']
server_errors= open( 'server-errors.txt', 'w' )
server= subprocess.Popen( args, stderr= server_errors )

time.sleep( 1 ) 

shell_command= 'py input-writer.py 0 1 client1-msg.txt | py -u ChatClient.py 6001 >client1-recvd.txt 2>>client1-errors.txt &'
os.system( shell_command )

shell_command= 'py input-writer.py 0 1 client2-msg.txt | py -u ChatClient.py 6001 >client2-recvd.txt 2>>client2-errors.txt &'
os.system( shell_command )

shell_command= 'py input-writer.py 0 1 client3-msg.txt | py -u ChatClient.py 6001 >client3-recvd.txt 2>>client3-errors.txt'
os.system( shell_command )

print( 'execution completed; grading...' )

subpoints= 0

found= withinFile.searchText( 'client1-recvd-from-client2-single-ref.txt', 'client1-recvd.txt' )
if found:
	subpoints+= 1

found= withinFile.searchText( 'client1-recvd-from-client3-single-ref.txt', 'client1-recvd.txt' )
if found:
	subpoints+= 1

found= withinFile.searchText( 'client2-recvd-from-client1-single-ref.txt', 'client2-recvd.txt' )
if found:
	subpoints+= 1

found= withinFile.searchText( 'client2-recvd-from-client3-single-ref.txt', 'client2-recvd.txt' )
if found:
	subpoints+= 1

found= withinFile.searchText( 'client3-recvd-from-client1-single-ref.txt', 'client3-recvd.txt' )
if found:
	points+= 1

found= withinFile.searchText( 'client3-recvd-from-client2-single-ref.txt', 'client3-recvd.txt' )
if found:
	points+= 1

points+= (subpoints / 2)

server.kill()
try:
	server_errors.close()
except Exception:
	pass

print( 'Executing 3 clients with multiple messages...' )

args= ['py','-u','ChatServer.py','6001']
server_errors= open( 'server-errors.txt', 'w' )
server= subprocess.Popen( args, stderr= server_errors )

time.sleep( 1 ) 

shell_command= 'py input-writer.py 0 1 client1-msgs.txt | py -u ChatClient.py 6001 >client1-recvd.txt 2>>client1-errors.txt &'
os.system( shell_command )

shell_command= 'py input-writer.py 0 1 client2-msgs.txt | py -u ChatClient.py 6001 >client2-recvd.txt 2>>client2-errors.txt &'
os.system( shell_command )

shell_command= 'py input-writer.py 0 1 client3-msgs.txt | py -u ChatClient.py 6001 >client3-recvd.txt 2>>client3-errors.txt'
os.system( shell_command )

print( 'execution completed; grading...' )

subpoints= 0

found= withinFile.searchText( 'client1-recvd-from-client2-multiple-ref.txt', 'client1-recvd.txt' )
if found:
	subpoints+= 1

found= withinFile.searchText( 'client1-recvd-from-client3-multiple-ref.txt', 'client1-recvd.txt' )
if found:
	subpoints+= 1

found= withinFile.searchText( 'client2-recvd-from-client1-multiple-ref.txt', 'client2-recvd.txt' )
if found:
	subpoints+= 1

found= withinFile.searchText( 'client2-recvd-from-client3-multiple-ref.txt', 'client2-recvd.txt' )
if found:
	subpoints+= 1

found= withinFile.searchText( 'client3-recvd-from-client1-multiple-ref.txt', 'client3-recvd.txt' )
if found:
	subpoints+= 1

found= withinFile.searchText( 'client3-recvd-from-client2-multiple-ref.txt', 'client3-recvd.txt' )
if found:
	subpoints+= 1

points+= (subpoints / 2)

print( 'Executing 3 *new* clients with multiple messages...' )

shell_command= 'py input-writer.py 0 1 client4-msgs.txt | py -u ChatClient.py 6001 >client4-recvd.txt 2>client4-errors.txt &'
os.system( shell_command )

shell_command= 'py input-writer.py 0 1 client5-msgs.txt | py -u ChatClient.py 6001 >client5-recvd.txt 2>client5-errors.txt &'
os.system( shell_command )

shell_command= 'py input-writer.py 0 1 client6-msgs.txt | py -u ChatClient.py 6001 >client6-recvd.txt 2>client6-errors.txt'
os.system( shell_command )

print( 'execution completed; grading...' )

found= withinFile.searchText( 'client4-recvd-from-client5-multiple-ref.txt', 'client4-recvd.txt' )
if found:
	points+= 1

found= withinFile.searchText( 'client4-recvd-from-client6-multiple-ref.txt', 'client4-recvd.txt' )
if found:
	points+= 1

found= withinFile.searchText( 'client5-recvd-from-client4-multiple-ref.txt', 'client5-recvd.txt' )
if found:
	points+= 1

found= withinFile.searchText( 'client5-recvd-from-client6-multiple-ref.txt', 'client5-recvd.txt' )
if found:
	points+= 1

found= withinFile.searchText( 'client6-recvd-from-client4-multiple-ref.txt', 'client6-recvd.txt' )
if found:
	points+= 1

found= withinFile.searchText( 'client6-recvd-from-client5-multiple-ref.txt', 'client6-recvd.txt' )
if found:
	points+= 1

server.kill()
try:
	server_errors.close()
except Exception:
	pass

print( 'Points: ' + str(points) );
