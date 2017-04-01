# What Day Will it Be?

```java
public class WhatDayWillItBe
{
    public static void main(String[] args)
    {
        Day desiredDay = new Day(1900,1,8);
        Day refDay = new Day(1990, 7, 1);
        int refWeekDay = 1;
        int daysBetween = desiredDay.daysFrom(refDay);
        int uWeekDay = refWeekDay + daysBetween;
        int weekday = uWeekDay % 7;

        System.out.print("Weekday: ");
        System.out.println(weekday);
    }
}
```
