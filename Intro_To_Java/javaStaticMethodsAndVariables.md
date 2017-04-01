# Java Static Methods and Variables

## Java static variable

It is a variable which belongs to the class and not to object(instance)

Static variables are initialized only once, at the start of the execution. These variables will be initialized first, before the initialization of any instance variables.

A single copy to be shared by all instances of the class

A static variable can be accessed directly by the class name and doesn’t need any object

-

Syntax: 

```
<class-name>.<variable-name>
```

***

## Java Static Method

It is a method which belongs to the class and not to the object(instance)

A static method can access only static data. It can not access non-static data (instance variables)

A static method can call only other static methods and can not call a non-static method from it

A static method can be accessed directly by the class name and doesn’t need any object

-

Syntax:

```
<class-name>.<method-name>
```

A static method cannot refer to "this" or "super" keywords in anyway

-

#### Side Note:

main method is static , since it must be be accessible for an application to run , before any instantiation takes place
