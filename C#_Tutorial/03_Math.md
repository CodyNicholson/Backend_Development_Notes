# Math

```cs
// ---------- MATH ----------

Console.WriteLine("5 + 3 = " + (5 + 3));
Console.WriteLine("5 - 3 = " + (5 - 3));
Console.WriteLine("5 * 3 = " + (5 * 3));
Console.WriteLine("5 / 3 = " + (5 / 3));
Console.WriteLine("5.2 % 3 = " + (5.2 % 3));

int i = 0;

Console.WriteLine("i++ = " + (i++));
Console.WriteLine("++i = " + (++i));
Console.WriteLine("i-- = " + (i--));
Console.WriteLine("--i = " + (--i));

Console.WriteLine("i += 3 " + (i += 3));
Console.WriteLine("i -= 2 " + (i -= 2));
Console.WriteLine("i *= 2 " + (i *= 2));
Console.WriteLine("i /= 2 " + (i /= 2));
Console.WriteLine("i %= 2 " + (i %= 2));


// ---------- Math functions -------------

// Math Functions
// Acos, Asin, Atan, Atan2, Cos, Cosh, Exp, Log, Sin, Sinh, Tan, Tanh
double number1 = 10.5;
double number2 = 15;

Console.WriteLine("Math.Abs(number1) " + (Math.Abs(number1)));
Console.WriteLine("Math.Ceiling(number1) " + (Math.Ceiling(number1)));
Console.WriteLine("Math.Floor(number1) " + (Math.Floor(number1)));
Console.WriteLine("Math.Max(number1, number2) " + (Math.Max(number1, number2)));
Console.WriteLine("Math.Min(number1, number2) " + (Math.Min(number1, number2)));
Console.WriteLine("Math.Pow(number1, 2) " + (Math.Pow(number1, 2)));
Console.WriteLine("Math.Round(number1) " + (Math.Round(number1)));
Console.WriteLine("Math.Sqrt(number1) " + (Math.Sqrt(number1)));

// Random Numbers
Random rand = new Random();
Console.WriteLine("Random Number Between 1 and 10 " + (rand.Next(1, 11)));
```
