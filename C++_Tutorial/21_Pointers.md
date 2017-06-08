# Pointers

```c++
// When data is stored it is stored in an appropriately sized box based
// on its data type 

int myAge = 39;
char myGrade = 'A';

cout << "Size of int " << sizeof(myAge) << endl;
cout << "Size of char " << sizeof(myGrade) << endl;

// You can reference the box (memory address) where data is stored with 
// the & reference operator

cout << "myAge is located at " << &myAge << endl;

// A pointer can store a memory address
// The data type must be the same as the data referenced and it is followed
// by a *

int* agePtr = &myAge;

// You can access the memory address and the data 
cout << "Address of pointer " << agePtr << endl;

// * is the dereference or indirection operator
cout << "Data at memory address " << *agePtr << endl;

int badNums[5] = {4, 13, 14, 24, 34};
int* numArrayPtr = badNums;

// You can increment through an array using a pointer with ++ or --
cout << "Address " << numArrayPtr << " Value " << *numArrayPtr << endl;
numArrayPtr++; 
cout << "Address " << numArrayPtr << " Value " << *numArrayPtr << endl;

// An array name is just a pointer to the array
cout << "Address " << badNums << " Value " << *badNums << endl;

// When you pass a variable to a function you are passing the value
// When you pass a pointer to a function you are passing a reference
// that can be changed

makeMeYoung(&myAge);

cout << "I'm " << myAge << " years old now" << endl;

// & denotes that ageRef will be a reference to the assigned variable
int& ageRef = myAge;

cout << "ageRef : " << ageRef << endl;

// It can manipulate the other variables data
ageRef++; 

cout << "myAge : " << myAge << endl;

// You can pass the reference to a function
actYourAge(ageRef);

cout << "myAge : " << myAge << endl;

// When deciding on whether to use pointers or references
// Use Pointers if you don't want to initialize at declaration, or if
// you need to assign another variable
// otherwise use a reference
```
