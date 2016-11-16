#Pop Quiz

###What is the Single Responsiblity Principle and why would you use it?

A class should have only one reason to change,

More responsibilities -> More dependencies

Dependencies change -> rebuilds/retests/redeploys must occur

More dependencies -> more complexity -> more opportunity to break

**To reduce the complexity of each class**

-

###True or False, members of inner scopes are visible to members of outer scopes but not the other way around

**False**

inner scopes can view objects of outer scopes, not the other way around

-

###True/False, Object Oriented Design is about defining good abstractions?

**True**

Object Oriented Design is about defining good interfaces, which means knowing what to hide and what to show (encapsulate)

Encapsulating is hiding behavior/implementation details from the outside world

-

###What do you call the thing client programmers interact with

**Interfaces** - as in the concept, any member (method/class/interface/field) that is visible to the client programmer

-

###The declared type refers to the left or right side of an assignment?

**Left**

-

###Conceptually speaking, what is the declared type of an object?

**The reference type that is put on the stack**

-

###What is the actual type of an object?

**The type of the object on the heap**

-

###Define covariance and contravariance?

**covariance - When the function returns some value, the return type is the same or less specific**

**contravariance - A method will acccept this type, or any of its subclasses**

-

###Why is multiple-class inheritance an issue, and how is it solved in java?

**Lots of dependencies increases risk of breaking** - the diamond problem (When you have multiple class inheritance)

**To avoid this we can define multiple interfaces**

-

###Casting changes the actual type of an object, T/F?

**False**

It changes the runtime type

-

###Describe the difference between the strategy pattern and the command pattern

What is each encapsulating?

**Strategy is encapsulating some behavior while the command pattern is encapsulating some message and will relay it to its resource**

-

###What is the difference between aggregation and composition?

**Composition contains an exclusive refference to an object**

**Aggregation does not have an exclusive reference to an object** - it will take in some method as its constructor parameter, (More details coming on this one, gotta read about it)

-

###What is the difference between "==" and ".equals"

**"==" - Testing the object on heap for equality**

**.equals - Testing the values of the objects**

-

###What is an immutable class, which common java class is immutable?

**A class whose value can't be changed, like String class**

-

###You will use which pattern for building immutable data classes incrementally?

**Builder pattern**

-

###Use a collection class to encapsulate the use of a ___?

**Datastructure/recursive definition**

***

##Pop Quiz 2

###Define Refactor

Change the design of the code to make it more readable and less prone to bugs without changing the behavior of the code

-

###What is the main reason to refactor?

Code smells, technical debt, optimization

Because you want to make your code easier to understand and less prone to errors. For example, by making sure that your code doesn't have a million dependencies when it only needs 2 or 3.

-

###What is the first thing you need to do before refactoring, and why?

Make sure you test the upper and lower bound, 100% coverage

Make sure you have a copy of your old code saved so that if you break anything you have the original working copy as a backup -- Version Control

-

###What is the open/close principle?

Classes are open for extention, but closed for modification

-

###What are the three heuristics of the open/close principle?

1. Make all member variables private

2. No global variables

3. RTTI is dangerous (Runtime Type Identification -- Checks the type of something)

-

###What is the Liskov Substitution Principle?

Any method of a class has to behave the same for any subclass of the class

-

###What is a rule of thumb about whether a newly created class should be the subtype of another class?

If it would require changes to the base class

-

###What is the Interface Segregation Principle?

Clients should not be fourced to depend on interfaces that they don't use - thin interfaces

-

###What are some reasons to use the interface segregation principle?

Prevent code bloat

Prevent type coupling

-

###What do UML Sequence Diagrams depict?

How objects interact with one another, and what sequences

Depicts the messages being passed around the system while also depicting the activity of the objects

-

###Two possible interfaces for factory create methods are ___ and ___?

One where you have a create method for each object

One method that does a check and then creates one of the objects of a type that is based on the check

***

##Pop Quiz 10/11

###What is the benefit of seperating your model code from your view code?

You can add multiple user interfaces without needing to change your model

-

###What is the diference between specialization and generalization?

Specialization - Base classes first, then create a specialized class out of those base classes

Generalization - Specialized classes first, then create a base class out of those specialized classes

-

###What is realization?

The implementation of an abstraction

When a class implements an interface

-

###What is the dependency inversion principle?

You want concrete things like classes to depend on abstract things like interfaces

High level modules (Class/package/etc) should not depend on low level modules

Abstractions should not depend on details, details should depend on abstractions

-

###What is the main problem that the dependency inversion principle solves?

It reduces tight coupling

-

###Why would you want to use constructer injection?

Its when you want to create an object to work with only one specific dependency

You create the object, you put in the dependency, then that module won't be changed by other code

-

###Why would you want to use method injection?

Method injection is passing in dependencies as a method parameter

You would want to give the caller the power to satisfy that dependency, like the strategy pattern

-

###Between the three methods of dependency injection, what should you default to?

The default should be constructer injection because of the principle of least knowledge, hide the implementation princples as much as possible, whatever is using those objects does not need to know which dependencies its using

***

##Pop Quiz 10-25

###What is a defining characteristic of the composite pattern?

It contains objects that contain other objects

-

###How does a client interact with a composite object? Does it know it is potenitally composed of many objects?

It gets back a pointer/handle to the interface. No.

-

###What pattern can be used to create immutable composite objects?

Builder pattern

-

###What is the difference between the state pattern and the strategy pattern? Why use one over the other?

The state is managed internally by some class, the strategy is manged by some other client

-

###What is the difference between the state and strategy UML diagram?

Instead of aggregation you use composition

-

###The oberver pattern uses a ___ model to notify clients of some event occuring?

Publish/subscribe

-

###What is a very common senario for using the observer pattern?

Looking at a button to see if it has been pressed or not

-

###The subject and the observer patterns both need to implement different interfaces, what are the members of those interfaces?

Subject/Observable: Attach, detach, notifyObservers
Observer: Update/Notify

***

##Pop Quiz 11/1

###What is a Null object?

A class that is used in place of actual null values that doesn't have any implementations

***

###In what situation would you want to use the Null Object Pattern?

Preventing null pointer exceptions, enable the client to specify no functionality

***

###What should your design look like if you want to use the null object pattern? Should the class inherit from a class or an interface?

Both work but **interface** works better, make sure the class that takes in the dependency is refering to the interface rather than the concrete class

***

###Which pattern would you use if you wanted to add functionality to a specific already existing concrete class without modifying the class?

Proxy Pattern

***

###Draw the proxy pattern uml diagram

INSERT PICTURE HERE

***

###What pattern would you use if you wanted to add funtionality to a group of related classes (classes that implement the same interface) without modifying those classes?

Decorator Pattern

***

###What pattern would you use to add functionality to a third party library (or any code that you couldn't modify for some reason)?

Adapter Pattern

***

###Draw the adapter uml diagram

```
                                              delagates
Client ---- > <<Interface>> <| - - - - Adapter ------> Adaptee
```

***

##Pop Quiz 10/8

###What are default values for uninitialized variables?

For booleans: **False**

For numbers: **0**

***

###What keyword do you use to call into the parent class of a subclass?

**Super**

***

###When does the garbage collecter run and what does it do?

**Frees up memory from objects that have no other refference**

***

###Which three conditions should be met when implementing a clone method?

**x.clone() != x**

**x.clone().getClass() == x.getClass()**

**x.clone().equals(x) == true**

***

###What is the difference between cloning and deep copying?

**Cloning is a shallow copy, a deep copy is where you are not just copying this object, you are also copying the child objects**

***

###Define the Singleton Pattern

Creating objects that only ever have one instance

***

###Describe the three ways of interfacing with a Singleton object

**A private static variable where you limit access to certain methods on static variable**

**A public static read-only variable**

**Lazy loaded - where the instance is loaded on the first access attempt**

***

###A class intended to be used as a Singleton should have a clone method (T/F)

**False**

***

###A class intended to be a Singleton should have a public constructor (T/F)

**False**

***

###When you have two related classes and you want to delegate responsibility pattern it should use?

**Factory Method**

***

###When you have a whole suite of related objects, which pattern would you use to create that suite of related objects?

**Abstract Factory**

***

###What pattern would you use if you want to reduce your memory foot print and all your objects of a certain type will have values that will be shared among all instances?

**Flyweight**

***

##Pop Quiz 11/15

###What is an abstract class?

**An interface that can have functionality in it**

***

###When would you pick an abstract class over an interface?

**When you want to share code between the subclasses of that abstract class**

***

###What keyword would you use to disallow any subquery of a class? It is the same kayword to mark something as read-only

**Final**

***

###What is the difference between overriding and hiding?

**Overriding is when you have a method in a parent class , and hiding is when you have a parent scope and a child scope for your variable (NEVER USE HIDING)**

***

###What is the difference between overriding and overloading?

**Overloading is when you have the same method signature (name and return type) but different parameters/arguments

***

###What is the Template Method Pattern?

**When you have an abstract class with a concete method that calls an abstract method from within the concrete method**

***

###When would you use the Template Method Pattern? (In place of strategy)

**When you have code you need to share between classes or if I want to add a state to the concrete classes**