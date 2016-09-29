#Immutable Data Classes

We already have seen a basic version: Person

***

###Guidelines
-

- Make all fields final

- Ensure that fields are correctly initialized by constructor

- Override equals, hashCode, and toString
    - Follow the recipes in Bloch
- Consider overriding compareTo
    - Follow the recipes in Bloch

An instance of an immutable data class is immutable if the objects passed into the constructor never change.

***

###Which of these are Immutable Classes?
-

```java
Pair p1 = new Pair("dog", "cat");
StringBuilder b2 = new StringBuilder("dog");
Pair p2 = new Pair(b2, "cat");
b2.append("ma");
Pair p3 = new Pair(new StringBuilder("dog"), "cat");
```

***

###Advantages of Immutable Objects
-

- Immutable objects do not change.

- Aliasing does not matter!

- We can freely copy references without fear that the object will change; This has several corollaries

- No need to clone an immutable object

- No need for an exclusive reference (defensive copy) of an immutable object.

- Concurrency presents no difficulties -- see SE552

- With extra care == and equals are equivalent -- discussed later

**Guideline: make all data classes immutable**