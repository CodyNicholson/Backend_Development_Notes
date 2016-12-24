#While & Do While Loops

###While Statements

The **While Statement** is used when you do not know how many times you want to loop through your code, but you are aware of when you want to stop

While Statement Syntax:

```
while (termination condition)
{
    Body of while loop that will be repeated until condition is false
}
```

-

###Examples

```java
int count = 0;
while (count <= 6)
{
    System.out.println("Hi there! " + count);
    count++;
}
```

The above while loop will execute 7 times because it will execute on both 0 and on 6

This is very similar to the for loop because the count could be the initializer for the for statement and the count++ could be the statement that executes at the end of the for statement

```java
while (true)
{
    if (count >= 6)
    {
        break;
    }
    System.out.println(count);
    count++;
}
```

This while loop would normally be an infinite loop since it is always true, but because of our **break** statement, this loop will eventually terminate

***

###Do While

```java
int count = 0;
do
{
    System.out.println(count);
    count++;
}
while(count <= 6);
```

The **Do While** statement is different from the **While** statement because it checks its conditional at the end instead of the beginning

This means that the loop will run at least one time even if the termination condition is false always

***

###Challenge

```java
public static void main(String[] args)
{
    int number = 5;
    int finishNumber = 20;
    while (number <= finishNumber)
    {
        if(!isEvenNumber(number))
        {
            number++;
            continue;
        }

        System.out.println("Even Number " + number);
        number++;
    }
}

public static boolean isEvenNumber(int number)
{
    if((number % 2) == 0)
    {
        return true;
    }
    return false;
}
```

The above code uses a while loop to find all the even numbers between 5 and 20 including 5 and 20 themselves

The **continue** keyword tells the while loop to stop the current iteration and start the next iteration - So if the number is not even, then the number will be incremented and then the continue statement will start the next iteration of the while loop without running the print statement and the second number++