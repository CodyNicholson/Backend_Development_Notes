# Dynamic Dispatch

### OO PROGRAMMING

What is Object-Oriented Programming (OOP)?

Ideas

- encapsulation
- dynamic dispatch
- inheritance (implementation vs interface)
- subtyping

Different implementations of these ideas

***

### ENCAPSULATION

How can internal behavior/storage be hidden?

Access control to restrict access to fields/methods

- private, protected, friend, etc.

```
class C {
  private String secret; 

  void updateSecret (String secret) { 
    this.secret = secret; 
  }

  boolean test (String candidate) { 
    return candidate.equals (this.secret); 
  }
}
```

***

### DIRECT CALLS

Direct calls refer to callee directly by name

In C

```
void foo () { printf ("Hello\n"); }

void bar () { foo (); }
```

Compiles to a direct call instruction

```
foo:
        ...

bar:
        pushq   %rbp
        movq    %rsp, %rbp
        movl    $0, %eax
        call    foo      /* target is 'foo' */
        popq    %rbp
        ret
```

-

In Java (static methods; no instance of class A)

```
class A { 
  static void foo () { 
    System.out.println ("Hello");
  } 
}

class B {
  void bar () { 
    A.foo ();
  }
}
```

***

### INDIRECT CALLS (C)

Indirection to code is very useful

C allows indirection to code via function pointers

- function pointer = machine code address (often)
- recall discussion of function pointers with GCC

Compilation of code using function pointers?

```
void foo1 () { printf ("Hello\n"); }
void foo2 () { printf ("World\n"); }

void bar (int b) { 
  void (*p) (); // declare local variable p as function pointer
  if (b) {
    p = &foo1;  // assign address of 'foo1' to p
  } else {
    p = &foo2;  // assign address of 'foo2' to p
  }
  (*p) ();      // invoke code at address stored in p
}
```

-

Compiles to an indirect call instruction

```
 bar:
    pushq   %rbp
    movq    %rsp, %rbp
    cmpl    $0, %edi
    je  .L4
    movq    $foo1, %rdx
    jmp .L5
.L4:
    movq    $foo2, %rdx
.L5:
    movl    $0, %eax
    call    *%rdx     /* target is stored in register rdx */
    leave
    ret
```

-

Test each function on multiple integers

```
int f (int x) { return x + 1; }
int g (int x) { return x + 2; }
int h (int x) { return x + 3; }

void main () {
  int (*funcs[]) (int) = { &f, &g, &h };
  int arr[] = { 10, 11, 12, 13 };
  for (int i = 0; i < 3; i++) {
    printf ("Working on function pointer #%d\n", i);
    for (int j = 0; j < 4; j++) {
      int input = arr[j];
      int output = (*funcs[i]) (input); // indirect call to *funcs[i]
      printf ("  input = %d -> output = %d\n", input, output);
    }
  }
}
```

-

```
$ gcc -std=c99 -o funcpointer funcpointer.c 
$ ./funcpointer 
Working on function pointer #0
  input = 10 -> output = 11
  input = 11 -> output = 12
  input = 12 -> output = 13
  input = 13 -> output = 14
Working on function pointer #1
  input = 10 -> output = 12
  input = 11 -> output = 13
  input = 12 -> output = 14
  input = 13 -> output = 15
Working on function pointer #2
  input = 10 -> output = 13
  input = 11 -> output = 14
  input = 12 -> output = 15
  input = 13 -> output = 16
```

***

### INDIRECT CALLS (SCALA)

PLs with first-class functions support indirect calls

- closure includes function pointer (or similar)

```
val fs:List[Int=>Int] = for (i <- List(1,2,3)) yield ((x:Int) => x+i)
val ds:List[Int] = List (10,11,12,13)

for (i <- 0 to (func_list.length - 1)) {
  println ("Working on function #" + i)
  for (input <- ds) {
    val output = fs (i) (input)  // indirect call to 'fs (i)'
    println ("  input = " + input + " -> output = " + output)
  }
}
```

***

### DYNAMIC DISPATCH (JAVA)

Which implementation of foo is used?

Dynamic type determines the implementation

```
class A           { void foo () { System.out.println ("A"); } }
class B extends A { void foo () { System.out.println ("B"); } }
class C extends A { void foo () { System.out.println ("C"); } }
```

```
public class Driver {
  public static void main (String[] args) { 
    A x = new C ();  // static type of x is A, dynamic type is C
    x.foo ();        // call foo method from class C
  }
}
```

Referred to as dynamic lookup in textbook

-

Dynamic dispatch version of function testing

```
interface Fn {                 int apply (int x);                  }
class F implements Fn { public int apply (int x) { return x + 1; } }
class G implements Fn { public int apply (int x) { return x + 2; } }
class H implements Fn { public int apply (int x) { return x + 3; } }

public class FnTest {
  public static void main (String[] args) {
    Fn[] fns = { new F (), new G (), new H () };
    int[] data_arr = { 10, 11, 12, 13 };
    for (int i = 0; i < fns.length; i++) {
      for (int j = 0; j < data_arr.length; j++) {
        int input = data_arr[j];
        int output = fns[i].apply (input);
        System.out.println ("  i = " + input + " -> o = " + output);
      }
    }
  }
}
```

-

Alternatively, anonymous inner classes in a loop

```
interface Fn { int apply (int x); }

public class FnTest {
  public static void main (String[] args) {
    Fn[] fns = new Fn[3];
    for (int i = 0; i < fns.length; i++) {
      final int j = i + 1; // Need a final var for inner class below
      fns[i] = new Fn () { public int apply (int x) { return x+j; } };
    }
    int[] data_arr = { 10, 11, 12, 13 };
    for (int i = 0; i < fns.length; i++) {
      for (int j = 0; j < data_arr.length; j++) {
        int input = data_arr[j];
        int output = fns[i].apply (input);
        System.out.println ("  i = " + input + " -> o = " + output);
      }
    }
  }
}
```

-

Functional interface in Java 8!

```
interface Fn { int apply (int x); }

public class FnTest {
  public static void main (String[] args) {
    Fn[] fns = new Fn[3];
    for (int i = 0; i < fns.length; i++) {
      final int j = i + 1; // Need a final var for inner class below
      fns[i] = x -> x + j; // Implement Fn using a lambda expression
    }
    int[] data_arr = { 10, 11, 12, 13 };
    for (int i = 0; i < fns.length; i++) {
      for (int j = 0; j < data_arr.length; j++) {
        int input = data_arr[j];
        int output = fns[i].apply (input);
        System.out.println ("  i = " + input + " -> o = " + output);
      }
    }
  }
}
```

***

### DYNAMIC DISPATCH

Java / Scala anon. functions use dynamic dispatch

Implementation of dynamic dispatch in C++ soon
