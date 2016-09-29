#Mixed Classes

It is useful to think of a mixed class in terms of its two functions:

- Static members belong to the class, eg, Integer.MAX_VALUE:int and Integer.parseInt(String):int. Access these members using the class name.

- Non-static members belong to the objects, eg, Integer.hashCode():int. Access these members using an object reference – this is the only way you can!

-

Example:

```java
public class Main {
  private Main() {}
  static public void main (final String[] args) {
    //stdlib.Trace.graphvizShowSteps (true); stdlib.Trace.run ();
    try {
      if (args.length != 1)
        throw new NumberFormatException();
      int vx = Integer.parseInt(args[0]);
      Integer rx = new Integer(vx);
      System.out.println("  Number: " + rx.toString());
      System.out.println("Hashcode: " + rx.hashCode());

    } catch (NumberFormatException e) {
      System.out.println("Error: Bad input");
    }
  }
}
```