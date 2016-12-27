#Primitive Data Types - Float and Double

###Float

A **float** in java is a floating point number, like "2.5". A float has a width of 32 (4 bytes).

***

###Double

A **double** is a double-precision floating-point number. A double has a width of 64 (8 bytes).

Double is Java's default type for handleing decimals, so if you divide integer 5 by integer 2, the resulting 2.5 will be automatically converted to the double type by Java.

Even though doubles take up a lot of space, they are still very useful. The use of a double is faster than floats on many modern computers. Many built-in functions in Java use doubles in their calculations because it is more precise.

***

Examples:

```java
// width of int = 32
int myIntValue = 5/3;
// width of float = 32
float myFloatValue = 5f/3f;
// width of double = 64
double myDoubleValue = 5d/3d;
System.out.println("my int = " + myIntValue);
System.out.println("my float = " + myFloatValue);
System.out.println("my double = " + myDoubleValue);

// Convert pounds to kilograms
double numPounds = 200d;
double convertKilograms = numPounds * 0.45359237d;
System.out.println("Kilograms = " + convertKilograms);
```
