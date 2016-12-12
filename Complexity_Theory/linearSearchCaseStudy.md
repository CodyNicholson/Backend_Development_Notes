#Linear Search - Case Study

We have an array of unsorted items/integers

We want to fina a given item

If we know the index of the item, we can get it in O(1) constant time complexity

Usually we do not know the index, so we have to iterate through the array and check for it

Input size is the number of items in the array

-

**Best-Case Scenario**: The first item in the array is the item we are searching for, **O(1)**

**Worst-Case Scenario**: The item we are searching for does not exist in the array so we check every item in the array, **O(N)**

**Average-Case Scenario**: On average we will have to look through about half of the items in the array before finding the item we are searching for (assuming it exists in the array), this makes our Average-Case runtime **O(N/2)**