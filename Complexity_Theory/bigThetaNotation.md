# The Big Theta Notation (θ)

It describes the limiting behavior of a function when the argument tends towards a particular value or infinity

An f(n) function is bounded by both above and below by a g(n) function: so both f(n) = O(g(n)) and f(n) = Ω(g(n)) are true

***

The f(n) = θ(g(n)) expression means that there is some c1,c2>0 values and some n_0 > 0 threshold value such that for n > n_0 the c1* |g(n)| >= |f(n)| > c2 * |g(n)|

***

In other words, f(n) is bounded above AND below by g(n)
