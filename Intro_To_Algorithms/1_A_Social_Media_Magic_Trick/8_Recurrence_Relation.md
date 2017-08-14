# Recurrence Relation

```python
def rec_russian(a,b):
	if a == 0: return 0
	if a % 2 == 0: return 2 * rec_russian(a/2,b)
	return b + 2 * rec_russian((a-1)/2,b)
```

We're going to do a recurrence relation which is a kind of recursive mathematical function which is a good match for this recursive algorithmic expression for **rec_russian()**. Looking at the structure of **rec_russian()**, if **a** is 0 then it's going to execute 1 statement to test to see whether it's 0, and returns. Otherwise, if **a** is bigger than 0 and even, then it will fail the first if-statement, but it will pass the second if statement which will execute the **2 * rec_russian(a/2,b)**. 

### Rec_Russian Recurrence Relation

```
T(a) = { if a = 0, 1 }
       { elif a is even, 3 + T(a/2) }
       { else, 3 + T((a-1)/2) }
```

The number of times that **a** can be divided in half before it reaches 0 can be expressed as: **floor(log_2(a))**. We multiply this by 3 because 3 will be added every time the function is called until **a = 0**. This makes our equation: **3 * floor(log_2(a))**. Lastly, we will add 4 since once **a = 0** we end up with 1, and we still have to add the 3 that comes from the else statement when **a** does not equal 0 and is odd. This makes our final answer: **3 * floor(log_2(a)) + 4**.
