# Accessors and Mutators

### Accessors

String str = "Some String";

str.toUpperCase();
THIS DOES NOT CHANGE str!
str will remain "Some String" because toUpperCase() is an accessor method, not a mutator, and cannot change a variable

If you want to change str to "SOME STRING" you must do:
str = str.toUpperCase();

***

### Mutator

```
Picture pic = new Picture("pic.jpg");

pic.translate(10,20);

translate() is a mutator method, so it will change pic without you needing to do: pic = pic.translate(10,20)
```


***

### Shared Objects, Rectangles are objects:

```java
Rectangle box1 = new Rectangle(5,10,60,90);
Rectangle box2 = box1;
box1.translate(100,100);
box1.getX();     = 105.0
box2.getX();     = 105.0
```

In this example we have box1 with an X coord of 5, and box2 equal to box1

Since we set box2 equal to box1, box2 points to the same Rectangle object as box1, so box2 and box1 both have an X coord of 105 after box1.translate(100,100)

This property is transitive, meaning that if we replaced box1.translate(100,100) with box2.translate(100,100) we would get the same result

This is called a shared object and these rules pertain to all objects in Java

***

###Strings are not Mutable, but objects are:

String g1 = "Hello";
String g2 = g1;
String g3 = g1.toUpperCase();
System.out.print(g2);
Output: Hello

Strings are not mutable in Java, so even though we used g3 to try and mutate g1, g1 did not change

***

###ints are not objects:

int num1 = 13;
int num2 = num1;
num2 = 12;

The value of num1 = 13
The value of num2 = 12
When we set num2 = num1, this is not the same as setting a Rectangle variable equal to another Rectangle variable
Setting num2 = num1 is the same as setting num2 = 13 because int's don't care about the refference to num1, they only care about the value of the number they contain
When we used Shared Objects with Rectangles, we used the word "new" to create an object, but since we don't have a int object we cannot make references to it
