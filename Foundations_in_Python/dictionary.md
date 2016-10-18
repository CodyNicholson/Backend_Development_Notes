#Dictionary

In Python you can create a dictionary that stoes pairs of keys and values, like a real dictionary stores pairs of words and definitions

***

####You can create a dictionary using the below syntax:

```python
dictionaryName = {'Key1':'Value1', 'Key2':'Value2'}
```

-

####Now that we have this dictionary we can explore the dictionary API

```python
#Running the below line of code will return all of the pairs stored in the dictonary: {'Key1': 'Value1', 'Key2': 'Value2'}

dictionaryName
```

-

```python
#This will return the value of Key1: Value1

dictionaryName['Key1']
```

-

```python
#The below code will create a new dictionary that has all the pairs stored in the dictionaryName dictionary, then it will return those pairs

newDictionary = dictionaryName.copy()

newDictionary
```

-

```python
#The below code will delete all the pairs stoed in dictionaryName, and will then return the empty dictionary: {}

dictionaryName.clear()

dictionaryName
```

-

```python
#Lastly, the below code will check if newDictionary contains the Key "Apples", this will return false

newDictionary.has_key('Apples')

#If we ask the dictionary if it has the key "Key1", it will be true because newDictionary still has that key from when we copied it over from before

newDictionary.has_key('Key1')
```