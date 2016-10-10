#Interfaces

Java interfaces allow us to unify common behavior

If you have three classes that are all drawable, you should make an interface called "Drawable"

Example:

```java
public interface Drawable
{
    void draw();
}

// Notice the draw method has no implementation, that is because it is the classes job to implement it
// Notice the method draw does not have the  work "public" in its declaration; this is because methods in an interface are automatically public
// You cannot create objects of an interface, instead you create objects of a class that implement the interface
// Interfaces behave like a classes
```

***

###Implementing an interface:

Example:

```java
public class className implements InterfaceName
{
    public void methodName()
    {
        methodImplementationCode
    }
}

// Many different classes can all implement the same interface
```

***

###Instanceof Test and Cast:

```java
Drawable d = elements.get(i);
if (d instanceof Moveable)
{
    Moveable m = (Moveable) d;
    m.move(1);
}

// The above conditional statement will be true if d belongs to a class that implements the Moveable interface
// Since d is of type Drawable, it cannot be moved
// However, if d is part of a class that implements the Moveable interface, you can cast d as a moveable object
```

***

###The Comparable Interface:

The compareable interface has one method, compareTo()

Example:

```java
int lowNum = 1;
int highNum = 2;

lowNum.compareTo(highNum);
// This will return -1 since lowNum is less than highNum

highNum.compareTo(lowNum);
// This will return a positive num sincee high num is greater than low num

lowNum.compareTo(lowNum);
// This will return 0 since the numbers are equal

String a = "a";
String b = "b";

a.compareTo(b);
// Returns a negative number because a comes before b in the alphabet

Collections.sort(arrayListName);
// This method would sort the array list passed through it by alphabetical/numeric order using the compareTo interface
```
