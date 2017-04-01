# Algebraic Data Types

- Product types: tuples
- Sum types: discriminated/tagged union, variants
- Algebraic data types: sum of products
- Examples seen so far
    - Option type
    - List type
- Decompose values of algebraic data types with pattern matching

***

### Algebraic Data Types in Programming Languages

- D
- F#
- Haskell
- Julia
- Hope (1970s, first PL with this feature)
- ML
- OCaml
- Rust
- Scala
- Swift

***

### PRODUCT TYPES

- Named for Cartesian product of sets
    - X * Y = { (x, y) | x ∈ X ∧ y ∈ Y }
- Case class definition for product of Int and String

```
case class C (x:Int, y:String)
```

new unnecessary for constructing instances

```
val c:C = C (5, "hello")
```

Extract elements with pattern matching

```
val n:Int = c match { 
  case (a, b) => a
}
```

***

### CASE CLASSES

- Compiler treatment for case classes
- Constructor arguments are visible and immutable

```
case class C (x:Int, y:String)
val c:C = C (5, "hello")
val a:Int = c.x
c.x = 6 // error: reassignment to val
```

- Generate sensible toString implementation
- Generate companion object with apply method
    - used to construct instances
- Generate pattern matching support
    - see unapply method / extractors in textbook

-

### TUPLES ARE CASE CLASSES

- Pairs / tuples are syntactic sugar for case classes
- See Tuple3.scala source

```
case class Tuple3[+T1, +T2, +T3](_1: T1, _2: T2, _3: T3)
  extends Product3[T1, T2, T3]
{
  override def toString() = "(" + _1 + "," + _2 + "," + _3 + ")"
}
```

Examine runtime type without syntactic sugar

```
scala> (5, "hello", true).getClass
res0: Class[_ <: (Int, String, Boolean)] = class scala.Tuple3
```

***

### SET UNION

Cartesian product of sets

- X * Y = { (x, y) | x ∈ X ∧ y ∈ Y }

Union of sets

- X ∪ Y = { z | z ∈ X ∨ z ∈ Y }

Coproduct or disjoint union of sets

- X ⊕ Y = X ⊍ Y = { (0, x) | x ∈ X } ∪ { (1, y) | y ∈ Y }

Elements are tagged to indicate their source

***

### DISJOINT UNION - CASE CLASSES

Disjoint union of 3 ints and 1 int
trait similar to Java interface

```
trait DateSpecifier
case class Absolute (year:Int,mon:Int,day:Int) extends DateSpecifier
case class Relative (daysOffset:Int)    extends DateSpecifier
```

Create instances

```
val ds = new Array[DateSpecifier] (2)
ds (0) = Absolute (2030, 0, 1) // Months are 0.11
ds (1) = Relative (-5)
```

Pattern match to decompose

```
import java.util.{Calendar,Date}

def resolveDate (d:DateSpecifier) : Calendar = {
  val b = new Calendar.Builder
  d match {
    case Absolute (y, m, d) => b.setDate (y, m, d).build
    case Relative (o)       => { 
      val c = b.build                 // Jan 1 1970, Gregorian calendar
      c.setTime (new Date)            // Today, Gregorian calendar
      c.add (Calendar.DAY_OF_YEAR, o) // Add days offset
      c                               // Return updated calendar object
    }
  }
}
```

***

### DISJOINT UNION - C

Union types in C must be tagged manually

```c
struct s_absolute_t {
  int year;
  int mon;
  int day;
};

struct s_relative_t {
  int days_offset;
};

union u_ds_t {
  struct s_absolute_t u_absolute;
  struct s_relative_t u_relative;
};

enum e_ds_t {
  e_absolute,
  e_relative,
};

struct ds_t {
  enum e_ds_t tag;
  union u_ds_t content;
};
```

Create instances
tag / union selector must match!

```
struct ds_t ds[2];
ds[0].tag = e_absolute;
ds[0].content.u_absolute.year = 2030;
ds[0].content.u_absolute.mon  = 0;
ds[0].content.u_absolute.day  = 1;
ds[1].tag = e_relative; 
ds[1].content.u_relative.days_offset = -5;
```

### Examine tag to decompose

Only access union selector matching tag!

```
void print_ds (struct ds_t *dsp) {
  switch (dsp->tag) {
  case e_absolute:
    printf ("absolute (%d, %d, %d)\n", dsp->content.u_absolute.year, 
                                       dsp->content.u_absolute.mon, 
                                       dsp->content.u_absolute.day);
    break;
  case e_relative:
    printf ("relative (%d)\n", dsp->content.u_relative.days_offset);
    break;
  default:
    fprintf (stderr, "Unknown tag\n");
    exit (1);
  }
}
```

***

### RECURSIVE TYPES

- Classes can be recursive
- Peano natural numbers
- Define functions between PeanoNat and Int

```
trait PeanoNat
case object Zero              extends PeanoNat
case class  Succ (n:PeanoNat) extends PeanoNat
```

***

### LINKED LISTS

- Case object/class for Nil and Cons
- Corresponds to cases for pattern matching
- Cons is a pair of head and tail
- Nil used at any List type
    - cf. None:Option[Nothing]

```
trait List[+X]
case object Nil                             extends List[Nothing]
case class  Cons[+X] (head:X, tail:List[X]) extends List[X]
```

***

### BINARY TREES

Binary trees with

- no data stored at leaves
- elements stored at internal nodes
- internal nodes have left and right subtrees

```
trait Tree[+X]
case object Leaf                                 extends Tree[Nothing]
case class  Node[+X] (l:Tree[X], c:X, r:Tree[X]) extends Tree[X]
```

***

### RED-BLACK TREES

```
trait Color
object Red   extends Color
object Black extends Color

trait Tree[+K,+V]
case object Leaf extends Tree[Nothing,Nothing]
case class  Node[+K,+V] (k:K, v:V, c:Color, l:Tree[K,V], r:Tree[K,V]) 
  extends Tree[K,V]

def rotateLeft  [K,V] (t:Node[K,V]) : Node[K,V] = {
  t match {
    case Node (k1, v1, c, l, Node (k2, v2, Red, m, r)) =>
      Node (k2, v2, c, Node (k1, v1, Red, l, m), r)
    case _ => 
      throw new RuntimeException ("does not match: " + t)
  }
}
```
