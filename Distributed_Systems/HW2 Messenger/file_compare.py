#! python3

# FileCompare
"""Compares files as either text files or binary files"""

class FileCompare():
	def textFiles( self, file1, file2, verbose ):
		textfile1= open( file1 )
		textfile2= open( file2 )
		line_num= 1
		more= True
		differ= False
		banner_printed= False
		while( more ):
			f1_line= textfile1.readline().rstrip()
			f2_line= textfile2.readline().rstrip()
			if f1_line and f2_line:
				if f1_line != f2_line:
					if verbose:
						if banner_printed is False:
							print( 'Comparing ' + file1 + ' (f1) and ' + file2 + ' (f2)' )
							banner_printed= True
						print( "Mismatch in line " + str(line_num) + ":" )
						print( "   f1: " + f1_line )
						print( "   f2: " + f2_line )
					differ= True
				line_num+= 1
			else:
				if f1_line:
					if verbose:
						print( file1 + " is larger than " + file2 )
					differ= True
				elif f2_line:
					if verbose:
						print( file2 + " is larger than " + file1 )
					differ= True
				more= False
		textfile1.close()
		textfile2.close()
		return differ
		
	def binFiles( self, file1, file2 ):
		binfile1= open( file1, 'rb' )
		binfile2= open( file2, 'rb' )
		differ= False
		more= True
		while( more ):
			f1_bytes= binfile1.read( 4096 )
			f2_bytes= binfile2.read( 4096 )
			if f1_bytes and f2_bytes:
				if f1_bytes != f2_bytes:
					differ= True
					break
			else:
				if f1_bytes or f2_bytes:
					differ= True
				more= False
		binfile1.close()
		binfile2.close()
		return differ		
		
# TESTING!!!
if __name__ == "__main__":
	# get the command line arguments
	import sys
	argc= len( sys.argv )
	if argc != 3 :
		print( 'Usage: py ' + sys.argv[0] + ' file1 file2' )
		sys.exit()
	compare= FileCompare()
	#result= compare.textFiles( sys.argv[1], sys.argv[2], True )
	result= compare.binFiles( sys.argv[1], sys.argv[2] )
	if result is False:
		print( "(files are the same)" )
	else:
		print( "(files differ)" )
