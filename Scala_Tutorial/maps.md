# Maps In Scala

```scala
def main(args: Array[String]){

    // Maps are immuatable - cannot be changed once created
    // Keys must be unique
    val employees = Map("Key" -> "Value", "Manager" -> "Bob")

    // If there is a Key "Manager" print its value
    if(employees.contains("Manager"))
        printf("Manager : %s\n", employees("Manager"))

    // This Map is mutable, can be changed, since we used the Map from the mutable class
    val customers = collection.mutable.Map(100 -> "Paul", 101 -> "Sally")

    // PrintsCustomer with Key "100"
    printf("Cust 1 : %s\n", customers(100))

    // Changes the value at Key 100 to be "Tom"
    customers(100) = "Tom"

    // Adds a Key with value "Megan"
    customers(102) = "Megan"

    // Prints all Keys and Values from the customers Map
    for((k,v) <- customers)
        printf("%d : %s\n", k, v)
}
```
