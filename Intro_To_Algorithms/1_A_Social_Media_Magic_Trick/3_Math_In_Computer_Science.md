# Math In Computer Science

There are three natural ways that theory/math can really help us in computing:

1. To get you thinking clearly about what it is that you're trying to accomplish. It is easy to lose track of the goal while in the depths of writing code. 
2. Analyzing the efficiency of what you've produced. Mathematical knowledge will give you a sense of spots inyour program where you could be doing a better job. More effective, more efficient without producing incorrect code. 

**Efficiency** is an important topic because it can mean more efficient in terms of time, more efficient in terms of memory, and more efficient in terms of energy usage. The main focus of this class is more efficient in terms of time.

***

### What Does This Algorithm Do?

```python
def naive(a, b):
    x = a
    y = b
    z = 0
    while x > 0:
        z = z + y
        x = x - 1
    return z
```

It adds **y** to itself **x** times. Since **y** is equal to **b**, and **x** is equal to **a**, this algorithm effectively multiplies **a** by **b**.

### Analyzing The Correctness Of The naive() Algorithm

What we are trying to prove is the correctness of the claim that: **naive(a,b)** outputs the product of **a** and **b**. The observation that we will make is that before or after the while loop this statement is always true: **a * b = x * y + z** is equal to **a** multiplied by **b**.

##### Base Case

The first time through, x = a, y = b, and z = 0

**a * b = a * b + 0**, and this is true

##### Inductive Step

If **a * b = x * y + z** before, then **a * b = x_prime * y_prime + z_prime** after

The next thing we will show is that, if it is the case that at the beginning of the while loop, this condition holds that **a** multiplied by **b** is exactly equal to **x** times **y** plus **z**, then it's going to be the case that with the new values: **a * b = x_prime * y_prime + z_prime**.

We know what **x_prime, y_prime, and z_prime** are so we can substitute them as: **(x-1) * (y) + (z + y)**, which equals: **x * y - y + z + y**, which equals: **x * y + z**, which is equal to **a * b**. This condition is maintained through each step of the while loop.

We now know that while this code is running each time we go through the while loop, **a * b = x * y + z**. At the end of the while loop **x** is 0. Since: **x * y + z = a * b**, and **x** is 0, then: **z = a * b**. Since **a * b** is equal to **z** at the end, we again prove that this algorithm is meant to multiply **a * b**.

***

### Running Time Of naive(a,b)

We notice that the larger we make our input numbers, the slower our program will run. It we plot our runtimes we will see that the as we increase the size of our inputs the time will increase and the relationship is *linear*.
