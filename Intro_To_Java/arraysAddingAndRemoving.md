# Adding and Removing Elements from an Array

### Adding an element to an array:

When you create an array it has a fixed size, and you can set each index equal to a certain value

What if you want to put an element in the array as the first element, and then push all of the other elements back?

This would require an array with one greater size than the amount of elements contained within it, as to accommodate for the new element

Code:

```java
size++;
for (int i = size - 1; i > pos; i--)
{
    values[i] = values[i - 1];
}

values[pos] = val;

// This code will start i pointing at the empty space after the last element,
// and will move each element in the array starting with the last one right 1 spot
// until it gets the the position where you want to insert the new value

// This same process can be done if you are removing an element, but
// then you would move all of the elements after the deleted element over to the left by one
```
