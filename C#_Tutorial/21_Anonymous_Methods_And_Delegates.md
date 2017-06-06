# Anonymous Methods & Delegates

```cs
// An anonymous method has no name and its return type is defined by the return used in the method

GetSum sum = delegate (double num1, double num2)
{
	return num1 + num2;
};


// Delegates are used to pass methods as arguments to other methods
// A delegate can represent a method with a similar return type and attribute list
delegate double GetSum(double num1, double num2);

Console.WriteLine("5 + 10 = " + sum(5, 10));
```
