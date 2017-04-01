# Input & Output In Scala

```scala
import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source

object ScalaTutorial
{
    def main(args: Array[String])
    {
        var numberGuess = 0

        do
        {
            print("Guess a number ")
            numberGuess = readLine.toInt
        }
        while(numberGuess != 15)

        printf("You guessed the secret number %d\n", 15)
    }
}
```

-

```scala
import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source

object ScalaTutorial
{
    def main(args: Array[String])
    {
        var name = "Cody"
        val age = 39
        val weight = 175.5

        println(s"Hello $name")
        println(f"I am ${age + 1} and weigh $weight%.2f")
        // Use %c for characters, %d for ints, %f for floating point nums, and %s for strings
    }
}
```
