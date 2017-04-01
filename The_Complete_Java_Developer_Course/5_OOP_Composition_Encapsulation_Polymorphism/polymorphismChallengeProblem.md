# Polymorphism Challenge

```java
public class Main
{
    public static void main(String[] args)
    {
        Car car = new Car(8, "Base car");
        car.startEngine();
        car.accelerate();
        car.brake();

        Mitsubishi mit = new Mitsubishi(8, "Outlander");
        mit.startEngine();
        mit.accelerate();
        mit.brake();

        Ford ford = new Ford(8, "Falcon");
        ford.startEngine();
        ford.accelerate();
        ford.brake();

        Holden holden = new Holden(8, "Falcon");
        holden.startEngine();
        holden.accelerate();
        holden.brake();
    }
/*
    Output:
    
    Car -> startEngine()
    Car -> accelerate()
    Car -> brake()
    Mitsubishi -> startEngine()
    Mitsubishi -> accelerate()
    Mitsubishi -> brake()
    Ford -> startEngine()
    Ford -> accelerate()
    Ford -> brake()
    Holden -> startEngine()
    Holden -> accelerate()
    Holden -> brake()
*/
}

class Car
{
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.engine = true;
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine()
    {
        System.out.println(getClass().getSimpleName() + " -> startEngine()");
        return getClass().getSimpleName() + " -> startEngine()";
    }

    public String accelerate()
    {
        System.out.println(getClass().getSimpleName() + " -> accelerate()");
        return getClass().getSimpleName() + " -> accelerate()";
    }

    public String brake()
    {
        System.out.println(getClass().getSimpleName() + " -> brake()");
        return getClass().getSimpleName() + " -> brake()";
    }
}

class Mitsubishi extends Car
{
    public Mitsubishi(int cylinders, String name)
    {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        System.out.println(getClass().getSimpleName() + " -> startEngine()");
        return getClass().getSimpleName() + " -> startEngine()";
    }

    @Override
    public String accelerate() {
        System.out.println(getClass().getSimpleName() + " -> accelerate()");
        return getClass().getSimpleName() + " -> accelerate()";
    }

    @Override
    public String brake() {
        System.out.println(getClass().getSimpleName() + " -> brake()");
        return getClass().getSimpleName() + " -> brake()";
    }
}

class Ford extends Car
{
    public Ford(int cylinders, String name)
    {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        System.out.println(getClass().getSimpleName() + " -> startEngine()");
        return getClass().getSimpleName() + " -> startEngine()";
    }

    @Override
    public String accelerate() {
        System.out.println(getClass().getSimpleName() + " -> accelerate()");
        return getClass().getSimpleName() + " -> accelerate()";
    }

    @Override
    public String brake() {
        System.out.println(getClass().getSimpleName() + " -> brake()");
        return getClass().getSimpleName() + " -> brake()";
    }
}

class Holden extends Car
{
    public Holden(int cylinders, String name)
    {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        System.out.println(getClass().getSimpleName() + " -> startEngine()");
        return getClass().getSimpleName() + " -> startEngine()";
    }

    @Override
    public String accelerate() {
        System.out.println(getClass().getSimpleName() + " -> accelerate()");
        return getClass().getSimpleName() + " -> accelerate()";
    }

    @Override
    public String brake() {
        System.out.println(getClass().getSimpleName() + " -> brake()");
        return getClass().getSimpleName() + " -> brake()";
    }
}
```
