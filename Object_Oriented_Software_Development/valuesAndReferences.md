#Values and References

Java has a reference model for objects. This is like C# and different from C++. In C# terminology, Java objects are boxed, whereas base values are unboxed.

What does the following print?


```java
public class Main {
  private Main() {}
  static public void main (String[] args) {
    //stdlib.Trace.graphvizShowSteps (true); stdlib.Trace.run ();
    int vi = 27;  MutInt ri = new MutInt(42);
    int vj = vi;  MutInt rj = ri;
    vi += 1;      ri.plus(1);
    System.out.println(vi);
    System.out.println(vj);
    System.out.println(ri);
    System.out.println(rj);
  }
}
final class MutInt {
  private int v;
  public MutInt(int v) { this.v = v; }
  public String toString() { return "MutInt(" + v + ")"; }
  public void plus(int z) { v += z; }
}
```

-

Consider the object diagram after line 00007:

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/objectDiagram4.jpg)

This phenomenon is called aliasing

Note that aliasing occurs whenever an object is passed as an argument to a function

Aliasing mutable values must be handled with care

***

###UML Notation for References
-

In the UML, references are usually shown using arrows.

Instead of this:

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/objectDiagram5.jpg)

We draw this:

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/objectDiagram6.jpg)