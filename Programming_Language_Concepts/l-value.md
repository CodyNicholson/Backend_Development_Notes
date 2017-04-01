# L-Value

### R-MODE AND L-MODE

Consider:

```
x = x + 1;
```

Right-hand x denotes

- value read from storage location

Left-hand x denotes

- the storage location (address)

Goes back to Strachey in the 1960s

- Fundamental Concepts in Programming Languages, Christopher Strachey (1967) (local)

***

### L-VALUES

Expression for which l-mode evaluation succeeds

Effectively, has an address

In C, take the address of l-values

```
int x = 5;
int y = 6;
int *p = &x;
int *q = &y;
int **r = &p;
r = &q;
q = p;
**r = 7;
```

-

### NOT L-VALUES

L-mode evaluation sometimes disallowed

In C

```
int x = 5;
int y = 6;
int *p = &(x + y); // not allowed
(x + y) = 7;       // not allowed
```

> (x + y) not an l-value

although it might be stored temporarily

***

### FURTHER L-VALUES

L-values may require r-mode evaluation

Array access in C, Java, etc.

```
arr[n + 2] = 7;
```

Field access in Java, Scala, etc.

```
obj.f1 = 7
```

Combinations (including method calls) in Java, etc.

```
obj.m1 ().f1[n + 2].m2 ().f2 = 7
```
