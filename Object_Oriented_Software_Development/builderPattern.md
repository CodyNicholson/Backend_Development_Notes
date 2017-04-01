# The Builder Pattern

Mutable data classes are useful for building objects incrementally.

This is called the builder pattern.

A builder is an object that is used to create an object of another class. Usually the builder is used to create exactly one other object, then discarded.

The important part of the following example is toPair, which converts the mutable class to the immutable companion class

-

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/builderPattern1.jpg)

-

Here is an example showing the usage:

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/builderPattern2.jpg)
