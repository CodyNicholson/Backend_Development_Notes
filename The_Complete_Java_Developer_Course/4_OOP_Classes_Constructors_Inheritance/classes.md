#Classes

Objects in Java can be easily compared to objects in the real world - we can think of them in terms of **state** and **behavior**

State - in terms of a computer - might be the amount of RAM is has, the operating system  it's running, the hard drive size, the size of the monitor

State - outside the computer, for example: an Ant - might be the age of the Ant, the number of legs, the conscious state

Behavior - for a computer - might be booting up, shutting down, printing something, outputting a sound

Behavior - for the Ant - might be eating, drinking, fighting, carrying food, etc

***

**Software Objects are very similar to real-world objects because they also have states and behaviors**

Software Objects store their states in fields known as variables, and they expose their bahavior with methods

**A Class can be thought of as a template or a blueprint for creating objects**

**A Class is more powerful than a primitive type because it is a user-defined data-type**

Example Car class:

```java
public class Car
{
    //These private variables represent the state of the Car
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;
}
```

**Local Variables** are the variables we have been using in our methods - they are local because they belong to the method - you cannot access those variables outside of the method

**Class/Member/Instance Variables** or **Fields** are variables that belong to a class - They are defined in the Class's block/scope

-

As a general rule in Java, we use the access modifier **Private** to define our field variables because we only need to use them inside the class, not outside - _**Encapsulation**_

**Encapsulation** is when we hide fields/methods/classes by limiting their access - This is one of the key rules of OOP

We have encapsulated all of the variables we defined in the Car class by making them private

***

###Creating an Object of our Car Class

```java
public class Main
{
    public static void main(String[] args)
    {
        Car porsche = new Car();
        Car holden = new Car();
    }
}
```

We create objects by using the **new** keyword

We define our objects with our user-defined type of **Car**

Now we have two Car objects, and if you type "porsche." and look at the method options the IDE provides, you will see that your object already has methods like "equals", "toString", "hashCode", etc

These are methods added to any user-defined class automatically by java

-

If we made out memeber/instance variables in the Car class public, we could do "porsche.model = '2017 CoolCarName'" - we could set that instance variable of our object

The reason we do not do this is because that violates the laws of OOP, because then ANYONE could change the model of your Car object at anytime, and you don't want your object to be vulnerable

***

###Setter Method

If we do want to change the model we create a method in the Car class to do so:

```java
public class Car
{
    //These private variables represent the state of the Car
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;

    public void setModel(String model)
    {
        this.model = model;
    }
}
```

The setModel() method allows us to change the instance/member variable *while* keeping that variable private - using encapsulation correctly, and following the rules of OOP

The **this** keyword allows us to access the fields of the object we call it on

For example, below we call setModel() on porsche, so the "this" keyword in that case references the porsche object and its' fields

```java
public class Main
{
    public static void main(String[] args)
    {
        Car porsche = new Car();
        porsche.setModel("2017 CarModelName");
    }
}
```

Above you will see how we can change the model by using the setModel() method since it is a public method - since the setModel() method is a part of the Car class, it has access to the fields or instance/member variables of that class

-

###Getter Method

Now we can set the model, but we cannot check the value of model

In order to check the value we will create a **Getter Method** for the Car's model field

```java
public class Car
{
    //These private variables represent the state of the Car
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getModel()
    {
        return this.model;
    }
}
```

As you can see, when we call getModel() we will return the instance variable for the Car object by using the word **this**

```java
public class Main
{
    public static void main(String[] args)
    {
        Car porsche = new Car();
        porsche.setModel("2017 CarModelName");
        System.out.println(porsche.getModel());
    }
}
// Output will be: 2017 CarModelName
```

getModel() returns the field "model" from whatever Car object we call it on