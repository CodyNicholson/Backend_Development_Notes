# Recurrence Relation

```python
def rec_russian(a,b):
	if a == 0: return 0
	if a % 2 == 0: return 2 * rec_russian(a/2,b)
	return b + 2 * rec_russian((a-1)/2,b)
```

We're going to do a recurrence relation which is a kind of recursive mathematical function which is a good match for this recursive algorithmic expression for **rec_russian()**. Looking at the structure of **rec_russian()**, if **a** is 0 then it's going to execute 1 statement to test to see whether it's 0, and returns. Otherwise, if **a** is bigger than 0 and evenfasdfdsafsd