#! python3

'''
Automated testing
Assignment: Args and Input

1. Start the program with command line args and capturing standard output
2. Input data from standard input
3. Inspect output file for proper data

9 points total
'''

import os
from file_compare import FileCompare

option_args= ['-h -t giraffe', '-t lion -h -o elephant', '-o tiger' ]
input_files= ['input1.txt', 'input2.txt', 'input3.txt' ]
ref_files= ['ref1.txt', 'ref2.txt', 'ref3.txt', 'ref4.txt', 'ref5.txt', \
 'ref6.txt', 'ref7.txt', 'ref8.txt', 'ref9.txt' ]

points= 0
size= len(option_args)
ref_index= 0
for input_index in range(size):
	shell_command= 'py input-writer.py 0 0 ' + input_files[input_index] + ' | py input_program.py >output.txt'
	os.system( shell_command )
	compare= FileCompare()
	differ= compare.textFiles( 'output.txt', ref_files[ref_index], True )
	if differ is False:
		points+= 1
	ref_index+= 1
	
for input_index in range(size):
	shell_command= 'py input-writer.py 0 0 blank.txt | py input_program.py ' + option_args[input_index] + ' >output.txt'
	os.system( shell_command )
	compare= FileCompare()
	differ= compare.textFiles( 'output.txt', ref_files[ref_index], True )
	if differ is False:
		points+= 1
	ref_index+= 1


for input_index in range(size):
	shell_command= 'py input-writer.py 0 0 ' + input_files[input_index] + ' | py input_program.py ' + option_args[input_index] + ' >output.txt'
	os.system( shell_command )
	compare= FileCompare()
	differ= compare.textFiles( 'output.txt', ref_files[ref_index], True )
	if differ is False:
		points+= 1
	ref_index+= 1

print( 'Points: ' + str(points) );
