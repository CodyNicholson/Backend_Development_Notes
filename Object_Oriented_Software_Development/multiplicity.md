#Multiplicity

Multiplicities put constraints on number of references held by an object

Recall java.util.List and java.io.BufferedReader.

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/multiplicity.jpg)

Note: if multiplicity is 1, then reference must be non-null when constructor terminates.

This may require that we throw an IllegalArgumentException if an argument to the constructor is null

***

```java
public class Main {
  private Main() {}
  static public void main (final String[] args) {
    //stdlib.Trace.graphvizShowSteps (true); stdlib.Trace.run ();
    try {
      System.out.println(new Person("bob"));
      System.out.println(new Person(null));
    } catch (IllegalArgumentException e) {
      System.out.println("Error creating Person: " + e);
    }
  }
}
final class Person {
  final private String name;
  public Person(String name) {
    if (name == null)
      throw new IllegalArgumentException("null name");
    this.name = name;
  }
  public String toString() { return "Person(" + name + ")"; };
}
```

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/multiplicity2.jpg)