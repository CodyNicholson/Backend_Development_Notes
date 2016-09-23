#Obey the General Contract when Overriding Equals

There are many ways to incorrectly override the Equals method

The easiest way to avoid problems is to avoid overriding the equals method, in which case each instance is equal only to itself

If that is not idel, then this is the right thing to do if any of the following conditions apply:

***

###Each instance of the class is inherently unique
-

This is true for classes that represent active entities rather than values, such as Thread

The equals implementation provided by Object has exactly the right behavior for these classes

***

###You don’t care whether the class provides a “logical equality” test
-

For example, java.util.Random could have overridden equals to check whether two Random instances would produce the same sequence of random numbers going forward, but the designers didn’t think that clients would need or want this functionality

Under these circumstances, the equals implementation inherited from Object is adequate

***

###A superclass has already overridden equals, and the behavior inherited from the superclass is appropriate for this class
-

For example, most Set implementations inherit their equals implementation from AbstractSet, List implementations from AbstractList, and Map implementations from AbstractMap

***

###The class is private or package-private, and you are certain that its equals method will never be invoked
-

Arguably, the equals method should be overridden under these circumstances, in case it is accidentally invoked someday:

```java
public boolean equals(Object o)
{
throw new UnsupportedOperationException();
}
```

***

###So when is it appropriate to override Object.equals?

When a class has a notion of logical equality that differs from mere object identity, and a superclass has not already overridden equals to implement the desired behavior

-

This is generally the case for value classes, such as Integer or Date

A programmer who compares references to value objects using the equals method expects to find out whether they are logically equivalent, not whether they refer to the same object

Not only is overriding the equals method necessary to satisfy programmer expectations, it enables instances of the class to serve as map keys or set elements with predictable, desirable behavior

***

###When you override the equals method, you must adhere to its general contract

Here is the contract, copied from the specification for java.lang.Object:

The equals method implements an equivalence relation:

- n It is reflexive: For any reference value x, x.equals(x) must return true
- n It is symmetric: For any reference values x and y, x.equals(y) must return
- true if and only if y.equals(x) returns true
- n It is transitive: For any reference values x, y, and z, if x.equals(y) returns
- true and y.equals(z) returns true, then x.equals(z) must return true
- n It is consistent: For any reference values x and y, multiple invocations of
- x.equals(y) consistently return true or consistently return false, provided
- no information used in equals comparisons on the object is modified
- n For any non-null reference value x, x.equals(null) must return false

-

Unless you are mathematically inclined, this might look a bit scary, but do not
ignore it!

If you violate it, you may well find that your program behaves erratically
or crashes, and it can be very difficult to pin down the source of the failure

No class is an island, instances of one class are frequently passed to another

Many classes, including all collections classes, depend on the objects passed to them obeying the equals contract

***

###Reflexivity
-

The first requirement of the equals contract says merely that an object must be equal to itself

If you were to violate it and then add an instance of your class to a collection, the collection’s contains method would almost certainly say that the collection did not contain the instance that you just added

***

###Symmetry
-

The second requirement of the equals contract says that any two objects must agree on whether they are equal

For example, consider the following class:

```java
/**
* Case-insensitive string. Case of the original string is
* preserved by toString, but ignored in comparisons.
*/
public final class CaseInsensitiveString
{
	private String s;
	public CaseInsensitiveString(String s)
	{
		if (s == null)
			throw new NullPointerException();
		this.s = s;
	}
	// Broken - violates symmetry!
	public boolean equals(Object o)
	{
		if (o instanceof CaseInsensitiveString)
			return s.equalsIgnoreCase(((CaseInsensitiveString)o).s);
		if (o instanceof String) // One-way interoperability!
			return s.equalsIgnoreCase((String)o);
		return false;
	}
}
```

The well-intentioned equals method in this class naively attempts to interoperate with ordinary strings

Let’s suppose that we have one case-sensitive string and one ordinary one:

CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
String s = "polish";

As expected, cis.equals(s) returns true

The problem is that while the equals method in CaseInsensitiveString knows about ordinary strings, the equals method in String is oblivious to case-insensitive strings

Therefore s.equals(cis) returns false, a clear violation of symmetry

Suppose you put a case-insensitive string into a collection:

```java
List list = new ArrayList();
list.add(cis);
```

What does list.contains(s) return at this point? Who knows?

In Sun’s current implementation, it happens to return false, but that’s just an implementation artifact

In another implementation, it could just as easily return true or throw a run-time exception

Once you’ve violated the equals contract, you simply don’t know how other objects will behave when confronted with your object

-

To eliminate the problem, merely remove the ill-conceived attempt to interoperate
with String from the equals method

Once you do this, you can refactor the method to give it a single return:

```java
public boolean equals(Object o)
{
	return o instanceof CaseInsensitiveString && ((CaseInsensitiveString)o).s.equalsIgnoreCase(s);
}
```

***

###Transitivity
-

The third requirement of the equals contract says that if one object is equal to a second and the second object is equal to a third, then the first object must be equal to the third

Consider the case of a programmer who creates a subclass that adds a new aspect to its superclass

In other words, the subclass adds a piece of information that affects equals comparisons

Let’s start with a simple immutable two-dimensional point class:

```java
public class Point
{
	private final int x;
	private final int y;
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public boolean equals(Object o)
	{
		if (!(o instanceof Point))
			return false;
		Point p = (Point)o;
		return p.x == x && p.y == y;
	}
... // Remainder omitted
}
```

Suppose you want to extend this class, adding the notion of color to a point:

```java
public class ColorPoint extends Point
{
	private Color color;
	public ColorPoint(int x, int y, Color color)
	{
		super(x, y);
		this.color = color;
	}
... // Remainder omitted
}
```

How should the equals method look?

If you leave it out entirely, the implementation is inherited from Point, and color information is ignored in equals comparisons

While this does not violate the equals contract, it is clearly unacceptable

Suppose you write an equals method that returns true only if its argument is another color point with the same position and color:

```java
// Broken - violates symmetry!
public boolean equals(Object o)
{
	if (!(o instanceof ColorPoint))
		return false;
	ColorPoint cp = (ColorPoint)o;
	return super.equals(o) && cp.color == color;
}
```

The problem with this method is that you might get different results when comparing a point to a color point and vice versa

The former comparison ignores color, while the latter comparison always returns false because the type of the argument is incorrect

To make this concrete, let’s create one point and one color point:

```java
Point p = new Point(1, 2);
ColorPoint cp = new ColorPoint(1, 2, Color.RED);
```

Then p.equals(cp) returns true, while cp.equals(p) returns false

You might try to fix the problem by having ColorPoint.equals ignore color when doing “mixed comparisons”:

```java
// Broken - violates transitivity.
public boolean equals(Object o)
{
	if (!(o instanceof Point))
		return false;
	// If o is a normal Point, do a color-blind comparison
	if (!(o instanceof ColorPoint))
		return o.equals(this);
	// o is a ColorPoint; do a full comparison
	ColorPoint cp = (ColorPoint)o;
	return super.equals(o) && cp.color == color;
}
```

This approach does provide symmetry, but at the expense of transitivity:

ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
Point p2 = new Point(1, 2);
ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);

At this point, p1.equals(p2) and p2.equals(p3) return true, while p1.equals(p3) returns false, a clear violation of transitivity

The first two comparisons are “color-blind,” while the third takes color into account

So what’s the solution? It turns out that this is a fundamental problem of equivalence relations in object-oriented languages

There is simply no way to extend an instantiable class and add an aspect while preserving the equals contract, there is a workaround

“Favor composition over inheritance.”

Instead of having ColorPoint extend Point, give ColorPoint a private Point field and a public view method (Item 4) that returns the point at the same position as this color point:

```java
// Adds an aspect without violating the equals contract
public class ColorPoint
{
	private Point point;
	private Color color;

	public ColorPoint(int x, int y, Color color) {
		point = new Point(x, y);
		this.color = color;
	}
	/**
	* Returns the point-view of this color point.
	*/
	public Point asPoint() {
		return point;
	}
	public boolean equals(Object o) {
		if (!(o instanceof ColorPoint))
			return false;
		ColorPoint cp = (ColorPoint)o;
		return cp.point.equals(point) && cp.color.equals(color);
	}
	... // Remainder omitted
}
```

***

###Consistency
-

The fourth requirement of the equals contract says that if two objects are equal, they must remain equal for all time, unless one (or both) of them is modified

This isn’t so much a true requirement as a reminder that mutable objects can be equal to different objects at different times while immutable objects can’t

When you write a class, think hard about whether it should be immutable

If you conclude that it should, make sure that your equals method enforces the restriction that equal objects remain equal and unequal objects remain unequal for all time

***

###“Non-nullity”
-

The final requirement, which in the absence of a name I have taken the liberty of calling “non-nullity,” says that all objects must be unequal to null

While it is hard to imagine accidentally returning true in response to the invocation o.equals(null), it isn’t hard to imagine accidentally throwing a NullPointerException

The general contract does not allow this

Many classes have equals methods that guard against it with an explicit test for null:

```java
public boolean equals(Object o)
{
	if (o == null)
		return false;
	...
}
```

This test is not necessary

To test its argument for equality, the equals method must first cast the argument to an appropriate type so its accessors may be invoked or its fields accessed

Before doing the cast, the method must use the instanceof operator to check that its argument is of the correct type:

```java
public boolean equals(Object o)
{
	if (!(o instanceof MyType))
		return false;
	...
}
```

If this type check were missing and the equals method were passed an argument of the wrong type, the equals method would throw a ClassCastException, which violates the equals contract

But the instanceof operator is specified to return false if its first operand is null, regardless of what type appears in the second operand

Therefore the type check will return false if null is passed in, so you don’t need a separate null check

Putting it all together, here’s a recipe for a high-quality equals method:

	1. Use the == operator to check if the argument is a reference to this object.
    If so, return true. This is just a performance optimization, but one that is worth
    doing if the comparison is potentially expensive.

	2. Use the instanceof operator to check if the argument is of the correct type.
    If not, return false. Typically, the correct type is the class in which the method occurs.
    Occasionally, it is some interface implemented by this class. Use an interface if the
    class implements an interface that refines the equals contract to permit comparisons
    across classes that implement the interface. The collection interfaces Set, List, Map,
    and Map.Entry have this property.

	3. Cast the argument to the correct type. Because this cast was preceded by an instanceof
    test, it is guaranteed to succeed.

	4. For each “significant” field in the class, check to see if that field of the
    argument matches the corresponding field of this object. If all these tests succeed,
    return true; otherwise, return false. If the type in Step 2 is an interface, you must
    access the argument’s significant fields via interface methods; if the type is a class,
    you may be able to access the fields directly, depending on their accessibility. For
    primitive fields whose type is not float or double, use the == operator for comparisons;
    for object reference fields, invoke the equals method recursively; for float fields,
    translate to int values using Float.floatToIntBits and compare the int values using
    the == operator; for double fields, translate to long values using Double.doubleToLongBits
    and compare the long values using the == operator. (The special treatment of float and
    double fields is made necessary by the existence of Float.NaN, -0.0f, and the analogous
    double constants; see the Float.equals documentation for details.) For array fields, apply
    these guidelines to each element. Some object reference fields may legitimately contain
    null. To avoid the possibility of a NullPointerException, use the following idiom to
    compare such fields:

	(field == null ? o.field == null : field.equals(o.field))

	This alternative may be faster if field and o.field are often identical object references:

	(field == o.field || (field != null && field.equals(o.field)))

	For some classes, like CaseInsensitiveString shown earlier, the field comparisons
    are more complex than simple equality tests. It should be apparent from the
    specification for a class if this is the case. If so, you may want to store a canonical
    form in each object, so that the equals method can do cheap exact comparisons on these
    canonical forms rather than more costly inexact comparisons. This technique is most
    appropriate for immutable classes (Item 13), as the canonical form would have to be kept
    up to date if the object could change. The performance of the equals method may be
    affected by the order in which fields are compared. For best performance, you should
    first compare fields that are more likely to differ, less expensive to compare, or,
    ideally, both. You must not compare fields that are not part of an object’s logical
    state, such as Object fields used to synchronize operations. You need not compare
    redundant fields, which can be calculated from “significant fields,” but doing so may
    improve the performance of the equals method. If a redundant field amounts to a summary
    description of the entire object, comparing this field will save you the expense of
    comparing the actual data if the comparison fails.

	5. When you are finished writing your equals method, ask yourself three questions:
    Is it symmetric, is it transitive, and is it consistent? (The other two properties
    generally take care of themselves.) If not, figure out why these properties fail
    to hold, and modify the method accordingly. For a concrete example of an equals
    method constructed according to the above recipe, see PhoneNumber.equals in Item 8.
    Here are a few final caveats:

		- Always override hashCode when you override equals (Item 8).
		- Don’t try to be too clever. If you simply test fields for equality, it’s not hard
        to adhere to the equals contract. If you are overly aggressive in searching for
        equivalence, it’s easy to get into trouble. It is generally a bad idea to take any
        form of aliasing into account. For example, the File class shouldn’t attempt to
        equate symbolic links referring to the same file. Thankfully, it doesn’t.
		- Don’t write an equals method that relies on unreliable resources. It’s extremely
        difficult to satisfy the consistency requirement if you do this. For example,
        java.net.URL’s equals method relies on the IP addresses of the hosts in URLs being
        compared. Translating a host name to an IP address can require network access, and
        it isn’t guaranteed to yield the same results over time. This can cause the URL
        equals method to violate the equals contract, and it has caused problems in
        practice. (Unfortunately, this behavior cannot be changed due to compatibility
        requirements.) With few exceptions, equals methods should perform deterministic
        computations on memory-resident objects.
		- Don’t substitute another type for Object in the equals declaration. It is not
        uncommon for a programmer to write an equals method that looks like the following,
        and then spend hours puzzling over why it doesn’t work properly:

		```java
		public boolean equals(MyClass o)
		{
		...
		}
		```

		The problem is that this method does not override Object.equals, whose argument is of type Object, but overloads it instead (Item 26). It is acceptable to provide such a “strongly typed” equals method in addition to the normal one as long as the two methods return the same result but there is no compelling reason to do so. It may provide minor performance gains under certain circumstances, but it isn’t worth the added complexity (Item 37).