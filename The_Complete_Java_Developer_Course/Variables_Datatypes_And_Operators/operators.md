#Operators In Java

###Mathematical Operators

The plus operator (+) adds values together

``java
int result = 1 + 2;
System.out.println("1 + 2 = " + result);
// 1 + 2 = 3
```

We can save the result (3) in the int: previousResult

```java
int previousResult = result;
```

-

The minus operator (-) subtracts values from each other

```java
result = result - 1; // This could also be written: result -= 1;
System.out.println(previousResult + " - 1 = " + result);
previousResult = result;
// 3 - 1 = 2
```

-

The multiplication operator (*) multiplies values together other

```java
result = result * 10;
System.out.println(previousResult + " * 10 = " + result);
previousResult = result;
// 2 * 10 = 20
```

-

The division operator (/) divides values from each other

```java
result = result / 5;
System.out.println(previousResult + " / 5 = " + result);
previousResult = result;
// 20 / 5 = 4
```

-

The modulus operator (%) gives you back the remainder after dividing values from each other

```java
result = result % 3;
System.out.println(previousResult + " % 3 = " + result);
// 4 % 3 = 1
```

-

The double-plus-sign operator (++) increments your value by 1

```java
result++;
System.out.println("Result is now: " + result);
// Result is now: 2
```

-

The double-minus-sign operator (--) decrements your value by 1

```java
result--;
System.out.println("Result is now: " + result);
// Result is now: 1
```

-

The plus-equal operator (+=) makes your variable equal to itself PLUS whatever value

```java
result += 2;
System.out.println("Result is now: " + result);
// Result is now: 3
```

-

The multiply-equal operator (*=) makes your variable equal to itself MULTIPLIED by whatever value

```java
result *= 10;
System.out.println("Result is now: " + result);
// Result is now: 30
```

-

The minus-equal operator (-=) makes your variable equal to itself MINUS whatever value

```java
result -= 10;
System.out.println("Result is now: " + result);
// Result is now: 20
```

-

The divide-equal operator (/=) makes your variable equal to itself DIVIDED by whatever value

```java
result /= 10;
System.out.println("Result is now: " + result);
// Result is now: 2
```

***

###Operators in Conditional Statements

The double-equals operator (==) checks that the values are the same and gives back a boolean value

```java
boolean isAlien = false;
if (isAlien == true)
    System.out.println("It is an Alien");
    // This will not print
```

-

The single-equals operator (=) sets a variable to a value, the double equals operator (==) checks that the values are the same

```java
int topScore = 100;
if (topScore == 100)
    System.out.println("The Top Score is equal to 100");
    // This will print
```

-

The not equals operator (!=) checks that the values are not equal, and gives back false if they are equal or true if they are

```java
if (topScore != 100)
    System.out.println("The Top Score is not 100");
    // This will not print
```

-

The less-than operator (<) checks that the first value is less than the second and gives back a boolean value

```java
if (topScore < 999)
    System.out.println("The Top Score is less than 999");
    // This will print
```

-

The greater-than operator (>) checks that the first value is greater than the second and gives back a boolean value

```java
if (topScore > 0)
    System.out.println("The Top Score is greater than 0");
    // This will print
```

-

The greater-than or equal to operator (>=) checks that the first value is greater than or equal to the second and gives back a boolean value

```java
if (topScore >= 100)
    System.out.println("The Top Score is greater than or equal to 100");
    // This will print
```

-

The less-than or equal to operator (<=) checks that the first value is less than or equal to the second and gives back a boolean value

```java
if (topScore <= 101)
    System.out.println("The Top Score is less than or equal to 101");
    // This will print
```

The AND operator (&&) allows you to check two conditional statements at once

If one is true and the other is false, then the whole statement is false

```java
int secondTopScore = 80;
if (topScore > secondTopScore && topScore > 100)
    System.out.println("Top Score is less than Second and greater than 100");
    // This will not print because topScore is not greater than 100
```

-

The OR operator (||) allows you to check two conditional statements at once

As long as one of the statements is true, the whole statement will evaluate to true

```java
if (topScore > secondTopScore || topScore > 100)
    System.out.println("Top Score is less than Second or it is greater than 100");
    // This will print since one of the conditionals is true
```

-

Since isCar is true, you don't need a conditional, the body of the if statement will run just fine

```java
boolean isCar = true;
if (isCar)
    System.out.println("It is a car");
```

-

This is a ternary operator that says: if isCar is true return true, if not return false

```java
boolean wasCar = isCar ? true : false;
if(wasCar)
    System.out.println("The ternary expression wasCar was true");
```

-

Below you will notice the myTotal variable is declared using the () operator. This just means that the smallNum and bigNum will be added BEFORE the multiplication happens

```java
double smallNum = 20d;
double bigNum = 80d;
double myTotal = (smallNum + bigNum) * 25;
System.out.println("This is myTotal: " + myTotal);
double myRemainder = myTotal % 40;
if (myRemainder <= 20)
    System.out.println("Total was over the limit");
```