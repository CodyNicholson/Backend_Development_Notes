# Data Types

```cs
// ---------- DATA TYPES ----------

// Booleans are true or false
bool canVote = true;

// Characters are single 16 bit unicode characters
char grade = 'A';

// Integer with a max number of 2,147,483,647
int maxInt = int.MaxValue;

// Long with a max number of 9,223,372,036,854,775,807
long maxLong = long.MaxValue;

// Decimal has a maximum value of 79,228,162,514,264,337,593,543,950,335
// If you need something bigger look up BigInteger
decimal maxDec = decimal.MaxValue;

// A float is a 32 bit number with a maxValue of 3.402823E+38 with 7 decimals of precision
float maxFloat = float.MaxValue;

// A float is a 32 bit number with a maxValue of 1.797693134E+308 with 15 decimals of precision
double maxDouble = double.MaxValue;

// You can combine strings with other values with +
Console.WriteLine("Max Int : " + maxDouble);

// The dynamic data type is defined at run time 
dynamic otherName = "Paul";
otherName = 1;

// The var data type is defined when compiled and then can't change
var anotherName = "Tom";
// ERROR : anotherName = 2;
Console.WriteLine("Hello " + anotherName);

// How to get the type and how to format strings
Console.WriteLine("anotherName is a {0}", anotherName.GetTypeCode());
```
