# People Class

```java
/**
    A person who can add friends to their network
*/
public class Person
{
    private String name;
    private String friends;
    private int x;
    private int y;

    /**
    Constructs a person with a picture of them displayed at (xCoord, yCoord)
    */
    public Person (String name, String pictureName, int x, int y)
    {
        this.name = name;
        this.friends = "";
        Picture picture = new Picture(pictureName);
        picture.translate(x, y);
        picture.draw();
        this.x = x;
        this.y = y;
    }

    /**
    Adds a friends to Person's friends var, creates a link between Person and friend in network diagram
    @param friend will be added to Person's friends, a small circle and a line will be drawn to connect Person to friend in diagram
    */
    public void addFriend(Person friend)
    {
        friends = friends + friend.name + " ";

        SmallCircle sc = new SmallCircle(x,y);
        sc.fill();
        Line connect = new Line(x,y,friend.x,friend.y);
        connect.draw();
    }

    /**
    Removes a friend from Person's friends
    @param nonFriend's name will be removed from Person's friends variable
    */
    public void unfriend(Person nonFriend)
    {
        friends = friends.replace(nonFriend.name + " ", "");
    }

    /**
    Returns a summary of the Person's friends.
    @return the names of frieds, separated by spaces.
    */
    public String getFriends()
    {
        return friends;
    }
}
```
