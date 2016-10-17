#Unified Modeling Language

Reference/Exclusive Reference:

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/umlRefVsExclusive.jpg)

Dependency (no reference):

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/dependency2.jpg)

Association (could be either reference or dependency):

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/association2.jpg)

***

###Uml sequence diagrams
-

Depict a sequence of messages being passed around for some method as well as depict the activity of objects

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/umlSequenceDiagram.png)

***

###UML Class Diagrams: Object Class
-

An object class looks like this:

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/objectClass.jpg)

The class name is not underlined

Non-static methods are not underlined

Fields are listed first, methods second

> - is private
> + is public

A static class describes the class itself.
An object class describes the instances of the class

***

###UML Class Diagrams: Static Class
-

A static class looks like this:

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/staticClass.jpg)

The class name is not underlined

Static methods are underlined

> <<static>> is a stereotype

Method return type follows colon

May contain static fields, which are also underlined (none shown here)

***

###UML Representation of Collections
-

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/umlRepresentationOfClasses.jpg)

***

###UML class diagrams: Specialization/Generalization

Specialization is when you have some base class and you create subclasses that inherit from that base class

Generalization is when you have a few classes and decide to create one base class for those classes to inherit from

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/classDiagram1.jpg)

Depending on what class(es) came first, this diagram shows specialization/generalization

When you see a diagram like this, you can just say it shows “inheritance”

***

###UML Class Diagrams: Realization
-

Realization is the implementation or derivation of an Interface or Abstract class

A Subtype realizes the Interface/Abstract class

Command and Strategy patterns are examples of realization

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/realizeUML.jpg)

SomeClass realizes IInterface

***

###UML Arrows
-

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/umlArrows.jpg)
