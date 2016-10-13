#When to Refactor Bad Smells

Refactoring is applied when something does not look or feel right in the code, this is called a Bad Smell

Bad Smells are symptoms of a program that might indicate deeper problems

Bad Smells are usually not bugs that prevent the program from running, they indicate weaknesses in the design of the system that might cause problems during maintenance

***

###List of very common Bad Smells:

Duplicated code, long method, large class,

long parameter list, divergent change,

shotgun surgery, feature envy, data clumps,

primitive obsession, switch statements,

parallel interface hierarchy, lazy class,

speculative generality, temporary field,

message chains, middle man, inappropriate library class,

data class, refused requests

***

####Examples:

Duplicated code problems can be resolved using the extract method refactoring technique to make a single method for the duplicated code and place calls to that method where the duplicated code was found

-

Long method problems can be resolved by using the decompose conditional and extract method techniques to shorten conditional statements and make methods to replace long confusing sections of code

-

Large class problems can be resolved by using the extract class or subclass techniques to divide up the single classes functionality to subclasses

-

Shotgun surgety happends when you make one change to the system that results in you having to make small little changes in a lot of other places in the code. This can be a symptom of functionality being spread too thin among many different classes, too much coupling. To fix this we can use the move field/method and inline class refactoring techniques to bring the related pieces of functionality together

-

Feature Envy refers to a method that seems more interested in a class other than the one it belongs to. Maybe it is using a lot of public fields from another class and/or is calling a lot of methods of the other class. In this case we can use the extract and move method refactoring techniques to take the method out of the class it does not belong in and into the class it does. This decreases coupling, which is great for the system.
