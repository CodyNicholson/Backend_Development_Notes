#Design Patterns

- Elements of software design that are reusable
- Provide a common vocabulary for software designers
- Way of laying out your code/classes that make it easier to maintain/use
- Patterns because there is no single use of that design – it’s an abstraction
- Not language specific

___

###Gang of four design principles
-

-Program to an interface, not an implementation
-Favor object composition (delegation) over class inheritance
-Consider what should be variable in your design: encapsulate the concepts that vary

___

###Factory
-

Factory is an object that makes other objects

-

####Static factory classes

- What if I want to hide class names from clients?
- This could be because class names are still changing or even just because clients don’t need to know (principle of least knowledge)
- Use a static factory

-

####Steps:

- Make interface public
- Make classes package-private
- Provide a public static* class (the factory) which will do the actual creation of the objects

-

- Other packages use the static factory methods, not the constructors of the objects
- Factory methods can take in parameters to pass along to the object’s constructors or to initialize the object

___

###Strategy Pattern
-

- Strategy object provides a consumer with information about what it needs to do
- Producer also wants to choose what to run and when
- Encapsulates behavior

___

###Command pattern
-

Very similar to Strategy pattern, but the producer doesn’t care what it does