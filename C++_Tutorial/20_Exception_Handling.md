# Exception Handling

```c++
// You can be prepared for potential problems with exception handling

int number = 0;

try{

	if(number != 0){
		cout << 2/number << endl;
	} else throw(number);

} 
catch(int number){

	cout << number << " is not valid input" << endl;

}
```
