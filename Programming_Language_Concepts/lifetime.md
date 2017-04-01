# Lifetime

Lifetime of an area of memory

- duration during which it is allocated

READING: chapter 7 of Mitchell textbook

- recall activation records from Systems I

- safe to ignore access links

***

### ACTIVATION RECORDS

Activation records: storage space for local variables / intermediate values that the runtime system generates

- also known as stack frames

ARs almost always placed on a call stack

***

### TYPICAL STORAGE OPTIONS

global (static)

- available for lifetime of program

in AR in call stack (stack-allocated)

- available whilst function active (called but not returned)

in heap (heap-allocated)

- available until deallocated (manually or via garbage collection)

***

### STORAGE LIFETIME ISSUES

Lifetime too short

- reads return other value
- writes overwrite other value
- resource state incorrect, e.g., file handle closed
- can cause security problems

Lifetime too long

- uses too much memory (memory leak)
- too late in freeing other resources / finalization

***

### CONTROL LINKS

Some systems, e.g., 32-bit x86, use control links

control link in each AR points to previous AR

Control links provide linked list / stack view of ARs

ebp register points to AR for most recently called function

***CALL STACK OF ARS

Call stack of ARs allows

- fast allocation of fresh AR on function call
- fast deallocation of AR on function return
- contrast with heap allocation

Stack discipline

1. (call f) allocate AR for f
2. (call g) allocate AR for g
3. (return from g) deallocate AR for g
4. (return from f) deallocate AR for f

***

### MULTIPLE THREADS

Each thread needs a separate call stack

Calls and returns in separate threads are independent

***

### HEAP ALLOCATION

Heap allocation can use other patterns

1. allocate M bytes
2. allocate N bytes
3. deallocate M bytes
4. deallocate N bytes

Allocations may be long-lived, others short-lived

Gives freedom, but more costly than call stack

***

### COMMON PROBLEMS
PLs with garbage collection

lifetime too long (not GCed)

For Java, Scala, C#, Python, Ruby, JS, Scheme, etc.

-

PLs with manual memory management (C, C++)

- pointers to storage whose lifetime has ended
    - dangling pointers to an old AR
    - dangling pointers to freed heap memory 
    - (use after free)
    - double freeing of heap memory

***

### DANGLING POINTER - AR

```
#include <stdio.h>
#include <stdlib.h>

int *f (int x) {
  int y = x;
  return &y;
}

int main (void) {
  int *p = f (1);
  printf ("*p = %d\n", *p);
  return 0;
}
```

```
$ gcc -o ar ar.c
ar.c: In function ‘f’:
ar.c:6:3: warning: function returns address of local variable 
  [enabled by default]

$ ./ar 
*p = 1
```

-

```
$ valgrind ./ar
==5505== Memcheck, a memory error detector
==5505== Copyright (C) 2002-2011, and GNU GPL'd, by Julian Seward et al.
==5505== Using Valgrind-3.7.0 and LibVEX; rerun with -h for copyright info
==5505== Command: ./ar
==5505== 
==5505== Conditional jump or move depends on uninitialised value(s)
==5505==    at 0x4E7C1A1: vfprintf (vfprintf.c:1596)
==5505==    by 0x4E85298: printf (printf.c:35)
==5505==    by 0x400536: main (in /tmp/ar)
==5505== 
==5505== Use of uninitialised value of size 8
==5505==    at 0x4E7A49B: _itoa_word (_itoa.c:195)
==5505==    by 0x4E7C4E7: vfprintf (vfprintf.c:1596)
==5505==    by 0x4E85298: printf (printf.c:35)
==5505==    by 0x400536: main (in /tmp/ar)
==5505== 
==5505== Conditional jump or move depends on uninitialised value(s)
==5505==    at 0x4E7A4A5: _itoa_word (_itoa.c:195)
==5505==    by 0x4E7C4E7: vfprintf (vfprintf.c:1596)
==5505==    by 0x4E85298: printf (printf.c:35)
==5505==    by 0x400536: main (in /tmp/ar)
==5505== 
*p = 1
==5505== 
==5505== HEAP SUMMARY:
==5505==     in use at exit: 0 bytes in 0 blocks
==5505==   total heap usage: 0 allocs, 0 frees, 0 bytes allocated
==5505== 
==5505== All heap blocks were freed -- no leaks are possible
==5505== 
==5505== For counts of detected and suppressed errors, rerun with: -v
==5505== Use --track-origins=yes to see where uninitialised values come from
==5505== ERROR SUMMARY: 3 errors from 3 contexts (suppressed: 2 from 2)
```

***

### NOT DANGLING POINTER - AR

```
#include <stdio.h>
#include <stdlib.h>

int *f (int x) {
  int *result = (int *) malloc (sizeof (int));
  *result = x;
  return result;
}

int main (void) {
  int *p = f (1);
  printf ("*p = %d\n", *p);
  return 0;
}
```

```
$ gcc -Wall -o ar ar.c

$ ./ar 
*p = 1
```

-

```
$ valgrind ./ar
==10962== Memcheck, a memory error detector
==10962== Copyright (C) 2002-2011, and GNU GPL'd, by Julian Seward et al.
==10962== Using Valgrind-3.7.0 and LibVEX; rerun with -h for copyright info
==10962== Command: ./ar
==10962== 
*p = 1
==10962== 
==10962== HEAP SUMMARY:
==10962==     in use at exit: 4 bytes in 1 blocks
==10962==   total heap usage: 1 allocs, 0 frees, 4 bytes allocated
==10962== 
==10962== LEAK SUMMARY:
==10962==    definitely lost: 4 bytes in 1 blocks
==10962==    indirectly lost: 0 bytes in 0 blocks
==10962==      possibly lost: 0 bytes in 0 blocks
==10962==    still reachable: 0 bytes in 0 blocks
==10962==         suppressed: 0 bytes in 0 blocks
==10962== Rerun with --leak-check=full to see details of leaked memory
==10962== 
==10962== For counts of detected and suppressed errors, rerun with: -v
==10962== ERROR SUMMARY: 0 errors from 0 contexts (suppressed: 2 from 2)
```

***

### DANGLING POINTER - HEAP

```
#include <stdio.h>
#include <stdlib.h>

int *f (int x) {
  int *result = (int *) malloc (sizeof (int));
  *result = x;
  return result;
}

int main (void) {
  int *p = f (1);
  free (p);
  printf ("*p = %d\n", *p);
  return 0;
}
```

```
$ gcc -Wall -o ar ar.c

$ ./ar 
*p = 0
```

-

```
$ valgrind ./ar
==13594== Memcheck, a memory error detector
==13594== Copyright (C) 2002-2011, and GNU GPL'd, by Julian Seward et al.
==13594== Using Valgrind-3.7.0 and LibVEX; rerun with -h for copyright info
==13594== Command: ./ar
==13594== 
==13594== Invalid read of size 4
==13594==    at 0x4005D2: main (in /tmp/ar)
==13594==  Address 0x51f0040 is 0 bytes inside a block of size 4 free'd
==13594==    at 0x4C2A82E: free (in /usr/lib/valgrind/vgpreload_memcheck-amd64-linux.so)
==13594==    by 0x4005CD: main (in /tmp/ar)
==13594== 
*p = 1
==13594== 
==13594== HEAP SUMMARY:
==13594==     in use at exit: 0 bytes in 0 blocks
==13594==   total heap usage: 1 allocs, 1 frees, 4 bytes allocated
==13594== 
==13594== All heap blocks were freed -- no leaks are possible
==13594== 
==13594== For counts of detected and suppressed errors, rerun with: -v
==13594== ERROR SUMMARY: 1 errors from 1 contexts (suppressed: 2 from 2)
```
