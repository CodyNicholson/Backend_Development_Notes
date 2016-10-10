#Objects

- Building block of program
- Component with some desired functionality
- You ask objects to do work
- An instance of a class

***

###Calling a method of an objects class:

```java
object.methodName(arguments);
```

-

###Creating a new object of class/type Picture:

```java
Picture rocket = new Picture("rocket.png");
```

***

##Classes

- Objects with common behavior
- Classes have methods that allow you to execute functions on the objects, which are instances of the class

Example:

String is a type, String name = "Joe";, but it is also a class
In the String class, for example, there is a method .length()
name.length() = 3 in this case

-

###Variables

- Use a variable to store a value that you need later
- Every variable has a name

Ex:

```java
Type variableName
Picture rocket;
String name;
int x;
boolean isItBlue;
```

There is a class for every variable type that has its own built in methods, like all String's have the method .length()

***

###Comments

Use "//"" to create a comment in your code to describe what it does

Example:

```java
x = 3;
// The reason I started x at 3 was because I like the number 3
```

***

###To Construct Objects

```java
Rectangle box = new Rectangle(x,y,z,a);
```

Check the object type's documentation to see the different ways you can create the object
