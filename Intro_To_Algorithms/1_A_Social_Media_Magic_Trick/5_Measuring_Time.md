# Measuring Time

We want to have a way to compare algorithms in terms of the time it takes to run them without actually having to go and do all the hard work of running them. Instead what we're going to try to do is analyze what the running time is in more of an abstract model of computation. We can use some simplifying assumptions that will allow us to do an analysis that is tractable.

1. Simple statement takes one unit of time. For example: x=x+1. This way we can count up the units of time that an algorithm takes to run.
2. The second simplifying assumption that we will make is that the time it takes to execute multiple statements in sequence is the sum of the times that it takes to execute each of the individual statements. This ignores a lot of issues that go on in the architecture of the computer like pipelining and caching that make this claim untrue in practice. This is a good approximation in reality. For example: To run an if-statement, we imagine that there is a unit of time taken for the conditional evaluation, combined with the time that it takes to actually execute the statement.
3. Looping takes time equal to the body of the loop multiplied by the number of iterations.

```python
s = 0
for i in range(10):
	s = s+i
print s
```

The above program takes 12 units of time. 1 unit for declaring **s**, 10 units for the for loop, and 1 unit to print out **s**.
