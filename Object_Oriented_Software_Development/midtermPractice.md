#Midterm Practice

###Draw a sequence diagram for the following code:

![alt tag](drawSeqDiagram.jpg)

-

###Sequence Diagram

![alt tag](seqDiagram1.jpg)

***

If there were methods that relied on title, director, and year, what are some potential issues you could foresee based on this code snippet?

![alt tag](codeSnip1.jpg)

***

###Write a unit test

We want to change this code so that if the director is null or whitespace, it throws an IllegalArgumentException

Write the unit test to test the change

![alt tag](unitTest1.jpg)

![alt tag](unitTest2.jpg)

```java
@Test
void TestConstructorTitle Throws Exception()
{
try
{
    VideoObj v = new VideoObj(null,6,"y");
    Assert fail();
}
catch(IllegalArgumentExecption){}
}

@Test
void TestConstructorYear Throws Exception()
{
try
{
    VideoObj v = new VideoObj("title",NULL,"y");
    Assert fail();
}
catch(IllegalArgumentExecption){}
}

@Test
void TestConstructorDirector Throws Exception()
{
try
{
    VideoObj v = new VideoObj("title",6,NULL);
    Assert fail();
}
catch(IllegalArgumentExecption){}
}

@Test
void TestConstructorWhiteSpaceOne Throws Exception()
{
try
{
    VideoObj v = new VideoObj(" ",6,"y");
    Assert fail();
}
catch(IllegalArgumentExecption){}
}

@Test
void TestConstructorWhiteSpaceMultiple Throws Exception()
{
try
{
    VideoObj v = new VideoObj("   ",6,"y");
    Assert fail();
}
catch(IllegalArgumentExecption){}
}
```

***

###When would you use Factory vs Builder?

Factory: When you are creating a simple, mutable object

Builder: when you are creating a complex, immutable object

***

###Composite Demo

One of the points of the Composite pattern is that the client doesn’t know the structure of the Composite object; it acts as one single object

Modify the Composite demo we did earlier to use a Builder pattern to put the Composite object together

The results should be the same as the first Composite demo

***

###State Pattern

State pattern encapsulates certain functionalities into classes, similar to Strategy

Their UML diagrams are almost the same

The differences are: States are managed inside of the class that has the state

Strategies are provided by external clients

Strategy is used to provide behavior to a class instead of subclassing

State is used as an alternative to having a bunch of if/else statements in your code

-

![alt tag](stateUML.jpg)

-

Write a Day class that will print out the day of the week of it’s internal date

The weekends should be in ALL CAPS and the weekdays should be lower case

-

Now modify the code so that the alarm will go off on weekdays and not weekends

***

###Observer Pattern

A subscribe/publish pattern

One or more objects subscribe to an object to be automatically notified when some event occurs

One common scenario is in a GUI application, multiple objects might subscribe to a button to be notified when the button is clicked

-

![alt tag](observerUML.jpg)

-

We want to add an event to the Count class so every time the count is divisible by 10, an object will print out to the console

-

Add another observer that will print out “I’m doing something” every 10 increments