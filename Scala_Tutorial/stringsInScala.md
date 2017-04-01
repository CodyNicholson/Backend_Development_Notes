# Strings In Scala

```
import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source

object ScalaTutorial
{
    def main(args: Array[String])
    {
        var myString = "abcdefg"
        println("The 3rd index of myString is: " + myString(3))
        // returns d

        println("The length of myString is: " + myString.length)
        // returns 7

        println(myString.concat("hijk"))
        // returns abcdefghijk

        println("You can add" + " strings together" + " with the + sign")

        println("The 3rd index of myString is: " + myString.indexOf("g")
        // returns 6

        val myStringArray = myString.toArray
        // returns an array of characters made from the string contents

        for (i <- myStringArray.length)
        {
            println(i) // prints each character in myStringArray
        }
    }
}
```
