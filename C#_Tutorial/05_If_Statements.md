# If Statements

```cs
// ---------- CONDITIONALS ----------

// Relational Operators : > < >= <= == !=
// Logical Operators : && || ^ !

// If Statement
int age = 17;

if ((age >= 5) && (age <= 7))
{
	Console.WriteLine("Go to elementary school");
}
else if ((age > 7) && (age < 13))
{
	Console.WriteLine("Go to middle school");
}
else
{
	Console.WriteLine("Go to high school");
}

if ((age < 14) || (age > 67))
{
	Console.WriteLine("You shouldn't work");
}

Console.WriteLine("! true = " + (!true));
```
