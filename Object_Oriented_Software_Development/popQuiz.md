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