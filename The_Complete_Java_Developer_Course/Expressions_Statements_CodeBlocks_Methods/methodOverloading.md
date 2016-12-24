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
public static double calcFeetAndInchesToCentimeters(double feet, double inches)
{
    if ((feet < 0) || (inches < 0) || (inches > 12))
    {
        System.out.println("Invalid feet or inches");
        return -1
    }

    double centimeters = (feet * 12) * 2.54;
    centimeter += inches * 2.54;
    System.out.println(feet + " feet, " + inches + " inches = " + centimeters + " cm");
}

public static double calcFeetAndInchesToCentimeters(double inches)
{

}
```