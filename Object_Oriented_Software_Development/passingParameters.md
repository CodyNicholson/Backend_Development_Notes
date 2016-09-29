#Passing Parameters

What does the following print?

```java
public class Main {
  private Main() {}
  static public void main (String[] args) {
    //stdlib.Trace.graphvizShowSteps (true); stdlib.Trace.showBoxedPrimitivesAsPrimitive(false); stdlib.Trace.run ();
    Integer x = 42;
    Integer y = 27;
    Main.swap(x,y);
    System.out.println(x);
    System.out.println(y);
  }
  static private void swap (Integer a, Integer b) {
    Integer t = a;
    a = b;
    b = t;
  }
}
```

This prints:

```
42
27
```

Java is call-by-value