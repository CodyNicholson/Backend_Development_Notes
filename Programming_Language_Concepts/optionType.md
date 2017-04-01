# Option Type

Option[T] resembles List[T] with length ≤ 1

Example expressions of type Option[Int]

```
None
```

```
Some (5)
```

Type-safe and principled approach to missing data

***

### INTRODUCING OPTIONS

Useful when an answer cannot be returned

```
def safeDivide (m:Int, n:Int) : Option[Int] = {
  if (n == 0) 
    None
  else
    Some (m / n)
}
```

Recall earlier Scheme function

```
(define (safe-divide m n) 
  (if (= n 0) 
      "divide by zero"
      (/ m n)))
```

Also used in arguments (cf. named parameters and builder pattern) / structures

***

### ELIMINATING OPTIONS

Branch and deconstruct options with matching

```
val a : Int = // ...
val b : Int = // ...
safeDivide (a, b) match {
  case None     => println ("failed")
  case Some (x) => println ("result is %d".format (x))
}
```

***

### OPTION ALTERNATIVES

Exceptions

Distinguished values in same type

- -1 for bytes read

- null reference for reference types (Java/Scala)

- NULL pointer for pointers types (C)

***

### INDEXING LISTS

Getting the nth element of a list may fail

```
def index [X] (xs:List[X], n:Int) : Option[X] = xs match {
  case Nil             => None
  case y::_  if n == 0 => Some (y)
  case _::ys           => index (ys, n - 1)
}
```

-

apply method from class List throws exception

```
scala> (10 to 19).toList.apply (9)
res1: Int = 19
```

```
scala> (10 to 19).toList.apply (10)
java.lang.IndexOutOfBoundsException: 10
```

apply method syntactic sugar

```
scala> (10 to 19).toList (9)
res1: Int = 19
```
