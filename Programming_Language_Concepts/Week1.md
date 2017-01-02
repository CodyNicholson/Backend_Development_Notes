#1-2-2017

Lisp and Scheme are languages for the class

FizzBuzz problem:

```java
class  FizzBuzz
{
    public static void main(String args)
    {
        for (int i = 1; i <= 100; i++)
        {
            if(i % 15 == 0)
            {
                System.out.println("FizzBuzz");
            }
            else if(i % 3 == 0)
            {
                System.out.println("Fizz");
            }
            else if(i % 5 == 0)
            {
                System.out.println("Buzz");
            }
            else
            {
                System.out.println(i);
            }
        }
    }
}
```

***

##Programming Languages

####1970: Assembly, FORTRAN, COBOL, Lisp

- Assembly -

- FORTRAN - Allows you to write arithmatic expressions that compile down

- COBOL - Known for being Verbose, where If-ThenElse came from

- Lisp - Parantheses everywhere

####1980: C, Pascal, BASIC, ML, Smalltalk

- C - Portable assembly language, you can do low level stuff with it

- Pascal - Verbose, a "pretty" language in terms of syntax

- Microsoft BASIC -

- ML - Writing compliers and interpreters

- Smalltalk - One of the first OOP languages, has easy graphical user interfaces

####1990: C++, Perl, Objective C, Erlang

- C++ - Object Oreinted version of C

- Perl - Made it easy for system admins to do string functions

- Objective C - Steve Jobs pushed this to build apple applications, swift is better, came from SmallTalk

- Erlang - Coded to make systems more reliable by creating redundant software

####2000: Java, JavaScript, Python, Ruby, Lua

- Java - Runs on Windows, Apple, Linux

- JavaScript - A programming language that could run in the browser

- Python -

- Ruby - Modern version of SmallTalk

- Lua - Great for embedding interpreters

####2005: C#

- C# - Microsoft wanted to attract people to their platform, Java with Windows plugins

####2010: Scala, F#, Clojure, Go

- Scala -

- F# - Combines ML with C#

- Clojure - Lisp & Java

- Go -

####2015: Rust, Swift, TypeScript

- Rust -

- Swift -

- TypeScript - Comes from Scala

***

###Programming Languages

Programming languages come and go

You have to keep up with new languages

Also keep up with the changes to your current languages, Java 8 and C++ 11 added anonymous functions and more

Fortunately, lots of common concepts

***

###Learning Goals

Learn PLs more easily by recognizing concepts: While loops, closures, comprehensions, dynamic dispatch using vtables, mixins

Deeper understanding of PL concepts/paradigms

Impact of PL on program development, modularity, correctness, runtime efficiency, etc

-

###Course Overview

Programming paradigms and styles:

- functional vs object-oriented

- mutability vs immutability

- iteration vs recursion

- pattern matching vs visitor design pattern

- Runtime storage: lexical and dynamic scope; stack layout; object vtable layout to support inheritance and dynamic dispatch; nested structures (functions or objects); garbage collection

- Static Analysis: dynamic vs static type checking; subtyping; parametric polymorphism

-

###Course Approach

- Hands on: write many programs and experiments

- Scala as main language: carefully designed multi-paradigm language, textbook explains PL concepts in context, minimize time spent installing PLs

- Also bits of: C, C++, Haskell, Java, JavaScript, Rust, Scheme. Chosen as exemplars of concepts
