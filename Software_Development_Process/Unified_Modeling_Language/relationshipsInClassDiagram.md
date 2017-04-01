# Relationships in the Class Diagram

Describes interaction between classes and objects

***

### Dependencies:

x uses y, can be represented by drawing a dashed line with an arrow from the superclass pointing towards the subclass

If x depends on y, and y changes, then x might break as well

That is why dependencies are important to pay attention to

***

### Associations/Aggregations:

x has a y, can be represented by lines between objects/classes/etc if association, can be represented by a solid line with a hollow diamond at the end if an aggregation

In association, objects of one class are connected to another, objects of one class have objects of another class

You can add a label to an association line to better indicate what the association is

You can also add a triangle above the line to indicate which class uses the object of another class

You can also add multiplicity by writing a number under each side of the line describing how many times the class is used in to other class

***

### Generalization:

x is a y, represented by a solid line pointing from x to y with a hollow arrow, subclass to superclass

A relationship between a general class, normally called a super class, and a more specific class called a subclass that refines the superclass

***

### Creation tips for class diagrams:

Understand the problem and the system domain

Choose good class names

Concentrate on the WHAT

Start with a simple graph and refine it

Refine until you feel it is complete, try out your product
