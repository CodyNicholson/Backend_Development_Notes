# Switch, Break, Continue

```cs
// Switch is used when you have limited options
// Fall through isn't allowed with C# unless there are no statements between cases
// You can't check multiple values at once

switch (age)
{
	case 0:
		Console.WriteLine("Infant");
        break;
	case 1:
	case 2:
        Console.WriteLine("Toddler");

        // Goto can be used to jump to a label elsewhere in the code
        goto Cute;
	default:
        Console.WriteLine("Child");
        break;
}

// Lable we can jump to with Goto
Cute:
	Console.WriteLine("Toddlers are cute");
```
