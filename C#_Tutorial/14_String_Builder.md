# String Builder

```cs
// ---------- STRINGBUILDER ----------
// Each time you create a string you actually create another string in memory
// StringBuilders are used when you want to be able to edit a string without creating new ones

StringBuilder sb = new StringBuilder();

// Append a string to the StringBuilder (AppendLine also adds a newline at the end)
sb.Append("This is the first sentence.");

// Append a formatted string
sb.AppendFormat("My name is {0} and I live in {1}", "Derek", "Pennsylvania");

// Clear the StringBuilder
// sb.Clear();

// Replaces every instance of the first with the second
sb.Replace("a", "e");

// Remove characters starting at the index and then up to the defined index
sb.Remove(5, 7);

// Out put everything
Console.WriteLine(sb.ToString());
```
