#Types Of Classes

###Interfaces (pure abstract class)

No method bodies, No instance fields

May not be instantiated

Must be implemented to be useful

-

###Abstract Class

Optional method bodies

May not be instantiated

Must be extended to be useful (except class methods)

-

###Concrete non-final class

Required method bodies

May be instantiated

May be extended

-

###Final Class

Required method bodies

May be instantiated

May not be extended

***

###General Rules of Thumb

Always create an interface – even on top of an abstract class

Always prefer delegation (it won’t always make sense to do so)

Both of these allow for more flexibility
