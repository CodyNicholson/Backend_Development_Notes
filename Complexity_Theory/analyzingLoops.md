# Analyzing Loops

**Constant Time Complexity Example: O(1)**

Swaping two numbers or deciding whether a number is even or odd

```
function swap(num1, num2)
    temp = num1;
    num1 = num2;
    num2 = temp;
```

### **Linear Running Time: O(N)**

When we have a *for* loop and inside the loop we make **O(1)** running time operations

```
for i = 0 to N:
    do O(1) operation
```

For example, we sum up items or we check whether an item is equal to 10 (Searching in 1 dimensional array)

### **Quadratic Running Time: O(N^2)**

When we have a *for* loop, and we have a nested *for* loop, and inside the loop we make )(1) running time operations

```
for i = 0 to N
    for j = 0 to N:
        do O(1) operation
```

For example, we sum items or we check whether an item is equal to 10 (Searching two-dimensional array)

```
for i = 0 to N
    for j = 0 to i:
        do O(1) operation
```

In the above algorithm we make fewer operations but we still run at quadratic runtime
