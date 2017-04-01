# jUnit

Create a test class. (Test classes are object classes.)

Each test method is treated like a separate program.

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/junit1.jpg)

Tests are run as: Arrange, Act, Assert:

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/junit2.jpg)

***

### jUnit Tests

Each test has one of three possible outcomes:

- pass: test ended normally and no assertion failed

- fail: test ended normally at least one assertion failed

- error: uncaught exception thrown before test ended

Rules for a test class:

- class must be public

- class name must include substring “TEST” (for ant)

- class must extend junit.framework.TestCase

- constructor must accept String parameter and pass it to constructor

- non-static methods “public void test...()” are run automatically as tests

***

### jUnit Assertions

junit.framework.Assert is a static class
The basic assertion method is assertTrue which comes in two forms:

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/junit3.jpg)

If the boolean value is false, then the enclosing test will fail
In the second form, the String is printed when the assertion is false

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/junit4.jpg)

If there are multiple assertions in a single test, then the enclosing test fails if any assertion is false

-

#### jUnit Derived Assertions

![alt tag](https://github.com/Cody-Nicholson96/Software_Development/blob/master/Object_Oriented_Software_Development/pics/junit4.jpg)
