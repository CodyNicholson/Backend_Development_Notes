# Flyweight Pattern

-

What if cars were all the same size/speed?

If all cars were the same size/speed, what would be the differentiating factor between those cars?

If this was the case, could we reduce the amount of memory in our application? Hint: think about the saying “Encapsulate what varies”.

-

#### We can encapsulate the parts that don’t change

Color and length don’t change, position and velocity do

In this case, we’re encapsulating what doesn’t vary

We can put the parts that do vary into their own object with a reference to the one object that doesn’t vary

This is called the Flyweight pattern

Example:

```java
public class Car {
    int position;
    int currentVelocity;
    Color color;
    int length;
}
```

-

### We can encapsulate the parts that don’t change

Color and length don’t change. Position and velocity do

In this case, we’re encapsulating what doesn’t vary

We can put the parts that do vary into their own object with a reference to the one object that doesn’t vary

This is called the Flyweight pattern
