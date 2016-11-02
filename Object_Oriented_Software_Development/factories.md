#Factories

Typical code for creating new objects

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/factory1.png)

***

###Static Factory Method

A factory allows concrete class names to be hidden

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/factory2.png)

***

###Static Factory Method
-

Benefit: Changing class names does not force Client code to change (nor should it)

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/factory3.png)

***

###Static Factory Class

An alternative to what we’ve seen, you can replace the giant if/else statement with individual class names

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/factory4.png)

***

We’ve already talked about the Static Factory pattern, and it has a couple of shortcomings

When you have two related objects (like a collection and it’s iterator), you might want the first object to be in charge of creating the specific second object (ArrayList creates an ArrayListIterator)

Static factory can’t handle this situation without the client being aware of its type