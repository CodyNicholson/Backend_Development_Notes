# Constructors

A constructor is written like a method of the class but must have the same name as the class

Its purpose is to create all of the instance variables your program needs and to run all of the methods that your class may need to run as soon as an object is created

```java
public Car(double mpg) - does not need return type
{
    milesDriven = 0; - instance var
    gasInTank = 0; - instance var
    milesPerGallon = mpg; - passed through, instance var
}

Car1 smartCar = new Car(60);
Car2 hummer = new Car(5);
```

-

You can have two methods named the same thing as long as they have a different number of parameters to pass through

Ex:

```java
printMessage("Hello");
//This line of code will run the code in the first printMessage method and never run the second printMessage code

printMessage("Hello", 3);
//This line of code will run the code in the second printMessage method and never run the first printMessage code

public void printMessage(String msg)
{
    System.out.println(msg);
}

public void printMessage(String msg, int n)
{
    for (int i = 0; i < n; i++)
    {
        System.out.println(msg);
    }
}
```
