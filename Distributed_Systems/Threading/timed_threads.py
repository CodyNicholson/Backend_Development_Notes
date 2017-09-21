#! python

# Timed threads demo

if __name__ == "__main__":
	import sleepy
	sleepy1= sleepy.Sleepy( 'sleepy1', 3, 0 )
	sleepy2= sleepy.Sleepy( 'sleepy2', 3, 1 )
	sleepy1.start()
	sleepy2.start()
	sleepy1.join()
	sleepy2.join()
	print( 'Done in main' )

