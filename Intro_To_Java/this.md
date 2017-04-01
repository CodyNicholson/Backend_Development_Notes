# This

A reference to the object to the left of the "." in the method call

It is never needed, it just makes the code more organized

In java, local and parameter variables are considered first when looking at variable names

***

### Application

If you would like, you can add "this" in front of every instance variable in your program so it is clear which variables are local and which are instance

You can also call methods using "this"

Example:

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
    public void unFriend(Person nonFriend)
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

    /**
    Adds this to friend's network of friends and also adds friend to this.friends as well
    @params friend.name will be added to this.friends, this.name will will be added to friend.friends
    */
    public void makeMutualFriend(Person friend)
    {
        this.addFriend(friend);
        friend.addFriend(this);
    }

    /**
    Removes this from friend's network of friends and also removes friend to this.friends as well
    @params friend.name will be removed from this.friends, this.name will will be removed from friend.friends
    */
    public void removeMutualFriend(Person nonFriend)
    {
        this.unFriend(nonFriend);
        nonFriend.unFriend(this);
    }
}
```
