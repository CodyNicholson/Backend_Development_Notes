# Loop Algorithm Pseudo Code

### Sum

```
total = 0
for each item
     total = total + input
```

***


### Counting Matches

```
matches = 0
for each item
    if the item matches
        matches = matches + 1
```

***

### Finding the Location of the First Match

```
found = false
position = 0
while it's not found, and there are more items
    if the item at position matches
        found = true
    else
        position = position + 1
if the item was found
    its location is position
```

***

### Maximum

```
largest = the first item
for all the items except the first
    if the current item is larger than largest
        replace the value in largest with the current item
```
