# Open-Close Principle

Software Entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.

Rather than change the behavior of code, you should extend it when functionality changes rather than changing the behavior of the old code that already works. Bug fixes should still occur.

The Open-Close Principle relies on “class-stacking” (subclassing)

***

### How to use it
-

Have code depend on abstractions, not concrete classes

The way to extend behavior is to create a class based on that abstraction

-

Client-Server Side Example

-

When you are checking actual types of objects at runtime, you are likely violating the open-close principle (code smell)

The problem with seeing this in one place is that it likely means it’s used in multiple places

-

Example

***

### Open-Close Principle Heuristics
-

Make all member variables private

Hide the state of any class

If any (external) code depends on a field, the OCP is broken because any changes to that field affect the code that calls it (C# properties vs fields)

Private fields (as opposed to protected fields) force child classes to add behavior rather than modify it

No Global Variables – Ever
Same reason as why you make private member variables
However, with C#, this is appropriate to violate on occasion (DateTime.Now)

-

RTTI (run-time type identification) is dangerous

RTTI = casting

Methods shouldn’t depend on specific (concrete) types

***

### Why use the Open-Close Principle?
-

Every time you open a file to make modifications, you increase the likelihood of breaking something

Once a unit has been created and thoroughly tested to ensure it works, for the most part, it can be left alone and can just sit there. You know it will work because it’s been working and it’s been tested thoroughly, and no one has had any reason to open it or change it

-

Example:

```java
public interface Shape {
}
class Circle implements Shape {
  Circle(int radius) { /* ... */ }
}
class Rectangle implements Shape {
  Rectangle(int height, int width) { /* ... */ }
}

public class Main {
    public static void main (String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(1);
        shapes[1] = new Rectangle(1, 2);

        WriteShapes(shapes);
    }

    public static void WriteShapes(Shape[] shapes){
        for(Shape shape:shapes){
            if(shape instanceof Circle)
                System.out.println("Circle");
            else if(shape instanceof Rectangle)
                System.out.println("Rectangle");
        }
    }
}
```
