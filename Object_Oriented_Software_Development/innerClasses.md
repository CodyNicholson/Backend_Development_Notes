#Inner Classes

Classes that are defined within another class (e.g. RecordObj and InventorySet from Homework 2)

Inner classes can’t be instantiated outside of their containing classes

Example:

```java
public class Main {
  private Main() {}
  static public void main (final String[] args) {
    //stdlib.Trace.graphvizShowSteps (true); stdlib.Trace.run ();
    C mc1 = new C(42);
    C mc2 = new C(36);
    mc1.f();
    mc2.f();
  }
}

interface Print { void print(); }

class C {
  int cx;
  C(int x) { cx = x; }
  class P implements Print {
    int py = 27;
    public void print() {
      System.out.println(" cx=" + cx + " py=" + py);
    }
  }
  void f() {
    Print p = new P();
    p.print();
  }
}
```

***

Can inner classes be instantiated by other classes?

???

***

Can static methods of inner classes be called from other classes?

?

***

Inner classes can be declared in the middle of a method – why might you want to do that?

Example:

```java
public class Main {
  private Main() {}
  static public void main (final String[] args) {
    //stdlib.Trace.graphvizShowSteps (true); stdlib.Trace.run ();
    C mc1 = new C(42);
    C mc2 = new C(36);
    mc1.f();
    mc2.f();
  }
}

interface Print { void print(); }

class C {
  int cx;
  C(int x) { cx = x; }
  void f() {
    Print p = new Print() {
      int py = 27;
      int cx = 5656;
      public void print() {
        System.out.println(" P.cx=" + this.cx);
        System.out.println(" cx=" + C.this.cx + " py=" + this.py);
      }
    };
    p.print();
  }
}
```

***

Unnamed inner classes that just have a single function can use a shorthand

Example:

```java
public class Main {
  private Main() {}
  static public void main (final String[] args) {
    C mc1 = new C(42);
    C mc2 = new C(36);
    mc1.f();
    mc2.f();
  }
}

interface Print { void print(); }

class C {
  int cx;
  C(int x) { cx = x; }
  void f() {
    Print p = () -> System.out.println(" cx=" + cx);
    p.print();

    G g = (int x) -> {
      cx = cx + x;
      cx = cx + x;
      cx = cx + x;
    };
    g.run(3);
  }
}

interface G { void run(int x); }
```

***

Inner classes can inherit from classes rather than interfaces

Example:

```java
public class Main {
  private Main() {}
  static public void main (final String[] args) {
    //stdlib.Trace.graphvizShowSteps (true); stdlib.Trace.run ();
    C mc1 = new C(42);
    C mc2 = new C(36);
    mc1.f();
    mc2.f();
  }
}

abstract class Print {
  int py;
  Print(int y) { py = y; }
  abstract void print();
}

class C {
  int cx;
  C(int x) { cx = x; }
  void f() {
    Print p = new Print(27) {
      public void print() {
        System.out.println(" cx=" + cx + " py=" + py);
      }
    };
    p.print();
  }
}
```