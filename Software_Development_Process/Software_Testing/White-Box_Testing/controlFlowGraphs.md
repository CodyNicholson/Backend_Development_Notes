#Control Flow Graphs

A Control Flow Graph is a graph that shows the order that the statements will be executed in a diagram

-

###Example:

```java
public void split(String str, int index)
{
    if(str.length == 0){
        System.out.println("Invalid");
        return;
    }
    System.out.println(str.substring(index));
}
```

###The control flow diagram would look like this:

```
        T
O --> O --> O --> O
      L---> O
        F
```

Each node represents a statement in the code starting with the node on the farthest left which is where the program enters when the it is called, line 7 of this code

From being called it then goes to line 9 and runs the if statement

If it is true, if goes to the line 10 node and then finishes after that on the line 11 node

If false it runs the line 13 code and terminates after
