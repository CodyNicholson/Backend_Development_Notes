# While Loop

```c++
// Use a while loop when you don't know ahead of time when a loop will end

// Generate a random number between 1 and 100
int randNum = (rand() % 100) + 1;

while(randNum != 100){

	cout << randNum << ", ";

	// Used to get you out of the loop
	randNum = (rand() % 100) + 1;

}

cout << endl;

// You can do the same as the for loop like this
// Create an index to iterate out side the while loop
int index = 1;

while(index <= 10){
	cout << index << endl;

	// Increment inside the loop
	index++;

}
```
