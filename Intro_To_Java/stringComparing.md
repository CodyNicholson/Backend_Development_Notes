# String Comparing

```java
String a = "One";
String b = "Two";
String ab = "OneTwo";
String c = a + b;

if(ab == c)
{
    System.out.print("They are the same!");
}
else
{
    System.out.print("NOT THE SAME!");
}

// This will print "NOT THE SAME!" because String ab and String c point
// to different objects of the String class that are not equal

// To tell if the CONTENTS of the two string objects are equal we do this:

ab.equals(c); // This will return true
```
