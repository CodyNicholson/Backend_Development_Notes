# Reading Inputs

```java
import java.util.Scanner;
// To use Scanner to read input you need to import it

Scanner in = new Scanner(System.in);
// This creates an object for reading user input

System.out.print("How old are you? ");
int age = in.nextInt();
// This will prompt the user for user input using the 'in' object and
// following the above question, and it will store it in the age variable

System.out.print("What is your weight? ");
double weight = in.nextDouble();
// You can use the same 'in' object to get input in multiple places in your program
```

***

### Sunset.java file:

```java
import java.util.Scanner;

public class Sunset
{
    public static void main(String[] args)
    {
        Picture pic = new Picture();
        pic.load("queen-mary.png");

        Scanner in = new Scanner(System.in);
        System.out.print("Added redness: ");
        int r = in.nextInt();
        // TODO: Read added redness from scanner

        pic.draw();
        for (int i = 0; i < pic.pixels(); i++)
        {
            Color c = pic.getColorAt(i);
            c.redden(r); // TODO: Pass added redness to method
            pic.setColorAt(i, c);
        }
    }
}


Color.java file:

public class Color
{
    private int red;
    private int green;
    private int blue;

    /**
     * Makes this color redder.
     */
    public void redden(int r) // TODO: Add a parameter
    {
        final int MAX_RED = 255;
        red = Math.min(MAX_RED, red + r);
    }

    /**
     * Gets the red value of this color.
     * @return the red value (between 0 and 255)
     */
    public int getRed()
    {
        return red;
    }

    /**
     * Gets the green value of this color.
     * @return the green value (between 0 and 255)
     */
    public int getGreen()
    {
        return green;
    }

    /**
     * Gets the blue value of this color.
     * @return the blue value (between 0 and 255)
     */
    public int getBlue()
    {
        return blue;
    }

    /**
     * Constructs a new Color object.
     * @param red the red value of the color (between 0 and 255)
     * @param green the green value of the color (between 0 and 255)
     * @param blue the blue value of the color (between 0 and 255)
     */
    public Color(int red, int green, int blue)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    // Color constants

    public static final Color RED = new Color(255, 0, 0);
    public static final Color GREEN = new Color(0, 255, 0);
    public static final Color BLUE = new Color(0, 0, 255);
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color LIGHT_GRAY = new Color(192, 192, 192);
    public static final Color GRAY = new Color(128, 128, 128);
    public static final Color DARK_GRAY = new Color(64, 64, 64);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color CYAN = new Color(0, 255, 255);
    public static final Color MAGENTA = new Color(255, 0, 255);
    public static final Color YELLOW = new Color(255, 255, 0);
    public static final Color PINK = new Color(255, 175, 175);
    public static final Color ORANGE = new Color(255, 200, 0);
}
```
