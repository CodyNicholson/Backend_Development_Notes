# Variables & Data Types

```c++
// ---------- VARIABLES / DATA TYPES ----------
// Variables start with a letter and can contain letters, numbers and _
// They are case sensitive
 
// A value that won't change is a constant
// Starts with const and it should be uppercase
const double PI = 3.1415926535;
 
// chars can contain 1 character that are surrounded with ' and is one byte in size
char myGrade = 'A';
 
// bools have the value of (true/1) or (false/0)
bool isHappy = true;
 
// ints are whole numbers
int myAge = 39;
 
// floats are floating point numbers accurate to about 6 decimals
float favNum = 3.141592;
 
// doubles are floating point numbers accurate to about 15 digits
double otherFavNum = 1.6180339887;
 
// You can output a variable value like this
cout << "Favorite Number " << favNum << endl;
 
// Other types include
// short int : At least 16 bits
// long int : At least 32 bits
// long long int : At least 64 bits
// unsigned int : Same size as signed version
// long double : Not less then double
 
// You can get the number of bytes for a data type with sizeof
 
cout << "Size of int " << sizeof(myAge) << endl;
cout << "Size of char " << sizeof(myGrade) << endl;
cout << "Size of bool " << sizeof(isHappy) << endl;
cout << "Size of float " << sizeof(favNum) << endl;
cout << "Size of double " << sizeof(otherFavNum) << endl;
 
int largestInt = 2147483647;
 
cout << "Largest int " << largestInt << endl;
```
