# CSC 376 - Programming Exercise 1
# YouTube link: https://youtu.be/kO63M4DubOw

import sys

print("Standard Input:")

words = []

for i in sys.argv:
    if(i[0] != '-' and i != 'input_program.py'):
        words.append(i)

for line in sys.stdin:
    print(line, end='')

if (len(sys.argv) > 1):
    print("Command line arguments:")

    if('-o' in sys.argv and len(words) > 0):
        print("option 1: " + words[0])

    if('-t' in sys.argv and len(words) > 1):
        print("option 2: " + words[1])

    if('-h' in sys.argv):
        print("option 3")
