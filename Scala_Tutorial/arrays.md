# Arrays In Scala

```scala
def main(args : Array[String]){

    val favNums = new Array[Int](20) // You have to declare type and size for array

    val friends = Array("Bob", "Tom") // You can define and initialize an array in one line

    friends(0) = "Sue" // You can index and change values in an array like this

    println("Best Friend " friends(0)) // We can access and print values of the array like this

    val friends2 = ArrayBuffer[String]() // You don't need to initialize its size because an ArrayBuffer's size can change

    friends2.insert(0, "Phil") // Inserts Phil at index 0 and changes size of array (If array was empty)

    friends2 += "Mark" // Adds Mark to the end of the array and increases size of the Array by 1

    friends2.insert(1, "A", "B", "C") // Inserts A B and C into the Array at position 1 and pushes elements in these positions backward in the array

    friends2.remove(1,2) // Removes elements at positions 1 and 2

    val friend : String = " " // Declares an empty string, same as: val friend = " "

    for(i <- friends2) // Prints every friend in the list
        println(i)

    for(j <- 0 to (favNums.length - 1)){ // Cycles through empty favNums Array
        favNums(j) = j // Sets each position in array equal to its corresponding index
        printsln(favNums(j)) // prints the positions it sets
    }

    val favNumsTimes2 = for(num <- favNums) yield 2 * num // We declare an array and populate that array will all of the values
    // from you favNums array * 2

    favNumsTimes2.foreach(println) // This will print all the favNumsTimes2

    var favNumsDiv4 = for(num <- favNums if num % 4 == 0) yield num // Declares an array and gives it all the nums from favNums divisible by 4

    favNumsDiv4.foreach(println) // Prints each num from favNums that are divisible by 4

    var multiTable = Array.ofDim[Int](10,10) // Declares a multi-dimensional array with dimensions 10 x 10

    for(i <- 0 to 9){ // Populates multiTable
        for(j <- o to 9){
            multiTable(i)(j) = i * j
        }
    }

    for(i <- 0 to 9){ // prints the values in the multiTable
        for(j <- o to 9){
            printf("%d : %d = %d\n", i, j, multiTable(i)(j))
        }
    }

    println("Sum of favNums : " + favNums.sum)
    println("Min of favNums : " + favNums.min)
    println("Max of favNums : " + favNums.max)

    val sortedNumsDecend = favNums.sortWith(_>_) // sort decending
    val sortedNumsAccend = favNums.sortWith(_\<_) // sort accending

    println(sortedNums.deep.mkString(", ")) // With print each value in this array with a ", " between wach of them
}
```
