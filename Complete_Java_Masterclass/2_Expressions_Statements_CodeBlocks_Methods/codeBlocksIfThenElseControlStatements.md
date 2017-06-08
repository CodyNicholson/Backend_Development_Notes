# Code Blocks & If-Then-Else Control Statements

### Code Blocks

```java
public static void main(String[] args)
{
	boolean gameOver = true;
	int score = 5000;
	int levelCompleted = 5;
	int bonus = 100;

	if(score == 5000)
	{
		System.out.println("Your score is 5000");
	}

	System.out.println("This executes even through the if statement fails");
}
// The output of main() will be: This executes even through the if statement fails
```

A **Code Block** in java is a section of code that is found between currly braces {}

There are two Code Blocks above - The body of the main() above is one Code Block, and the body of the if-statement inside main() is another code block

Since the if statement fails, the second code bloack will never run in this case BUT notice that the if-statement failing does not prevent the print statement below the if-statement from executing

***

### If-Then-Else Control Statements

```java
int myNum = 1;

if (myNum > 7)
{
	System.out.println("myNum is greater than 7");
}
else if (myNum < 1)
{
	System.out.println("myNum is less than 1");
}
else
{
	System.out.println("All the if statements failed, so this statement runs");
}
```

We can control which Code Blocks are run using **If-Then-Else Statements**

What the above statement is saying is: If the first conditional fails, try the second conditional. If the second conditional fails, run the Else statement.

HOWEVER, if the first conditional is true, run the corresponding Code Block and then stop there, don't try the other conditional, don't run the Else Code Block
