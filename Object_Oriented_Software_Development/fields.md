#Fields

Fields can be used to distinguish different objects of a class

Example:

```java
public class Main {
  private Main() {}
  static public void main (String[] args) {
    //stdlib.Trace.graphvizShowSteps (true); stdlib.Trace.run ();
    Int x = new Int(42);
    Int y = new Int(27);
    System.out.println(x);
    System.out.println(y);
  }
}
final class Int {
  private final int v;
  public Int(int v) { this.v = v; }
  public String toString() { return "Int(" + v + ")"; }
}
```

The object diagram at line 00008 is:

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/objectDiagram2.jpg)

***

It is traditional in the UML to show objects, but not ARIs

This can be confusing

Although the names given to objects are arbitrary, perhaps the following are more helpful:

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/objectDiagram3.jpg)