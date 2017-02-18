#Case Study: C++ & V-Tables

Very large PL

Brief overview of

- OO features
- vtable implementation of dynamic dispatch

***

###C++ EVOLUTION

C++98, C++03, C++11, C++14, C++17

Sampling of new features

- memory model for concurrency
- lambda expressions
- rvalue references / move constructors
- type inference
- tuple types

***

###HELLO WORLD!

```
#include <iostream>

int main () {
  std::cout << "Hello world" << std::endl;
  return 0;
}
```

```
$ g++ -std=c++11 -o hello hello.cpp

$ ./hello 
Hello world
```

***

###CLASS DEFINITIONS

Member variables (AKA fields, instance variables)

Member functions (AKA methods) with inline impl.

Access control using public, private

Constructor has initializer list before (empty) body

```
class Counter {
private:
  int count;
public:
  Counter () : count {0} {};
  int get () { return count++; }
  void reset () { count = 0; }
};
```

***

###STACK ALLOCATION

Create instance of Counter in AR on stack

```
#include <iostream>

class Counter {
private:
  int count;
public:
  Counter () : count {0} {};
  int get () { return count++; }
  void reset () { count = 0; }
};

int main () {
  Counter c;
  std::cout << "a: " << c.get () << std::endl;
  std::cout << "b: " << c.get () << std::endl;
  std::cout << "c: " << c.get () << std::endl;
}
```

-

Results:

Run previous code with stack-allocated Counter
 
```
$ g++ -std=c++11 -o class01 class01.cpp

$ ./class01 
a: 0
b: 1
c: 2
```

***

###HEAP ALLOCATION

Create instance of Counter on heap

Recall p->get() means (*p).get()

```
#include <iostream>

class Counter {
private:
  int count;
public:
  Counter () : count {0} {};
  int get () { return count++; }
  void reset () { count = 0; }
};

int main () {
  Counter* p = new Counter;
  std::cout << "a: " << p->get () << std::endl;
  std::cout << "b: " << p->get () << std::endl;
  std::cout << "c: " << p->get () << std::endl;
}
```

***

###JAVA VS C++ OBJECTS

Java implicitly dereferences references to instances!

Java using reference to heap-allocated instance

```
Counter r = new Counter ();  // reference r on stack, instance on heap
r.get ();                    // invoke 'get' via reference
```

C++ using pointer to heap-allocated instance

```
Counter* p = new Counter (); // pointer p on stack, instance on heap
p->get ();                   // invoke 'get' via pointer
```

C++ with stack-allocated instance

```
Counter c;                   // instance on stack
c.get ();
```

***

###STORAGE LOCATION

Print locations of allocated data

```
int main () {
  Counter c;
  Counter* p = new Counter;
  cout << "&c = " << &c << std::endl; // stack-allocated local var
  cout << "&p = " << &p << std::endl; // stack-allocated local var
  cout << " p = " << p << std::endl;  // heap-allocated instance
}
```

```
$ g++ -std=c++11 -o class02 class02.cpp

$ ./class02
&c = 0x7ffe2ae9b490
&p = 0x7ffe2ae9b498
 p = 0x20c4010
```

***

###C++ STORAGE SUBTLETIES

Many options to control copying or moving of instances

Nothing comparable in Java, Scala, Python, Ruby, etc.

***

###SINGLE INHERITANCE - FIELDS

```
#include <iostream>

class A {
public:
  int m;
  A (const int m) : m {m} {}
};

class B : public A {
public:
  int n;
  B (const int m, const int n) : A {m}, n {n} {}
};

int main () {
  std::cout << "sizeof (A) = " << sizeof (A) << std::endl;
  std::cout << "sizeof (B) = " << sizeof (B) << std::endl;
  B* p = new B (3, 5);
  std::cout << "p->m = " << p->m << std::endl;
  std::cout << "p->n = " << p->n << std::endl;
}
```

***

###STATIC DISPATCH

C++ uses the static type to determine impl. by default

The following program prints A

```
#include <iostream>

class A { 
public: 
  void foo () { std::cout << "A" << std::endl; } 
};

class B : public A {
public: 
  void foo () { std::cout << "B" << std::endl; } 
};

int main () { 
  A* x = new B (); // static type of x is A*, dynamic type of x is B*
  x->foo ();       // invokes A::foo
}
```

***

###DYNAMIC DISPATCH

Add virtual in base (super) class to use dynamic type

The following program prints B

```
#include <iostream>

class A { 
public: 
  virtual void foo () { std::cout << "A" << std::endl; } 
};

class B : public A {
public: 
  void foo () override { std::cout << "B" << std::endl; } 
};

int main () { 
  A* x = new B (); // static type of x is A*, dynamic type of x is B*
  x->foo ();       // invokes B::foo
}
```

***

###ABSTRACT CLASSES

Abstract methods indicated by =0 instead of impl.

```
#include <iostream>

class A { 
public: 
  virtual int f (int x) { 
    std::cout << "A.f (" << x << ")" << std::endl; 
    if (x == 0) {
      return g ();
    } else {
      return f (x - 1);
    }
  } 
  virtual int g () = 0; // g is abstract
};

class B : public A {
public: 
  int g () override { std::cout << "B.g ()" << std::endl; return 0; } 
};

int main () { 
  (new B ())->f (3); 
}
```

***

###REFRESHER: 32-BIT X86

See textbook for Systems I & II prerequisite courses

Chapter 7 of Mitchell textbook

- CAUTION: diagrams in Ch. 7 of Mitchell textbook are not intended to match the x86 activation record layout

-

32-bit integers and 32-bit addresses

32-bit registers

- General purpose registers: %eax,%ebx,%ecx,%edx
- Base pointer: %ebp
- Stack pointer: %esp

***

###REFRESHER: 32-BIT X86

Dereference memory location %ebp-4, then copy contents to %eax

```
movl -4(%ebp), %eax
```

Tip: on a 64 bit system, compile 32 bit code using:

```
$ gcc -march=i386 -m32 foo.c
$ g++ -march=i386 -m32 foo.cc
```

***

###C++ OBJECT REPRESENTATION

Study object representation by looking at x86

Identify vtables supporting dynamic dispatch

Sections 11.5 & 12.3 of Mitchell textbook cover vtables

***

###SINGLE INHERITANCE: FIELDS

Impl. of single inheritance with no methods

```
#include <iostream>

class C {
public: 
  unsigned int c1;
  unsigned int c2;
};

class D : public C {
public: 
  unsigned int d1;
  unsigned int d2;
};

int main () {
  D *d = new D ();
  d->d1 = 9032;
  d->d2 = 3293;
  d->c1 = 2948;
  d->c2 = 8432;
  C *c = d; // OK to upcast
  unsigned int x1 = c->c1;
  unsigned int x2 = c->c2;
  std::cout << "Values are: " << x1 << ", " << x2 << std::endl;
}
```

***

###SINGLE INHERITANCE: FIELDS

Compile with G++ to assembly

```
$ g++ -S singlefields.cpp
```

C and assembly side-by-side

***

###SINGLE INHERITANCE: METHODS

Generate vtables and code for dynamic dispatch

C and assembly side-by-side

```
#include <iostream>

class C {
public: 
  unsigned int c1;
  unsigned int c2;
  virtual void f1 () { std::cout << "C.f1" << std::endl; }
  virtual void f2 () { std::cout << "C.f2" << std::endl; }
};

class D : public C {
public: 
  unsigned int d1;
  unsigned int d2;
  virtual void f2 () { std::cout << "D.f2" << std::endl; }
  virtual void f3 () { std::cout << "D.f3" << std::endl; }
};

int main () {
  D *d = new D ();
  d->c1 = 2948;
  d->f1 ();
  d->f2 ();
  d->f3 ();
  C *c = d;
  c->f1 ();
  c->f2 ();
  // Not allowed, because f3 is not member function of class C:
  // c->f3 ();
}
```

***

###MULTIPLE INHERITANCE: FIELDS

Common Lisp Object System (CLOS) and C++ feature multiple inheritance

How are the fields of a class with multiple base (super) classes arranged?

Casting may involve changing the value of a pointer!

***

###MULTIPLE INHERITANCE: FIELDS

Generate code to adjust pointers when casting

C and assembly side-by-side

```
#include <iostream>

class C {
public: 
  unsigned int c1;
  unsigned int c2;
};

class D {
public: 
  unsigned int d1;
  unsigned int d2;
};

class E : public C, public D {
public: 
  unsigned int e1;
  unsigned int e2;
};

int main () {
  E *e = new E ();
  e->e1 = 1419;
  e->e2 = 7292;
  e->d1 = 9032;
  e->d2 = 3293;
  e->c1 = 2948;
  e->c2 = 8432;
  C *c = e;
  unsigned int x1 = c->c1;
  unsigned int x2 = c->c2;
  D *d = e;
  unsigned int y1 = d->d1;
  unsigned int y2 = d->d2;
  std::cout << "Values are: " << x1 << ", " << x2 << ", " << y1 << ", " << y2 << std::endl;
}
```
