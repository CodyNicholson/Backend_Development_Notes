# Magic Numbers - Final / Constants

### THIS IS WRONG:

```java
red = Math.min(red + 25, 255);
```

The reason this is wrong is because if another person saw this code, they would not know the purpose of the 25 and 255

They are called 'Magic Numbers' because no one understands why they are there.

-

### It Should Be:

```java
final int ADDED_RED = 25;
final int MAX_RED = 255;
red = Math.min(red + ADDED_RED, MAX_RED);
```

When you write the code like this, you can see clearly that the purpose of +25 is to add red to the image, and that 255 is the maximum value for red

The keyword 'final' means that the variable you are declaring is a constant, and cannot be changed
