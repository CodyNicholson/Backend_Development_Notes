#Dynamic Type Checking

Tracks and stores type of data at *runtime*

Checks types before applying an operation

Example in python:

```python
1 + "2"
```

This will throw an error because python has Dynamic Type Checking, and after it checks that one variable is an int and one is a String it throws an error that it cannot add them

-

####How do we tell if it is dynamically typed?

- Defer computation to function body

- Failure is when f runs

- Conclusion: no type checking before execution

```scheme
#;> (define (f) (- 5 "hello"))
#;> (f)
;Error in -: expected type number, got '"hello"'.
```
