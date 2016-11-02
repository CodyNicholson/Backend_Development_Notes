#Object Lifespan And Cloning

In Java, everything are references

When you create an object, an object is created in the heap and you are given a pointer which contains the address in memory where the object is stored at

Java will keep track of how many pointers are pointing at an object

When the count hits 0, the object will get deleted by the Garbage Collector, which will free up that space for future use by the program

***

If you have a list that contains a pointer to some object o1, and you clone o1, you now have two different objects in the heap (as opposed to if you were to just do Object o2 = o1)

***

###Cloning

```
When you clone, the following should be true:
x.clone() != x
x.clone().getClass() == x.getClass()
x.clone().equals(x)
The last won’t necessarily be true, but it probably should be true.
```

-

###Cloning Vs Deep Copying

Cloning copies the current values of the objects

If an object that’s being cloned has a pointer to a child object, the clone will just copy the pointer to that child object

If you want a complete copy of the object and its child objects, you will need to do a deep copy

This will require you to also call a deep copy on the child objects
