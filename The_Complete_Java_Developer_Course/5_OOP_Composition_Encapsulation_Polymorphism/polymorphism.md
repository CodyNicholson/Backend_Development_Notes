#Polymorphism

**Polymorphism** allows us to assign different functionality depending on the type of object that we have created

Example:

```java
class Movie
{
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot()
    {
        return "No plot here";
    }

    public String getName(){
        return name;
    }
}

class Jaws extends Movie
{
    public Jaws()
    {
        super("Jaws");
    }

    @Override
    public String plot(){ //Overrides Movie.plot()
        return "A shark eats lots of people";
    }
}

class IndependanceDay extends Movie{
    public IndependanceDay(){
        super("Independance Day");
    }

    @Override
    public String plot(){
        return "Aliens attempt to take over Earth";
    }
}

class MazeRunner extends Movie{
    public MazeRunner(){
        super("Maze Runner");
    }

    @Override
    public String plot(){
        return "Kids try to escape a maze";
    }
}

class StarWars extends Movie{
    public StarWars(){
        super("Star Wars");
    }

    @Override
    public String plot(){
        return "Imperial Forces try to take over the universe";
    }
}

class Forgetable extends Movie{
    public Forgetable(){
        super("Forgetable");
    }

    // The Movie class's plot method will be called since
    // there is no plot method in Forgettable
}

public class Main
{
    public static void main(String[] args)
    {
        for(int i = 1; i < 11; i++){
            Movie movie = randomMovie();
            System.out.println("Move #" + i + " : " + movie.getName()
            + "\n" + "Plot: " + movie.plot() + "\n");
        }
    }

    public static Movie randomMovie(){
        int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("Random Number wasL " + randomNumber);
        switch(randomNumber){
            case 1:
                return new Jaws();
            case 2:
                return new IndependanceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new Forgetable();
        }
        return null;
    }
}
/*
Output

*/
```

The above program will run the plot() method for whichever object gets selected randomly

Without Polymorphism - We could not call Movie.plot() in our print statement in our main method - instead we would have to do some check to find out which object was calling the method
