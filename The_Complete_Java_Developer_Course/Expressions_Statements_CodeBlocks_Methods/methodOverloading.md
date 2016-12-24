#Method Overloading

```java
public static void main(String[] args)
{
    int newScore = calculateScore("Cody", 123);
    System.out.println("New Score is " + newScore);
    calculateScore(75);
    calculateScore();
}

public static int calculateScore(String playerName, int score)
{
    System.out.println("Player " + playerName + " scored " + score + " points");
    return score * 1000;
}

public static int calculateScore(int score)
{
    System.out.println("Unamed Player scored " + score + " points");
    return score * 1000;
}

public static int calculateScore()
{
    System.out.println("No player, no score");
    return 0;
}
```

Notice we have three methods that with the same name

When you call this method java will automatically look at the number of arguments you passed through AND their types to decide which method to run

If you passed two methods of types (String, int) respectively then it will run the first calculateScore, if you passed through one (int) then it will run the second, and if you pass through nothing it will run the third

-

```java
public static void main(String[] args)
{
    calcFeetAndInchesToCentimeters(150);
    calcFeetAndInchesToCentimeters(10, 4);
    calcFeetAndInchesToCentimeters(1);
}

public static double calcFeetAndInchesToCentimeters(double feet, double inches)
{
    if ((feet < 0) || (inches < 0) || (inches > 12))
    {
        System.out.println("Invalid feet or inches");
        return -1;
    }

    double centimeters = (feet * 12) * 2.54;
    centimeters += inches * 2.54;
    System.out.println(feet + " feet, " + inches + " inches = " + centimeters + " cm");
    return centimeters;
}

public static double calcFeetAndInchesToCentimeters(double inches)
{
    if(inches < 0)
    {
        System.out.println("Invalid inches value");
        return -1;
    }

    double feet = (int) inches / 12;
    double remainingInches = (int) inches % 12;
    System.out.println(inches + " inches is equal to " + feet + " feet and " + remainingInches);
    return calcFeetAndInchesToCentimeters(feet, remainingInches);
}
```

By using method overloading we made the calcFeetAndInchesToCentimeters method much more dynamic and useful
