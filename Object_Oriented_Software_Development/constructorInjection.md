#Constructor Injection

Pass dependencies to an object via the Constructor (notice the guard clause to ensure the dependency is fulfilled):

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/constructorInjection.jpg)

-

Use Constructor Injection if you want to allow the creator in the higher-level module to specify which type to use to fulfill the dependency and to force the lower level class to only use the one object

Make sure the dependency field is private and read only

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/constructorInjection2.jpg)