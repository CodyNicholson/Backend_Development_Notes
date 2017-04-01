# Functional Programming

### PRINT EVERY ELEMENT

How to print every element of a list?

```scala
def printList [X] (xs:List[X]) : Unit = {
  xs match {
    case Nil   => ()
    case y::ys => { 
      println (y)
      printList (ys)
    }
  }
}
```

***

### ??? EVERY ELEMENT

Abstract the idea of processing every element

```scala
def foreach [X] (xs:List[X], f:X=>Unit) : Unit = {
  xs match {
    case Nil   => ()
    case y::ys => { 
      f (y)
      foreach (ys, f)
    }
  }
}

def printElt [X] (x:X) : Unit = println (x)

def printList [X] (xs:List[X]) : Unit = foreach (xs, printElt)
```

```
scala> printList (List (1,2,3))
1
2
3
```

***

### NEW CONTROL STRUCTURES

foreach is a new control structure for lists

f is a function parameter

Type (X=>Unit) means a function that

- takes an argument of type X

- returns a result of type Unit

```scala
def foreach [X] (xs:List[X], f:X=>Unit) : Unit = {
  xs match {
    case Nil   => ()
    case y::ys => { 
      f (y)
      foreach (ys, f)
    }
  }
}
```

***

### ANONYMOUS FUNCTIONS

Eliminate the need to name single-use functions

Pass a named function to foreach

```
def printElt [X] (x:X) : Unit = println (x)

def printList [X] (xs:List[X]) = foreach (xs, printElt)
```

Pass an anonymous function to foreach

```
def printList [X] (xs:List[X]) = foreach (xs, (x:X) => println (x))
```

Anonymous functions AKA lambda expressions

***

### BUILTIN FOREACH

Scala List class has foreach method

```
def printList [X] (xs:List[X]) = xs.foreach ((x:X) => println (x))
```

vs our own foreach function

```
def printList [X] (xs:List[X]) = foreach (xs, (x:X) => println (x))
```

***

### SUM A LIST

Using foreach and a variable in scope

```
def sum (xs:List[Int]) : Int = {
  var result = 0
  xs.foreach ((x:Int) => result = result + x)
  result
}
```

or

```
def sum (xs:List[Int]) : Int = {
  var result = 0
  xs.foreach ((x:Int) => {
    result = result + x
  })
  result
}
```

(but folds are better!)

***

### TRANSFORM ELEMENTS

Create a new list from an old list

Recall that List is immutable in Scala

- so a new list is returned; old list unchanged

```
def transform (xs:List[Int]) : List[String] = {
  xs match {
    case Nil   => Nil
    case y::ys => ("%02d".format (y)) :: transform (ys)
  }
}
```

***

### MAP ON LISTS

Abstract building a new list

f function parameter

- from each element y of old list...

- ...builds an element f(y) of new list
 
```
def map [X,Y] (xs:List[X], f:X=>Y) : List[Y] = {
  xs match {
    case Nil   => Nil
    case y::ys => f (y) :: map (ys, f)
  }
}

def transform (xs:List[Int]) : List[String] = 
  map (xs, (x:Int) => "%02d".format (y))
```

-

#### Example:

Scala List class has a builtin map method

```
import java.io.File

def getFileSizes () : List[(String,Long)] = {
  val files : List[File] = new File (".").listFiles.toList
  files.map ((f:File) => (f.getName, f.length))
}
```

***

### IDENTITY FUNCTION ON LISTS

Identity function: returns the same data

Actually builds a copy of the list

```
def identity [X] (xs:List[X]) : List[X] = {
  xs match {
    case Nil   => Nil
    case y::ys => y :: identity (ys)
  }
}
```

***

### IDENTITY AND MAP PROPERTIES

one cons cell in input => one cons cell in output

∴ input list length = output list length

```
identity (1::(2::(3::Nil)))
--> 1::(identity (2::(3::Nil)))
--> 1::(2::(identity (3::Nil)))
--> 1::(2::(3::(identity (Nil))))
--> 1::(2::(3::(Nil)))
```

```
map (1::(2::(3::Nil)), f)
--> f(1)::(map (2::(3::Nil), f))
--> f(1)::(f(2)::(map (3::Nil, f)))
--> f(1)::(f(2)::(f(3)::(map (Nil, f))))
--> f(1)::(f(2)::(f(3)::(Nil)))
```

***

### FOREACH VS MAP

Compare cons cases

```
foreach discards f(y); map conses f(y)
 def foreach [X] (xs:List[X], f:X=>Unit) : Unit = {
  xs match {
    case Nil   => ()
    case y::ys => { f (y); foreach (ys, f) }
  }
}
def map [X,Y] (xs:List[X], f:X=>Y) : List[Y] = {
  xs match {
    case Nil   => Nil
    case y::ys => f (y) :: map (ys, f)
  }
}
```

***

### FILTER

Only copy elements satisfying predicate f

```
def filter [X] (xs:List[X], f:X=>Boolean) : List[X] = {
  xs match {
    case Nil            => Nil
    case y::ys if f (y) => y :: filter (ys, f)
    case _::ys          => filter (ys, f)
  }
}
```

```
scala> filter ((0 to 15).toList, (x:Int) => (x % 3 != 0))
res1: List[Int] = List(1, 2, 4, 5, 7, 8, 10, 11, 13, 14)
```

***

### CAUTION: "COPY"

In Scala, "copy elements" can mean

- Copy a value of primitive type, e.g., int

- Copy a reference to an object

***

### HIGHER-ORDER FUNCTIONS

foreach, map, filter are higher-order functions

- they take other functions as arguments

***

### FUNCTIONAL PROGRAMMING

PL supports object-oriented programming (OOP)

- objects are first-class citizens

- created/passed at runtime

PL supports functional programming (FP)

- functions are first-class citizens

- created/passed at runtime

- Sometimes: side-effects (assignment!) banned

***

### FP - SCHEME

Scheme supports FP

```
(define (factorial n) 
  (if (equal? n 0)
      1 
      (* n (factorial (- n 1)))))
```

```
#;> (map factorial '(1 2 3 4 5 6 7 8 9 10))
(1 2 6 24 120 720 5040 40320 362880 3628800)
```

***

### FP - JAVA 8

```
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class Map {
  static int factorial (int n) {
    return (n == 0) ? 1 : n * factorial (n - 1);
  }
  public static void main (String[] args) {
    ArrayList<Integer> data = new ArrayList<> ();
    for (int i = 1; i < 10; i++) { data.add (i); }
    data.forEach (x -> System.out.println (x));
    List<Integer> result = 
      data.stream ().map (x -> factorial (x))
                    .collect (Collectors.toList ());
    System.out.println (result);
  }
}
```
