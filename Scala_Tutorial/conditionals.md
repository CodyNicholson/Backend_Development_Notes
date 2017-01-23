#Conditionals In Scala

#####Conditional Operators:

```
== Equal to
!= not equal to
> greater than
< less than
>= greater than or equal to
<= less than or equal to
```

-

#####Logical Operators:

```
&& and
|| or
! not
```

***

###If Statements

If statements are similar to Java except that they will return a value kind of like ternary operators in Java

```
val age = 18
val canVote = if(age >= 18) "yes" else "no"  // will return yes (string)

if((age>=5) && (age <= 6)){
    | println("Go to kindergraden")
    | } else if((age > 6) && (age <= 7)){
    | println("Go to grade 1")
    | } else {
    | println("Go to grade " + (age - 5)
    | }
```
