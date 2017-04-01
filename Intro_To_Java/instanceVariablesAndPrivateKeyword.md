# Instance Variables and the Private keyword

Public interface for Car class:

```java
public void addGas(double amount)
public void drive(double distance)
public double getMilesDriven()
public double getGasInTank()
```

The keyword 'private' in java means that the method or variable you declared will be unique to every instance of the class/object of the class

Private interface for unique instances of Car class:

```java
private double gasInTank;
private double milesDriven;
```

Public interface the is the same for all instances of the Car class:

```java
public void addGas(double amount)
public void drive(double distance)
public double getMilesDriven()
public double getGasInTank()
```


Declaring an instance variable for a person's name and friends:

```java
public class Person
{
    private String name;
    private String friends;
}
```
