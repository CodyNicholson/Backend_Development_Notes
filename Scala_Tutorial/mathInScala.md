#Math In Scala

In Scala you can do math using a variety of operators just like in Java:

```
+
-
*
/
%
+=
-=
*=
/=
```

-

You cannot do "++" and "--" in Scala like you can in Java to increment or decrement ints

***

If you want to use math functions in java you can do so by importing the math library like so:

```scala
import scala.math._   // "._" means all like in java when you use ".*"
abs(-8) // returns 8 (int)
cbrt(64) // returns 4.0 (double)
ceil(5.45) // return 6.0 (double)
round(5.45) // returns 5 (Long)
floor(5.45) // returns 5.0 (double)
exp(1) // returns Euler's number of 1
pow(2,3) // returns 8 (double)
sqrt(144) // returns 12 (double)
hypot(3,4) // returns the hypotenuse 5.0 (double)
log10(1000) // returns 3.0 (double)
log(128) // returns 4.852030263919617 (double)
min(5,12) // returns 5 (int)
max(5,12) // returns 12 (int)
(random * (11 - 1) + 1).toInt // returns a random number between 1 and 10
```
