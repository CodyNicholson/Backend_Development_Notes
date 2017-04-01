# Methods In Java

Methods help us avoid writing duplicate code

```java
public static void main(String[] args)
{
	boolean gameOver = true;
	int score = 800;
	int levelCompleted = 5;
	int bonus = 100;

	calculateScore(gameOver, score, levelCompleted, bonus);

	score = 10000;
	levelCompleted = 8;
	bonus = 200;

	calculateScore(true, score, 10, 123);
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

Looking at the main() method above (The block of code with the title main) you can see that we declare some variables and reassign them later on in the block

Reassigning variables is good because it uses less memory space, but it is bad because it means that we will overwrite the previous values for those variables

Thus far we have only ever run the main method to test our code, but now we have created a new method - the calculateScore() method

In our main() method we call calculate score twice and we give the calculateScore method the four variables work with by passing them through as **arguments**

If we did not pass through those four variables, caqlculateScore would not have any variables to calculate - by passing variables through the method we give the method access to those variables

If not for this method we would have to rewrite the contents of the calculateScore method to do our calculation

Imagine if you have a million calculations to make, calling a method is a lot more efficient than rewriting the code over and over