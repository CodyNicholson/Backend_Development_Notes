# Operators

When writing C# code, you will often use operators.  An operator is a token that applies to operations on one or more operands in an expression. An expression can be part of a statement, or the entire statement. Examples include:

3 + 4 – an expression that will result in the literal value 4 being added to the literal value 3

counter++ – an expression that will result in the variable (counter) being incremented by one

Not all operators are appropriate for all data types in C#.  As an example, in the preceding list the + operator was used to sum two numbers.  You can use the same operator to combine two strings into one such as:

“Tom” + “Sawyer” which will result in a new string TomSawyer

You cannot use the increment operator (++) on strings however. In other words, the following example would cause an error in C#.

“Tom”++

***

## The following table lists the C# operators by type

```
{Type}
{Operators}

Arithmetic
+, -, *, /, %

Increment, decrement
++, --

Comparison
==, !=, <, >, <=, >=, is

String concatenation
+

Logical/bitwise operations
&, |, ^, !, ~, &&, ||

Indexing (counting starts from element 0)
[ ]

Casting
( ), as

Assignment
=, +=, -=, *=, /=, %=, &=, |=, ^=, <<=, >>=, ??

Bit shift
<<, >>

Type information
sizeof, typeof

Delegate concatenation and removal
+, -

Overflow exception control
checked, unchecked

Indirection and Address (unsafe code only)
*, ->, [ ], &

Conditional (ternary operator)
?:
```
