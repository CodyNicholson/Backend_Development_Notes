# If Statement

```c++
// ---------- IF STATEMENT ----------
// Executes different code depending upon a condition
 
// Comparison operators include ==, !=, >, <, >=, <=
// Will return true (1) if the comparison is true, or false (0)
 
// Logical operators include &&, ||, !
// Used to test 2 or more conditionals
 
int age = 70;
int ageAtLastExam = 16;
bool isNotIntoxicated = true;
 
if((age >= 1) && (age < 16)){
	cout << "You can't drive" << endl;
} else if(!isNotIntoxicated){
	cout << "You can't drive" << endl;
} else if(age >= 80 && ((age > 100) || ((age - ageAtLastExam) > 5))){
	cout << "You can't drive" << endl;
} else {
	cout << "You can drive" << endl;
}
```
