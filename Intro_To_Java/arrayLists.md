#ArrayLists

An ArrayList in Java is a list of objects we call elements that are stored in a list and assigned indices starting from 0

An arrayList should be used instead of an array for every situation except when you want the code to look nice, or when you are working with lots of numbers

***

###Array Lists in java are defined as:

```java
ArrayList<Type> listName = new ArrayList<Type>();
```

Ex:

```java
ArrayList<Picture> gallery = new ArrayList<Picture>();
```

-

###To add elements to an array list:

```java
gallery.add(new Picture("pic.png"));
```

-

###To get an element from an array list:

```java
Picture pic1 = gallery.get(0);

// get takes an int as an arguement
```

-

###To get the size of the array:

```java
int gallerySize = gallery.size();
```

-

###Modifying array lists:

```java
arrayListName.set(index, value);

// This will change the value of the object at the index that you enter of the array list
```
