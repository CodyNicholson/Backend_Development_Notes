# Classes & Objects

```c++
// Classes are the blueprints for modeling real world objects
// Real world objects have attributes, classes have members / variables
// Real world objects have abilities, classes have methods / functions
// Classes believe in hiding data (encapsulation) from outside code

// Declare a Animal type object
Animal fred;

// Set the values for the Animal
fred.setHeight(33);
fred.setWeight(10);
fred.setName("Fred");

// Get the values for the Animal
cout << fred.getName() << " is " << fred.getHeight() << " cms tall and "
	<< fred.getWeight() << " kgs in weight" << endl;

fred.setAll(34, 12, "Fred");

cout << fred.getName() << " is " << fred.getHeight() << " cms tall and "
	<< fred.getWeight() << " kgs in weight" << endl;

// Creating an object using the constructor
Animal tom(36, 15, "Tom");

cout << tom.getName() << " is " << tom.getHeight() << " cms tall and "
	<< tom.getWeight() << " kgs in weight" << endl;

// Demonstrate the inheriting class Dog
Dog spot(38, 16, "Spot", "Woof");

// static methods are called by using the class name and the scope operator
cout << "Number of Animals " << Animal::getNumOfAnimals() << endl;

spot.getSound();

// Test the toString method that will be overwritten
tom.toString();
spot.toString();

// We can call the superclass version of a method with the class name 
// and the scope operator
spot.Animal::toString();

// When a function finishes it must return an integer value
// Zero means that the function ended with success
return 0;
```
