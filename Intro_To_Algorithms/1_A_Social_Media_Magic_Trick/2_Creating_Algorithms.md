# Creating Algorithms

Algorithms are really useful. Without careful algorithm design we don't see fast enough responses from things like websites and user interfaces - things we really depend on to be able to have computers react quickly.

Algorithms are also really clever. The goal is always to make our algorithms go really fast. To do this we should take care in organizing our programs so that they are not doing a lot of wasteful stuff. There is a lot of time that we can spend tweaking loops and other things in a program to just get rid of little bits and pieces of inefficiency. The most important thing is *good algorithm design*. Whenever our program is doing something that requires a great deal of computation you need to think hard about how to organize that computation so it does what we want it to do fast.

When we think about developing algorithms for particular problems, it is a kind of algorithm in itself:

1. We start off by analyzing the problem specification
2. Then we devise some kind of strategy for doing the computation - we'll call that our algorithm
3. Once we propose an algorithm is to analyze the correctness with respect to the problem specification to see if it actually accomplishes what the problem says you're supposed to accomplish
4. Lastly we analyze its efficiency - is it fast enough?

If our algorithm is not correct or fast enough then we can keep looping through the steps of this process until we come up with something better
