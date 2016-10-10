#Inheritance

Inheriance is like interfaces because it can pick up common behavior, but it can also pick up data from other classes

A class can only inherit from one other class, unlike interfaces

If a class inherits from another class, then it is the subclass and the other class is the superclass

To declare one class as inheriting another class:

```java
public class classOne extends classTwo
{
    add new instance variables
    add new methods
    add methods you want to modify by redeclaring them and they will override the original methods
    Do not include methods from the super class that work fine because you already have access to those
    Do not include superclass fields because you already have access to those
}

// You should only include the difference between the superclass and the subclass,
// not things that already exist and work fine in the superclass
```

YOU DO NOT GET THE PRIVATE INSTANCE VARIABLES OR METHODS FROM THE SUPERCLASS!

If you need to get an instance variable from a superclass to a subclass, make a public method in the superclass to get the private instance variable and then call that public method from the subclass
