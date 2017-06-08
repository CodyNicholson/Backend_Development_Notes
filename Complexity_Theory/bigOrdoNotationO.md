# The Big Ordo Notation (O)

The big O notation is also known as the Landau notation

It describes the limiting behavior of a function, when the argument tends towards a particular value or infinity

It is used to classify algorithms by how they respond (in their processing time or working space requirements) to changes in input size

***

The f(n) = O(g(n)) expression means that there is some c > 0 value and some n_0 > 0 threshold value such that for n > n_0 the |f(n)| <= c* |g(n)|

("n" is the input size)

For example, bubble sort has O(N^2) running time complexity

It is also true that bubble sort has a O(N^3) or O(N^4) or O(N^5) run time complexity

It is like x <10, so x < 100 as well

***

In other words, for f(n) = O(g(n)), f(n) is the **lower bound** of g(n)
