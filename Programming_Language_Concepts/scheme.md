#Sheme & Lisp

Lisp (LISt Processor)

Influential programming language from the 1950s

Originally motivated by logic/AI applications

Pioneered many PL concepts:

- automatic garbage collection

- first-class, higher-order, nested functions

- read-eval-print loop including runtime compilation with "eval"

- sophisticated macro system

- multiple dispatch / multi-methods

***

###Lisp & Scheme

Dialects of Lisp: Common Lisp, Scheme, Clojure, Racket

We will use Scheme

Sample Scheme function to find the length of a list

```
; This (recursive) function calculates the length of a linked list.
(define (length l)
  (if (equal? l ())
    0
    (+ 1 (length (cdr l)))))
```

Lots of Infuriating & Silly Parentheses

***

###Literals In Scheme

Number literal

```
5
```

String literal

```
"hello world"
```

Symbol

```
'helloworld
```

***

###ARITHMETIC IN SCHEME

Arithmetic expressions use prefix notation

```
; (1 + 2) * 3 would be written in Scheme as follows
(* (+ 1 2) 3)
```

Parentheses are required for each operator

- Operator precedence not necessary!

Try out

```
(+ 10 5 2)
(- 10 5 2)
```

***

###OPERATOR TERMINOLOGY

Prefix notation: operator before arguments

```
+ 1 2
```

Infix notation: operator between arguments

```
1 + 2
```

Postfix notation: operator after arguments

```
1 2 +
```

***

###Functions

Define a function square with parameter n

```
(define (square n) (* n n))
```

Invoke the square function

```
(square 5)
```

Invoke the square function twice

```
(square (square 5))
```

-

###DEFINING FUNCTIONS

General form is

```
(define (f param_1 param_2 ... param_m)
  e_1 e_2 ... e_n)
```

Takes m arguments

Body of function is a sequence of expressions

e_1, e_2, ..., e_n-1 evaluated for side effect

e_n is evaluated and its result is returned

No return keyword, no statements, just expressions

begin like C comma operator, but not needed

```
(define (f param_1 param_2 ... param_m)
  (begin e_1 e_2 ... e_n))
```

-

###INVOKING FUNCTIONS

Invoke function f with m arguments

```
(f e_1 e_2 ... e_m-1)
```

Parentheses are required

```
(square 5)
```

Try in Scheme REPL

```
square 5
```

***

###EVALUATION ORDER

Expression (f M N) is evaluated by

Evaluating expression M to value U

Evaluating expression N to value V

Invoking function f with values U and V

***

###BOOLEANS AND CONDITIONALS

= operator tests number equality

```
(define (zero n) (= n 0))
```

Boolean values are #t and #f

if special form is an expression

```
(define (safe-divide m n)
  (if (= n 0)
      "divide by zero"
      (/ m n)))
```

***

###RECURSIVE FUNCTIONS

Recursive functions are common in Scheme

Factorial using conditional expressions

```
(define (fact n)
  (if (<= n 1)
      1
      (* n (fact (- n 1)))))
```

Recall C factorial using conditional expressions

```
int fact (int n) {
  return (n <= 1) ? 1 : n * fact (n - 1);
}
```

***

###CONS CELLS

A cons cell is a pair of two pieces of data

Pair of numbers

```
(cons 1 2)
```

Pair of strings

```
(cons "hello" "world")
```

Pair of a number and a string

```
(cons 1 "world")
```

car and cdr functions extract components

```
(car (cons 1 "world"))
(cdr (cons 1 "world"))
```

***

###Cons Cells For Linked Lists

Cons cells (pairs) are used to represent linked lists

**car** position for elements

**cdr** position for next cons cell

-

###Cons Cells For Linked Lists

Linked lists built up using () and cons

Empty list

```
()
```

Singleton list containing 3 only

```
(cons 3 ())
```

List containing 1, 2, 3

```
(cons 1 (cons 2 (cons 3 ())))
```

***

###SYNTACTIC SUGAR FOR LISTS

Quote special form prevents evaluation

```
(quote (3))
(quote (1 2 3))
```

' is shorthand for quote

```
'(3)
'(1 2 3)
```

list function evaluates args, puts results in a list

```
(list 3)
(list 1 2 3)
(list 1 2 (+ 1 2))
```

***

###EQUALITY TESTING FOR LISTS

eq? for pointer equality

```
(eq? (cons 1 (cons 2 (cons 3 ()))) '(1 2 3))
```

equal? for structural equality

```
(equal? (cons 1 (cons 2 (cons 3 ()))) '(1 2 3))
```

Pointer equality compares two pointers

Structural equality traverses two structures

***

###RECURSIVE FUNCTIONS ON LISTS

Compute length of linked list recursively

```
(define (length l)
  (if (equal? l ())
    0
    (+ 1 (length (cdr l)))))
(length '(5 6 7 8 9))
```

Or in Java

```
class Node {
  int item;
  Node next;
}

static int length (Node data) {
  return (data == null) ? 0 : 1 + length (data.next)
```

***

###READ-EVAL-PRINT LOOP (REPL)

Quoting delays evaluation of functions

```
(+ 1 2)
'(+ 1 2)
(car '(+ 1 2))
```

eval function evaluates an expression

```
(eval '(+ 1 2))
(define (add-all l) (eval (append '(+) l)))
(add-all '(1 2 3))
```

read function reads an expression

```
(read)
(eval (read))
(eval (append '(+) (read)))
```

***

###Scheme Stuff

```scheme
(cons 1 (cons 2 (cons 3))) ; Outputs (1 2 3)

(quote (1 2 3)) ; Outputs (1 2 3)

'(1 2 3) ; Outputs (1 2 3)

(list 1 2 3) ; Outputs (1 2 3)

(list 1 2 (+ 2 1)) ; Outputs (1 2 3)

(quote (1 2 (+ 1 2))) ; Outputs (1 2 (+ 1 2))
```

-

####Equals In Scheme

```scheme
(eq? '(1 2 3) '(1 2 3)) ; Outputs false because the lists are stored in separate places
(equal? '(1 2 3) '(1 2 3)) ; Outputs true because the values are equalivalent
```

-

###Linked List Length In Scheme

```scheme
(define (length l)
  (if (equal? l ())
    0
    (+ 1 (length (cdr l))))
)
```
