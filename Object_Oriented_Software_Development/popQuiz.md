#Pop Quiz

###What is the Single Responsiblity Principle and why would you use it?

A class should have only one reason to change,
More responsibilities -> More dependencies
Dependencies change -> rebuilds/retests/redeploys must occur
More dependencies -> more complexity -> more opportunity to break

To reduce the complexity of each class

-

###True or False, members of inner scopes are visible to members of outer scopes but not the other way around

False

inner scopes can view objects of outer scopes, not the other way around

-

###True/False, Object Oriented Design is about defining good abstractions?

True

Object Oriented Design is about defining good interfaces, which means knowing what to hide and what to show (encapsulate)

Encapsulating is hiding behavior/implementation details from the outside world

-

###What do you call the thing client programmers interact with

Interfaces - as in the concept, any member (method/class/interface/field) that is visible to the client programmer

-

###The declared type refers to the left or right side of an assignment?

Left

-

###Conceptually speaking, what is the declared type of an object?

The reference type that is put on the stack

-

###What is the actual type of an object?

The type of the object on the heap

-

###Define covariance and contravariance?

covariance - When the function returns some value, the return type is the same or less specific

contravariance - A method will acccept this type, or any of its subclasses

-

###Why is multiple-class inheritance an issue, and how is it solved in java?

Lots of dependencies increases risk of breaking, the diamond problem (When you have multiple class inheritance)

To avoid this we can define multiple interfaces

-

###Casting changes the actual type of an object, T/F?

False

-

###Describe the difference between the strategy pattern and the command pattern

What is each encapsulating?

Strategy is encapsulating some behavior while the command pattern is encapsulating some message and will relay it to its resource

-

###What is the difference between aggregation and composition?

Composition contains an exclusive refference to an object,

Aggregation does not have an exclusive reference to an object - it will take in some method as its constructor parameter, ?

-

###What is the difference between "==" and ".equals"

"==" - Testing the object on heap for equality

.equals - Testing the actual values of the objects

-

###What is an immutable class, which common java class is immutable?

A class whose value can't be changed, like String class

-

###You will use which pattern for building immutable data classes incrementally?

Builder pattern

-

###Use a collection class to encapsulate the use of a ___?

Datastructure/recursive definition

-