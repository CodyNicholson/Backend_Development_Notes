# Farm Plot - Practicing Math in Java

This class uses some basic Java math to compute how many circular farm fields could fit in a plot of land that you can define the dimensions of

```java
public class Plot
{
    private int width;
    private int length;

    /**
        Constructs a plot of a given size.
        @param width the width of the plot
        @param length the length of the plot
    */
    public Plot(int width, int length)
    {
        this.width = width;
        this.length = length;
    }

    /**
     * Calculates the number of circular fields that can fit on this plot.
     * @params radius is radius of the circular plot
     * @return the number of circular fields that can fit on the plot
     */
    public int getNumberOfFields(int radius)
    {
        int diameter = 2 * radius;
        int nRows = (int) ((length - diameter) / (radius * Math.sqrt(3))) +1;
        int oddRows = (nRows + 1) / 2;
        int evenRows = nRows / 2;
        int colsPerOddRow = width / diameter;
        int colsPerEvenRow = (width - radius) / diameter;
        int totalFields = oddRows * colsPerOddRow + evenRows * colsPerEvenRow;
        return totalFields;
    }
}
```
