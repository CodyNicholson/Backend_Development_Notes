# Exception Handling

```cs
// ---------- EXCEPTION HANDLING ----------
// All the exceptions 
// msdn.microsoft.com/en-us/library/system.systemexception.aspx#inheritanceContinued

try
{
	Console.Write("Divide 10 by ");
    int num = int.Parse(Console.ReadLine());
    Console.WriteLine("10 / {0} =  {1}", num, (10 / num));
}

// Specifically catches the divide by zero exception
catch (DivideByZeroException ex)
{
	Console.WriteLine("Can't divide by zero");

    // Get additonal info on the exception
    Console.WriteLine(ex.GetType().Name);
    Console.WriteLine(ex.Message);

    // Throw the exception to the next inline
    // throw ex;

	// Throw a specific exception
    throw new InvalidOperationException("Operation Failed", ex);
}

// Catches any other exception
catch (Exception ex)
{
	Console.WriteLine("An error occurred");
    Console.WriteLine(ex.GetType().Name);
    Console.WriteLine(ex.Message);
}
```
