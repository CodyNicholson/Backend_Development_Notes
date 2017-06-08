# Constructors

The class below has six fields

Rather than call "set{FieldName}" six times, we can use a constructor to set the variables when we create the object

Whenever we create an object we call that object's constructor upon creation

A class's constructor method is a method with the same name as the class that does not have a return type

You should be able to pass arguments through the constructor - the classes fields will be set to the values that you pass through

This saves us a lot of time and makes our code look better too

-

I created two constructor methods below: one where you can set all of the fields, and one where you do not need to set any of them

In the case where you do not need to set any of them they will be set to the default values I have specified using: this(), which calls the constructor *from* the constructor to set the fields

When you call the constructor from the constructor, you must put this call on the first line of your constructor - We could not print "Empty Constructor" *before* we used the this() to call the constructor in the no-arguments constructor

-

If you wanted, in the non-empty constructor you could call the setter methods instead of using "this.field = field" - this is not good practice, though

```java
public class Main
{

    public static void main(String[] args)
    {
        Account codysAccount = new Account("0123456789", 12.34, "Cody Liam", "cody@cody.com", "123456789");
        System.out.println(codysAccount.getNumber() + " " +
            codysAccount.getBalance() + " " +
            codysAccount.getCustomerName() + " " +
            codysAccount.getCustomerEmailAddress() + " " +
            codysAccount.getCustomerPhoneNumber());
            codysAccount.deposit(123456.789);
            codysAccount.withdrawal(8.0);

        VipPerson person1 = new VipPerson();

        VipPerson person2 = new VipPerson("Bob", 25000.0);

        VipPerson person3 = new VipPerson("Cody", 100.0, "cody@cody.com");
    }
}
/*
This code will print:

Account Constructor With Parameters Called
0123456789 12.34 Cody Liam cody@cody.com 123456789
Deposit of 123456.789 made. New balance is: 123469.129
Withdrawal of 8.0 processed. Remaining balance: 123461.129
*/
```

```java
public class Account
{
    private String number;
    private double balance;
    private String customerName;
    private String customerEmailAddress;
    private String customerPhoneNumber;

    public Account()
    {
        this("Default Number", 2.50, "Default Name", "Default Address", "Default Phone Number");
        System.out.println("Empty Constructor Called");
    }

    public Account(String customerName, String customerEmailAddress, String customerPhoneNumber) {
        this.customerName = customerName;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public Account(String number, double balance, String customerName, String customerEmailAddress, String customerPhoneNumber)
    {
        System.out.println("Account Constructor With Parameters Called");
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.customerEmailAddress = customerEmailAddress;
        this. customerPhoneNumber = customerPhoneNumber;
    }

    public void deposit(double depositAmount)
    {
        this.balance += depositAmount;
        System.out.println("Deposit of " + depositAmount + " made. New balance is: " + this.balance);
    }

    public void withdrawal(double withdrawalAmount)
    {
        if(this.balance - withdrawalAmount < 0)
        {
            System.out.println("Only " + this.balance + " available. Withdrawal not processed.");
        }
        else
        {
            this.balance -= withdrawalAmount;
            System.out.println("Withdrawal of " + withdrawalAmount + " processed. Remaining balance: " + this.balance);
        }
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerEmailAddress()
    {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress)
    {
        this.customerEmailAddress = customerEmailAddress;
    }

    public String getCustomerPhoneNumber()
    {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber)
    {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
```

```java
public class VipPerson
{
    private String name;
    private double creditLine;
    private String emailAddress;

    public VipPerson()
    {
        this("Default Name", 50000.0, "default@email.com");
    }

    public VipPerson(String name, double creditLine)
    {
        this.name = name;
        this.creditLine = creditLine;
    }

    public VipPerson(String name, double creditLine, String emailAddress)
    {
        this.name = name;
        this.creditLine = creditLine;
        this.emailAddress = emailAddress;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getCreditLine()
    {
        return creditLine;
    }

    public void setCreditLine(double creditLine)
    {
        this.creditLine = creditLine;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }
}
```
