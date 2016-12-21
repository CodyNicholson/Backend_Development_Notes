#Primitive Datatypes - Char and Boolean

###Char

A **char** stores *one* of any character

A char has a width of 16 (2 bytes)

A char holds one of any character - numbers, letters, special symbols, etc

You should wrap your single char in single-quotes

```java
char myChar1 = '^';
char myChar2 = '.';
System.out.println(myChar1 + myChar2 + myChar1);
```

Notice the above code did not print out '^.^', it instead printed '234' because that is the ASCII code for ^.^

-

Unicode lets us use characters that we cannot find on our keyboard by typing in their address

```java
char myUnicodeChar = '\u00A9';
System.out.println("Unicode Character: " + myUnicodeChar);
```

***

###Boolean

**Booleans** hold either true or false values and can be used to add logic to code

```java
boolean myBoolean = false;
boolean isMan = true;

char registeredSymbol = '\u00AE';
System.out.println("Registered Symbol: " + registeredSymbol);
```