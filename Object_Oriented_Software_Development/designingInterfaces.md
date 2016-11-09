#Designing Interfaces

You need to consider many circumstances when designing interfaces (interfaces the construct, not the Java construct).

You can have a class provide an interface of sorts by having methods that are protected that need to be overridden or called by a child class.

Ex. Observable.setChanged

-

Rather than designing an interface for subclassing (you need to subclass the interface in order to make it useful), you can design an interface for delegation. This is mostly what we’ve been doing this course.

An example would be some class that uses Constructor Injection.
