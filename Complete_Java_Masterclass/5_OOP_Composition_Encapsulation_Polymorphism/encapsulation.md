# Encapsulation

**Encapsulation** allows you to limit access to certain components in the objects that you are creating

You can protect the members of a class from unauthorized access

Here is an example of an application that does *not* use encapsulation:

```java
public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        player.name = "Cody";
        player.health = 20;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println(player.healthRemaining());

        damage = 11;
        player.health = 200; // This is bad!
        player.loseHealth(damage);
        System.out.println(player.healthRemaining());
    }
}
/*
Output:

10
189
*/
```

```java
public class Player
{
    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage)
    {
        this.health = this.health - damage;
        if(this.health <= 0)
            System.out.println("You are dead");
    }

    public int healthRemaining()
    {
        return this.health;
    }
}
```

In the above application you can set the health - cheat the game - because the player's health variable is public, not private/encapsulated

***

Here is the corrected code that uses Encapsulation:

```java
public class Main {
    public static void main(String[] args) {
        EnhancedPlayer player = new EnhancedPlayer("Cody", 50, "Sword");
        System.out.println("Initial Health is " + player.getHealth());
        // We cannot access the player's health without the getHeath method
        // since the player's health is now encapsulated (private), not accessible
        // to outside classes
    }
}
```

```java
public class EnhancedPlayer
{
    private String name;
    private int health = 100;
    private String weapon;

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;

        if(health > 0 && health <= 100)
            this.health = health;

        this.weapon = weapon;
    }

    public void loseHealth(int damage)
    {
        this.health = this.health - damage;
        if(this.health <= 0)
            System.out.println("You are dead");
    }

    public int getHealth()
    {
        return this.health;
    }
}
```
