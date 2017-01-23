#Higher-Order Functions In Scala

Functions can be passed just like any other variable since they have a return type

**Higher-Order Functions** are functions that take other functions as parameters like map() and filter()

```
object ScalaTutorial
{
    def main(args: Array[String])
    {
        val log10Function = log10 _
        // underscore denotes a function

        println(log10Function(1000))
        // this will print 3.0 since log10Function is the function

        List(1000.0, 10000.0).map(log10Function).foreach(println)
        // prints: 3.0 4.0, the map() method applies a function given as a parameter to every element in a list

        List(1,2,3,4,5).map((x : Int) => x * 50).foreach(println)
        // prints: 50 100 150 200 250

        List(1,2,3,4,5).filter(_ % 2 == 0).foreach(println)
        // prints even numbers in list, the filter() method filters elements
        // in our list based on a conditional we provide as a parameter


    }
}
```

***

###How To Pass Different Functions Into A Function

```scala
object ScalaTutorial
{
    def main(args: Array[String])
    {
        val log10Func = log10 _

        def times3(num : Int) = num * 3
        // Takes a num, returns that num times 3

        def times4(num : Int) = num * 4
        // Takes a num, returns that num times 4

        def multiIt(functionArugmentName : (Int) => Double, num : Int) = {
            functionArugmentName(num)
            // This will use whatever function we passed through on the number
        }

        printf("4 * 100 = %.1f\n", multiIn(times4, 100))


        // A closure is a function that depends on a variable that is declared outside of that function

        val divisorVal = 5
        val divisor5 = (num : Double) => num / divisorVal
        println("5 / 5 = " + divisor(5.0))
    }
}
```
