# Java Algebra

### Integer Arithmetic in Java:

```java
int p = 435;
int d = p/100;
d = 4
// because java will round down from 4.35

c = p%100;
c = 35
// because mod takes the remainder after you divide by 100, which is 35

p/10 = 43
// rounds down from 4.5

p%10 = 5 (435 - 4*10)
// because mod takes the remainder after you divide by 10, which is 5
```

***

###Class for java math:

```
public class MathInJava
{
    public double amdahlSpeedup(double s, double n)
    {
        return 1/(s+((1-s)/n));
    }

    public double crossRatio(double a, double b, double c, double d)
    {
        return ((a-c)*(b-d))/((b-c)*(a-d));
    }

    public double average(int a, int b, int c, int d)
    {
        return (a+b+c+d)/4.0; 
        // This must be 4.0, and not 4 in order to get the correct answer
        // If it was just 4, then java would round the decimal down and return and incorrect answer
    }
}
```
