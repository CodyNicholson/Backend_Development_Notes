#Mutable Data Classes

Guidelines:

- Always override toString
- Consider overriding clone
    - Follow the recipies in Bloch.
- Be careful with null references!
- Be careful when overriding equals, hashCode, and comparesTo
    - hashCode should depend only on immutable attributes
    - If two objects are equals, they must have the same hashCode
    - compareTo should return 0 if and only if equals returns true

***

When dealing with mutable data objects, there are three choices:

- Leave equals/hashCode alone and do not override compareTo

- Make equals/hashCode/compareTo rely only on immutable data

- Use dangerous equals/hashCode and hope no-one uses the objects as keys in a hash table

In general, solution 1 is probably the best one. In homework 1, I chose option 2

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/mutableDataClasses.jpg)

***

###Hashing Mutable Data is Dangerous!

It is possible to lose mutable values in a hashtable.

java.util.Date is mutable and overrides hashCode

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/mutableDataClasses2.jpg)