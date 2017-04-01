# Data Types

All applications store and manipulate data within the computer's memory. C# supports two kinds of data types used to represent real-world information. **Value types** are so-called because they **contain the actual value of the data** they store. For example, you might have an int type that stores the value 3. The literal value of 3 is stored in the variable that you declare to hold it.

With the exception of DateTime and string, in the below table, the data types listed are aliases for structs in .NET that represent the data types in the Microsoft .NET Framework. **Any place you can use int you can also use System.Int32**.  We'll cover structs in module four.

Reference types are also known as objects. Reference types are created from class files, which you will cover in module five A reference type stores a reference to the location in memory of the object.  . If you are familiar with C/C++ then you can think of a reference to the memory location to be the same as a pointer. C# does not require you to use pointers.

The following table shows the most commonly used value types:

```
|  Type    |         Description        | Size | .Net Type       |           Range               |
|:-------- |:-------------------------- | :--: |:---------------:|:-----------------------------:|
| int      | Whole numbers              | 4B   | System.Int32    | +/-2,147,483,648              |
| long     | Whole numbers              | 8B   | System.Int64    | +/-9,223,372,036,854,775,808  |
| float    | Floating-point numbers     | 4B   | System.Single   | +/-3.4x10^38                  |
| double   | More accurate float        | 8B   | System.double   | +/-1.7x10^308                 |
| decimal  | Monetary Values            | 16B  | System.Decimal  | 28 Significant Figures        |
| char     | Single Character           | 2B   | System.Char     | N/A                           |
| bool     | Boolean                    | 1B   | System.Boolean  | True/False                    |
| DateTime | Moments of time            | 8B   | System.DateTime | Before 23:59:59 on 12/31/9999 |
| String   | Sequence of characters     | 2B/L | System.String   | N/A                           |
```
