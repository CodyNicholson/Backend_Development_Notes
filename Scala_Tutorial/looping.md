#Looping In Scala

###While Loop

```scala
object ScalaTutorial
{
    def main(args: Array[String])
    {
        var i = 0

        while(i <= 10)
        {
            print(i)
            i += 1
        }
    }
}
// returns: 012345678910
```

***

###Do-While Loop

You use Do-While loops when you want to make sure you go through the loop at least once

```scala
object ScalaTutorial
{
    def main(args: Array[String])
    {
        var i = 0

        do
        {
            print(i)
            i += 1
        }
        while (i <= 10)
    }
}
// returns: 012345678910
```

***

###For Loop

```scala
object ScalaTutorial
{
    def main(args: Array[String])
    {
        var i = 0

        // This is the syntax for a for loop that will iterate from 1 to 10
        for (i <- 1 to 10) 
        {
            print(i)
        }
    }
}
// returns: 12345678910
```

-

```scala
object ScalaTutorial
{
    def main(args: Array[String])
    {
        val i = 0
        var randLetters = "SADFASGHWTRHERTHWERGQGWEGFBFDGBFGE"

        for (i <- 1 until randLetters.length) 
        {
            print(randLetters(i))
        }
    }
}
// returns: SADFASGHWTRHERTHWERGQGWEGFBFDGBFGE
```

-

```scala
object ScalaTutorial
{
    def main(args: Array[String])
    {
        val i = 0
        var aList = List(11,22,33,44,55)

        for (i <- aList) 
        {
            println("List itme " + i)
        }
    }
}
/* returns:
List item 11
List item 22
List item 33
List item 44
List item 55
*/
```

-

```scala
object ScalaTutorial
{
    def main(args: Array[String])
    {
        val i = 0

        var evenList = for { i <- 1 to 10
            if (i % 2) == 0
            } yield i

        for (i <- evenList) 
        {
            println(i)
        }
    }
}
/* returns:
2
4
6
8
10
*/
```

-

```scala
object ScalaTutorial
{
    def main(args: Array[String])
    {
        val i = 0

        // For every i, j will iterate from 4 to 6 as seen in the output
        for (i <- 1 to 3; j <- 4 to 6) 
        {
            println("i : " + i)
            println("j : " + j)
        }
    }
}
/* returns:
i : 1
j : 4
i : 1
j : 5
i : 1
j : 6
i : 2
j : 4
i : 2
j : 5
i : 2
j : 6
i : 3
j : 4
i : 3
j : 5
i : 3
j : 6
*/
```

-

###Break & Continue Substitutes

```scala
object ScalaTutorial
{
    def main(args: Array[String])
    {
        val i = 0

        def printPrimes(){
            val primeList = List(1,2,3,5,7,11)
            for(i <- primeList){
                if(i == 11){ // A make-shirt break
                    return
                }

                if(i != 1){ // A make-shift continue
                    println(i)
                }
            }
        }

        printPrimes

    }
}
/* returns:
2
3
5
7
*/
```
