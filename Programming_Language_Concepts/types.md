# Types

### Overview

Type checking

- static (compile-time) vs dynamic (runtime)

- strong vs weak

Examples in: Java, C, Scheme

***

Primitive types - boolean, int, char, long, short

Reference types - Like a pointer that references another instance or null

***

### Linked List

Nodes get put on the heap

new Node (...) allocates an instance of Node on the heap

Creating an object in Java will always put that object in the Heap

***

```
int z = 0; // z is saved in global variables since it is not in a function

void f()
{
    int x = 0; // x is put on the call stack
    int *p = malloc (sizeof (int)); // p is put on the call stack but points to an object on the heap
}
```
