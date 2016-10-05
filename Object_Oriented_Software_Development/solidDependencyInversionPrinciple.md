#SOLID: Dependency inversion principle (DIP)

Called Dependency Inversion because we are inverting the structure of the application so dependent modules are no longer dependencies – they are controlled by higher-level modules (but as abstract classes)

Tenet 2: Black box: implementation is up to the Interface/whatever is passed in. Separation of concerns

***

States:

- High-level modules should not depend on low-level modules. Both should depend on abstractions

- Abstractions should not depend on details. Details should depend on abstractions

***

###DIP Definitions
-

Abstractions: abstract classes, interfaces

Low level module: does more of the nitty-gritty; the details of the implementation

High level module: more abstract module made up of lower-level modules

***

###DIP Example
-

CreditCardProcessor and SwipeCardReader

Processor processes payments, and the card reader reads the credit card that’s passed in

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/exDIP1.jpg)

-

###DO NOTs
-

Don’t pass in the two CardReaders as an argument to different functions

This leads to code bloat and the CreditCardProcessor will need to be updated anytime there is a new Reader implemented (such as TapCardReader)

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/dontDo1.jpg)

-

Don’t pass in an enum to determine which type of Reader to call

This leads to long if/else blocks

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/dontDo2.jpg)

***

###TO DOs
-

- Update dependencies so they implement an interface or abstract class

- Pass in an interface or abstract class as a parameter to the method

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/toDo1.jpg)

***

###Following DIP requires little extra work:

Create an interface

Update both readers to implement that interface

Both readers already have the Read method implemented

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/toDo2.jpg)

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/toDo3.jpg)

***

High-level modules should not depend on low-level modules

Both should depend on abstractions

Abstractions should not depend on details

Details should depend on abstractions

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/exDIP2.jpg)

-

- Tenet 1: Processor (high-level) depends on interface; CardReader (low-level) depends on same interface

- Tenet 2: Reader implementation details left up to the specific implementation of ICardReader. Processor doesn’t care what the implementation is, or which type it is. It only cares that it can read the card.

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/exDIP3.jpg)

-

###Finding the Abstraction Example
-

Inverting the CreditCard dependency allows us to be able to accept anything that implements the ICreditCard interface, such as CreditCard Information from a mobile device

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/abstractionExample.jpg)

In addition, this change removes the dependency on CreditCard in ICardReader’s Read method

-

###What does this solve?
-

Enables ability to reuse high-level modules for different purposes

We can now reuse the ProcessPayment logic with all sorts of CardReaders and CreditCards
This logic is simple, but imagine if was more complex.

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/whatDoesThisSolve.jpg)

Reduces/Removes Transitive Dependencies (improves use of Layers)

Transitive dependency would be if Class A depends on Class B, and Class B depends on Class C, then Class A depends on Class C.
Changes to Class C would affect Class A.

***

###Transitive Dependencies
-

CreditCardSwipeReader has a dependency on CreditCardSwipeValidator

Transitively, CreditCardProcessor has dependency on CreditCardSwipeValidator

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/transDepend.jpg)

CreditCardSwipeReader has a dependency on CreditCardSwipeValidator

Transitively, CreditCardProcessor has dependency on CreditCardSwipeValidator.

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/transDepend2.jpg)

After refactoring for DIP, CreditCardProcessor only has dependency on ICardReader, changes to CreditCardSwipeReader and CreditCardSwipeValidator no longer affect CreditCardProcessor

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/transDepend3.jpg)

***

###What does this solve?
-

Improves testability

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/whatDoesThisSolve2.jpg)

You can use a TestCreditCard which implements ICreditCard, so when the card needs to be read, rather than needing to swipe it, the TestCreditCard can just say it’s been read and return data

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/testing.jpg)

The benefit of using the testCreditCard is you can isolate testing on just the Reader classes

You can use a TestCardReader when you want to test the different types of CreditCard.

***

###What issues does this solve?

This resolves Tight Coupling

Modules are heavily dependent on other modules making it difficult to reuse or make modifications to without affecting others

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/tightCoupling.jpg)

-

This also resolved Rigidity

Changing code in one place leads to many parts of the application needing to be changed

With the old code, we couldn’t just add a CreditCardChipReader, even though their functionality was very similar

Without using the DIP, we would need to make a lot of changes to the code base just to support it

-

Also solves Fragility

Changing code in one place breaks many different places

-

Immobility

Difficult to reuse code in another application

-

CreditCardSwipeReader has a dependency on CreditCardSwipeValidator

Let’s say you want to add a dependency to CreditCardEncryptionProvider

The CreditCardProcessor is now more fragile because there is an increased potential for breaking, since now changes to the EncryptionProvider affect CreditCardProcessor (via transitive dependency).

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/whatDoesThisSolve3.jpg)

If you change it to use DI, CreditCardProcessor no longer has that second transitive dependency and it’s much less fragile

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/whatDoesThisSolve4.jpg)

-

If you change it to use DI, CreditCardProcessor no longer has that second transitive dependency and it’s much less fragile

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/whatDoesThisSolve6.jpg)

-

Let’s say you want to reuse this code in another application that has its own CreditCard and CreditCardSwipeReader implementation

Because this code is so dependent on this implementation of CardReader and CreditCard, CreditCardProcessor can’t be easily reused

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/whatDoesThisSolve5.jpg)

-

Using DIP:
New classes can implement the ICardReader and ICreditCard interfaces and this module can be reused without needing any changes

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/whatDoesThisSolve7.jpg)

If the new CardReader and CreditCard implementation are in an external library, you can easily create Proxy classes that implement the interfaces