#Tuples

```scala
def main(args : Array[String])
{
    // Decalres a new tuple with 3 values
    var tupleMarge = (103, "Marge Simpson", 10.25)

    // We can index our tuple using tuple._i where i is the position starting at 1
    printf("%s owes us $%.2f\n", tupleMarge._2, tupleMarge._3)
    // prints: Marge Simpson owes us $10.25

    // Iterates through teh values in our tuple and prints them
    tupleMarge.productIterator.foreach{i => println(i)}

    println(tupleMarge.toString()) // Prints the tuple as a string
}
