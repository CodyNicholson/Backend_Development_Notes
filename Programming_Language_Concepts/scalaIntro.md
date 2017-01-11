#Scala Introduction

###Overview

Functional and object-oriented PL

- ML + Java + more

- Scalable Component Abstractions

Compiles to JVM

- Interop: Scala calls Java; Java calls Scala

Examples

- Better Java; distributed systems; data science

- Twitter (Scala School)

- Apache Spark (Scala, Java, Python, R)

***

###SCALA REPL

Scala has a REPL like Scheme, ML, Python, etc.

Boolean, numeric, and string Literals as in Java

```scala
false || true
1 + 2
("hello" + " " + "world").length
```

Access to Java libraries

```scala
import java.io.File
val dir = new File (".")
dir.listFiles.filter (f => f.isFile && f.getName.endsWith (".txt"))
```

***

###SCALA TYPE CHECKING

Scala performs static type checking

```scala
def f () { 5 - "hello" }  // rejected by type checker
```

REPL prints types of expressions

####Java to Scala type hierarchy:

- Java primitive types to Scala value types

- Java reference types to Scala reference types

- java.lang.Object to scala.AnyRef

***

###IMMUTABLE VARIABLES

####Java

```java
final int x = 10;  // declare and initialize x
x = 11;            // assignment to x fails
//Final.java:4: error: cannot assign a value to final variable x
```

-

####C

```c
const int x = 10;  // declare and initialize x
x = 11;            // assignment to x fails
//final.c:6:3: error: assignment of read-only variable ‘x’
```

-

####Scala

```scala
val x = 10         // declare and initialize x
x = 11             // assignment to x fails
//final.scala:3: error: reassignment to val
```

***

###MUTABLE VARIABLES

####Java

```java
int x = 10;        // declare and initialize x
x = 11;            // assignment to x OK
```

-

####C

```c
int x = 10;        // declare and initialize x
x = 11;            // assignment to x OK
```

-

####Scala
```scala
var x = 10         // declare and initialize x
x = 11             // assignment to x OK
```

***

###EXPRESSION ORIENTED

Scala is expression oriented; no statements

like Scheme, ML, etc.

unlike C, Java, etc.

-

####C comma expressions

```c
(e_1, e_2, ..., e_n)
```

-

####Scheme begin expressions

```scheme
(begin e_1 e_2 ... e_n)
```

-

####Scala compound expressions

```scala
{e_1; e_2; ...; e_n}
```

####Semicolons optional (inferred, whitespace sensitive)

```scala
{
  e_1
  e_2
  ...
  e_n
}
```

***

###Functions

Parameters require type annotations

Return types

- can often be inferred

- but are required for recursive functions

Body is an expression; its value is returned

```scala
def plus (x:Int, y:Int) : Int = x + y
```

-

Conditional expressions for factorial

```scala
def fact (n:Int) : Int = if (n <= 1) 1 else n * fact (n - 1)
```

Compound expressions for side-effects

```scala
def fact (n:Int) : Int = {
  println ("called with n = %d".format (n))
  if (n <= 1) {
    println ("no recursive call")
    1 
  } else {
    println ("making recursive call")
    n * fact (n - 1)
  }
}
```

Syntax like C statements, but uses expressions

***

###EVERYTHING IS AN OBJECT

5:Int is an object with methods

```
5.toDouble
```

Methods can have symbolic names

```
5.+ (6)
```

scala.runtime.RichInt adds more methods

```
5.max (6)
```

e1.f(e2) can be written as e1 f e2
```
5 + 6
5 max 6
```

***

###IMMUTABLE TUPLES

Fixed number of heterogeneous items

####Scala

```scala
val p : (Int, String) = (5, "hello")
val x : Int = p._1
```

Java

```java
public class Pair<X,Y> {
  final X x;
  final Y y;
  public Pair (X x, Y y) { this.x = x; this.y = y; }

  static void f () {
    Pair<Integer, String> p = new Pair<Integer, String> (5, "hello");
    Pair<Integer, String> q = new Pair<> (5, "hello"); // infer type params
    int x = p.x;
  }
}
```

***

###IMMUTABLE LINKED LISTS

Varying number of homogeneous items

Fundamentally same as Scheme, C, Java

Good language support

-

####Scheme

```scheme
(cons 1 (cons 2 (cons 3 (cons 4 ()))))
```

####Scala

```scala
1 :: (2 :: (3 :: (4 :: Nil)))
1 :: 2 :: 3 :: 4 :: Nil         // right associative
```

-

Projection called head and tail in many PLs

####Scheme

```scheme
(car (cons 1 (cons 2 (cons 3 (cons 4 ())))))

(cdr (cons 1 (cons 2 (cons 3 (cons 4 ())))))
```

####Scala

```scala
(1 :: (2 :: (3 :: (4 :: Nil)))).head

(1 :: (2 :: (3 :: (4 :: Nil)))).tail
```

-

Syntactic sugar for linked lists

####Scheme

```scheme
'(1 2 3)
```

####Scala

```scala
List (1, 2, 3)
```

***

###MUTABILITY VARIATIONS

Variable mutability orthogonal to data mutability

Java mutable linked list with final variable

```java
final List<Integer> xs = new List<> ();
xs.add (4); xs.add (5); xs.add (6); // mutating list OK
xs = new List<> ();                 // assignment to xs fails
```

Scala immutable linked list with var variable

```scala
var xs = List (4, 5, 6)
xs = 0 :: xs            // assignment to xs OK
xs (1) = 7              // mutating list fails
```

***

###MUTABLE LISTS, ETC.

Scala Collections guide

scala.collection

scala.collection.immutable

scala.collection.mutable

java.util is available

Scala has arrays Array[Int]

***

###PATTERN MATCHING

Branch and deconstruct data with matching

```scala
val p : (Int, String) = // ...
p match {
  case (x, y) => "Int is %d".format (x)
}

val xs : List[Int] = // ...
xs match {
  case Nil   => "List is empty"
  case y::ys => "List is non-empty, head is %d".format (y)
}
```

Found in ML, Haskell, Rust, Swift, etc.

***

###PATTERN MATCHING BEHAVIOR

The behavior of pattern matching...

```scala
val xs : List[Int] = // ...
xs match {
  case Nil   => "List is empty"
  case y::ys => "List is non-empty, head is %d".format (y)
}
```

...branches and binds pattern variables

```scala
var xs : List[Int] = // ...
if (xs == Nil) {
  "List is empty"
} else {
  val y : Int = xs.head
  val ys : List[Int] = xs.tail
  "List is non-empty, head is %d".format (y)
}
```

***

###SIMPLE LIST OPERATIONS

Implement isEmpty, head, tail by pattern matching

Parametric polymorphism: X is type parameter

```scala
def isEmpty [X] (xs:List[X]) : Boolean = xs match {
  case Nil   => true
  case y::ys => false
}

def head [X] (xs:List[X]) : X = xs match {
  case Nil   => throw new NoSuchElementException ()
  case y::ys => y
}

def tail [X] (xs:List[X]) : List[X] = xs match {
  case Nil   => throw new NoSuchElementException ()
  case y::ys => ys
}
```

***

###FUNCTIONS VS METHODS

Builtin head method from List class

```scala
List (1, 2, 3).head
```

head function defined on previous slide

```scala
head (List (1, 2, 3))
```

***

###RECURSIVE FUNCTIONS

Imperative programming typically has

- iteration using while loops

- mutable programming

Functional programming typically has

- iteration using recursion

- immutable programming

Efficient function calls / recursion

***

###RECURSIVE FUNCTIONS: LISTS

Length of a linked list recursively

```scala
def length (xs:List[Int]) : Int = xs match {
  case Nil   => 0
  case y::ys => 1 + length (ys)
}
```

With parametric polymorphism

```scala
def length [X] (xs:List[X]) : Int = xs match {
  case Nil   => 0
  case y::ys => 1 + length (ys)
}
```

Ignore head of list with wildcard _

```scala
def length [X] (xs:List[X]) : Int = xs match {
  case Nil   => 0
  case _::ys => 1 + length (ys)
}
```

***

###REASONING

Evaluate step-by-step

```
length (List (1, 2, 3))
--> length (1::(2::(3::Nil)))
--> 1 + length (2::(3::Nil))      // y = 1, ys = 2::(3::Nil)
--> 1 + (1 + length (3::Nil))     // y = 2, ys = 3::Nil
--> 1 + (1 + (1 + length (Nil)))  // y = 3, ys = Nil
--> 1 + (1 + (1 + 0))
--> 1 + (1 + 1)
--> 1 + 2
--> 3
```

```scala
def length (xs:List[Int]) : Int = xs match {
  case Nil   => 0
  case y::ys => 1 + length (ys)
}
```

The expression is the state of the computation

***

###APPENDING LISTS

Join two lists with append

A new list is returned

The two lists are not modified

But the second list is shared!

```scala
def append [X] (xs:List[X], ys:List[X]) : List[X] = xs match {
  case Nil   => ys
  case z::zs => z::(append (zs, ys))
}
```

The expression is the state of the computation

-

Evaluate step-by-step

```
append (1::(2::Nil), 3::Nil)
--> 1::(append (2::Nil, 3::Nil))    // z = 1, zs = 2::Nil
--> 1::(2::(append (Nil, 3::Nil)))  // z = 2, zs = Nil
--> 1::(2::(3::Nil))                // z = 2, zs = Nil
```

```scala
def append [X] (xs:List[X], ys:List[X]) : List[X] = xs match {
  case Nil   => ys
  case z::zs => z::(append (zs, ys))
}
```

Cons cells created with 1 and 2 in head

Cons cell (3::Nil) is reused (shared)

***

###SCHEME COMPARISON

####Scala

```scala
def append [X] (xs:List[X], ys:List[X]) : List[X] = xs match {
  case Nil   => ys
  case z::zs => z::(append (zs, ys))
}
```

####Scheme

```scala
(define (append xs ys) 
  (if (equal? xs ()) 
      ys 
      (cons (car xs) (append (cdr xs) ys))))
```

***

###APPENDING LISTS

List class has builtin method :::

```
scala> ((1 to 5).toList) ::: ((10 to 15).toList)
res1: List[Int] = List(1, 2, 3, 4, 5, 10, 11, 12, 13, 14, 15)
```

***

###UNKNOWN FUNCTIONS

```scala
def f [X] (xs:List[X]) : List[X] = xs match {
  case Nil   => Nil
  case y::ys => f (ys) ::: List (y)
}
```

What does f do?

```
f (Nil)
--> Nil
```

```
f (3::Nil)
--> f (Nil) ::: List (3)
--> Nil ::: List (3)
--> List (3)
```

```
f (2::(3::Nil))
--> f (3::Nil) ::: List (2)
--> List (3) ::: List (2)
--> List (3, 2)
```

```
f (1::(2::(3::Nil)))
--> f (2::(3::Nil)) ::: List (1)
--> List (3, 2) ::: List (1)
--> List (3, 2, 1)
```

Conclusion: f is reverse
