# Vectors

```c++
// Vectors are like arrays, but their size can change

vector <int> lotteryNumVect(10);

int lotteryNumArray[5] = {4, 13, 14, 24, 34};

// Add the array to the vector starting at the beginning of the vector
lotteryNumVect.insert(lotteryNumVect.begin(), lotteryNumArray, lotteryNumArray+3);

// Insert a value into the 5th index
lotteryNumVect.insert(lotteryNumVect.begin()+5, 44);

// at gets the value in the specified index
cout << "Value in 5 " << lotteryNumVect.at(5) << endl;

// push_back adds a value at the end of a vector
lotteryNumVect.push_back(64);

// back gets the value in the final index
cout << "Final Value " << lotteryNumVect.back() << endl;

// pop_back removes the final element
lotteryNumVect.pop_back();

// front returns the first element
cout << "First Element " << lotteryNumVect.front() << endl;

// back returns the last element
cout << "Last Element " << lotteryNumVect.back() << endl;

// empty tells you if the vector is empty
cout << "Vector Empty " << lotteryNumVect.empty() << endl;

// size returns the total number of elements
cout << "Number of Vector Elements " << lotteryNumVect.size() << endl;
```
