#Parametric Polymorphism

###Monomorphic Linked Lists (C)

Implement linked lists in C for each pointer type?

Is duplicating code by cutting and pasting bad?

```c
typedef struct node_int_ptr node_int_ptr;

struct node_int_ptr {
  int *item;
  node_int_ptr *next;
};

int length_while_int_ptr (node_int_ptr *data) {
  int result = 0;
  while (data) {
    result += 1;
    data = data->next;
  }
  return result;
}
```

***

###Generic Linked Lists (C)

Use (void *) type in C

Can cast/store any pointer type at type (void *)

Must cast from (void *) before dereferencing

```c
typedef struct node node;

struct node {
  void *item;
  node *next;
};

int length_while (node *data) {
  int result = 0;
  while (data) {
    result += 1;
    data = data->next;
  }
  return result;
}
```

-

No static protection against casts from (void *)

```c
typedef struct node node;

struct node {
  void *item;
  node *next;
};

node *data = ...        // filled with (int *) elements
void *p = data->item;   // OK
char *q = (char *) p;   // uh oh
char c = *q;            // runtime type error
```

***

###Monomorphic Lists (Java)

Implement linked lists in Java for each reference type?

```java
static class Node {
  String item;
  Node next;
}

static int length (Node data) {
  int result = 0;
  while (data != null) {
    result += 1;
    data = data.next;
  }
}
```

***

###Generic Linked Lists (Java)

Use Object reference type in Java

Can cast/store any reference type at type Object

Must cast from Object to get most methods/fields

```java
static class Node {
  Object item;
  Node next;
}

static int length (Node data) {
  int result = 0;
  while (data != null) {
    result += 1;
    data = data.next;
  }
}
```

-

Little static protection against casts from Object

But dynamic checks gives ClassCastException

Better than runtime type error

```java
static class Node {
  Object item;
  Node next;
}

Node data = ...         // filled with java.io.InputStream elements
Object p = data.item;   // OK
String q = (String) p;  // runtime ClassCastException halts execution
q.endsWith ("x");       // never reach runtime type error
```

***

###Parametric Polymorphism (Generic in Java)

Subtype polymorphism is not the only option

- Every reference type in Java is a subtype of Object

*Parametric polymorphism* uses type parameters for unknown types

From ML in the 1970s; in Haskell, Java, C#, Scala, Rust, etc.

Strong connections with mathematical logic

- leading to, e.g., Coq

C++ templates are different but related

-

###Java Parametric Polymorphism

```java
static class Node<X> {
  X item;
  Node<X> next;

  public Node (X item, Node<X> next) { 
    this.item = item; 
    this.next = next; 
  }
}

static <X> int length (Node<X> node) {
  if (node == null) {
    return 0;
  } else { 
    return 1 + length (node.next);
  }
}
```

***

###More Polymorphism

More on subtype and parametric polymorphism later

Including variance and bounds for type parameters