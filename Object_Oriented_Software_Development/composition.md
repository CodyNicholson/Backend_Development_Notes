# Composition

```java
import java.util.Random;
final class Person {
  static private Random random = new Random();
  final  private String name;
  public Person() { name = Integer.toString(random.nextInt()); }
  //public Person(String name) { name = name.clone(); }
  public String toString() { return "Person(" + name + ")"; };
}
```

Exclusive reference to objects of another class:

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/composition.jpg)

In UML, this is called composition.

Consequences of composition:

When the person dies, the name dies too

Name can only be accessed through the person