#Functional Programming

###PRINT EVERY ELEMENT

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

###??? EVERY ELEMENT

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

###NEW CONTROL STRUCTURES

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

