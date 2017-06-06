# Formatting String

```cs
// Formatting : Currency, Decimal Places, Before Decimals, Thousands Separator
string fmtStr = String.Format("{0:c} {1:00.00} {2:#.00} {3:0,0}", 1.56, 15.567, .56, 1000);

Console.WriteLine(fmtStr.ToString());
```
