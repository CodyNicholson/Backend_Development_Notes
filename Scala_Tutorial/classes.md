# Classes In Scala

**Classes** are going to be used as blueprints to make real-world objects

Those objects are going to define attributes, which are called **fields** in Object Oriented Programming (OOP)

Objects will also have capabilities that are called **methods**

-

The static keyword does not exist in Scala

Constructors are created differently in Scala than Java

-

Scala supports the same access modifiers that Java does: public, private, protected

-

### Inheritance

When one class inherits from another it gains access to all of that classes protected variables and methods

If you do not want a class to be inherited from, declare it as final

***

```
object ScalaTutorial
{
    def main(args: Array[String])
    {
        val rover = new Animal
        rover.setName("Rover")
        rover.setSound("Woof")
        printf("%s says %s\n", rover.getName, rover.getSound)

        val cat = new Animal("Luna", "Meow")
        println(s"${cat.getName} with id ${cat.id} says ${cat.sound})

        println(car.toString)

        val spike = new Dog("Spike", "Woof", "Grrrr")
        spike.setName("Spike")

        spike.tostring
    }

    class Animal(var name: String, var sound: String)
    {
        this.setName(name) // This is the constructor, you do not need to create a constructor method like in Java
        this.setSound(sound)  // Constructor

        val id = Animal.newIdNum

        def getName() : String = name
        def getSound() : String = sound

        def setName(name : String)
        {
            // If the name has numbers, set name to "No Name"
            if(!(name.matches(".*\\d+.*")))
                this.name = name
            else
                this.name = "No Name"
        }

        def setSound(sound: String)
        {
            this.sound = sound
        }

        def this(name : String) // A new constructor is defining a "this" method with different arguments
        {
            this("No Name", "No sound")
            this.setName(name)
        }

        def this() // A new constructor is defining a "this" method with different arguments
        {
            this("No Name", "No sound")
        }

        // Overriding methods
        override def toString() : String = {
            return "%s with the id %d says %s".format(this.name, this.id, this.sound)
        }
    }

    // This is how you create static fields and functions inside of scala
    object Animal {
        private var idNumber = 0
        private def newIdNum = {idNumber += 1; idNumber}
    }

    class Dog(name: String, sound: String, growl: String) extends Animal(name, sound){
        def this(name: String, sound: String){
            this("No Name", sound, "No Growl")
            this.setName(name) // Inherits method from Animal
        }

        def this(name: String){
            this("No Name", "No Sound", "No Growl")
            this.setName(name)
        }

        def this(){
            this("No Name", "No Sound", "No Growl")
        }

        override def toString(): String = {
            return "%s with the id %d says %s or %s".format(this.name, this.id, this.sound, this.growl)
        }
    }
}
```

***

### Abstract Classes

Abstract Classes cannot be instantiated (Cannot create an object of this class) and is made up of both abstract and non-abstract methods

```
object ScalaTutorial
{
    def main(args: Array[String]){
        val fang = new Wolf("Fang")
        fang.moveSpeed = 36.0
        println(fang.move)
    }

    abstract class Mammal(val name : String){
        var modeSpeed : Double
        // This is just a field with no value assigned since it is abstract

        def move : String
        // This is just a method definition with a return type because it is abstract
    }

    class Wolf(name : String) extends Mammal(name){
        var moveSpeed = 35.0

        // We don't need to declare the return type or arguments for this
        // method since it is inherited from the abstact class
        def move = "The wolf %s runs %.2f mph".format(this.name, this.moveSpeed)
    }
}
```
