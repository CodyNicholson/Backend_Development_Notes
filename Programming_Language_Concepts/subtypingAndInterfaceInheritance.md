# Subtyping & Interface Inheritance

### INTERFACES

Two senses for interface

General sense: interfaces = contracts

Java-specific sense: interface declarations

-

Informal usage for dynamically-typed PLs

- documentation describes what is allowed
- dynamic errors may occur if the interface is not obeyed or the interface was incorrect

Formal usage for statically-typed PLs

- static checks that data uses interfaces correctly
- to eliminate dynamic errors

These slides apply to statically-typed PLs

-

Class declarations describe interfaces

- can invoke f method on any instance of A
- pass an int and expect one to be returned

Declaration also provides method implementations

```
class A {
  public int f (int x)         { ... }
  public int g (String[] arr)  { ... }
  public void h (int x, int y) { ... }
}
```

```
A o = new A ();
int p = o.f (5); // OK, instances of A must have f implementations
```

***

### INTERFACE INHERITANCE

Subclassing introduces interface inheritance

From class B, class C inherits

- requirement/guarantee of f method

```
class B {
  public int f (int x)         { ... }
}

class C extends B {
  public int f (int x)         { ... }
  public int g (String[] arr)  { ... }
}
C o = new C ();
int p = o.f (5); // OK, instances of C must have f methods
```

***

### SUBTYPING

Since instances of C provide f

- safe to use where instances of B are expected

Say that C is a subtype of B

- written C<:B

Subtyping is not just subclassing

***

### SUBTYPING & SUBSTITUTION

If Y<:X and e:Y, then e:X also

- (because e satisfies the contract for type X)

This substitution is sometimes called upcasting

```
B o = new C ();   // OK to upcast because C <: B
```

```
class D {
  static void foo (B b) { ... }
}

D.foo (new C ()); // OK to upcast arg of type C to 'foo' because C <: B
```

```
class E {
  static C bar () { ... }
}

B o = E.bar ();   // OK to upcast result from C to B because C <: B
```

***

### DOWNCASTING

Downcasting is potentially unsafe

- requires explicit cast in Java, Scala, etc.
- also requires storing type at runtime
- downcast introduces a dynamic check (Java)

```
class B {
  public int f (int x)         { ... }
}

class C extends B {
  public int f (int x)         { ... }
  public int g (String[] arr)  { ... }
}
B[] arr = new B[2];
arr[0] = new C (); arr[1] = new B ();
((C) arr[0]).g (...); // OK, dynamic check succeeds
((C) arr[1]).g (...); // dynamic check fails, ClassCastException thrown
```

-

Examine runtime downcast check

```
class B {
  public int f (int x)         { return 1; }
}

class C extends B {
  public int f (int x)         { return 2; }
  public int g (String[] arr)  { return 3; }

  static void test (B o) {
    C p = (C) o;
    p.g (new String[] { "hello" });
  }
}
```

-

```
$ javap -c C
Compiled from "B.java"
class C extends B {
  ...
  static void test(B);
    Code:
       0: aload_0
       1: checkcast     #2  // class C  <-- RUNTIME DOWNCAST CHECK
       4: astore_1
       5: aload_1
       6: iconst_1
       7: anewarray     #3  // class java/lang/String
      10: dup
      11: iconst_0
      12: ldc           #4  // String hello
      14: aastore
      15: invokevirtual #5  // Method g:([Ljava/lang/String;)I
      18: pop
      19: return
}
```

***

### UPCASTING & DOWNCASTING

```
Y<:X

upcast (always safe) e:Y --> e:X

X --- Y

downcase (potentially unsafe) e:y <-- e:X
```

***

### SUBTYPING PREORDER

Subtyping relation <: is a preorder on types

- reflexive - X<:X
- transitive - if X<:Y and Y<:Z then X<:Z

***

### SUBTYPING PREORDER - TOP

Some PLs have a Top type

- X<:Top (greater than all other types)

In Java - java.lang.Object above reference types

In Scala - scala.Any above all types

In Scala - scala.AnyRef above reference types

```
import java.io.FileInputStream

val xs:List[AnyRef] = List ("hello", new FileInputStream ("a.txt"))
val ys:List[Any]    = List ("hello", 1)
```

***

### SUBTYPING: LISTS

```
Subtyping for Scala lists
If Y<:X then List[Y]<:List[X]
 class B {
  def f (x:Int) : Int             = 1 
}

class C extends B {
  override def f (x:Int) : Int    = 2
  def g (arr:Array[String]) : Int = 3
}
```

```
val xs1:List[B] = List (new B, new B) // OK
val xs2:List[C] = List (new C, new C) // OK
val xs3:List[B] = List (new B, new C) // OK, because C <: B
val xs4:List[B] = xs2                 // OK, because List[C] <: List[B]
xs4 (1).f (0)                         // OK, f method exists at runtime
```

***

### SUBTYPING PREORDER - BOTTOM

Most PLs do not have a Bottom type

- Bottom<:X (less than all other types)

Recall Scala type hierarchy

In Scala - Bottom is scala.Nothing

Important for typing uses of Nil

- Nil:List[Nothing]
- List[Nothing]<:List[X]

```
val mynil1:List[Int]     = Nil
val    xs1:List[Any]     = "hello"::mynil1 // Best type possible

val mynil2:List[Nothing] = Nil
val    xs2:List[String]  = "hello"::mynil2 // Best type possible
```

***

### COVARIANCE

List said to be covariant

Generally, C[-] is covariant if and only if

- Y<:X implies C[Y]<:C[X]

***

### ARRAYS NOT COVARIANT

In Scala, Array[C]<:Array[B]? No!

Array is invariant

```
class B {
  def f (x:Int) : Int             = 1 
}

class C extends B {
  override def f (x:Int) : Int    = 2
  def g (arr:Array[String]) : Int = 3
}
```

```
val xs1:Array[B] = Array (new B, new B) // OK
val xs2:Array[C] = Array (new C, new C) // OK
val xs3:Array[B] = Array (new B, new C) // OK, because C <: B
val xs4:Array[B] = xs2 // Not allowed; following steps must not occur
xs4 (0) = new B        // OK, because xs4:Array[B]
xs2 (0).g ()           // OK because xs2 (0) : C (statically)
                       // but fails because xs2 (0) : B (dynamically)
```

-

Compiler error message agrees

```
val xs1:Array[B] = Array (new B, new B)
val xs2:Array[C] = Array (new C, new C)
val xs3:Array[B] = Array (new B, new C)
val xs4:Array[B] = xs2 // TYPECHECKING FAILS HERE
```

```
error: type mismatch;
 found   : Array[C]
 required: Array[B]
Note: C <: B, but class Array is invariant in type T.
You may wish to investigate a wildcard type such as `_ <: B`. [...]
       val xs4:Array[B] = xs2
                          ^
```

-

Problem summary: two views of same array

- xs4 - write values of type B
- xs2 - read values of type C

```
class B {
  def f (x:Int) : Int             = 1 
}

class C extends B {
  override def f (x:Int) : Int    = 2
  def g (arr:Array[String]) : Int = 3
}
```

```
val xs2:Array[C] = Array (new C, new C) // OK
val xs4:Array[B] = xs2 // Not allowed; following steps must not occur
xs4 (0) = new B        // OK, because xs4:Array[B]
xs2 (0).g ()           // OK because xs2 (0) : C (statically)
                       // but fails because xs2 (0) : B (dynamically)
```

***

### JAVA ARRAYS COVARIANT

Java arrays are covariant, unlike Scala arrays

Java runtime checks assignments to arrays

```
public class Driver {
  public static void main (String[] args) {
    C[] xs2 = new C[] { new C (), new C () };
    B[] xs4 = xs2;     // Uses covariance of Java arrays
    xs4[0] = new B (); // Compiles OK, fails at runtime
    xs2[0].g (new String[] { }); 
  }
}
```

```
$ javac Driver.java 

$ java Driver
Exception in thread "main" java.lang.ArrayStoreException: B
  at Driver.main(Driver.java:14)
```

***

### CONTRAVARIANT

Write-only data types often contravariant

+X, -X indicate co/contra-variant in Scala

Variance declarations checked by compiler

```
// Covariant in X
trait RefR[+X] {
  def get () : X
}

// Contravariant in X
trait RefW[-X] { 
  def set (x:X) : Unit
}

// Invariant in X
class Ref[X] (var contents:X) extends RefR[X] with RefW[X] {
  def get () : X = contents
  def set (x:X) : Unit = contents = x
}
```

-

Test classes with C<:B<:A

- RefR[C]<:RefR[B]<:RefR[A]
- RefW[A]<:RefW[B]<:RefW[C]

```
class A {
}

class B extends A {
  def f (x:Int) : Int             = 1 
}

class C extends B {
  override def f (x:Int) : Int    = 2
  def g (arr:Array[String]) : Int = 3
}
```

-

Create reference cell holding B instances

r3 - reading A instances (weaker guarantee)

r7 - writing C instances (stronger requirement)

```
val r1:Ref[B] = new Ref[B] (new B)

val r2:Ref[A]  = r1 // Typechecker rejects
val r3:RefR[A] = r1 // OK, Ref[B]<:RefR[B]<:RefR[A]
val r4:RefW[A] = r1 // Typechecker rejects

val r5:Ref[C]  = r1 // Typechecker rejects
val r6:RefR[C] = r1 // Typechecker rejects
val r7:RefW[C] = r1 // OK, Ref[B]<:RefW[B]<:RefW[C]

val o:C = new C
r7.set (o)
val p:A = r3.get () // o == p (o's type is more accurate than p's type)
```

***

### VARIANCE

For C[-] and Y<:X

|                 |  Covariant  | Invariant    | Contravariant |
|:--------------- |:-----------:|:------------:|:-------------:|
| Relationship    | C[Y]<:C[X]  | -            | C[X]<:C[Y]    |
| Example         | List[-]     | Array[-]     | ???           |
| Data Structure  | read only   | read & write |    write only |

***

### POLYMORPHISM

Polymorphism from dynamic dispatch in OO PLs 
called subtype polymorphism

Polymorphism from type parameters in PLs 
called parametric polymorphism

Outside the scope of this course

- bounded polymorphism (Java, C#, Scala, Flow)
- Java's use-site variance and wildcards
- adhoc polymorphism, typeclasses, implicit params
