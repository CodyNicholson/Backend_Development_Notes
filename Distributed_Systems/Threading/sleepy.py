#! python

# Sleepy class
"""Demonstrates timed behavior within a thread."""
import threading, time

class Sleepy( threading.Thread ):
	def __init__(self, data, count, delay):
		threading.Thread.__init__(self)
		self.data= data
		self.count= count
		self.delay= delay
		
	def run(self):
		self.delay_start()
		# loop -- print data count times
		for i in range(self.count):
			print( self.data )
			self.wait_for_it(2)

	def delay_start(self):
		self.wait_for_it(self.delay)

	def wait_for_it(self, wait_time):
		time.sleep(wait_time)
