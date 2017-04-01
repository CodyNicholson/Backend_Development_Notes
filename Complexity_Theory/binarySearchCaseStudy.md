# Binary Search - Case Study

We want to find an item in an array, but this time the array is sorted

If we know the index of the item, we can get it with O(1) constant time complexity

If we don't know the index, we can start in the middle, and on every iteration we can discard half of the items

-

What is the running time of this algorithm? How many times can we divide **N** by **2** until we have only **1** left?

1 = N/2^x

2^x = N

log2^x = logN

x = logN

So we have come to the conclusion that binary search has O(logN) logarithmic running time

What does this mean?

If we have 4x larger array, algorithm has 2x running time

If we have 9x larger array, algorithm has 3x running time

**This is Logarithmic Running Time, it is better than Linear Time**
