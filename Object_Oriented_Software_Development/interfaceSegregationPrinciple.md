# Interface Segregation Principle

Clients should not be forced to depend upon interfaces that they do not use

Separate clients mean separate interfaces

Do not add dependencies to a single class – consumers will now have dependencies to all the classes instead of the single one

-

Problem with class stacking in this example:

    Subclasses of door – whether they’re timed or not – will need to provide a default implementation of TimerClient.Timeout()

    Or the door can implement this. However, this creates interface pollution (implementing this interface for the sake of one subclass) and leads to fat interfaces (when other functionality is added to TimerClient, the Door interface will need to be updated further to provide implementations for it)

-

If we change the interface for TimerClient, we will also need to update the Door – why should Door (and its subtypes) be dependent on functionality that it doesn’t even care about? This significantly increases time for changes related to the TimerClient and increases the possibility of something else breaking somewhere

-

### Interface segregation principle – why use it?

Prevent code-bloat.

Prevent violation of LSP (via implementing default implementations that do nothing in the base class).

Prevent Rigidity/Fragility in the code – based on the example, you would need to update the Door class and all its subclasses if a change to the interface were made. Changes to the abstract interface (or even to something that consumes door) can cause bugs in completely unrelated modules

In addition, you are preventing recompiles. If recompiles are lengthy, engineers might start putting code in the wrong places to reduce compile time.

Prevent coupling – fat interfaces create inadvertent couplings between clients that ought otherwise to be isolated.

-

Example:

```java
abstract class Door{
    public void lock() {}
    public void unlock() {}
    public boolean isDoorOpen() { return false; }
}

class Timer{
    public void register(int timeout, TimerClient client);
}

interface class TimerClient{
    void Timeout();
}

class TimedDoor {
    //TODO
}
```
