#Packages

Packages are used to organize related classes

Packages are like last names, there can be multiple classes named "Scanner" but you can tell them apart based on the package that the class is in

For example:

```
java.util contains classes: Scanner, ArrayList, Arrays, Random, etc
// util is the package
```

***

###Import statements:

The purpose of import statements is not to import code, it is to simplify code

####For example:

Instead of:

```java
import java.util.Scanner;
Scanner scannerName = new Scanner();
```
You could do:

```java
java.util.Scanner scannerName = new java.util.Scanner();

// This is the same code, but since no one wants to write "java.util" a hundred times,
// you can use an import statement to simplify the code
```
