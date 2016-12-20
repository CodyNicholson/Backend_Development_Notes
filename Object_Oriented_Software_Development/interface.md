#Interface

- An interface (the concept, not the Java construct interface) is what client programmers interact with
- The interface of a package is the names of its public classes and interfaces
- The interface of a class (or interface) is the name and type of its public members
- The interface of a method is its type (arguments and return)

-

####What makes a good interface?
-

- Good interfaces have high cohesion
- Cohesion: measures the strength of relationship between pieces of functionality within a given module
- High Cohesion helps us follow the Single Responsibility Principle

***

###Interfaces
-

Interfaces provide no implementation, they only provide a contract to consumers guaranteeing an implementing object has certain methods (and/or properties in C#), and what those method signatures look like

-

Default Interface

If a class implements multiple interfaces, and multiple have a default implementation for the same method, the implementing class must specify its own implementation

```java
interface Colored {
  Color getColor();
}
interface Point {
  double getX();
  double getY();
}
final class CartesianPoint implements Colored, Point {
  /* ... */
}
final class PolarPoint implements Colored, Point {
  /* ... */
}

public class Main {
    public static void main(String[] args) {
        CartesianPoint p1 = new CartesianPoint(0,0,Color.RED);
        PolarPoint r1 = new PolarPoint(0,0,Color.RED);
        printColor(p1);
        printColor(p2);
    }

    public void printColor(CartesianPoint point){
        System.out.println(point.getColor());
    }

    public void printColor(PolarPoint point){
        System.out.println(point.getColor());
    }
}
```
