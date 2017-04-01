# ARGUMENT PASSING

Consider:

```
def f (x:String, y:Int) = x * y

f ("hello", 10)
```

x, y - formal parameters (or parameters)

"hello", 10 - actual parameters (or arguments)

-

Subtleties in passing arguments

What does a call to f print?

```
void g (int y) {
  y = y + 1;
}

void f () {
  int x = 1;
  g (x);
  print (x);
}
```

***

### CALL-BY-VALUE (CBV)

Most PLs use call-by-value (CBV) by default

To run g (e)

- evaluate e to a value v

- pass a copy of v to g

- callee changes to copy of v not visible to caller

-

#### Example:

For g(x+1) with x = 5

x+1 evaluates to 6

a location containing 6 is given to g

location could be memory or a register

For g(x) with x = 5

x evaluates to 5

a location containing 5 is given to g

location is different to that of x!

#### Answer

Prints 1 in a CBV PL

- I.e., x=1 after call to g

```
void g (int y) {
  y = y + 1;
}

void f () {
  int x = 1;
  g (x);
  print (x);
}
```

***

### CALL-BY-REFERENCE (CBR)

Some PLs use call-by-reference (CBR)

To run g (e)

- evaluate e to an l-value r

- pass the l-value r to g

- callee changes via r are visible to caller

#### CALL-BY-REFERENCE EXAMPLE

For g(x) with x = 5

x evaluates to the location of x

that location (of x) is given to g

g has an alias of x

writing to the alias is visible to caller

##### CALL-BY-REFERENCE ANSWER

Prints 2 in a CBR PL

```
void g (int y) {
  y = y + 1;
}

void f () {
  int x = 1;
  g (x);
  print (x);
}
```

***

### CBR AND TEMPORARIES

Can temporary values be passed as l-values?

f(x+1) is not obviously legitimate in CBR

Some languages reject it

Perl allows it

Modern C++ has a more complex story

-

### CBR IN PERL

Perl uses CBR

```
sub g { 
    $_[0] = $_[0] + 1;
}

sub f {
    my $x = 1;
    g ($x);
    print ("x = $x\n");
}

f ();
$ perl ./cbr.pl 
x = 2
```

But allows temporaries!

```
sub g { 
    $_[0] = $_[0] + 1;
}

sub f {
    my $x = 1;
    g ($x + 1);
    print ("x = $x\n");
}

f ();
$ perl ./cbr.pl 
x = 1
```

-

### SIMULATING CBV IN PERL

Simulate CBV by creating copies explicitly

```
sub g { 
    my ($y) = @_;
    $y = $y + 1;
}

sub f {
    my $x = 1;
    g ($x);
    print ("x = $x\n");
}

f ();
```

```
$ perl ./cbr.pl 
x = 1
```

-

### SIMULATE CBR IN C

Explicitly pass, receive, access a pointer
 
```
void g (int *p) {
  *p = *p + 1;
}

int main () {
  int x = 1;
  g (&x);
  printf ("x = %d\n", x);
  return 0;
}
```

```
$ gcc -o pointer pointer.c 
$ ./pointer 
x = 2
```

-

### SIMULATE CBR IN JAVA

Java has references not pointers

- must point to heap-allocated objects

- cannot point to stack-allocated data

- cannot point to primitive types

Java references cannot be forged

- not from integers via casting

- not from other references via pointer arithmetic

Objects only accessed via references

- unlike C++

- Java has no address-of & operator

-

### SIMULATE CBR IN JAVA

Heap-allocated object with field of intended argument type

Pass a reference to the object instance by value

```
class IntRef { int n; }

public class Ref {
  static void g (IntRef r) { r.n = r.n + 1; }

  public static void main (String[] args) {
    IntRef s = new IntRef (); s.n = 1;
    g (s);
    System.out.println (s.n);
  }
}
```

```
$ javac Ref.java 
$ java Ref
2
```

-

### CBR IN C++

C++ has reference types int&

Unlike int*, creates references (aliases) implicitly

```
#include <iostream>

using namespace std;

void g (int& y) {
  y = y + 1;
}

int main () {
  int x = 1;
  g (x);
  cout << "x = " << x << endl;
  return 0;
}
```

```
$ g++ -o reference reference.cpp 
$ ./reference
x = 2
```

-

```
#include <iostream>

using namespace std;

void g (int& y) {
  y = y + 1;
}

int main () {
  int x = 1;
  g (x + 1);
  cout << "x = " << x << endl;
  return 0;
}
```

```
$ g++ -o reference reference.cpp 
reference.cpp: In function ‘int main()’:
referencs.cpp:11:8: error: invalid initialization of non-const
  reference of type ‘int&’ from an rvalue of type ‘int’
   g (x + 1);
        ^
references.cpp:5:6: error: in passing argument 1 of ‘void g(int&)’
 void g (int& y) {
      ^
```
