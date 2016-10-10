#While Loop

While loops wil repeat over and over until there condition is false, or you get a runtime error

```java
public class InterestCalculator
{
    public static void main(String[] args)
    {
        double balance = 100;
        int year = 0;

        while (balance < 1000000000)
        {
            double interest = balance * .01;
            balance = balance + interest;
            year++;
        }
        System.out.println("It will take " + year + " years.");
    }
}
```

After 1620 years (iterations) the balance will not be less than a billion and the while loop will stop because of this
