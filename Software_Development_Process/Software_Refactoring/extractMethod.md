#Extract Method

We start with a cohesive code fragment in a large method

We then create a method using that code fragment and then replace the code fragment with a call to that method

This is just like extracting a class, but with methods

####Example:

````java
void printTotalAndDetails(int x, int y, int z)
{
    int total = x + y + z;
    System.out.println("The total is: " + total);
    System.out.println("x represents: " + descriptionX);
    System.out.println("y represents: " + descriptionY);
    System.out.println("z represents: " + descriptionZ);
}
```

####This could be changed to:

```java
void printTotalAndDetails(int x, int y, int z)
{
    int total = x + y + z;
    printTotalAndDetails();
}
```
