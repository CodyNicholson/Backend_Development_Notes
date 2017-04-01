# Random Numbers

```java
Random generator = new Random();

int randomInteger = generator.nextInt(n);
// n is the upper limit
// You will get an int between 0 and n-1

double x = generator.nextDouble();
```

***

### Random Darts:

```java
import java.util.Random;
import java.util.Scanner;

/**
   This program computes an estimate of pi by simulating dart throws onto a square.
*/
public class MonteCarlo
{
    public static void main(String[] args)
    {
        System.out.println("Number of tries");
        Random generator = new Random(42); // Seeded random
        Scanner in = new Scanner(System.in);
        int tries = in.nextInt();

        int hits = 0;
        for (int i = 1; i <= tries; i++)
        {
            // Generate two random numbers between -1 and 1

            double x = generator.nextDouble() * 2 -1;

            double y = generator.nextDouble() * 2 -1;

            // Check whether the point lies in the unit circle

            if (x * x + y * y <= 1)
            {
                hits++;
            }
        }

        /*
           The ratio hits / tries is approximately the same as the ratio
           circle area / square area = pi / 4
        */

        double piEstimate = 4.0 * hits / tries;
        System.out.println("Estimate for pi: " + piEstimate);
    }
}
```
