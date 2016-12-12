#The Big Omega Notation (Ω)

Big Omega describes the limiting behavior of a function, when the argument tends towards a particular value of infinity

It has two distinct definitions:

According to number theory: it means that an f(n) function is not dominated by g(n) function asymptotically

According to complexity theory: it means that an f(n) is bounded below by an g(n) function asymptotically

-

The f(n) = Ω(g(n)) expression means that there is some c > 0 value and some n_0 > 0 threshold value such that for n > n_0 the |f(n)| >= c * |g(n)|

In other words, for f(n) = O(g(n)), f(n) is the lower bound of g(n). For f(n) = Ω(g(n)), f(n) is the **upper bound** of g(n)

-

If we have an Ω(N^2) running time complexity, it is also true that it is in Ω(N), or Ω(logN), or Ω(1)

