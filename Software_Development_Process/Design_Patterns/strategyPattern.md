The Strategy Pattern provides a way to configure a class with one of many behaviors

More precisely, this pattern allows us to define a family of algorithms, ecapsulating them in separate classes so that each algorthim has a class and making these classes interchangable by providing a common interface for all the encapsulated algorithms

***

###Intent

Allows for switching between different algorithms for accomplishing a task, for example if you had many different sorting algorithms this design pattern would make them all available so you could use the most ideal algorithm for each situation

***

###Applicability

This pattern is applicable when we have different varients of an algorithm, like in sorting you have mergesort, quicksort, and a few others

This pattern is also useful when we have many related classes that only differ in their behavior

***

##Structure

###Context

The context is the interface to the outside world, it maintains reference to the current algorithm (defined as one of the Concrete Strategies) and allows for updating the references at runtime

The outside world will invoke the functionality provided by the different algorithms by using the contextInterface

Depending on which algorithm is currently selected, that is the one that will be executed when the functionality is invoked

-

###Algorithm (Also called the Strategy):

Defines the common interface for the different algorithms

-

###Concrete Strategy:

The Concrete Strategy contains the actual implementation of the algorithm

There can be many Concrete Strategies each defined in their own separate class with their own algorithm implementation's

These algorithms in the Concrete Strategies implement the interface in the Algorithms class

***

Example:

```java
package patterns.strategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

//Algorithm interface
interface CheckStrategy {
    public boolean check(String s);
}

//Algorithm instances
class All implements CheckStrategy {
    @Override
    public boolean check(String s) {
        return true;
    }
}

class StartWithT implements CheckStrategy {
    @Override
    public boolean check(String s) {
        if( s == null || s.length() == 0) {
            return false;
        }
        return s.charAt(0) == 't';
    }
}

class LongerThan5 implements CheckStrategy {
    @Override
    public boolean check(String s) {
        if(s == null) {
            return false;
        }
        return s.length() > 5;
    }
}

class Palindrome implements CheckStrategy {
    @Override
    public boolean check(String s) {
        if(s == null) {
            return false;
        }
        int length = s.length();
        if(length < 2) {
            return true;
        }
        int half = length/2;
        for(int i = 0; i < half; ++i) {
            if(s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

class Context {
    private CheckStrategy strategy;

    public Context() {
        this.strategy = new All();
    }

    public void changeStrategy(CheckStrategy strategy) {
        this.strategy = strategy;
    }

    public void filter(String filename) throws IOException {
        BufferedReader infile = new BufferedReader(new FileReader(filename));
        String buffer = null;
        while((buffer = infile.readLine()) != null) {
            StringTokenizer words = new StringTokenizer(buffer);
            while( words.hasMoreTokens() ) {
                String word = words.nextToken();
                if (strategy.check(word)) {
                    System.out.println(word);
                }
            }
        }
    }
}

public class StrategyPattern {

    public static void main(String[] args) throws IOException {
        Context context = new Context();
        String filename = "foo.txt";

        System.out.println("\n* Default:");
        context.filter(filename);

        System.out.println("\n* Longer than 5:");
        context.changeStrategy(new LongerThan5());
        context.filter(filename);

        System.out.println("\n*Palindromes:");
        context.changeStrategy(new Palindrome());
        context.filter(filename);
    }
}

// In the context we declare the CheckStrategy to keep a refference to the current concrete strategy

// Setting the strategy to the All() strategy by default allows our program to accept all input

// The changeStrategy method allows us to change strategy during the runtime of our program

// Our main method creates the context

// It will perform the filtering using all of different filters

// The Algorithm class gives us an interface for the algorithms defined in the Concrete Strategies and
// allows us to change the algorithms freely without ever needing to change classes
```
