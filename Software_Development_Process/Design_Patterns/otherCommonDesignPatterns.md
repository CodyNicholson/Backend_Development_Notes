#Other Common Design Patterns

###Visitor Pattern

A Way of separating an algorithm from an object structure on which it operates

This is useful because it allows you to add new operations to existing object structures without modifying the structures

It allows for defining and easily modifying a set of operations to perform on the object of the collection

It also allows you to decouple operations from the objects

***

###Decorator Pattern

A wrapper that adds functionality to a class, and is stackable

You will build a class that wraps around another class so it can use its functionality and more

***

###Iterator

Access elements of a collection without knowing the underlying representation

Allows to access elements of a collection without knowing the underlying representation

This means you can go through a set of objects without worrying about how the objects are stored

Just ask the iterator to give you the first object, and then iterate to the next

***

###Observer

Notifies the dependencies when the object changes

Allows you to register these objects so that they let the system know that they are interested in changes in this first object, and then every time that there is a change these other objeccts will be able to beautomatically notified

***

###Proxy

Surrogate controls access to an object

In other words, we have an object and a proxy and all of the requests to the object will go through the proxy that will then forward them to the object

All the responces from the object will also go through the proxy that will then forward them to the oringinal requester

This allows you to control how an object is accessed, by filtering for example
