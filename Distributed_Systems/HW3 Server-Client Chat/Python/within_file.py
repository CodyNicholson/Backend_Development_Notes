#! python3

# WithinFile
"""Test whether the content of the first file is found within the content
of the second file"""

class WithinFile():
	def searchText( self, file1, file2 ):
		textfile1= open( file1 )
		textfile2= open( file2 )
		linesfile1= textfile1.readlines()
		linesfile2= textfile2.readlines()
		textfile1.close()
		textfile2.close()
		number_of_lines_file1= len(linesfile1)
		number_of_lines_file2= len(linesfile2)
		more= True				
		file2_lineno= 0
		for file1_lineno in range(number_of_lines_file1):
			while( more ):
				if linesfile1[file1_lineno] != linesfile2[file2_lineno]:
					file2_lineno+= 1
					if file2_lineno == number_of_lines_file2:
						more= False
				else:
					more= False
			if file2_lineno == number_of_lines_file2:
				return False
			more= True		
		return True
		
# TESTING!!!
if __name__ == "__main__":
	# get the command line arguments
	import sys
	argc= len( sys.argv )
	if argc != 3 :
		print( 'Usage: py ' + sys.argv[0] + ' <text file> <within file>' )
		sys.exit()
	withinFile= WithinFile()
	result= withinFile.searchText( sys.argv[1], sys.argv[2] )
	if result:
		print( "(content within file)" )
	else:
		print( "(content not found)" )
