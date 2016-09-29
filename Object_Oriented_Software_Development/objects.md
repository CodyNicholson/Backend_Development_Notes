#Objects

What is an object?

**Basic idea**: an object is something that may respond to a message.

**Further**: an object may have state.

The state of the object may be used in generating a response to a message.

If an object is mutable, its response may vary over time.

Example: a printer queue.

***

###What does it mean to be Object-Oriented?
-

Curious fact: in a java program, there is no direct way to describe an object.

Java is class-based.

- Classes are described directly.

- Objects are instances of classes.

Most OO-languages are class based -- descendants of simula and smalltalk.

Prototype-based languages work differently.

***

###Object Classes and Static Classes
-

Let's distinguish two types of classes:

- object classes are instantiable -- they are templates for stamping objects

- static classes are not instantiable -- they are collections of functions

Example:

```java
// A static class
public class Main1 {
  private Main1() {}
  static public void main (String[] args) {
    //stdlib.Trace.graphvizShowSteps (true); stdlib.Trace.run ();
    Circle1 c = new Circle1(1);
    String s = ((c==null) ? "null" : c.toString());
    System.out.println(s);
  }
}
// An object class
final class Circle1 extends Object {
  final int radius;
  public Circle1(int radius) { super(); this.radius = radius; }
  public String toString() { return "Circle(" + radius + ")"; }
}
```

-

Java allows some shorthand

The following declarations are equivalent

```java
// A static class
public class Main2 {
  private Main2() {}
  static public void main (String[] args) {
    //stdlib.Trace.graphvizShowSteps (true); stdlib.Trace.run ();
    System.out.println(new Circle2 (1));
  }
}
// An object class
final class Circle2 extends Object {
  int radius;
  public Circle2(int radius) { this.radius = radius; }
  public String toString() { return "Circle(" + radius + ")"; }
}
```

Important: compilers add/remove local variables as they wish (that are not parameters). Some locals get mapped to addresses on the stack and some to registers.

Do not “optimize” local variables for performance!

***

###Object Diagrams
-

An object diagram is a snapshot of a running system, showing live objects.

Here are the ARIs when executing Circle.toString

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/objectDiagram1.jpg)

Note the difference between the ARIs

The ARI for toString has a special variable, this, which identifies the object receiving the message

This is the main difference between a static method and a non-static method