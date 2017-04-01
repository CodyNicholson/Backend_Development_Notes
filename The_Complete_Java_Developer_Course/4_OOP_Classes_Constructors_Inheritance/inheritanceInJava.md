# Inheritance In Java

In order to avoid rewriting the same code we can use **inheritance**

Subclasses can **Inherit** methods from a super class

For example: you could have a Vehicle super class with the methods drive, stop, getGasAmount, and refuel. If the super class Vehicle has subclasses: truck, car, motorcycle, and golf cart - then all of those subclasses can inherit the superclass's four methods so you don't have to rewrite them over and over

```java
public class Animal
{
    private String name;
    private int brain;
    private int body;
    private int size;
    private int weight;

    public Animal(String name, int brain, int body, int size, int weight)
    {
        this.name = name;
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weight = weight;
    }

    public void eat()
    {
        System.out.println("Animal.eat() called");
    }

    public void move(int speed)
    {
        System.out.println("Animal.move() called. Animal is moving at speed: " + speed);
    }
}
```

```java
public class Dog extends Animal
{
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int brain, int body, int size, int weight, int eyes, int legs, int tail, int teeth, String coat)
    {
        super(name, brain, body, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew()
    {
        System.out.println("Dog.chew() called");
    }

    @Override
    public void eat()
    {
        System.out.println("Dog.eat() called");
        chew();
        super.eat(); // super here means call the super object's eat method
    }

    private void moveLegs(int speed)
    {
        System.out.println("Dog.moveLegs() called. Dog is moving legs at speed: " + speed);
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called.");
        moveLegs(speed);
        super.move(speed);
    }

    public void walk()
    {
        System.out.println("Dog.walk() called");
        move(5);
    }

    public void run()
    {
        System.out.println("Dog.run() called");
        move(10);
    }
}
```

```java
public class Main
{
	public static void main(String[] args)
	{
		Animal animal = new Animal("Animal", 1, 1, 5, 5);

        Dog dog = new Dog("Yorkie", 1, 1, 8, 20, 2, 4, 1, 20, "long silky");
		dog.eat();
	}
}
/*
Output:

Dog.eat() called
Dog.chew() called
Animal.eat() called

*/
```

As you can see from the above output, calling the Dog.eat() method prints a message, calls Dog.chew(), and then calls the super class's (Animal's) eat() method

Here is another class that could also inherit from Animal:

```java
public class Fish extends Animal
{
    private int gills;
    private int eyes;
    private int fins;

    public Fish(String name, int size, int weight, int gills, int eyes, int fins)
    {
        super(name, 1, 1, size, weight);
        this.gills = gills;
        this.eyes = eyes;
        this.fins = fins;
    }

    private void rest()
    {
        System.out.println("Fish.rest() called.");
    }

    private void moveMuscles()
    {
        System.out.println("Fish.moveMuscles() called.");
    }

    private void moveBackFin()
    {
        System.out.println("Fish.moveBackfin() called.");
    }

    private void swim(int speed)
    {
        moveMuscles();
        moveBackFin();
        super.move(speed);
    }
}
```

This Fish class is an example of another subclass you could make that inherits from the Animal class

***

### Inheritance Challenge Problem

```java
public class Main
{
    public static void main(String[] args)
    {
        Outlander outlander = new Outlander(36);
        outlander.steer(45);
        outlander.accelerate(30);
        outlander.accelerate(20);
    }
}
```

```java
public class Vehicle
{
    private String name;
    private String size;

    private int currentVelocity;
    private int currentDirection;

    public Vehicle(String name, String size)
    {
        this.name = name;
        this.size = size;

        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    public void steer(int direction)
    {
        this.currentDirection += direction;
        System.out.println("Vehicle.steer() called");
    }

    public void move(int velocity, int direction)
    {
        currentVelocity = velocity;
        currentDirection = direction;
        System.out.println("Vehicle.move() called. Moving at velocity " + velocity + ", direction " + direction);
    }

    public void stop()
    {
        this.currentVelocity = 0;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }
}
```

```java
public class Car extends Vehicle
{
    private int wheels;
    private int doors;
    private int gears;
    private boolean isManual;

    private int currentGear;

    public Car(String name, String size, int wheels, int doors, int gears, boolean isManual)
    {
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void changeGear(int currentGear)
    {
        this.currentGear = currentGear;
        System.out.println("Car.setCurrentGear() called. Changed to: " + this.currentGear + " gear.");
    }

    public void changeVelocity(int speed, int direction)
    {
        move(speed, direction);
        System.out.println("Car.changeVelocity(): Velocity = " + this.getCurrentVelocity() + ", Direction = " + this.getCurrentDirection());
    }
}
```

```java
public class Outlander extends Car
{
    private int roadServiceMonth;

    public Outlander(int roadServiceMonth) {
        super("Outlander", "4WD", 5, 5, 6, false);
        this.roadServiceMonth = roadServiceMonth;
    }

    public void accelerate(int rate)
    {
        int newVelocity = getCurrentVelocity() + rate;
        if(newVelocity == 0)
        {
            stop();
            changeGear(1);
        }
        else if(newVelocity > 0 && newVelocity <= 10)
        {
            changeGear(1);
        }
        else if(newVelocity > 10 && newVelocity <=20)
        {
            changeGear(2);
        }
        else if(newVelocity > 20 && newVelocity <=30)
        {
            changeGear(3);
        }
        else
        {
            changeGear(4);
        }

        if(newVelocity > 0)
        {
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }
}
```

In the challenge problem you can see how inheritance works with a super class (Vehicle), a sub class (Car), and a sub of a sub class (Outlander)
