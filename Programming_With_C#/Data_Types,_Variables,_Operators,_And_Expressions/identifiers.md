# Identifiers

In C#, an Identifier is name you give to the elements in your program.  Elements in your program include;

- **Namespaces** - the .NET Framework uses namespaces as a way to separate class files into related buckets or categories.  it also helps avoid naming collisions in applications that may contain classes with the same name

- **Classes** - classes are the blueprints for reference types.  They specify the structure an object will take when you create instances of the class

- **Methods** - covered in week three, methods are discrete pieces of functionality in an application.  They are analogous to functions in the non-OOP world

- **Variables** - these are identifiers that you create to hold values or references to objects in your code.  A variable is essentially a named memory location

-

When you create a variable in C# you must give it a data type. You can assign a value to the variable at the time you create it or later in your program code. C# will not allow you to use an unassigned variable to help prevent unwanted data from being used in your application. The following code sample demonstrates declaring a variable and assigning a value to it.

```
int myVar = 0;
```

***

#### C# has some restrictions around identifiers that you need to be aware of

First off, identifiers are case-sensitive because C# is a case-sensitive language. That means that identifiers such as myVar, _myVar, and myvar, are considered different identifiers.

Identifiers can only contain letters (in any case), digits, and the underscore character. You can only start an identifier with a letter or an underscore character. You cannot start the identifier with a digit. myVar and _myVar are legal but 2Vars is not.

C# has a set of reserved keywords that the language uses. You cannot use these keywords as an identifier in your code.  You may choose to take advantage of the case-sensitivity of C# and use Double as an identifier to distinguish it from the reserved keyword double, but that is not a recommended approach.

-

The following list contains the C# reserved keywords:

abstract, as, base, bool, break, byte, case, catch char, checked, class, const, continue, decimal, default, delegate, do, double, else, enum, event, explicit, extern, false, finally, fixed, float, for, foreach, goto, if, implicit, in, in (generic modifier), int, interface, internal, is, lock, long, namespace, new, null, object, operator, out, out (generic modifier), override, params, private, protected, public, readonly, ref, return, sbyte, sealed, short, sizeof, stackalloc, static, string, struct, switch, this, throw, true, try, typeof, uint, ulong, unchecked, unsafe, ushort, using, virtual, void, volatile, while
