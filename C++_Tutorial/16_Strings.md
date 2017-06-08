# Strings

```c++
// The string library class provides a string object
// You must always surround strings with "
// Unlike the char arrays in c, the string object automatically resizes

// The C way of making a string
char happyArray[6] = {'H', 'a', 'p', 'p', 'y', '\0'};

// The C++ way
string birthdayString = " Birthday";

// You can combine / concatenate strings with +
cout << happyArray + birthdayString << endl;

string yourName;
cout << "What is your name? ";
getline (cin,yourName);

cout << "Hello " << yourName << endl;

double eulersConstant = .57721;
string eulerGuess;
double eulerGuessDouble;
cout << "What is Euler's Constant? ";
getline (cin,eulerGuess);

// Converts a string into a double
// stof() for floats
eulerGuessDouble = stod(eulerGuess);

if(eulerGuessDouble == eulersConstant){

	cout << "You are right" << endl;

} else {

	cout << "You are wrong" << endl;

}

// Size returns the number of characters
cout << "Size of string " << eulerGuess.size() << endl;

// empty tells you if string is empty or not
cout << "Is string empty " << eulerGuess.empty() << endl;

// append adds strings together
cout << eulerGuess.append(" was your guess") << endl;

string dogString = "dog";
string catString = "cat";

// Compare returns a 0 for a match, 1 if less than, -1 if greater then
cout << dogString.compare(catString) << endl;
cout << dogString.compare(dogString) << endl;
cout << catString.compare(dogString) << endl;

// assign copies a value to another string 
string wholeName = yourName.assign(yourName);
cout << wholeName << endl;

// You can get a substring as well by defining the starting index and the
// number of characters to copy
string firstName = wholeName.assign(wholeName, 0, 5);
cout << firstName << endl;

// find returns the index for the string your searching for starting
// from the index defined
int lastNameIndex = yourName.find("Banas", 0);
cout << "Index for last name " << lastNameIndex << endl;

// insert places a string in the index defined
yourName.insert(5, " Justin");
cout << yourName << endl;

// erase will delete 6 characters starting at index 7
yourName.erase(6,7);
cout << yourName << endl;

// replace 5 characters starting at index 6 with the string Maximus
yourName.replace(6,5,"Maximus");
cout << yourName << endl;
```
