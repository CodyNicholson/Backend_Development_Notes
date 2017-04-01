# MVC

Stands for Model, View, and Controller

Model: Data model (DTOs and related classes)

View: The UI

Controller: Communicates between the data model and the UI.

-

Notice that View and Model modules never talk directly to each other

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/mvc1.jpg)

Think about Homework 3 and the Control class

This is the “controller” in our program

How many UIs did the program support?

What changes to the Control class and the Data package (the Controller and Model modules) do we need to make to support more UIs?

Because the “controller” logic is in this one class and this class depends on abstractions, we can add any number of UIs, as long as they implement those abstractions
