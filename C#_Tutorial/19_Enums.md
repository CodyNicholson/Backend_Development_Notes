# Enums

```cs
// ---------- ENUMS ----------
// Enums are unique types with symbolic names and associated values

public enum Temperature
{
    Freeze,
    Low,
    Warm,
    Boil
}


// Using the ENUM
Temperature micTemp = Temperature.Low;
Console.Write("What Temp : ");

Console.ReadLine();

switch (micTemp)
{
    case Temperature.Freeze:
    	Console.WriteLine("Temp on Freezing");
        break;

    case Temperature.Low:
    	Console.WriteLine("Temp on Low");
        break;

    case Temperature.Warm:
    	Console.WriteLine("Temp on Warm");
        break;

    case Temperature.Boil:
    	Console.WriteLine("Temp on Boil");
        break;
}
```
