# Complexity Notation Examples

Suppose we have a function f(n) = 3n^2 - 100n + 6

***

### 1.) Let's prove that f(n) = O(n^2)

The definition for O: |f(n)| <= c * |g(n)|

If n is large, we can get rid of the absolute values, we have to make sure that 3n^2 >= 100n

So if c > n_0 = 34 we can get rid of the absolute values since |f(n)| = f(n)

3n^2 - 100n + 6 <= c*n^2

If c = 3 and n_0 = 34 it is going to be ok because 3n^2 - 100n + 6 <= 3n^2

***

### 2.) Now let's prove that f(n) = O(n^3)

The definition for O: |f(n)| <= c * |g(n)|

If n is large, we can get rid of the absolute values, we have to make sure that 3n^2 >= 100n

So if n > n_0 = 34 we can get rid of the absolute values since |f(n)| = f(n)

3n^2 - 100n + 6 <= 3n^2 <= n^3

If c = 1 and n_0 = 34 it is going to be ok because 3n^2 - 100n + 6 <= 3n^2

***

If f(n) = O(n^k) then f(n) = O(n^k+i) where i > 1 because bit O is an upper bound for a given f(n) function

For example: bubble sort has O(N^2) running time complexity

It is also true that bubble sort is in O(N^3) or O(N^4) ...

***

### 3.) Let's prove that f(n) does not equal O(n)

The definition for O: |f(n)| <= c * |g(n)|

If n is large, we can get rid of the absolute values, we have to make sure that 3n^2 >= 100n

So if n > n_0 = 34 we can get rid of the absolute values since |f(n)| = f(n)

f(n) <= c*n -> 3n^2 - 100n + 6 <= c * n

We have already come to the conclusion that 3n^2 - 100n + 6 >= n^2 if n > n_0

So: c * n >= n^2 which is not feasible, thus we have proved f(n) does not equal O(n)

***

### 4.) Let's prove that f(n) = Ω(n^2)

The definition for Ω: |f(n)| >= c * |g(n)|

If n > n_0 = 34, we can get rid of the absolute values

f(n) >= c * n^2 -> 3n^2 - 100n + 6 > c * n^2 = 1 * n^2

So if c=1 and n_0 = 34 then it is going to be a lower cound which is omega

**Because f(n) = O(n^2) and f(n) = Ω(n^2) -> f(n) = θ(n^2)**
