# Russian Peasants Algorithm

The Russian Peasants Algorithm is an algorithm that people actually implemented by hand before there were computers to do multiplication

```python
def russian(a,b):
	x = a
	y = b
	while x > 0:
		if x % 2 == 1: z = z + y
		y = y << 1 # Take whatever the binary representation of y is and shift it over 1 to the left
		x = x >> 1 # Take whatever the binary representation of x is and shift it over 1 to the right
	return z
```

```
17 >> 1 = 8

This is because 17 = 10001

Shifting 1 to the right results in: 1000

1000 = 8
```

### Correctness - Why Does This Work?

The correctness check for this algorithm is very similar to the last. What holds is that the product of **a** and **b** is always equal to the product of **x** and **y** plus **z**. Since **x** is going to be counting down and eventually be 0, **z** is going to have to hold the product of **a** and **b**. To prove this we need to do two things.

1. We need to prove that when it starts off, this is the case
2. We need to show that if this condition holds at the beginning of the top of the while loop, then it is going to hold at the end with the new values of **x**, **y**, and **z**. To prove this we need to break this into two cases:

- Case 1: **x** is odd, so we add **z** and **y** together and make that the new value of **z**. Then we do a bit shift on **x** which is equivalent to **(x-1)/2**. Then **y** gets doubled because of its bit shift. What can we say about **x_prime**, **y_prime**, and **z_prime** at the bottom of the loop. We can substitute in values: **x_prime** * **y_prime** + **z_prime** = ((**x**-1)/2) * 2 * **y** + **z** + **y**, which equals: **x** * **y** - **y** + **z** + **y**, which equals **x** * **y** + **z**, which is equal to: **a** * **b**.
- Case 2: **x** is even, so **z** stays the same. Then we do a bit shift on **x** and we don't need to subtract 1 since **x** is even so we do: **x**/2. **y** still gets doubled. Then **x_prime** * **y_prime** + **z_prime** = (**x**/2) * 2 * **y** + **z**, which equals **x** * **y** + **z**, which is equal to: **a** * **b**.

In both of our cases we get a correct answer

### Which Is Better, naive() or russian()?

If we want the code to be more easy to read, then we would choose **naive()**. Which is fastest? **naive()** is much slower than **russian()** is terms of runtime. We can check this by running both algorithms with very large values and seeing which finishes first.
