#Public Interface and APIs

If you wanted to create a social network program, you should probably have a PublicInterface Class (To define all the things that the social network users can do) with a method to add other people to your network. Lets call that method addFriend();

***

###API description/Public Interface for addFriend() method:

```java
public void addFriend(Person friend);
```

-

###Calling this method would look like:

```java
John.addFriend(Maria);
```

-

###API description/Public Interface for removeFriend():

```java
public void removeFriend(Person friend);
```

-

###Calling this method:

```java
John.removeFriend(Maria);
```

-

###Public interface for Car Class:

```java
public void addGas(double amount)
public void drive(double distance)
public double getMilesDriven()
public double getGasInTank()
```
