###Checkers If-Else

This program below is a great example of how to use an If-Else statement

An If-Else statement will first check "If" some condition is true, and if it is, it will do the things defined in the "If" statment, in this case it will return 0

However, if the condition is false, then it will go to the "Else" statement and run its code instead, ignoring the "If" statement code

```java
public class CheckerBoardPainter
{
    /**
     * Spaces are red if one of the coordinates is even and the other is odd
     * Spaces are blue if both coordinates are even
     * Spaces are blue if both coordinates are odd
     *
     * @return 1 for red spaces and 0 for blue
     * @param row the row of the space to paint
     * @param col the column of the space to paint.
     */
    public int getColor(int row, int col)
    {
        if ((row + col)%2 == 0)
        {
            return 0;
        }

        else
        {
            return 1;
        }
    }
}
```
