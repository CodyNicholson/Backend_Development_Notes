#Arrays In Java

**Arrays** allow us to store multiple variables of the same type in a single variable

You can create an array of any primitive datatype or even Objects - Like an array of Strings or of one of your own user defined types

```java
public class Arrays
{
	public static void main(String[] args)
	{
		int[] myIntArray = new int[10];
		// This defines a list of 10 ints named myVar
		// The 10 ints currently have a value of null

		myIntArray[5] = 50;
		// This sets the sixth element in the array equal to 50
		// It is the sixth because java starts counting at 0 for arrays

		System.out.println(myIntArray[5]);
		// This will print the value of the int stored in the sixth position of myIntArray

		double[] myDoubleArray = {1.1, 2.2 3.3, 4.4, 5.5, 6.6};
		// Since we don't want to set the value of every single element of
		// our array in a separate statement, Java allows us to use the above
		// syntax to set the values of an array all at once when we initialize the array
		// Java automatically sets the size of this array equal to the number of elements 

		double[] doubleArray2 = new double[10];
		for (int i = 0; i < doubleArray2.length; i++)
		{
			doubleArray2[i] = i * 10;
			System.out.println("Element " + i + " has a value of " + doubleArray2[i]);
		}
		// The last way that we can assign values to our array is by using a for loop
		// We can iterate through the entire array by using i < array.length
		// This means that we will iterate once for every element in the array
		// We can then access each indice of our array using array[i], and set it equal to some value
		// By using array.length instead of 10 we make our code more maintainable
		// since we only have to change the number of elements in our array in one
		// place and then array.length will automatically update to that value

		// If you try and access an index of the array that is larger or smaller than
		// the size of the array you will get an **index out of bounds error**

		printArray(myDoubleArray);
		// We can pass our arrays through as parameter to methods we create
	}

	public static void printArray(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.println("Element " + i + " has a value of " + doubleArray2[i]);
		}
	}
}
```

```java
public class MoreArrays
{
private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		int[] myInts = getIntegers(5);
		for(int i = 0; i < myInts.length; i++)
		{
			System.out.println("Element " + i + ", typed value was " + myInts[i]);
		}
		System.out.println("The average is " + getAverage(myIntegers));
	}

	public static int[] getIntegers(int number)
	{
		System.out.println("Enter " + number + " integer values.\r");
		int[] values = new int[number];
		for (int i = 0; i < values.length; i++)
		{
			values[i] = scanner.nextInt();
		}
		return values;
	}

	public static double getAverage(int[] array)
	{
		int sum = 0;
		for (int i = 0; i < array.length; i++)
		{
			sum += array[i];
		}
		return (double) sum/(double)array.length;
	}
}
```