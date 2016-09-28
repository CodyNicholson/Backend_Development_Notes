#Constructors/methods/fields

Object classes have three kinds of members:

- Constructors specify how to build objects inhabiting the class.

- Methods specify how the object responds to messages.

- Fields specify the state of the object.

Example:

```java
public class Main3 {
  private Main3() {}
  static public void main (String[] args) {
    //stdlib.Trace.graphvizShowSteps (true); stdlib.Trace.run ();
    Circle3[] list = new Circle3[3];
    for (int i = 0; i < list.length; i++)
      list[i] = new Circle3 (i*10);
    for (Circle3 c : list)
      System.out.println(c);
  }
}
// An object class
final class Circle3 extends Object {
  int radius;
  public Circle3(int radius) { this.radius = radius; }
  public String toString() { return "Circle(" + radius + ")"; }
}
```

***

![alt tag](cmf1.jpg)