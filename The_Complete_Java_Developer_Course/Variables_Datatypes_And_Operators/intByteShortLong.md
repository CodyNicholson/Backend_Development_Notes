#Primitive Data Types - Integer, Byte, Short, Long

###Integer

A whole number, the computer can only store 'int's that are between -2147483648 billion and +2147483647 billion because that is the limit of the 'int' data type

```java
// int has a width of 32
int mySmallestInt = -2147483648;
int mySmallestInt = 2147483647;

When you define a variable to a fixed value, that is called a **literal** - for example: "int x = 4" and "String name = "Cody" both contain the literals: "4" for the first example and "Cody" for the second

When you set a variable based on the values of other variables, like "int x = y * z", the "y * z" is called an expression

-

###Byte

```java
// byte has a width of 8
byte smallestPossibleByte = -128;
byte largestPossibleByte = 127;
```

A **byte** is another data type for storing numbers, and it is more efficient than an int because a byte takes up a quarter of the amount of memory as an int

-

###Short

```java
// short has a width of 16
short mySmallestShort = -32768;
short myLargestShort = 32767;
```

A short takes up twice the amount of space as a byte, but half the amount of space as an int

-

###Long

```java
// long has a width of 64
long myLongestLong = 9223372036854775807L;
long mySmallestLong = -9223372036854775808L;
```

***

###Doing Math With Special Types (Non-int)

```java
byte myByteOne = 22;
byte myByteTwo = myByteOne/2; // THIS IS AN ERROR
```

The above code has an error because when you do "myByteOne/2", java converts the resulting number into an 'int'

This causes an error because, as you can clearly see, "myByteTwo" is defined as a byte, NOT an int, so it throws an error

To resolve this issue we have to use a **cast**:

```java
byte myByteOne = 22;
byte myByteTwo = (byte) myByteOne/2; // THIS IS AN ERROR
```

The **cast**: "(byte)" tells java to convert the resulting value into the datatype "byte"

In other words: when you do "myByteOne/2", java changes the type to int, but then when java sees you cast: "(byte)", it will convert the int into a byte