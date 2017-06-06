# String Functions

```cs
// ---------- STRINGS ----------

// Escape Sequences : \' \" \\ \b \n \t

string sampString = "A bunch of random words";

// Check if empty
Console.WriteLine("Is empty " + String.IsNullOrEmpty(sampString));
Console.WriteLine("Is empty " + String.IsNullOrWhiteSpace(sampString));
Console.WriteLine("String Length " + sampString.Length);

// Find a string index (Starts with 0)
Console.WriteLine("Index of bunch " + sampString.IndexOf("bunch"));

// Get a substring
Console.WriteLine("2nd Word " + sampString.Substring(2, 6));

string sampString2 = "More random words";

// Are strings equal
Console.WriteLine("Strings equal " + sampString.Equals(sampString2));

// Compare strings
Console.WriteLine("Starts with A bunch " + sampString.StartsWith("A bunch"));
Console.WriteLine("Ends with words " + sampString.EndsWith("words"));

// Trim white space at beginning and end or (TrimEnd / TrimStart)
sampString = sampString.Trim();

// Replace words or characters
sampString = sampString.Replace("words", "characters");
Console.WriteLine(sampString);

// Remove starting at a defined index up to the second index
sampString = sampString.Remove(0, 2);
Console.WriteLine(sampString);

// Join values in array and save to string
string[] names = new string[3] { "Matt", "Joe", "Paul" };
Console.WriteLine("Name List " + String.Join(", ", names));
```
