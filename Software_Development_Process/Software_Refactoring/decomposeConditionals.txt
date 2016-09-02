To make your code more readable it is good to Decompose Complex Conditionals and modify the Then and Else part of the conditional like so:

if(date.before(Summer_Start)||date.after(Summer_End))
{
    c = q * winterRate + winterServiceCharge;
}
else
{
    c = q * summerRate;
}


The above code can be changed into:


if(notSummer(date))
{
    c = winterCharge(q);
}
else
{
    c = summerCharge(q);
}

public boolean notSummer(date)
{
    return (date.before(Summer_Start)||date.after(Summer_End))
}

public double winterCharge(double q)
{
    return q * winterRate + winterServiceCharge;
}

public double summerCharge(double q)
{
    return q * summerRate;
}