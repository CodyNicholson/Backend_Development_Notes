# Dependency

```java
* I disagree with this definition in part – still a dependency if it has a Concrete class as a field.

import java.util.Random;
final class Person {
  final private String name;
  public Person(String name) { this.name = name; }
  public String toString() { return "Person(" + name + ")"; };
}
class PersonFactory {
  private PersonFactory() {}
  static private Random random = new Random();
  static public  Person randomPerson() {
    return new Person(Integer.toString(random.nextInt()));
  }
}
```

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/dependency.jpg)

This dependency indicates that PersonFactory mentions Person, but holds no references to Person objects

Typical reasons for a dependency*:

- Person is returned by a method
- Person is a parameter of a method
- Person is held in a local variable but not a field

