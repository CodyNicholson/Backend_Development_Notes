# Liskov Substitution Principle

Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it.

In Java, everything is a reference (non-primitive types)

***

Rule of thumb: If creating a subtype requires changes in the base class, it should not be a subtype of that base class

No longer should you use “Practical Inheritance”, but now “Behavioral Inheritance”

Just because a Square is a Rectangle doesn’t mean Square should inherit from Rectangle. Adding a Square class would require separate methods that consume Rectangles/Squares (violating this principle).

(example Square and Rectangle – SetHeight/SetWidth)

***

When designing classes and considering inheritance, you should think about whether the inheritance might break reasonable assumptions about the base class.

Design by contract.

***

A square might be a rectangle, but a square object is different than a rectangle object – their public behavior is inconsistent

Is-a relationships should pertain to behavior

***

### Why use LSP?
-

Prevents bugs – there are assumptions consuming classes make about objects that are passed in. Using the LSP, you help reduce bugs created as a result of assumptions.

-

Example:

```java
class Rectangle {
    private double height;
    private double width;
    public setHeight(double newHeight) { height = newHeight; }
    public setWidth(double newWidth) { width = newWidth; }
    public double getHeight() { return height; }
    public double getWidth() { return width; }
}

public class Main {
    public static void main (String[] args) {
        Rectangle r = new Rectangle();
        setInitialHeightAndWidth(r);
    }

    public static void setInitialHeightAndWidth(Rectangle r){
        r.setHeight(5);
        r.setWidth(10);
    }
}
```
