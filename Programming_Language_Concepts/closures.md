# Closures

Runtime support for nested functions

- particularly when lifetimes do not nest

Only applies to static / lexical scope

***

###

### TOP-LEVEL FUNCTIONS

Function declarations made at top level

Not hidden by scope

```
int aux (int n, int result) {
  if (n <= 1) {
    return 1;
  } else {
    return aux (n - 1, n * result);
  }
}

int fact (int n) {
  return aux (n, 1);
}
```

***

### NESTED FUNCTIONS - GCC

Nested function declarations not allowed in C

But GNU C Compiler has extensions for them

```
int fact (int n) {
  int aux (int n, int result) {
    if (n <= 1) {
      return 1;
    } else {
      return aux (n - 1, n * result);
    }
  }
  return aux (n, 1);
}
```

```
$ gcc -c function.c 
$ gcc -pedantic -c function.c 
function.c: In function ‘fact’:
function.c:2:3: warning: ISO C forbids nested functions [-pedantic]
```

-

### EXAMPLE: NESTED FUNCTIONS

```
def printElt [A,B] (f:A=>B) (x:A) : B = {
  println (x)
  f (x)
}
def mapDebug [A,B] (xs:List[A], f:A=>B) : List[B] = {
  xs.map (printElt (f))
}
```

```
def mapDebug [A,B] (xs:List[A], f:A=>B) : List[B] = {
  def printElt (x:A) : B = { 
    println (x)
    f (x)  // use f from enclosing context
  }
  xs.map (printElt)
}
```

```
def mapDebug [A,B] (xs:List[A], f:A=>B) : List[B] = {
  xs.map ((x:A) => { println (x); f (x) })  // make function anonymous
}
```

-

### WHY NESTED FUNCTIONS?

Inner functions may be anonymous

- sometimes aids clarity

Access variables from enclosing context

- avoid duplicating parameters

- requires some runtime support

```
def foldRight [A,B] (xs:List[A], e:B, f:(A,B)=>B) : B = {
  xs match { 
    case Nil     => e
    case y :: ys => f (y, foldRight (ys, e, f))
  }
}
```

```
def foldRight [A,B] (xs:List[A], e:B, f:(A,B)=>B) : B = {
  def aux (xs:List[A]) : B = {
    xs match { 
      case Nil     => e
      case y :: ys => f (y, aux (ys))
    }
  }
  aux (xs)
}
```

-

### WHY NESTED FUNCTIONS?

Limit scope of inner function

Lifetime of inner function vs lifetime of outer function?

Potentially unsafe, and requires more runtime support

- more support than accessing variables from enclosing function

-

### NESTED FUNCTIONS - GCC

From GCC Nested Functions (GCC extensions)

```
If you try to call the nested function through its address after the containing function exits, all hell breaks loose. If you try to call it after a containing scope level exits, and if it refers to some of the variables that are no longer in scope, you may be lucky, but it's not wise to take the risk. If, however, the nested function does not refer to anything that has gone out of scope, you should be safe.
```

Lifetime problems!

Lexical Closures for C++ (T. M. Breuelm, 1988)

-

### NESTED FUNCTIONS - GCC

Lifetime problems caused by nested functions

```
#include <stdio.h>
#include <stdlib.h>

typedef void (*funcptr) (int);

funcptr f (int x) {
  void g (int y) {
    printf ("x = %d, y = %d\n", x, y); // use x from enclosing defn
  }
  for (int i = 0; i < 3; i++) {
    g (i); // OK, f's activation record still allocated
  }
  return &g;
}

int main (void) {
  funcptr h = f (5);
  for (int i = 0; i < 3; i++) {
    (*h) (i); // unsafe to call h, f's activation is deallocated!
  }
  f (6);
  for (int i = 0; i < 3; i++) {
    (*h) (i); // unsafe to call h, f's activation is deallocated!
  }
}
```

-

### NESTED FUNCTIONS - GCC

Unsafe calls may or may not work

```
$ gcc -std=c99 -o gcc-nested gcc-nested.c
$ ./gcc-nested 
x = 5, y = 0 <- safe to call g
x = 5, y = 1
x = 5, y = 2
x = 5, y = 0 <- unsafe to call h, happens to be correct output x=5
x = 5, y = 1
x = 5, y = 2
x = 6, y = 0 <- safe to call g
x = 6, y = 1
x = 6, y = 2
x = 6, y = 0 <- unsafe to call h, incorrect output x should be 5
x = 6, y = 1
x = 6, y = 2
```

-

### NESTED FUNCTION - CLANG

Clang and LLVM

Apple's Blocks extension to C = nested functions

- Ars Technica - Snow Leopard review (2009)
- Apple Developer Library: Introduction to Blocks

Applications (iOS and OSX)

- Graphical user interface callbacks
- Collections processing
- Concurrent tasks

-

### NESTED FUNCTION - CLANG

```
#include <stdio.h>
#include <stdlib.h>
#include <Block.h>

// ^funcptr for blocks; *funcptr for function pointers
typedef void (^funcptr) (int); 

funcptr f (int x) {
  funcptr g;
  g = ^(int y) {      // assign block (anonymous function) to g
    printf ("x = %d, y = %d\n", x, y);
  };
  g = Block_copy (g); // copy g (and x) to heap
  for (int i = 0; i < 3; i++) {
    g (i);
  }
  return g;
}

int main (void) {
  funcptr h = f (5);
  for (int i = 0; i < 3; i++) {
    h (i);
  }
  f (6);
  for (int i = 0; i < 3; i++) {
    h (i);
  }
  Block_release (h); // free g, and reclaim heap space
}
```

-

### NESTED FUNCTION - CLANG

Blocks support is not turned on by default

```
$ clang -o nested-clang nested-clang.c
nested-clang.c:4:15: error: blocks support disabled
   - compile with -fblocks or pick a deployment target that supports
     them
typedef void (^funcptr) (int);
          ^
nested-clang.c:8:7: error: blocks support disabled
   - compile with -fblocks or pick a deployment target that supports
     them
  g = ^(int y) {
      ^
2 errors generated.
```

-

### NESTED FUNCTION - CLANG

Runtime support libraries are needed

```
$ clang -fblocks -o nested-clang nested-clang.c  
/tmp/nested-clang-f9827e.o: In function `f':
nested-clang.c:(.text+0x20): undefined reference to
   `_NSConcreteStackBlock'
clang: error: linker command failed with exit code 1
   (use -v to see invocation)

$ sudo apt-get install libblocksruntime-dev
```

-

### NESTED FUNCTION - CLANG

Correct output

```
$ clang -fblocks -o nested-clang nested-clang.c -lBlocksRuntime
$ ./nested-clang 
x = 5, y = 0 <- safe to call g                    
x = 5, y = 1                                         
x = 5, y = 2                                         
x = 5, y = 0 <- safe to call h, correct output x=5
x = 5, y = 1                                         
x = 5, y = 2                                         
x = 6, y = 0 <- safe to call g                    
x = 6, y = 1                                         
x = 6, y = 2                                         
x = 5, y = 0 <- safe to call h, correct output x=5
x = 5, y = 1
x = 5, y = 2
```

-

### NESTED FUNCTION - CLANG

Without Block_copy and Block_release

```
$ clang -fblocks -o nested-clang nested-clang.c -lBlocksRuntime

$ ./nested-clang 
x = 5, y = 0
x = 5, y = 1
x = 5, y = 2
x = -1857014568, y = 0
Segmentation fault (core dumped)
```

***

### NESTED FUNCTION - SCALA

Nested functions work correctly in Scala

```
def f (x:Int) : Int=>Unit = {
  def g (y:Int) : Unit = { println ("x = %d, y = %d".format (x, y)) }
  for (i <- 0 to 2) {
    g (i)
  }
  g
}

val h = f (5)
for (i <- 0 to 2) {
  h (i)
}
f (6)
for (i <- 0 to 2) {
  h (i)
}
```

-

### NESTED FUNCTION - SCALA

```
x = 5, y = 0 <- safe to call g
x = 5, y = 1
x = 5, y = 2
x = 5, y = 0 <- safe to call h, correct output x=5
x = 5, y = 1
x = 5, y = 2
x = 6, y = 0 <- safe to call g
x = 6, y = 1
x = 6, y = 2
x = 5, y = 0 <- safe to call h, correct output x=5
x = 5, y = 1
x = 5, y = 2
```

-

### NESTED FUNCTION - SCALA

Alternative definition of inner function

Technical distinction between Scala functions and methods

```
def f (x:Int) : Int=>Unit = {
  // def g (y:Int) : Unit = {
  //   println ("x = %d, y = %d".format (x, y))
  // }
  val g:Int=>Unit = (y:Int) => println ("x = %d, y = %d".format (x, y))
  for (i <- 0 to 2) {
    g (i)
  }
  g1  // or g2
}
```

***

### NESTED FUNCTION - JAVA 8

Nested functions work correctly in Java 8

```java
import java.util.function.IntConsumer;

public class NestedFunc1 {
  static IntConsumer f (int x) {
    IntConsumer g = y -> System.out.format ("x = %d, y = %d%n", x, y);
    for (int i = 0; i < 3; i++) {
      g.accept (i);
    }
    return g;
  }

  public static void main (String[] args) {
    IntConsumer h = f (5);
    for (int i = 0; i < 3; i++) {
      h.accept (i);
    }
    f (6); 
    for (int i = 0; i < 3; i++) {
      h.accept (i);
    }
  }
}
```

-

### NESTED FUNCTION - JAVA 8

```
$ javac NestedFunc1.java 
$ java NestedFunc1
x = 5, y = 0 <- safe to call g
x = 5, y = 1
x = 5, y = 2
x = 5, y = 0 <- safe to call h, correct output x=5
x = 5, y = 1
x = 5, y = 2
x = 6, y = 0 <- safe to call g
x = 6, y = 1
x = 6, y = 2
x = 5, y = 0 <- safe to call h, correct output x=5
x = 5, y = 1
x = 5, y = 2
```

-

### NESTED FUNCTION - JAVA 8

Easier to compare to Scala

```java
import java.util.function.Function;

public class NestedFunc2 {
  static Function<Integer,String> f (int x) {
    Function<Integer,String> g = y -> { 
      System.out.format ("x = %d, y = %d%n", x, y); 
      return "dummy";
    };
    for (int i = 0; i < 3; i++) {
      g.apply (i);
    }
    return g;
  }

  public static void main (String[] args) {
    Function<Integer,String> h = f (5);
    for (int i = 0; i < 3; i++) {
      h.apply (i);
    }
    f (6); 
    for (int i = 0; i < 3; i++) {
      h.apply (i);
    }
  }
}
```

***

### JAVA 8 - FP

Other FP machinery added to Java 8

```
import java.util.*;
import java.util.stream.Collectors;

public class NestedFunc3 {
  static <X> void print (List<X> list) {
    list.forEach (x -> System.out.println (x));
  }
  public static void main (String[] args) {
    List<Integer> l = new ArrayList<> ();
    for (int i = 0; i < args.length; i++) {
      l.add (Integer.parseInt (args[i]));
    }
    l = l.stream ().map (x -> x + 1).collect (Collectors.toList ());
    print (list);
  }
}
```

***

### PROBLEM SUMMARY

1. enclosing function outer is called

- AR contains data x

2. outer returns nested function inner

- inner references x from outer's AR
- lifetime of outer's AR and x ends

3. nested function inner is called

- needs x from outer's AR

```
def outer (x:A) : B=>C = {
  def inner (y:B) : C = {
    ...use x and y...
  }
  inner
}
```

***

### IMPLEMENTATION: CLOSURES

Closures store inner function and environment

Environment contains variables from enclosing scope

Lifetime of environment = lifetime of inner function

- environment is allocated on the heap

Different implementations in different PLs

Recurring implementation choice: copy or share?

***

### IMPLEMENTATION CHOICE

Closure contains

- pointer/reference to code for inner
- copies of x and u

inner sees updated u?

Require u to be immutable?

```
def outer (x:A) : B=>C = {
  var u:A = x
  def inner (y:B) : C = {
    ...use u and y...
  }
  u = u + 1
  inner
}
```

-

### IMPLEMENTATION CHOICE

Alternatively, share u

Closure contains

- pointer/reference to code for inner
- copy of x
- reference to shared u (on heap)

```
def outer (x:A) : B=>C = {
  var u:A = x
  def inner (y:B) : C = {
    ...use u and y...
  }
  u = u + 1
  inner
}
```

***

### SCALA IMPLEMENTATION

```
object Closure {
  def outer (x:Int) : Boolean=>Int = {
    def inner (y:Boolean) : Int = {
      x + (if (y) 0 else 1)
    }
    inner
  }
}
```

```
$ scalac Closure.scala

$ ls -1 Closure*
Closure$$anonfun$outer$1.class
Closure.class
Closure$.class
Closure.scala
```

-

### SCALA IMPLEMENTATION

The closure is an instance of the second class

x copied into field x$1

```
$ javap -p Closure
Compiled from "Closure.scala"
public final class Closure {
  public static scala.Function1<java.lang.Object, java.lang.Object> outer(int);
}

$ javap -p Closure\$\$anonfun\$outer\$1
Compiled from "Closure.scala"
public final class Closure$$anonfun$outer$1 extends scala.runtime.AbstractFunction1<java.lang.Object, java.lang.Object> {
  private final int x$1;
  public final int apply(boolean);
  public Closure$$anonfun$outer$1(int);
}
```

(some parts removed)

***

### SCALA IMPLEMENTATION

u is a var declaration, so is mutable

```
object Closure {
  def outer (x:Int) : Boolean=>Int = {
    var u:Int = x
    def inner (y:Boolean) : Int = {
      x + u + (if (y) 0 else 1)
    }
    inner
  }
}
```

-

### SCALA IMPLEMENTATION

x copied into field x$1

u shared on heap via reference in field u$1

```
$ javap -p Closure\$\$anonfun\$outer\$1
Compiled from "Closure.scala"
public final class Closure$$anonfun$outer$1 extends scala.runtime.AbstractFunction1<java.lang.Object, java.lang.Object> {
  private final int x$1;
  private final scala.runtime.IntRef u$1;
  public final int apply(boolean);
  public Closure$$anonfun$outer$1(int, scala.runtime.IntRef);
}
```

(some parts removed)
