# Formatted Output

```java
public static void main(String[] args)
{
    int score = 127;
    double cost = 1.267;
    String name = "Cody";

    System.out.printf("%4d", score);
    // Will print the number 6 characters wide, as long as the number is less than 6 characters

    System.out.println();

    System.out.printf("%4.2f", cost);
    // Will print 4 characters wide with 2 decimal places.
    // If given a long decimal value, it will round up to stay 4 chars wide
    // The 2 decimal places and the decimal itself are counted in the 4 chars wide count,
    // so you will only have one char to the left of the decimal in this example

    System.out.println("");

    System.out.printf("%s", name);
    // Will print a string
}
```

### Making a table

```java
public class MicroKitchenTable
{
    public static void main(String[] args)
    {
        int saraCookiesPerDay = 3;
        double saraCerealPerDay = .06;
        String saraName = "Sara";
        int cayCookiesPerDay = 1;
        double cayCerealPerDay = 0;
        String cayName = "Cay";
        System.out.println("cookies | cereal | name");
        System.out.println("------------------------");
        System.out.printf("%8d|%8.2f|%s", saraCookiesPerDay, saraCerealPerDay, saraName);
        System.out.println();
        System.out.printf("%8d|%8.2f|%s", cayCookiesPerDay, cayCerealPerDay, cayName);
        System.out.println();
    }
}
```
