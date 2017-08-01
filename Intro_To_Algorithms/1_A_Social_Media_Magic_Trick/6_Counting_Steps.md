# Counting Steps

```python
def countdown(x): # 1 unit
	y=0
	while x > 0: # 2 * x/5 units in this loop
		x = x-5
		y = y+1
	print y # 1 unit
print countdown(50) # 1 unit
```

The function to determine how long this program takes to run is:

```python
def time(n):
	return 3 + 2 * math.ceil(n/5)
```

This function reveals that the program scales linearly - meaning that as **n** gets bigger the time it takes to run the program grows proportionally to it

***

### Steps For Naive

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

Recall the **naive()** program above, let's count the number of steps (time units) it takes to run **naive()** as a function of **a**

```python
def time(a):
    # The number of steps it takes to execute naive(a, b)
    # as a function of a
    steps = 0
    # your code here
    return 2*a+3
```

The answer in this case is **2 * a + 3** because the running time depends on **x** since **x** controls how many times the while loop executes. Since **x** is equal to **a**, we can say that **a** controls the  number of time the loop executes. Since there are 2 statements in the loop we multiply **a** by 2 and add 3 to it since there are three statements outside the loop to consider.

***

### Halving

```python
def russian(a,b):
	x = a
	y = b
	while x > 0:
		if x % 2 == 1: z = z + y
		y = y << 1
		x = x >> 1
	return z
```

The number of statements that it takes to execute **naive(a,b)** is a linear function of **a**. Recall the above **russian()** function. It will be a bit trickier to get the runtime because of the if statements inside the while loop. The key step in analyzing the number of steps that this algorithm will take is understanding how many times this loop is going to be executed. This is equal to number of times that it takes to divide **x** in half before it rounds down to 0.

#### How many times can you divide a number **x** in half (rounding down) before it hits zero?

**floor(log2_x) + 1**

### Steps For russian() Program

Notice that in the russian() program we know the number of times the loop will be executed: **floor(log2_x) + 1** times. For each of those times, how many statements get executed? We know the conditional statement of the if statement will execute always along with the two lines below that. The additional statement within the if statement only gets executed when **x** is odd. This happens however many times as there are 1 bits in the binary representation of **a**. With this info we can find the runtime as:

**3 * (floor(log2_a) + 1) + 3 + number of 1 bits in a**

We can make this slightly less of a mess if we notice that this is upper bounded by: **<= 4 * floor(log_2_a) + 7**, since the most number of 1 bits you can have in a number is equal to the number of bits in that number. This is much faster than **naive()**.
