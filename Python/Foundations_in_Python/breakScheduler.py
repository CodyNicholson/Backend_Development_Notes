import time
import webbrowser

total_breaks = 3
break_count = 0

print("This program started on " + time.ctime())
while(break_count < total_breaks):
    time.sleep(5)
    webbrowser.open("https://i.ytimg.com/vi/pC2xKOj-FSM/hqdefault.jpg")
    break_count = break_count + 1

#Currently this program tells you to take a break every 5 seconds but ideally you would
#change the sleep from 5 seconds to 360 seconds so you would break every 2 hours of work
