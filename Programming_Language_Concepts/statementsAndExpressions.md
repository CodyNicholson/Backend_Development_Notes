# Statements & Expressions

**Statements**: Executed for their side-effects

**Expressions**: Executed for their value

***

### Expressions

Literals (boolean, character, integer, string)

Operators (Arithmetic, bitwise, logical)

Function calls

```
f (1 + (2 * strlen ("hello")))
```

***

### Statements

Expression statements (including asssignment)

Return statements

Selection statements (if-then-else; switch-case)

Iteration statements (while, do-while, for)

```
int count = 0;
while (1) {
  int ch = getchar ();
  switch (ch) {
  case -1: return count;
  case 'a': count = count + 1;
  default: continue;
  }
}
```

***

#### ++x++

++x, x afterward will be 6, value returned will be 6

x++, x afterward will be 6, value returned will be 5

Different compliers treat this differently - C is not portable

-

## Side-Effecting Expressions

```
x++

x += 2

x = (y = 5)

x -= (y += 5)

int global = 0;

int post_inc () {
  return global++;
}

int main () {
  printf ("%d\n", post_inc () + post_inc ());
}
```

-

### C's Ternary Operator

Ia a **conditional expression**

```
(e1 ? e2 : e3)
```

If expression e1 evaluates to true, take result of evaluating e2. Otherwise, take result of evaluating e3

-

### Conditional Statement Vs Conditional Expression

```
int fact (int n) {
  if (n <= 1) {
    return 1;
  } else {
    return n * fact (n - 1);
  }
}

int fact (int n) {
  return (n <= 1) ? 1 : n * fact (n - 1);
}
```

***

### C's Comma Operator

(e1, e2, ..., en)

Executes expressions from left to right

Take result of evaluating en

Side effects

Sequential execution of expressions!

```
int main () {
  int x = 5;
  x *= 2;
  printf ("%d\n", x);
}

int main () {
  int x = 5;
  printf ("%d\n", (x *= 2, x));
}
```
