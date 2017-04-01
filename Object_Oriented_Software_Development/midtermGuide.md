# Midterm Guide

**Interface**

Type of an object. Defines behaviors the object implements

-

**Class**

Definition of an object, including behaviors and state (fields)

-

**Constructor**

Code that runs when an object is initialized to setup the object’s initial state

-

**Delegation**

Allowing some other object to provide the behavior (e.g. lambdas)

-

**Subclassing**

Allowing some other class to provide behavior (e.g. abstract classes, interface implementations)

-

**Immutable Data Class**

Object whose state does not change (e.g. String)

-

**Mutable Data Class**

Object whose state can change

-

**Collection Class**

Encapsulates a collection of objects. Can be either immutable or mutable

-

**MVC**

IO logic (View) is separate from business logic (Model).

-

**Static Class**

Class that does not have an instantiable state, defines only global fields and methods

-

**Static Factory**

Static class whose purpose is to generate instances of some concrete interface implementations

The interface and factory are public, but the interface implementations are not

-

**Builder**

A mutable object used to build an immutable object

Add pieces to the builder bit by bit, then convert into an immutable object

-

**Command**

Encapsulate a message in an object

-

**Strategy**

Encapsulate behavior into it’s own object

Receiving objects delegate behavior to a method parameter or field

***

## Midterm Notes

You can have 1 sheet of standard sized paper with notes on both sides

You have one and a half hours to take the exam

If a question is unclear or ambiguous, write down your assumptions

The exam is closed book and closed notes

You may consult one letter-size page (front and back) of notes that you have prepared

Write your answers on the exam, if I can not read your answer clearly, it will be marked as incorrect

You will find some information on Java APIs, junit, and design patterns at the end of the exam

When drawing UML class diagrams, follow these guidelines:

- Be specific (prefer aggregation and dependency to association, prefer composition to aggregation)

- Show multiplicities on aggregations and compositions

- Be careful with arrowheads and with dashed/solid lines

- Clearly distinguish classes and interfaces.

- Clearly indicate static classes.

Topics:

```
+ UML Object Diagrams
  - objects (fields with value)
  - relations
    * link

+ UML Sequence Diagrams
  - objects (lifetime) (also static classes)
  - method/constructor call (lifetime and arguments)
  - method/constructor return (value)

+ UML Class Diagrams
  - classes (fields and methods with type and visibility)
  - interfaces (methods with type and visibility)
  - big arrow relations (triangular arrowhead)
    * specialization
    * realization
  - small arrow relations
    * aggregation
    * composition
    * dependency

+ Simple Idioms and OO programming techniques (using java)
  - packages
  - interfaces
  - classes
  - constructors
  - delegation
  - inner classes
  - static versus object classes
  - immutable data classes
  - mutable data classes
  - data object methods (equals, hashCode, compareTo, ...)
  - collection classes

+ Patterns
  - static factory
  - builder
  - command
  - strategy
  - state
  - composite
```
