# Extract Class

There are times when you will find a class that is doing the work of two classes, so by Extracting a Class from these kinds of classes we can divide the work in two and make the code look and act better

***

#### Example:

Class People
Instance Variables: Name, Address, Phone Number
Methods: getName, getNumber, getAreaCode

-

#### This above code could be split into:

Superclass People
Instance Variables: Name, Address
Methods: getName, getNumber

Subclass PhoneNumber
Instance Variables: AreaCode, Number
Methods: getAreaCode

-

The split version is better because it improves structure of the code because now the classes are more cohesive and do exactly one thing
