# More On Methods

A procedure is a method that's return type is void

A method can also be called a function

```java
public static void main(String[] args)
{
    boolean gameOver = true;
    int score = 800;
    int levelCompleted = 5;
    int bonus = 100;

    int highScore = calculateScore(gameOver, score, levelCompleted, bonus);
    System.out.println("Your high score was: " + highScore);

    score = 10000;
    levelCompleted = 8;
    bonus = 200;

    int highScore = calculateScore(gameOver, score, levelCompleted, bonus);
    System.out.println("Your high score was: " + highScore);
}

public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus)
{
    if (gameOver)
    {
        int finalScore = score + (levelCompleted * bonus);
        finalScore += 2000;
        System.out.println("Your final score was " + finalScore);
        return finalScore;
    }
    else
    {
        return -1;
    }
}
```

Since the return type of the calculateScore method is int, when we call it we are given an int. We can set this int equal to a variable called "highscore" and then use that variable later on in our script to print a message

***

```java
public static void main(String[] args)
{
    int highScorePosition = calculateHighScorePosition(1500);
    displayHighScorePosition("Cody", highScorePosition);

    highScorePosition = calculateHighScorePosition(900);
    displayHighScorePosition("Percy", highScorePosition);

    highScorePosition = calculateHighScorePosition(430);
    displayHighScorePosition("Bill", highScorePosition);

    highScorePosition = calculateHighScorePosition(99);
    displayHighScorePosition("Titan", highScorePosition);
}

public static void displayHighScorePosition(String playerName, int highScorePosition)
{
    System.out.println(playerName + " managed to get into position "
        + highScorePosition + " on the high score table!");
}

public static int calculateHighScorePosition(int playerScore)
{
    if (playerScore >= 1000)
    {
        return 1;
    }
    else if (playerScore >= 500)
    {
        return 2;
    }
    else if (playerScore >= 100)
    {
        return 3;
    }
    else
    {
        return 4;
    }
}
```

With this basic knowledge of methods in java you can do cool stuff like the script above
