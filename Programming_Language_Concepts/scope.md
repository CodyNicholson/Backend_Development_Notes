# Scope

Scope of an identifier

- region of text in which it may be used

-

### COMMON SCOPE RULES

z is in scope after its declaration until end of if

```
void f (int x) {
  int y = x + 1;
  if (x > y) {
    int z = y + 1;
    printf ("z = %d\n", z);
  }
}
```

***

### FORWARD DECLARATIONS

C, C++ require forward declarations

Most other modern languages do not

```
char f (int x);

char g (int x) {
  return f (x) + f (x);
}

char f (int x) {
  if (x > 0) { 
    return g (x >> 8);
  } else {
    return 1;
  }
}
```

***

### SHADOWING - JAVA

Is shadowing allowed in Java?

See Java Language Specification

```
public class C {
  static void f () {
    int x = 1;
    {
      int y = x + 1;
      {
        int x = y + 1;
        System.out.println ("x = " + x);
      }
    }
  }
}
```

```
$ javac C.java 
C.java:7: error: variable x is already defined in method f()
        int x = y + 1;
            ^
1 error
```

-

Fields have different treatment

```
public class C {
  static int x = 1;
  static void f () {
    int y = x + 1;
    {
      int x = y + 1;
      System.out.println ("x = " + x);
    }
  }
  public static void main (String[] args) {
    f ();
  }
}
$ javac C.java 
$ java C
x = 3
```

***

### SHADOWING C

C is less strict than Java (on shadowing)

```
int main () {
  int x = 1;
  {
    int y = x + 1;
    {
      int x = y + 1;
      printf ("x = %d\n", x);
    }
  }
}
```

```
$ gcc -o scope scope.c 
$ ./scope
x = 3
```

***

### SHADOWING SCALA

Scala is less strict than Java (on shadowing)

```
object C {
  def f () {
    var x = 1;
    {
      var y = x + 1;
      { 
        var x = y + 1;
        println ("x = " + x)
      }
    }
  }
  def main (args:Array[String]) {
    f ()
  }
}
```

```
$ scalac C.scala 
$ scala C
x = 3
```

Shadowing occurs in the REPL naturally

```
scala> val x = 1
x: Int = 1

scala> def f (a:Int) = x + a
f: (a: Int)Int

scala> f (10)
res0: Int = 11

scala> val x = 2
x: Int = 2

scala> x
res1: Int = 2

scala> f (10)
res2: Int = 11
```

REPL behavior corresponds to

```
{
  val x = 1;
  def f (a:Int) = x + a
  f (10)
  {
    val x = 2; 
    x
    f (10)
    ...
  }
}
```

***

### SHADOWING AND RECURSION

Is x in scope?
 
```
int main (void) {
  int x = 10;
  {
    int x = x + 1;
    printf ("x = %08x\n", x);
  }
  return 0;
}
```

```
$ gcc -o scope scope.c

$ gcc -Wall -o scope scope.c
scope.c: In function ‘main’:
scope.c:5:7: warning: unused variable ‘x’ [-Wunused-variable]
scope.c:7:9: warning: ‘x’ is used uninitialized in this function [-Wuninitialized]

$ ./scope 
x = 00000001
```

-

### RECURSION SCALA

Scala requires initialization of variables

Recursion is allowed, and sometimes makes sense

Scala's Stream type for lazy sequences

```
scala> val ones:Stream[Int] = 1 #:: ones
ones: Stream[Int] = Stream(1, ?)

scala> ones.take (5)
res0: scala.collection.immutable.Stream[Int] = Stream(1, ?)

scala> ones.take (5).toList
res1: List[Int] = List(1, 1, 1, 1, 1)
```

***

### SCALA STREAMS

Lazy evaluation of stream elements

```
scala> def f (x:Int) : Int = { println ("f(%d)".format (x)); x+1 }
f: (x: Int)Int

scala> val q:Stream[Int] = 1 #:: (q.map (f))
q: Stream[Int] = Stream(1, ?)

scala> q.take (3).toList
f(1)
f(2)
res0: List[Int] = List(1, 2, 3)

scala> q.take (3).toList
res1: List[Int] = List(1, 2, 3)

scala> q.take (4).toList
f(3)
res2: List[Int] = List(1, 2, 3, 4)

scala> q
res3: Stream[Int] = Stream(1, 2, 3, 4, ?)
```

***

### TERMINOLOGY: OCCURRENCES

Occurrences of identifiers classified as one of

- free occurrence has no matching binding

```
y = 5*x;   // Free occurrences of x and y
```

binding occurrence declares the identifier

```
int y;    // binding occurrence of y
```

bound occurrence follows matching declaration

```
int y;    // Binding occurrence of y
int x;    // Binding occurrence of x

x=6;      // Bound occurrence of x
y = 5*x;  // Bound occurrences of x and y
```

Complete programs usually have no free occurrences of identifiers

How do IDEs treat free occurrences?

##### NOT JUST VARIABLES

Applies to identifiers for

- normal variables
- function parameters
- function type parameters
- function/method names
- class names
- and more

***

### WHAT DOES THIS PROGRAM DO?

What does this program do?

Using Scala syntax, but various different semantics

- not just Scala's semantics

```
var x:Int = 0
def foo () {
  x = x + 1
}
def bar () {
  var x:Int = 0
  foo ()
}
bar ()
println (x)
```

***

### STATIC SCOPE

Static scope: identifiers are bound to the closest binding occurrence in an enclosing block of the program code

Static scoping property: We can rename any identifier, so long as we rename it consistently throughout its scope 
(and so long as the new name we have chosen does not appear in the scope)

Also known as lexical scope

***

### DYNAMIC SCOPE

Dynamic scope: identifiers are bound to the binding occurrence in the closest activation record.

Consistent renaming may break a working program!

-

Where could z come from?

```
...
def g (x:Int) : Int = {
  var y:Int = x * 2
  z * x * y          // x and y are local; z is non-local
}
```

##### Dynamic scope:

- non-locals are not resolved (bound) until runtime
- to resolve non-local identifier, look at the callers

***

### STATIC VS DYNAMIC SCOPE

Scala uses static scope (prints 1)

Most languages do use static scope

```
var x:Int = 0
def foo () : Unit = {
  x = x + 1
}
def bar () : Unit = {
  var x:Int = 0
  foo ()
}
bar ()
println (x)
```

-

Well-known PLs have included dynamic scoping...

- Lisp, Perl, Python

...and later added static scoping!

-

##### Emacs Lisp (prints "0"):

```
(let ((x 0))
  (defun foo ()
    (setq x (+ x 1)))
  (defun bar ()
    (let ((x 0))
      (foo)))
  (bar)
  (message (int-to-string x)))
```

-

##### Common Lisp (prints 1):

```
(let ((x 0))
  (defun foo ()
    (setq x (+ x 1)))
  (defun bar ()
    (let ((x 0))
      (foo)))
  (bar)
  (print x))
```

-

##### Scheme (prints 1):

```
(let ((x 0))
  (define (foo)
    (set! x (+ x 1)))
  (define (bar)
    (let ((x 0))
      (foo)))
  (bar)
  (display x)
  (newline))
```

-

##### Perl (prints 0):

```
local $x = 0;
sub foo {
    $x = $x + 1;
}
sub bar {
    local $x = 0;
    foo ();
}
bar ();
print ($x);
```

-

##### Perl (prints 1):

```
my $x = 0;
sub foo {
    $x = $x + 1;
}
sub bar {
    my $x = 0;
    foo ();
}
bar ();
print ($x);
```
