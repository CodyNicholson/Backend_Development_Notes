# Array Functions

```cs
// ---------- ARRAYS ----------
// Declare an array
int[] randNumArray;

// Declare the number of items an array can contain
var randArray = new int[5];

// Declare and initialize an array
int[] randArray2 = { 1, 2, 3, 4, 5 };

// Get array length
Console.WriteLine("Array Length " + randArray2.Length);

// Get item at index
Console.WriteLine("Item 0 " + randArray2[0]);

// Cycle through array
for (i = 0; i < randArray2.Length; i++)
{
	Console.WriteLine("{0} : {1}", i, randArray2[i]);
}

// Cycle with foreach
foreach (int num in randArray2)
{
	Console.WriteLine(num);
}

// Get the index of an item or -1
Console.WriteLine("Where is 1 " + Array.IndexOf(randArray2, 1));

names = new string[] {"Tom", "Paul", "Sally"};

// Join an array into a string
string nameStr = string.Join(", ", names);
Console.WriteLine(nameStr);

// Split a string into an array
string[] nameArray = nameStr.Split(',');

// Create a multidimensional array
int[,] multArray = new int[5, 3];

// Create and initialize a multidimensional array
int[,] multArray2 = { { 0, 1 }, { 2, 3 }, { 4, 5 } };

// Cycle through multidimensional array
foreach (int num in multArray2)
{
	Console.WriteLine(num);
}

// Cycle and have access to indexes
for (int x = 0; x < multArray2.GetLength(0); x += 1)
{
	for (int y = 0; y < multArray2.GetLength(1); y += 1)
    {
    	Console.WriteLine("{0} | {1} : {2}", x, y, multArray2[x, y]);
    }
}
```
