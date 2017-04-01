# Data Type Conversion

C# supports two inherent types of conversion (casting) for data types, implicit and explicit

C# will use implicit conversion where it can, mostly in the case when a conversion will not result in a loss of data or when the conversion is possible with a compatible data type

The following is an example of an implicit data conversion. Converting from smaller to larger integral types:

```java
int myInt = 2147483647;
long myLong= myInt;
```

The long type has a 64-bit size in memory while the int type uses 32-bits.  Therefore, the long can easily accomodate any value stored in the int type. Going from a long to an int may result in data loss however and you should use explicit casting for that.

-

Explicit casts are accomplished in one of two ways as demonstrated with the following coe sample

```java
double myDouble = 1234.6;
int myInt;
// Cast double to int by placing the type modifier ahead of the type to be converted
// in parentheses
myInt = (int)myDouble;
```

-

The second option is to use the methods provided in the .NET Framework

```java
double myDouble = 1234.6;
int myInt;
// Cast double to int by using the Convert class and the ToInt32() method.
// This converts the double value to a 32-bit signed integer
myInt = Convert.ToInt32(myDouble);
```

You will find many other methods in the Convert class that cast to different integral data types such as ToBoolean(), ToByte(), ToChar(), etc

***

The Convert.ToInt32() method can also be used to cast a string literal to a numeric data type. For example, you may have GUI-based application which puts input data into text boxes. These values are string values when passed to the code in your application. Use of the above method to cast the string to numbers can help prevent exceptions in your code when trying to use the wrong data type in a specific area.

-

C# also provides another mechanism to deal with casting types. The use of the TryParse() method and Parse() methods can help with casting as well. These methods are attached to the types in C# rather than the Convert class. An example will help demonstrate:

```java
// TryParse() example
bool result = Int32.TryParse(value, out number);
// Parse() example
int number = Int32.Parse(value);
```

In the TryParse() example, the method returns a Boolean result indicating if the conversion succeeded.   In the Parse() example, if the conversion does not succeed, an exception will be thrown.
