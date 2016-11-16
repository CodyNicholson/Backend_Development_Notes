#Visitor Design Pattern



***

###Double Dispatch

Dynamic dispatch is when you have an object of an unknown concrete type (in other words you have an abstract reference to it)

The method body of a function relies on the concrete type of that object

Double dispatch is when the actual method call relies on the concrete types of two objects

Visitor pattern relies on double dispatch