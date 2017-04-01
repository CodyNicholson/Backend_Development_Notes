# For Loop

When you want something to repeat some exact amount of times, you should use a for loop not a while loop

```java
for (initialize; condition; mutator)
{
    doStuff();
}
```

You can initialize a variable in the for loop, include a condition that must be true for the for loop to continue iterating, and lastly mutate one of the values so that you can influence how long the for loop will run for

```java
for (i = 0; i < 10; i++)
{
    System.out.println("Hi!");
}
```

The above for loop will run 10 times for the indices 0-9

After i becomes 10, the conditional statement will read 10 < 10, which is false and will cause the loop to stop
