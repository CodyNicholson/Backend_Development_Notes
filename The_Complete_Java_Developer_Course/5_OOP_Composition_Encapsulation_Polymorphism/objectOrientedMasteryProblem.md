#Object Oriented Mastery Problem

This application uses all the skills I learned in the OOP section of this class

```java
public class Main
{
    public static void main(String[] args)
    {
        Hamburger hamburger = new Hamburger("Basic", "Sausage", 3.56, "White");
        double price = hamburger.itemizeHamburger();
        hamburger.addHamburgerAddition1("Tomato", 0.27);
        hamburger.addHamburgerAddition2("Lettuce", 0.75);
        hamburger.addHamburgerAddition3("Cheese", 2.13);
        hamburger.itemizeHamburger();

        HealthyBurger hb = new HealthyBurger("Bacon", 5.67);
        hb.addHealthyAddition1("Egg", 5.43);
        hb.addHealthyAddition2("Lentils", 3.41);
        hb.itemizeHamburger();

        DeluxeBurger db = new DeluxeBurger();
        db.addHamburgerAddition1("Should not be able to do this", 600.0);
        db.itemizeHamburger();
    }
}
```

```java
public class Hamburger
{
    private String name;
    private String meat;
    private double price;
    private String breadRollType;

    private String addition1Name;
    private double addition1Price;

    private String addition2Name;
    private double addition2Price;

    private String addition3Name;
    private double addition3Price;

    private String addition4Name;
    private double addition4Price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
    }

    public void addHamburgerAddition1(String name, double price)
    {
        this.addition1Name = name;
        this.addition1Price = price;
    }

    public void addHamburgerAddition2(String name, double price)
    {
        this.addition2Name = name;
        this.addition2Price = price;
    }

    public void addHamburgerAddition3(String name, double price)
    {
        this.addition3Name = name;
        this.addition3Price = price;
    }

    public void addHamburgerAddition4(String name, double price)
    {
        this.addition4Name = name;
        this.addition4Price = price;
    }

    public double itemizeHamburger()
    {
        double hamburgerPrice = this.price;
        System.out.println("A " + this.name + " hamburger with " + this.meat + " on a " + this.breadRollType + " roll costs " + this.price + " without additions");
        if(this.addition1Name != null)
        {
            hamburgerPrice += this.addition1Price;
            System.out.println("Added " + this.addition1Name + " for an extra " + this.addition1Price);
        }
        if(this.addition2Name != null)
        {
            hamburgerPrice += this.addition2Price;
            System.out.println("Added " + this.addition2Name + " for an extra " + this.addition2Price);
        }
        if(this.addition3Name != null)
        {
            hamburgerPrice += this.addition3Price;
            System.out.println("Added " + this.addition3Name + " for an extra " + this.addition3Price);
        }
        if(this.addition4Name != null)
        {
            hamburgerPrice += this.addition4Price;
            System.out.println("Added " + this.addition4Name + " for an extra " + this.addition4Price);
        }
        System.out.println("Your hamburger's total cost is: " + hamburgerPrice);
        return hamburgerPrice;
    }
}
```

```java
public class HealthyBurger extends Hamburger
{
    private String healthyBurgerExtra1Name;
    private double healthyBurgerExtra1Price;

    private String healthyBurgerExtra2Name;
    private double healthyBurgerExtra2Price;

    public HealthyBurger(String meat, double price)
    {
        super("Healthy", meat, price, "Brownrye");
    }

    public void addHealthyAddition1(String name, double price)
    {
        this.healthyBurgerExtra1Name = name;
        this.healthyBurgerExtra1Price = price;
    }

    public void addHealthyAddition2(String name, double price)
    {
        this.healthyBurgerExtra2Name = name;
        this.healthyBurgerExtra2Price = price;
    }

    @Override
    public double itemizeHamburger() {
        double hamburgerPrice = super.itemizeHamburger();
        if(this.healthyBurgerExtra1Name != null)
        {
            hamburgerPrice += this.healthyBurgerExtra1Price;
            System.out.println("Adding the " + this.healthyBurgerExtra1Name + " costs " + healthyBurgerExtra1Price +
                    " and brings the total price to " + hamburgerPrice);
        }
        if(this.healthyBurgerExtra2Name != null)
        {
            hamburgerPrice += this.healthyBurgerExtra2Price;
            System.out.println("Adding the " + this.healthyBurgerExtra2Name + " costs " + healthyBurgerExtra2Price +
                    " and brings the total price to " + hamburgerPrice);
        }
        System.out.println("Total hamburger price is now: " + hamburgerPrice);
        return hamburgerPrice;
    }
}
```

```java
public class DeluxeBurger extends Hamburger
{
    public DeluxeBurger() {
        super("Deluxe", "Sausage & Bacon", 14.54, "White");
        super.addHamburgerAddition1("Chips", 2.75);
        super.addHamburgerAddition2("Drink", 1.81);
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Cannot add additional items to Deluxe Burger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("Cannot add additional items to Deluxe Burger");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("Cannot add additional items to Deluxe Burger");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("Cannot add additional items to Deluxe Burger");
    }
}
```