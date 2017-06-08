# Functions

```c++
// ---------- FUNCTIONS ----------
// The function has return type, function name and attributes with 
// their data types
// The attribute data types must match the value passed in
// This data is passed by value
// You can define default values to attributes as long as they come last
// This is known as a function prototype
int addNumbers(int firstNum, int secondNum = 0){
 
		int combinedValue = firstNum + secondNum;
 
		return combinedValue;
 
}
 
// An overloaded function has the same name, but different attributes
int addNumbers(int firstNum, int secondNum, int thirdNum){
 
	return firstNum + secondNum + thirdNum;
 
}
 
// A recursive function is one that calls itself
 
int getFactorial(int number){
 
	int sum;
	if(number == 1) sum = 1;
	else sum = (getFactorial(number - 1) * number);
	return sum;
 
	// getFactorial(2) [Returns 2] * 3
	// getFactorial(1) [Returns 1] * 2 <This value goes above>
	// 2 * 3 = 6
 
}
 
// Doesn't have a return type so use void
// Since I'm getting a pointer use int*
// Refer to the referenced variable with *age
void makeMeYoung(int* age){
 
	cout << "I used to be " << *age << endl;	
	*age = 21;
 
}
 
// A function that receives a reference can manipulate the value globally
void actYourAge(int& age){
 
	age = 39;
 
}
```
