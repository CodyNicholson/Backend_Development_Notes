# While

```cs
// ---------- WHILE LOOP ----------

i = 0;

while (i < 10)
{
	// If i = 7 then skip the rest of the code and start with i = 8
	if (i == 7)
    {
    	i++;
        continue;
    }

    // Jump completely out of the loop if i = 9
    if (i == 9)
    {
    	break;
    }

    // You can't convert an int into a bool : Print out only odds
    if ((i % 2) > 0)
    {
    	Console.WriteLine(i);
    }
    	i++;
    }
}
```
