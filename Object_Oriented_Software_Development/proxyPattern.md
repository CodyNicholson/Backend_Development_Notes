# Proxy Pattern

A Proxy is used to add functionality to already existing functionality/class, it acts as a wrapper

A Proxy class implements the same interface as the class it wants to act as a proxy for so it can be used in the same place without clients knowing the class with the real functionality exists/is being used

The Proxy will either create or have injected the Subject it wants to use, it knows the specific type it will receive (not the interface)
