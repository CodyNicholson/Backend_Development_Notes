#Name In Box

This is a program I wrote that takes in a String as a parameter and returns a picture of that String in a box

```java
public class NameInBox {

    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println("+" + repeat(s.length(), "-") + "+");
        System.out.println("|" + s + "|");
        System.out.println("+" + repeat(s.length(), "-") + "+");
    }

    public static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

    public static String repeat(int count) {
        return repeat(count, " ");
    }
}
```
