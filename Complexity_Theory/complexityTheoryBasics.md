# Complexity Theory Basics

There are two types of complexities:

**Space Complexity**: How much memory an algorithm needs

**Time Complexity**: How much time an algorithm needs

-

We care more about Time Complexity than Space Complexity because space is very cheap

-

### How do we measure Time Complexity?

A new computer will be faster than an old computer and desktops are faster than smartphones, so how do we really know the **absolute time** an algorithm takes?

To measure the absolute time we consider the number of steps the algorithm takes

This approach is generic and machine independent, so we can use it to measure absolute time

***

For analyzing algorithms we have to consider the input size (number of items)

We want to make a good guess how the algorithm's running time depends on the number of items (input size)

This is the **order of growth**: how the algorithm will scale and behave with the input size

-

We want to make sure that we make a sorting algorithm that is approximately linear in terms of input

For example:

```
Sorting 100 items   ->  100ms
Sorting 1000 items  ->  1000ms (Good)
Sorting 1000 items  ->  10000ms (Bad)
```

As you can see in the above example, if we sort 100 items in 100ms we should try and make an algorithm that can sort 1000 items in 1000ms - that is good scaling

If we sort 1000 items and it takes 10000ms, we are taking 10 tims as long - we are not scaling well, the relationship between number of items and milliseconds is not linear

-

##### In another example:

**First Sorting Algorithm**

Sort 10 items: 1ms
Sort 20 items: 2ms
Sort 100 items: 10ms

This algorithm has linear time complexity denoted as: O(N)

**Second Sorting Algrithm**

Sort 10 items: 1ms
Sort 20 items: 4ms
Sort 100 items: 100ms

This algorithm has quadratic time complexity denoted as: O(N^2)

*The second algorithm is much slower than the first*

-

Usually we are interested in large input sizes so we can make some approximations

We are not interested in how our algorithm performs on small inputs, we want to see how it handles large inputs to see if it can scale well

This is called the **asymptotic analysis**
