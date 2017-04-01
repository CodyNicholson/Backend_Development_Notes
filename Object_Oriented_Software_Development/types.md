# Types

- Runtime type (The type of the reference to the object on the heap)
- Compile time type (Left side, declared type)

___

### Subtypes
-

- A subtype is a type that extends another type
- Even though it’s “extending”, a subtype could have less functionality than the parent (private methods)
- Objects can be subtypes of more than one type (e.g. Integer is a subtype of both Object and Comparable)
- Subtyping is Transitive (if A : B and B : C, then A : C)

-

When assigning an object to a reference, the left side will always be less specific or as specific as the right side

```java
/*Valid:*/ Integer i = new Integer(2);
/*Valid:*/ Object o = i;
/*Invalid:*/ i = o;
```

-

When calling a method, you can pass in the requested type as an argument or a more specific type (contravariance). The return type will be as specific or less specific than the type of the objects being returned (covariance)

```java
public static void main(String[] args) throws Exception
{
    Integer i = new Integer(2);
    Execption ex = getException(i);
    throw ex;
}

public static Exception getException(Object o)
{
    if(o.hashCode() > 5)
        return new IOException();
    else
        return new IndexOutOfBoundsException();
}
```

***

### Late Binding
-

The actual method being called is determined at Runtime, based on the object’s actual type (not the type of the reference)

___

### Casting
-

- Casting: changing the declared type of an object (does not change the actual object in memory itself)
- Downcasting: casting from supertype to subtype
- Upcasting: casting from subtype to supertype

-

#### Casting - Compile-time and Run-time checks

In Java, the compiler will check to see if a given cast is potentially valid
It will check if the type you’re trying to cast to is a supertype or subtype of the type you’re trying to cast from
Run-time will also perform the same check – why?

```java
public class Main {
  public static void main (String[] args) {
    String str = "Hello World";
    int i = (int)str;
    System.out.println(i);
  }
}
```

___

### Type Coercion
-

- Coercion: similar in concept (and syntax) to Casting
- Changes the actual type of the object, as opposed to casting which changes just the pointer’s declared type and not the object’s actual type

```java
public class Main {
  public static void main (String[] args) {
    float f = 2.5f;
    int i = (int)f;
    f = i;
    System.out.println(f);
  }
}
```

***

#### StringBuilder objects are mutable, String objects are immutable
