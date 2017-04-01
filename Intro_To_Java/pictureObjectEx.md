# Picture Object

```java
public class PictureDemo
{
    public static void main(String[] args)
    {
        Picture rocket = new Picture("pic.jpg");
        rocket.translate(200, 200);
        rocket.draw();
        Picture planet = new Picture("mars.gif");
        planet.grow(-50,-50);
        planet.draw();
    }
}
```
