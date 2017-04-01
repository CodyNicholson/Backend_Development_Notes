# For Expressions

### SET/LIST COMPREHENSIONS

Set comprehensions

- { (m, n) | m ∈ { 0, ..., 10 } ∧ n ∈ { 0, ..., 10 } ∧ m ≤ n }

List comprehensions in many PLs

- SETL (1960s)

- Haskell

- Scala (for expressions)

- JavaScript 1.7!

***

### SCALA: FOR EXPRESSIONS

for expressions with yield keyword have a result

```
val xs : List[Int] = for (n <- (0 to 10).toList) yield (2 * n)
```

***

### FOR EXPRESSIONS - TYPES

Result type determined by expression

If xs : List[T] then x : T

If e : U when x : T, then result : List[U]

```
val result = for (x <- xs) yield e
```

***

### FOR EXPRESSIONS VS MAP

for expressions and map equivalence

```
(for (x <- xs) yield e) == xs.map ((x) => e)
```

For example

```
(for (x <- xs) yield (2*x)) == xs.map ((x) => (2*x))
```

***

### CONDITIONALS

Conditionals filter elements from result

map/filter equivalence

```
for (x <- (0 to 10).toList; if (x % 3 != 0)) yield (2 * x)
```

equivalent to

```
(0 to 10).toList.filter ((x:Int) => x % 3 != 0).map ((x:Int) => 2 * x)
```

***

### FLATTEN

Flattening lists of lists

```
val xss = List(List(1,2,3),List(4,5,6,7),List(8,9),List(10))
xss.flatten == (1 to 10).toList
```

And with for expressions using nested iterations

```
(for (xs <- xss; x <- xs) yield x) == (1 to 10).toList
```
