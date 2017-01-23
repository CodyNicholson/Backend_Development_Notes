#Higher-Order Functions In Scala

Functions can be passed just like any other variable since they have a return type

**Higher-Order Functions** are 

```
object ScalaTutorial
{
    def main(args: Array[String])
    {
        val log10Function = log10 _
        // underscore means "for every item"

        println(log10Function(1000))

        List(1000.0, 10000.0).map(log10Function).foreach(println)
        // prints: 3.0 4.0

        List(1,2,3,4,5).map((x : Int) => x * 50).foreach(println)
        // prints: 50 100 150 200 250

        List(1,2,3,4,5).filter(_ % 2 == 0).foreach(println)
        // prints even numbers in list

        def times3(num : Int) = num * 3

        def times4(num : Int) = num * 4

        def multiIt(functionName : (Int) => Double, num : Int) = {
            functionName(num)
        }

        printf("4 * 100 = %.1f\n", multiIn(times4, 100))

        val divisorVal = 5

        val divisor5 = (num : Double) => num / divisorVal

        println("5 / 5 = " + divisor(5.0))
    }
}
