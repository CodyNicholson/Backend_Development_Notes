# File.IO In Scala

To read and write from files we need to import these libraries:

```
import java.io.PrintWriter
import scala.io.Source
```

```scala
object ScalaTutorial
{
    def main(args: Array[String])
    {
        // Writing to files
        val writer = new PrintWriter("testFileName.txt")
        writer.write("Just some random text\n next line")
        writer.close()

        // Reading files
        val textFromFile = Source.fromFile("test.txt", "UTF-8")
        val lineIterator = textFromFile.getLines

        for(line <- lineIterator)
            println(line)

        textFromFile.close()
    }
}
```
