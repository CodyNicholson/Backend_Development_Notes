# Statements, Whitespace, & Indentation (Code Organization)

### Statements In Java

A statement is a command in java code that is terminated by a semicolon

Below you will see three statements

```java
int myVariable = 50;
myVariable++;
myVariable--;
```

***

### Whitespace

The two print statements below are equivalent, they are functionally the same

The whitespace has no effect on the execution of this code

```java
System.out.println("My variable " +
        "is equal to" +
        myVariable);
System.out.println("My variable is equal to: " + myVariable);
```

-

Two statements can be put on the same line and java will interpret it the same as if they each had their own lines

```java
int myNum = 5; System.out.println(myNum);
```

***

### Indentation

We indent our code in java not because we need to, but because we want our code to be more readable
