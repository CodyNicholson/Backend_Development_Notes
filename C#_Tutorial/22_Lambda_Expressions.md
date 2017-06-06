# Lambda Expressions

```cs
// ---------- LAMBDA EXPRESSIONS ----------
// A lambda expression is used to act as an anonymous function or expression tree

// You can assign the lambda expression to a function instance
Func<int, int, int> getSum = (x, y) => x + y;
Console.WriteLine("5 + 3 = " + getSum.Invoke(5, 3));

// Get odd numbers from a list
numList = new List<int> { 5, 10, 15, 20, 25 };

// With an Expression Lambda the input goes in the left (n) and the statements go on the right
List<int> oddNums = numList.Where(n => n % 2 == 1).ToList();

foreach (int num in oddNums)
{
	Console.Write(num + ", ");
}
```
