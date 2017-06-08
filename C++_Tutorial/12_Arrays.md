# Arrays

```c++
// Arrays store multiple values of the same type

// You must provide a data type and the size of the array
int myFavNums[5];

// You can declare and add values in one step
int badNums[5] = {4, 13, 14, 24, 34};

// The first item in the array has the label (index) of 0
cout << "Bad Number 1: " << badNums[0] << endl;

// You can create multidimensional arrays
char myName[5][5] = {{'D','e','r','e','k'},{'B','a','n','a','s'}};

cout << "2nd Letter in 2nd Array: " << myName[1][1] << endl;

// You can change a value in an array using its index
myName[0][2] = 'e';

cout << "New Value " << myName[0][2] << endl;
```
