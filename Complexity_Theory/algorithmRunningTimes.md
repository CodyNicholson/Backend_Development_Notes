#Algorithm Running Times

Here is a list of algorithm runtimes from highest (worst) to lowest (best):

- O(n!) Factorial Complexity

- O(c^n) Exponential Complexity (c is a constant)

- O(n^k) Polinomial Complexity (k > 1)

- O(N * logN) Linearithmic Complexity

- O(N) Linear Complexity

- O(logN) Logarithmic Complexity

- O(1) constant time complexity

***

We like to create algorithms that are of Linearithmic Complexity or faster because **Any algorithms that are slower than Linearithmic Algorithms are not practial to use since they do not scale well**

***

###Constant Time Complexity O(1)

Swapping two numbers or deciding whether a number is odd or even are both examples of things we can do in constant time

```
function swapNums(num1, num2):
    temp = num1
    num1 = num2
    num2 = temp
end function
```

-

###Logarithmic Time Complexity  O(logN)

Finding an arbitrary item in a sorted array

Checking whether there is a cycle in a graph when solving Kruskal-Algorithm (with disjoint sets)

-

###Linear Time Complexity O(N)

Finding the maximum value in an array of numbers

```
function findMax(a[])
    max = a[0]

    for(int i=0; i < a.length; i++):
        if(a[i] > max):
            max = a[i]

    return max
end function
```

-

###Linearithmic Time Complexity O(N * logN)

mergesort, quicksort, heapsort

finding closest pair of points whith divide and conquer method

-

###Polinomial Time Complexity O(N^k) where k=2 - quadratic

bubble sort, insertion sort

finding the closest pair of points with brute fource approach

-

###Exponential Time Complexity O(c^N) where c is a constant

Towers of Hanoi problem ~ c=2 in this case

Calculating Fibonacci numbers with recursive manner ~ c = 2

Traveling Salesman Problem with dynamic programming implementation

-

###Factorial Time Complexity O(N!)

Solving the traveling salesmen problem with brute force search ( we generate all the possible routes which is N! and try to find the one with the minimum overall distance)
