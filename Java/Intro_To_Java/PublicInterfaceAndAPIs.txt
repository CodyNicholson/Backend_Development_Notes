Ig you wanted to create a social network program, you should probably have a PublicInterface Class (To define all the things that the social network users can do) with a method to add other people to your network. Lets call that method addFriend();


API description/Public Interface for addFriend(); method:

public void addFriend(Person friend);


Calling this method would look like:

John.addFriend(Maria);


API description/Public Interface for removeFriend():

public void removeFriend(Person friend);


Calling this method:

John.removeFriend(Maria);



Public interface for Car Class:

public void addGas(double amount)
public void drive(double distance)
public double getMilesDriven()
public double getGasInTank()