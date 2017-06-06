# Classes & Objects

```cs
// ---------- CLASSES & OBJECTS ----------

Animal bulldog = new Animal(13, 50, "Spot", "Woof");

Console.WriteLine("{0} says {1}", bulldog.name, bulldog.sound);

// Console.WriteLine("No. of Animals " + Animal.getNumOfAnimals());
```

```cs
namespace ConsoleApplication2
{
    class Animal
    {
 
        // public : Access is not limited
        // protected : Access is limited to the class methods and subclasses
        // private : Access is limited to only this classes methods
        public double height { get; set; }
        public double weight { get; set; }
        public string sound { get; set; }
 
        // We can either have C# create the getters and setters or create them ourselves to verify data
        public string name;
        public string Name
        {
            get { return name; }
            set { name = value; }
        }
 
        // Every object has a default constructor that receives no attributes
        // The constructor initializes every object created
        // this is used to refer to this objects specific fields since we don't know the objects given name
 
        // The default constructor isn't created if you create any other constructor
        public Animal()
        {
            this.height = 0;
            this.weight = 0;
            this.name = "No Name";
            this.sound = "No Sound";
 
            numOfAnimals++;
        }
 
        // You can create custom constructors as well
        public Animal(double height, double weight, string name, string sound)
        {
            this.height = height;
            this.weight = weight;
            this.name = name;
            this.sound = sound;
 
            numOfAnimals++;
        }
 
        // A static fields value is shared by every object of the Animal class
        // We declare thinsg static when it doesn't make sense for our object to either have the property or
        // the capability to do something (Animals can't count)
        static int numOfAnimals = 0;
 
        // A static method cannot access non-static class members
        public static int getNumOfAnimals()
        {
            return numOfAnimals;
        }
 
        // Declare a method
        public string toString()
        {
            return String.Format("{0} is {1} inches tall, weighs {2} lbs and likes to say {3}", name, height, weight, sound);
        }
 
        // Overloading methods works if you have methods with different attribute data types
        // You can give attributes default values
        public int getSum(int num1 = 1, int num2 = 1)
        {
            return num1 + num2;
        }
 
        public double getSum(double num1, double num2)
        {
            return num1 + num2;
        }
 
        static void Main(string[] args)
        {
            // Create an Animal object and call the constructor
            Animal spot = new Animal(15, 10, "Spot", "Woof");
 
            // Get object values with the dot operator
            Console.WriteLine("{0} says {1}", spot.name, spot.sound);
 
            // Calling a static method
            Console.WriteLine("Number of Animals " + Animal.getNumOfAnimals());
 
            // Calling an object method
            Console.WriteLine(spot.toString());
 
            Console.WriteLine("3 + 4 = " + spot.getSum(3, 4));
 
            // You can assign attributes by name
            Console.WriteLine("3.4 + 4.5 = " + spot.getSum(num2: 3.4, num1: 4.5));
 
            // You can create objects with an object initializer
            Animal grover = new Animal
            {
                name = "Grover",
                height = 16,
                weight = 18,
                sound = "Grrr"
            };
 
            Console.WriteLine(grover.toString());
 
            // Create a subclass Dog object
            Dog spike = new Dog();
 
            Console.WriteLine(spike.toString());
 
            spike = new Dog(20, 15, "Spike", "Grrr Woof", "Chicken");
 
            Console.WriteLine(spike.toString());
 
            // One way to implement polymorphism is through an abstract class
            Shape rect = new Rectangle(5, 5);
            Shape tri = new Triangle(5, 5);
            Console.WriteLine("Rect Area " + rect.area());
            Console.WriteLine("Trit Area " + tri.area());
 
            // Using the overloaded + on 2 Rectangles
            Rectangle combRect = new Rectangle(5, 5) + new Rectangle(5, 5);
 
            Console.WriteLine("combRect Area = " + combRect.area());
 
            // ---------- GENERICS ----------
            // With Generics you don't have to specify the data type of an element in a class or method
            KeyValue<string, string> superman = new KeyValue<string, string>("","");
            superman.key = "Superman";
            superman.value = "Clark Kent";
            superman.showData();
 
            // Now use completely different types
            KeyValue<int, string> samsungTV = new KeyValue<int, string>(0, "");
            samsungTV.key = 123456;
            samsungTV.value = "a 50in Samsung TV";
            samsungTV.showData();
 
            Console.Write("Hit Enter to Exit");
            string exitApp = Console.ReadLine();
 
        }
    }
 
    class Dog : Animal
    {
        public string favFood { get; set; }
 
        // Set the favFood default and then call the Animal super class constructor
        public Dog() : base()
        {
            this.favFood = "No Favorite Food";
        }
 
        public Dog(double height, double weight, string name, string sound, string favFood) :
            base(height, weight, name, sound)
        {
            this.favFood = favFood;
        }
 
        // Override methods with the keyword new
        new public string toString()
        {
            return String.Format("{0} is {1} inches tall, weighs {2} lbs, likes to say {3} and eats {4}", name, height, weight, sound, favFood);
        }
 
    }
}
```
