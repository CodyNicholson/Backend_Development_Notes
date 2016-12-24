#For Statements In Java

**For Statements** are used to loop through code in java, in other words it means that we willbe able to run the same code multiple times

For loop syntax:

```
for (initialize; termination conditional; do this at the end of each loop)
{
    body of for loop that will repeat over and over until the termination condition is met
}
```

In order for a for loop to know how many times it will repeat the body of the loop you need to initialize a variable, check that variable before every iteration of the loop, and modify that variable at the end of the loop

-

```java
public static void main(String[] args)
{
    for (int i = 0; i < 5; i++)
    {
        System.out.println("Loop " + i + " hello!");
    }

    for (int i = 2; i < 9; i++)
    {
        System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f",calculateInterest(10000.0, i)));
    }
}

public static double calculateInterest(double amount, double interestRate)
{
    return (amount * (interestRate/100));
}
```

The first for loop will execute 5 times, and the second one will execute 7 times because at the end of every loop we execute "i++" - since we execute "i++" eventurally i will be large enough for the conditional statement to fail, and the for loop will terminate

It takes 5 iterations for the first for loop to terminate because i starts at 0, and 0 + 5 = 5, and 5 is not less than 5, so the conditional will fail

The same is true for thee second for loop

**String.format("%.2F", double)** just means that the double will be displayed with only 2 decimal points

***

###Challenge Problems

```java
for (int i = 0; i >= 2; i--)
{
    System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000.0, i)));
}
```
