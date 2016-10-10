#Casts

A way to change the runtime type of a variable

Example:

```java
double p = 4.35;
int r = 4.5 * 100;
// This will create a compiler error because you declare r and an int but the number will be a double

int r = (int)(4.35 * 100);
// This will maybe the result an int so no error will appear
// The result will be int r = 434 because 4.35 * 100 = 434.99999999 and the .99999 will be removed since ints dont have decimals

int r = (int Math.round(4.35 * 100));
// This is how you would get r to equal 435, like it should in real life, because Math.round will round the .99999 up to an aditional whole number
```
