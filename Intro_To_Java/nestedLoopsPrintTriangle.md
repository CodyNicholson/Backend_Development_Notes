# Triangle Pattern

This program prints a triangle pattern by using a nested for loop

```java
public class TrianglePattern
{
    public static void main(String[] args)
    {
        int numberOfRows = 5;
        for (int i = 1; i <= numberOfRows; i++)
        {
            for (int r = 0; r < i; r++)
            {
                System.out.print("[]");
            }
            System.out.println();
        }

    }
}
```
