# Lists

```cs
// ---------- LISTS ----------
// A list unlike an array automatically resizes

// Create a list and add values
List<int> numList = new List<int>();
numList.Add(5);
numList.Add(15);
numList.Add(25);

// Add an array to a list
randArray = new int[] {1, 2, 3, 4, 5};
numList.AddRange(randArray);

// Clear a list
// numList.Clear();

// Copy an array into a List
List<int> numList2 = new List<int>(randArray);

// Create a List with array
List<int> numList3 = new List<int>(new int[] { 1, 2, 3, 4 });

// Insert in a specific index
numList.Insert(1, 10);

// Remove a specific value
numList.Remove(5);

// Remove at an index
numList.RemoveAt(2);

// Cycle through a List with foreach or
for (i = 0; i < numList.Count; i++)
{
	Console.WriteLine(numList[i]);
}

// Return the index for a value or -1
Console.WriteLine("4 is in index " + numList3.IndexOf(4));

// Does the List contain a value
Console.WriteLine("5 in list " + numList3.Contains(5));

// Search for a value in a string List
List<string> strList = new List<string>(new string[] { "Tom", "Paul" });
Console.WriteLine("Tom in list " + strList.Contains("tom", StringComparer.OrdinalIgnoreCase));

// Sort the List
strList.Sort();
```
