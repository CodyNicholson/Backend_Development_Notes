# Aggregation

```java
final class Person {
  //stdlib.Trace.graphvizShowSteps (true); stdlib.Trace.run ();
  final private String name;
  public Person(String name) { this.name = name; }
  public String toString() { return "Person(" + name + ")"; };
}
```

Reference to objects of another class:

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/aggregation.jpg)

In UML, this is called aggregation

Note that the aggregation refers to the instances of the class, not the class itself