#Consolidate Conditional Expression

Sometimes you will find a set of conditionals in your code that all have the same result:

if(true){x += 1;};

if(false){x += 1;};

-

In cases like this we should consolidate and extract the two if statements using && and || connectors to have a single conditional check with a single result:

if(true || false){x += 1;};
