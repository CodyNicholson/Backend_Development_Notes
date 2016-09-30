A class is coupled with another class if the code in the class uses the other class's object


For example:


public class someClassName
{
    String abc = "123";
    System.out.println(abc);
}

// In this example the someClassName class is coupled with the String, System, and PrintStream classes because it uses those classes in its code
// The String, PrintStream, and System classes do not use any objects of someClassName in their code, so they are not coupled with someClassName, someClassName is coupled with them


As a general rule of thumb, couple as little as possible so you can make your code easy to read