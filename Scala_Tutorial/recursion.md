# Recursion In Scala

```scala
def factorial(num : BigInt) BigInt = {
    if(num <= 1)
        1
    else
        num * factorial(num - 1)
}
println("Factorial of 4 = " factorial(4))
/* How this function works:
1st : num = 4 * factorial(3) = 4 * 6 = 24
2st : num = 3 * factorial(2) = 3 * 2 = 6
3st : num = 2 * factorial(1) = 2 * 1 = 2
*/
```
