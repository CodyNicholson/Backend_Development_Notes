#Strings

A **String** in Java is a sequence of characters and, although it is very commonly used, it is not a primitive data type - it is a *class*

A String is a sequence of characters

```java
String myString = "This is a String";
System.out.println("myString is equal to: " + myString);
```

Prints: myString is equal to: This is a String

-

You can append more characters onto a String by using the plus (+) operator as seen below

```java
myString = myString + ", and this is more.";
System.out.println("myString is equal to: " + myString);
```

Prints: myString is equal to: This is a String, and this is more.

-

You can still use unicode characters in Strings just like you would in chars

```java
myString = myString + " \u00A9 2016";
System.out.println("myString is equal to: " + myString);
```

Prints: myString is equal to: This is a String, and this is more. © 2016

-

You cannot do math with strings, you can just append strings together

```java
String numberString = "250.23";
numberString = "32.54";
System.out.println("numberString is equal to: " + numberString);
```

Prints: numberString is equal to: 32.54

-

If you append a number to a String it will convert the number into a string - it will not add the value of the number in a mathematical way

```java
String lastString = "10";
int myInt = 50;
lastString = lastString + myInt;
System.out.println("laststring is equal to: " + lastString);
double myDouble = 324.234;
lastString = lastString + myDouble;
System.out.println("laststring is equal to: " + lastString);
```

Prints: laststring is equal to: 1050
Prints: laststring is equal to: 1050324.234
