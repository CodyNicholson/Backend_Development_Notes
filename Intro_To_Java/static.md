#Static

###Static Methods:

A static method is a method that is not called on any object

For example:

```java
num = Math.sqrt(2);
// The sqrt() method is a static method because it is not called on an object, it is called from its class
```

A static method belongs to a class and cannot be called on an object and they are not common

***

###Static Variables:

A static variable is a variable that belongs to a class, but not to any object in that class

In production code you should never use static variables, unless you declare them final and capitalize them

They are mainly used for creating constants

Examples:

```java
public static final double PI = 3.14159265358979323846;
// PI will never change, so naturally it can be declared as final and static

public final static PrintStream out;
// The out method of the System class can also be declared as final and static
```
