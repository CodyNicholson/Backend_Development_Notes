#Ternary Operator

A Ternary Operator is a shorthand method for writing an "if-else" statement

-

####Syntax Example

```
result = testCondition ? value1 : value2;
```

What the above statement is saying is that "result" will equal "value1" if "testCondition" is true, or "value2" if "testCondition" is false

-

####Real Example

```java
int userAge = 20;
String legalToDrink = (userAge >= 21) ? "It is legal for you to drink" : "It is illegal for you to drink";
System.out.print(legalToDrink);
```

The above code will print "It is illegal for you to drink" because userAge is 20

If userAge was greater than or equal to 21, it then legalToDrink would equal "It is legal for you to drink"
