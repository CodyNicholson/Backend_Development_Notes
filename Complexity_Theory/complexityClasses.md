# Complexity Classes

### P Complexity Class

**P** stands for polynomial

All the decision problems that can be solved with deterministic Turing-machines using polynomial amount of computational time

These problems are efficiently solvable but not all of these problems have practical solutions

For example: bubble sort is in **P** but usually we can use mergesort for sorting problems

-

### NP Complexity Class

** NP** stands for nondeterministic polynomial

If we have a certain solution for the problem: we can verify this solution in polynomial time

**P** is in **NP**: it is true for the problems in **P** that we can verify the solution in polynomial time, we can even solve it in polynomial time

One of the most important problems: does **P** = **NP**?

For example: Integer factorization is a very hard problem to solve, but if we have the solutions **x** and **y**, we can verify it by multiplying the two numbers **x * y** which is a polynomial procedure

In the Traveling Salesman Problem, if we have the solution route, we can make sure it satisfies the conditions in polynomial time

-

### NP-Complete Complexity Class

The hardest problems in **NP**

We can transform an NP-Complete problem into an **NP** problem in polynomial time - "Karp Reduction"

Important in Computer Science: if we manage to find a polynomial algorithm for an NP-Complete problem, it means P = NP

This is why it is an important complexity class

If we know the solution it is easy to verify in polynomial time

That is, the time required to solve the problem using any currently known algorithm increases very quickly as the size of the problem grows

Fr example: Graph Coloring, Hamiltonian Path Problem

-

### NP-Hard Complexity Class

Problems that are at least as hard as the problems in **NP** class

We can transform an **NP-Hard** problem into an **NP-Complete** problem in polynomial time using "Karp reduction"

For example: halting problem

- This is the problem which asks: given a program and the input, will it run forever? Yes/No question, so a decision problem

