# Divide & Conquer

What is it about the design of the **russian()** algorithm that makes it so much better than the **naive()** app8roach that is just repetitive addition? Multiplication is repeated addition! We can represent multiplication as **number 1** added to itself **number 2** times. That said, we could also represent it as (**number 1** added to itself (**number 2**/2) times) plus (**number 1** added to itself (**number 2**/2) times). This means that we could also represent it as: 2 * (**number 1** added to itself (**number 2**/2) times). This is called **Divide & Conquer**, and it saves us time as opposed to doing one large additon statement.

The idea behind **Divide & Conquer** is that we can break a problem into roughly equal size sub-problems, solve each sub-problem separately, and then combine the results. In the example we talked about every time we compute a sub-problem we only do half the work, and this keeps compounding to give us a logarithmic number of steps instead of linear. This leads us to a recursive solution for the **russian()** problem:

```python
def rec_russian(a,b):
	if a == 0: return 0
	if a % 2 == 0: return 2 * rec_russian(a/2,b)
	return b + 2 * rec_russian((a-1)/2,b)
```
