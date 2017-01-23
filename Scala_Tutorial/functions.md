#Functions In Scala

The syntax for a function in Scala is:

```
def functionName (parameter1:datatype, parameter2:datatype) : ReturnType = {
    function body
    return valueToReturn
}
```

-

Example functions:

```scala
def getSum(num1 : Int = 1, num2 : Int = 1) Int = {
    num1 + num2
    // You don't need to return, scala automatically returns the last line of your functions
}
println("5 + 4 = " getSum(5,4))

def sayHi() : Unit =  { // We use the return type Unit when we don't want to return anything
    println("Hello there")
}

// "args : Int*" means this function will take any number of inputs of type Int
def getSum(args : Int*) : Int = {
    var sum : Int = 0
    for(num <- args){
        sum += num
    }
    sum
}
println("Sum is: " + getNum(1,2,3))
```
