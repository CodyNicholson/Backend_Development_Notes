#Do Loops

Do loops are commonly used for input validation

Do loops end when the "while (condition)"'s condition becaomes false

In this case, that is when value becomes less than 100

```java
import java.util.Scanner;

public class InputValidation
{
    public static void main(String[] args)
    {
        Scanner in new Scanner(System.in);
        int value;
        do
        {
        System.out.println("Enter an integer < 100;");
        value = in.nextInt();
        }
        while (value >= 100);

        System.out.println("Thank you for entering " + value);
    }
}
```
