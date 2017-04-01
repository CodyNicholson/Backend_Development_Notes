# And Or Not Conditional Statements in Java

And is written '&&' in java

Or is written '||' in java

Not is written '!' in java

Ex:

```java
String abc = "123";
int x = 5;

if (abc.equals("123") && x != 5)
{
    System.out.print("This will never run because x does equal 5");
}

if (abc.equals("123") || x != 5)
{
    System.out.print("This will run because even though x does equal 5,
    the abc String object does contain '123', and that satisfies the Or statement.")
}

if (!x == 68)
{
    System.out.print("This will execute because it is a 'not' statement meaning that ANY
    conditional statement that is false will make this if statement work.");
}
```
