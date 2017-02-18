#Inheritance

Interface inheritance (subtyping)

- inherit requirement/guarantee for methods
- in statically-typed OO PLs

Implementation inheritance

- inherit fields and method implementations
- inheritance for code reuse
- in almost all OO PLs

***

###INHERITANCE AND OVERRIDING

Inherit f impl.; override g impl.

Which g is called from f?

"return g ()" is "return this.g ()"

- this has static type A, dynamic type B

```
class A {
  int f (int x) {
    System.out.format ("A.f (%d)%n", x);
    return (x == 0) ? g () : f (x - 1); 
  }
  int g () { System.out.println ("A.g ()"); return 0; }
}

class B extends A {
  int g () { System.out.println ("B.g ()"); return 0; }
}

public class Inheritance {
  public static void main (String[] args) { new B ().f (3); }
}
```

Results:

```
$ java Inheritance
A.f (3)
A.f (2)
A.f (1)
A.f (0)
B.g ()
```

***

###ABSTRACT METHODS = "HOOKS"

Java: method with no impl. called abstract

Cannot instantiate classes with abstract methods

Fill in abstract methods in subclasses

```
abstract class A {
  int f (int x) {
    System.out.format ("A.f (%d)%n", x);
    return (x == 0) ? g () : f (x - 1); 
  }
  abstract int g ();
}

class B extends A {
  int g () { System.out.println ("B.g ()"); return 0; }
}

public class Inheritance {
  public static void main (String[] args) { new B ().f (3); }
}
```

Results:

```
$ java Inheritance
A.f (3)
A.f (2)
A.f (1)
A.f (0)
B.g ()
```

***

###OVERRIDING AGAIN

Override f, so A.f does not run

```
abstract class A {
  int f (int x) {
    System.out.format ("A.f (%d)%n", x);
    return (x == 0) ? g () : f (x - 1); 
  }
  abstract int g ();
}

class B extends A {
  int f (int x) { System.out.format ("B.f (%d)%n", x); }
  int g () { System.out.println ("B.g ()"); return 0; }
}

public class Inheritance {
  public static void main (String[] args) { new B ().f (3); }
}
```

Results:

```
$ java Inheritance
B.f (3)
```

***

###OVERRIDING AND SUPER CALLS

Use superclass impl. via super call

super.f(x) vs this.f(x)?

```
abstract class A {
  int f (int x) {
    System.out.format ("A.f (%d)%n", x);
    return (x == 0) ? g () : f (x - 1); 
  }
  abstract int g ();
}

class B extends A {
  int f (int x) { System.out.format ("B.f (%d)%n", x); return super.f (x); }
  int g () { System.out.println ("B.g ()"); return 0; }
}

public class Inheritance {
  public static void main (String[] args) { new B ().f (3); }
}
```

Results

```
$ java Inheritance
B.f (3)
A.f (3)
B.f (2)
A.f (2)
B.f (1)
A.f (1)
B.f (0)
A.f (0)
B.g ()
```

***

###COMPOSITION AND DELEGATION

Favor 'object composition' over 'class inheritance'

- See GoF book or [1]

Delegate to methods of components

-

Recursion behaves differently with delegation

```
class A {
  int f (int x) {
    System.out.format ("A.f (%d)%n", x);
    return (x == 0) ? g () : f (x - 1); 
  }
  int g () { System.out.println ("A.g ()"); return 0; }
}

class B {
  A a = new A ();
  int f (int x) { System.out.format ("B.f (%d)%n", x); return a.f (x); }
  int g () { System.out.println ("B.g ()"); return 0; }
}

public class Inheritance {
  public static void main (String[] args) { new B ().f (3); }
}
```

Results:

```
$ java Inheritance
B.f (3)
A.f (3)
A.f (2)
A.f (1)
A.f (0)
A.g ()
```

-

Arrange to call back from delegatee to delegator

```
interface I {
  int f (int x);
  int g ();
}

class A implements I {
  I back = this;
  public int f (int x) {
    System.out.format ("A.f (%d)%n", x);
    return (x == 0) ? back.g () : back.f (x - 1); 
  }
  public int g () { System.out.println ("A.g ()"); return 0; }
}

class B implements I {
  A a;
  B () { a = new A (); a.back = this; }
  public int f (int x) { System.out.format ("B.f (%d)%n", x); return a.f (x); }
  public int g () { System.out.println ("B.g ()"); return 0; }
}

public class Inheritance06 {
  public static void main (String[] args) { new B ().f (3); }
}
```

Results:

```
$ java Inheritance
B.f (3)
A.f (3)
B.f (2)
A.f (2)
B.f (1)
A.f (1)
B.f (0)
A.f (0)
B.g ()
```

***

###EXAMPLE: INPUTSTREAM

java.io.InputStream represents stream of bytes

- implement read() in subclass
- inherit other methods

```
public abstract class InputStream implements Closeable {
  public abstract int read() throws IOException;
  public int read (byte b[], int off, int len) throws IOException {
    // calls read()
    ...
  }
  public long skip(long n) throws IOException {
    // calls read(byte b[], int off, int len) 
    ...
  }
  public int available() throws IOException {
    return 0;
  }
  public void close() throws IOException {
  }
  ...
}
```

java.io.InputStream API docs

```
Applications that need to define a subclass of InputStream must
always provide a method that returns the next byte of input.

The read(b, off, len) method for class InputStream simply calls
the method read() repeatedly.

The skip(n) method of this class creates a byte array and then
repeatedly reads into it until n bytes have been read or the
end of the stream has been reached.

Subclasses are encouraged to provide a more efficient
implementation of [these methods].
```

***

###EXAMPLE: SUBCLASS

```
import java.io.*;
public class DemoStream extends InputStream {
  int next = 0;
  public int read () throws IOException {
    int result = 32 + next;
    next = (next + 1) % (127 - 32);
    return result;
  }
  public static void main (String[] args) {
    byte[] buffer = new byte[50];
    InputStream is = new DemoStream ();
    for (int i = 0; i < 3; i++) {
      try {
        int numread = is.read (buffer, 0, buffer.length);
        System.out.println (new String (buffer, 0, numread));
      } catch (IOException e) {}
    }
  }
}
```

Results:

Calls read in InputStream

Which in turn calls back to read in DemoStream

Improve efficiency by overriding read to array

Overriding all ⇒ interface vs abstract class?

```
$ javac DemoStream.java 
$ java DemoStream
 !"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQ
RSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz{|}~ !"#$
%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUV
```
