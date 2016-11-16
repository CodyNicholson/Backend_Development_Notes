#Iterator Design Pattern

This is the iterator pattern, you have an interface with a HasNext() and Next() method

The concrete collection creates the iterator (we can use the factory method pattern to force the collection create the iterator)

The client interacts with the Iterator interface and the collection interface
