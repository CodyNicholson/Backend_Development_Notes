#Arrays

An array is a container object that holds a fixed number of values of a single type

The length of an array is established when the array is created

After creation, its length is fixed

An array's indicies start at 0

-

An array is better than an arrayList when you do not care for neat syntax, or when you are working with lots of numbers

An arrayList should be used for every other situation

-

###An array is a list of items of a specific type defined using this syntax:

```java
type[] arrayName = new type[lengthOfArray];
```

Real Example:

```Java
double[] values = new double[5];

// This will create an array of five doubles
// You cannot change the amount of items an array can hold after it is constructed; the above array will always have a maximum of 5 items
```

-

###Targeting elements in an array:

```java
double firstValue = values[0];

// This will get the 0th index of the values array
```

-

###Chaning/setting the values of an array:

```java
values[0] = 42;

// This will set the value of the double element at the 0th index of the values array to 42
```

-

###To print all of the elements in the array:

```java
for (int i = 0; i < values.length; i++)
{
    System.out.println(values[i]);
}

or

for (double value : values)
{
    System.out.println(value);
}
```

-

###If you want an array to be able to contain more values, you can define a new array and copy the contents of the old array into it like so:

```java
if (size >= LENGTH)
{
    values = Arrays.copyOf(values, 2 * values.length);
}

// This will take the create a brand new array of size "2 * values.length" that will already have the original contents of the values array stored within it via the args of copyOf()
```
