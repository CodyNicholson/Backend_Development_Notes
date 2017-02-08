#Scala Classes

SCALA FP AND OOP

Scala supports both Functional Programming and OOP

```
(0 to 9).toList.partition ((x:Int) => x%3 == 0)
```

```
class Counter {
  var n = 0
  def get () : Int = { val tmp = n; n = n + 1; tmp }
}

val c = new Counter
c.get
c.get
```

We create an Anonymous function and pass it through as a parameter - Scala is a **Functional Programming**

***

###SCALA OOP

Brief overview of Scala OOP:

- Class definitions, fields, methods

- Companion objects

-

###CLASS PARAMETERS

Define a class ABC

```
class ABC (f1:Int, val f2:Int, var f3:Int) {
  ...
}
```

Only one constructor; has parameters f1, f2, f3

```
val x : ABC = new C (2, 3, 5)
```

- Instance of ABC is heap allocated

- x is a reference to instance

-

###CLASS PARAMETERS

```
class ABC (f1:Int, val f2:Int, var f3:Int) {
  ...
}
```

f1 private and immutable; f2 immutable

```
scala> val c = new ABC (2, 3, 5)
c: ABC = C@8bd1b6a

scala> c.f1
<console>:10: error: value f1 is not a member of ABC

scala> c.f2
res1: Int = 3

scala> c.f3
res2: Int = 5

scala> c.f2 = 10
<console>:9: error: reassignment to val

scala> c.f3 = 10
c.f3: Int = 10
```

***

###CLASS BODY

Class body contains

- val or var field declarations

- constructor code

- method definitions

```
class ABC (f1:Int, val f2:Int, var f3:Int) {
  val f4 = f1 * f2
  var f5 = f2 * f3

  println ("Constructing instance of ABC")
 
  def m (x:Int) : Int = {
    // cannot reassign to f1, f2, f4
    f3 = f3 + 1
    f5 = f5 + 1
    f1 * f3 * x
  }
}
```

***

###OMITTING PARTS

Can omit empty body

```
class D (f1:Int)
```

Can omit empty parentheses

```
class E { 
  private var n:Int = 0
  def get () : Int = { val tmp = n; n = n + 1; tmp }
}

val o : E = new E
o.get
```

***

###COMPANION OBJECTS

Companion objects replace static components

Java

```
class C {
  int f1;
  int m1 () { return f1; }
  static int f2;
  static int m2 () { return f2; }
}
```

Scala

```
class C {
  var f1:Int
  def m1 () : Int = f1
}

object C {
  var f2:Int
  def m2 () : Int = f2
}
```

-

###COMPANION OBJECTS

Only one instance of object declarations

Language support for singleton design pattern

```
object C {
  var count:Int = 0
}
```

-

###PROGRAM STARTUP

Java

```
public class C {
  public static void main (String[] args) {
    ...
  }
}
```

Scala

```
object C {
  def main (args:Array[String]) : Unit = {
    ...
  }
}
```

-

###CONSTRUCTION VIA COMPANION

Companion objects used to construct object

Companion can invoke private constructor

- but paste together using :paste!

```
class Point private (private var x:Int, private var y:Int) {
  def translate (xDisp:Int, yDisp:Int) : Unit = {
    x = x + xDisp
    y = y + yDisp
  }
}

object Point {
  def apply (x:Int, y:Int) : Point = {
    if (0 <= x && x <= 10 && 0 <= y && y <= 10) {
      new Point (x, y)
    } else {
      throw new RuntimeException ("invalid params")
    }
  }
}
```

-

```
:paste
// Entering paste mode (ctrl-D to finish)
[...snip class and object definitions here...]
// Exiting paste mode, now interpreting.

defined class Point
defined object Point

scala> Point.apply (1, 100)
java.lang.RuntimeException: invalid params

scala> Point.apply (1, 10)
res5: Point = Point@49e202ad

scala> new Point (1, 100)
<console>:10: error: constructor Point in class Point cannot be accessed in object $iw
```

-

apply method is the default

```
scala> Point (1, 100)   // means Point.apply (1, 100)
java.lang.RuntimeException: invalid params

scala> Point (1, 10)    // means Point.apply (1, 10)
res5: Point = Point@49e202ad
```

List class has a companion object

```
 object List extends SeqFactory[List] with Serializable {
  def apply[A](xs: A*): List[A] = ...
  ...other methods...
}

List (1, 2, 3)        // means List.apply (1, 2, 3)
```
