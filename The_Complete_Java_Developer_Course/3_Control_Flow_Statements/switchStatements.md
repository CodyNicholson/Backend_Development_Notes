# Switch Statements

A **Switch Statement** in java is useful for checking the contents of a variable that could be one or many different types

```java
int value = 2;
if(value == 1)
{
    System.out.println("Values was 1");
}
else if (value == 2)
{
    System.out.println("Values was 2");
}
else
{
    System.out.println("Values was not 1 or 2");
}



int switchValue = 2;
switch(switchValue)
{
    case 1:
        System.out.println("Value was 1");
        break;

    case 2:
        System.out.println("Values was 2");
        break;

    case 3:case 4:case 5:
        System.out.println("It was a 3, or a 4, or a 5");
        System.out.println("It was a " + switchValue);
        break;

    default:
        System.out.println("Values was one");
        break;
}
```

The above if-else statement is equivalent to the above switch statement

The switch statement will check for different cases relating to the variable that is passed through

If-then-else statements can check more than one conditional in an "else-if" line, but a single switch statement can only check one variable at a time

A switch statement will check all cases - but in this case if the value is one, then the first case is true and we don't care about the other cases - to stop the rest of the code block from executing we use a **break** statement

The **default** case will always run unless you have a **break** statement before it gets there

***

### Challenge Problems

```java
char charVal = 'A';
switch(charVal)
{
    case 'A':
        System.out.println("A was found");
        break;

    case 'B':
        System.out.println("B was found");
        break;

    case 'C': case 'D': case 'E':
        System.out.println("C, or D, or E was found");
        break;

    default:
        System.out.println("Could not find A, B, C, D, or E");
}
```

The switch statement can check numbers, chars, strings, booleans (You should just use an if statement for a boolean though)

```java
String month = "June";
switch(month.toLowerCase())
{
    case "january":
        System.out.println("Jan");
        break;

    case "june":
        System.out.println("Jun");
        break;

    default:
        System.out.println("Not Sure");
}
```

The String class has the methods **toUpperCase()** and **toLowerCase()** that change a strings characters to all be upper case or lower case

This is useful in the above switch statement because if you passed "January" through it would print "Not Sure" because "January" does not equal "january" in java

Since we used toLowerCase, we can always expect to get lower case strings
