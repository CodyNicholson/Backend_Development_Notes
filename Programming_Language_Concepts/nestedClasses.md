# Nested Classes

Nested classes in Java, Scala, etc.

Added in Java 1.1 (1997!) for GUI development

Used in, for example:

- Android
- concurrency APIs
- collections processing

***

### ANONYMOUS INNER CLASS

```
interface I {
  U apply (T t); // for some types T and U
}

class C {
  I f () {
    int x = 0;
    I a = new I () { // new instance of anonymous class implementing I
      public U apply (T t) { 
        // can use x from enclosing scope, and t parameter
      }
    };
    return a;
  }
}
```

***

### WITHOUT INNER CLASS

```
interface I {
  U apply (T t); // for some types T and U
}

class D implements I {
  final int x;              
  D (int x) { this.x = x; } 
  public U apply (T t) { /* can use x in field, and t parameter */ }
}

class C {
  I f () {
    int x = 0;
    I a = new D (x); // new instance of named class implementing I
    return a;
  }
}
```

***

### JAVA GUI

java.awt.event.ActionListener

Implementation invoked when button pressed, etc.

Implementation usually refers to other objects

```
package java.awt.event;

interface ActionListener {
  void actionPerformed (ActionEvent e);
}
```

-

### JAVA GUI

```
import java.awt.*;
import java.awt.event.*;

public class Example extends Frame {
  public static void main (String[] args) {
    new Example ();
  }

  public Example () {
    super ("Example");
    Panel p = new Panel ();
    p.setLayout (new BorderLayout ());
    p.add (new Label ("Press it!", Label.LEFT), BorderLayout.NORTH);
    Button button = new Button ("Go");
    p.add (button, BorderLayout.CENTER);
    Label out = new Label ("     0", Label.RIGHT);
    p.add (out, BorderLayout.SOUTH);
    add (p, BorderLayout.NORTH);
    button.addActionListener (new ActionListener () {
        private int count = 0;
        public void actionPerformed (ActionEvent e) {
          count += 1;
          out.setText (Integer.toString (count)); // "out" is from
          out.repaint ();                         // enclosing scope
        }
      });
    setVisible (true);
  }
}
```

***

### ANDROID

Android code uses callbacks extensively

GUI events, e.g., android.view.View.OnClickListener

Run code in alternate threads

-

```
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
...
public class SimpleImageViewer extends Activity {
  Handler h;
  ...
  public void onCreate (Bundle savedInstanceState) {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.main);
    ...
    h = new Handler ();
    Button b = (Button) findViewById (R.id.Button01);
    b.setOnClickListener (new OnClickListener () {
      public void onClick (View v) {
        h.post (new Runnable () {
          public void run () {
            currentImage = (currentImage + 1) % imageIds.length;
            loadImage ();
          }
        });
      }
    });
  }
}
```

***

### JAVA CONCURRENCY

Package code in implementation of Runnable

Pass instance to Thread constructor

```
package java.lang;

@FunctionalInterface
public interface Runnable {
  void run ();
}

class Thread {
  Thread (Runnable target); // Allocates a new Thread object
  ...
}
```

```
new Thread (new Runnable () {
  public void run () { /* packaged code here */ }
}).start ();
```

-

### JAVA CONCURRENCY

Scala using Java concurrency

```
val threads : List[Thread] = {
  for (i <- (1 to 26).toList) yield {
    val ch : Byte = ('A' + i - 1).asInstanceOf[Byte]
    new Thread (new Runnable {
      def run () = {
        while (true) { System.out.write (ch) }
      }
    })
  }
}
for (t <- threads) { t.start }
```

-

### JAVA CONCURRENCY

Runnable for code with no return value

Callable for code with a return value

java.util.concurrent.Callable

```
package java.util.concurrent;

@FunctionalInterface
public interface Callable<V> {
  V call ();
}
```

-

### JAVA CONCURRENCY

Futures and promises - concurrency primitives

- originally in Lisp and an actor language
- gained popularity in recent years
- C++, C#, Java, JavaScript, R, Scala, Swift, etc.

```
FutureTask<String> future = new FutureTask<> (new Callable<> () {
    public String call () {
       return searcher.search (target);
    }
  });
executor.execute (future);
...
if (future.isDone ()) {
  String result = future.get ();
  ...
}
```

***

### COLLECTIONS PROCESSING

Sequential map over list

```
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Nested {
  public static void main (String[] args) {
    List<Integer> l = new ArrayList<> ();
    l.add (1); l.add (2); l.add (3);
    Function<Integer,Integer> f;
    f = new Function<Integer,Integer> () { // anonymous inner class
      public Integer apply (Integer x) { return x + 1; }
    };
    l.stream ().map (f)
     .collect (Collectors.toList ())
     .forEach (x -> System.out.println (x));
  }
}
```

-

### COLLECTIONS PROCESSING

Parallel version!

```
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Nested {
  public static void main (String[] args) {
    List<Integer> l = new ArrayList<> ();
    l.add (1); l.add (2); l.add (3);
    Function<Integer,Integer> f;
    f = new Function<Integer,Integer> () { // anonymous inner class
      public Integer apply (Integer x) { return x + 1; }
    };
    l.parallelStream ().map (f) // parallel 
     .collect (Collectors.toList ())
     .forEach (x -> System.out.println (x));
  }
}
```

***

### IMPLEMENTING NESTED CLASSES

Java compiler supports nested classes

- (anonymous inner classes and other variations)

javac: Foo.java → Foo.class

JVM does not support nested classes!

Java compiler eliminates nested classes

Creates new classes with reserved $ in name

-

### IMPLEMENTING NESTED CLASSES

```
class C {
  public static void main (String[] args) {
    for (int i = 0; i < 5; i++) {
      int x = i;
      new Thread (new Runnable () {
          public void run () {
            while (true) {
              System.out.print (Integer.toString (x));
              System.out.flush ();
            }
          }
        }).start ();
    }
  }
}
```

```
$ javac C.java 

$ javap -private 'C$1' 
Compiled from "C.java"
final class C$1 implements java.lang.Runnable {
  final int val$x;
  C$1(int);
  public void run();
}
```

-

### IMPLEMENTING NESTED CLASSES

Bytecode disassembly shows C$1 constructor call

```
$ javap -c C
Compiled from "C.java"
class C {
  C();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: iconst_0
       1: istore_1
       2: iload_1
       3: iconst_5
       4: if_icmpge     33
       7: iload_1
       8: istore_2
       9: new           #2                  // class java/lang/Thread
      12: dup
      13: new           #3                  // class C$1
      16: dup
      17: iload_2
      18: invokespecial #4                  // Method C$1."<init>":(I)V
      21: invokespecial #5                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
      24: invokevirtual #6                  // Method java/lang/Thread.start:()V
      27: iinc          1, 1
      30: goto          2
      33: return
}
```

-

### IMPLEMENTING NESTED CLASSES

Cannot use i directly in inner class

Restricted to or final or effectively final

- variables from enclosing scope are copied
- final restrictions prevent surprises

What if variable is a reference?

```
class C {
  public static void main (String[] args) {
    for (int i = 0; i < 5; i++) {
      new Thread (new Runnable () {
          public void run () {
            while (true) {
              System.out.print (Integer.toString (i));
              System.out.flush ();
            }
          }
        }).start ();
    }
  }
}
```

***

### JAVA FUNCTIONAL INTERFACE

Java 8 introduced lambda expressions

- i.e., anonymous functions
- new PL feature useful for older APIs?

***

### JAVA FUNCTIONAL INTERFACE

Scala first-class function of type T⇒U

- instance of class with apply method

```
class ... {
  def apply (x:T) : U = ... 
}
```

Java 8 nested functions of type T⇒U

- implementing interfaces with a "single" method
- Callable (with no argument) and Function

```
class ... implements Callable<U> {
  public U call () { ... }
}

class ... implements Function<T,U> {
  public U apply (T t) { ... }
}
```

-

### JAVA FUNCTIONAL INTERFACE

Java reference types marked as

*This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.*

@FunctionalInterface annotation

-

### JAVA FUNCTIONAL INTERFACE

These definitions are equivalent

Allowed because Function is a functional interface

```
import java.util.function.Function;

Function<Integer,Integer> f = new Function<Integer,Integer> () {
  public Integer apply (Integer x) {
    return x + 1;
  }
};

Function<Integer,Integer> f = x -> x + 1;
```

***

### COLLECTIONS PROCESSING

Java map method takes a Function

Note

- Java List (or Collection) to Stream
- Java Stream unrelated to Scala Stream

```
package java.util.stream;

interface Stream<T> {
  ...
  // Returns a stream consisting of the results of applying
  // the given function to the elements of this stream
  <R> Stream<R> map (Function<? super T,? extends R> mapper);
  ...
}
```

-

### COLLECTIONS PROCESSING

With lambda expression simplify earlier code to

```
import java.util.*;
import java.util.stream.Collectors;

public class Nested {
  public static void main (String[] args) {
    List<Integer> l = new ArrayList<> ();
    l.add (1); l.add (2); l.add (3);
    l.stream ().map (x -> x + 1)
     .collect (Collectors.toList ())
     .forEach (x -> System.out.println (x));
  }
}
```

***

### JAVA GUI

Some event interfaces have multiple methods

java.awt.event.MouseListener

Not a functional interface

Instead use anonymous inner class

```
package java.awt.event;

interface MouseListener {
  void mouseClicked (MouseEvent e);
  // Mouse button clicked (pressed and released) on a component
  void mouseEntered (MouseEvent e);
  // Mouse enters a component
  void mouseExited (MouseEvent e);
  // Mouse exits a component
  void mousePressed (MouseEvent e);
  // Mouse button has been pressed on a component
  void mouseReleased (MouseEvent e);
  // Mouse button has been released on a component
}
```
