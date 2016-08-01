public class EqualStrings
{
    public static void main(String[] args)
    {
        String first = "Uda";
        String second = "city";
        String firstAndSecond = first + second;
        String third = "Udacity";
        if (firstAndSecond == third)
        {
            System.out.println("They are the same");
        }
        else
        {
            System.out.println("firstAndSecond is "
                               + firstAndSecond);
        }
    }
}



public class EqualNumbers
{
    public static void main(String[] args)
    {
        double original = 2;
        double root = Math.sqrt(original);
        double rootSquared = root * root;
        if (rootSquared == original)
        {
            System.out.println("They are the same");
        }
        else
        {
            System.out.println("rootSquared is "
                               + rootSquared);
        }
    }
}



class Numbers
{
    public static void main(String args[])
    {
        int oneMillion = 1000000;
        int mystery = oneMillion * oneMillion;
        System.out.println(mystery);
    }
}



public class DaysAlivePrinter
{
    public static void main(String[] args)
    {
        Day birthday = new Day(1951, 5, 25);
        Day lastDay = new Day(2012, 5 ,26);
        int daysAlive = lastDay.daysFrom(birthday);
        System.out.println(daysAlive);
    }
}



public class Trim
{
    public static void main(String[] args)
    {
        String river = "Mississippi";
        System.out.println(river.replace("i", "x"));
    }
}



public class Cases
{
    public static void main(String[] args)
    {
        String river = "Mississippi";
        System.out.println(river.toUpperCase());
        System.out.println(river.toLowerCase());
        System.out.println(river.toUpperCase().toLowerCase());
        System.out.println(river);
    }
}



public class HelloJello
{
    public static void main(String[] args)
    {
        String greeting = "Hello";
        System.out.println(greeting.replace("H", "J"));
        System.out.println(greeting);
    }
}



public class RectangleTranslate
{
    public static void main(String[] args)
    {
        Rectangle box = new Rectangle(5, 10, 60, 90);
        System.out.println(box.getX());
        System.out.println(box.getWidth());
        box.translate(25, 40);
        System.out.println(box.getX());
        System.out.println(box.getWidth());
    }
}



public class Box2
{
    public static void main(String[] args)
    {
        Rectangle box = new Rectangle(5, 10, 60, 90);
        Rectangle box2 = box;
        box.translate(25, 40);
        System.out.println(box.getX());
        System.out.println(box2.getX());
    }
}



public class Greeting
{
    public static void main(String[] args)
    {
        String greeting = "Hello";
        System.out.println(greeting.replace("H", "J"));
        System.out.println(greeting);
    }
}



public class LuckyNumber
{
    public static void main(String[] args)
    {
        int luckyNumber = 13;
        int luckyNumber2 = luckyNumber;
        luckyNumber2 = 12;
        System.out.println(luckyNumber);
    }
}



public class RectangleDemo
{
    public static void main(String[] args)
    {
        Rectangle box = new Rectangle(5, 10, 60, 90);
        box.draw();
        box.translate(200, 100);
        Rectangle box2 = new Rectangle(40, 60, 90, 100);
        box2.draw();
        box2.translate(200, 100);
    }
}



public class Mariner4
{
    public static void main(String[] args)
    {
        Day mariner4 = new Day(1964, 11, 28);
        mariner4.addDays(228);
        System.out.println(mariner4.toString());
    }
}



public class Shrink
{
    public static void main(String[] args)
    {
        Picture jonathan = new Picture("jonathan.jpg");
        jonathan.translate(100, 100);
        jonathan.grow(-50, -50);
        jonathan.draw();

    }
}



public class Trim2
{
    public static void main(String args[])
    {
        String messyString = " Hello, Space! ";
        System.out.println(messyString.trim());
    }
}



public class RectangleExample
{
    public static void main(String[] args)
    {
        Rectangle box = new Rectangle(60, 90, 20, 30);
        Rectangle box2 = new Rectangle(80, 120, 20, 30);
        box.draw();
        box2.draw();

        box.setColor(new Color(255, 0, 0));
        box.draw();
        box2.setColor(new Color(0, 255, 0));
        box2.fill();
    }
}



public class RectangleExample2
{
    public static void main(String[] args)
    {
        Rectangle box = new Rectangle(5, 10, 60, 90);
        Rectangle box2 = box;
        box.setColor(Color.RED);
        box.setColor(Color.BLUE);
        box2.fill();
    }
}



public class CopyString
{
    public static void main(String[] args)
    {
        String greeting = "Hello, World!";
        String greeting2 = greeting;
        greeting2.toUpperCase();
    }
}



class Replace
{
    public static void main(String args[])
    {
        String river = "Mississippi";
        System.out.print(river.replace("s", "8"));
    }
}



public class Homework0
{
    public static void main(String[] args)
    {
        java.util.Properties props = System.getProperties();
        System.out.println("OS: " + props.get("os.name")
            + " " + props.get("os.version"));
        System.out.println("Java: " + props.get("java.vendor")
            + " " + props.get("java.version"));
        String classpath = "" + props.get("java.class.path");
        String ide;
        if (classpath.contains("bluej"))
            ide = "BlueJ";
        else if (props.get("com.horstmann.codecheck") != null)
            ide = "Udacity";
        else
            ide = "Unknown";
        System.out.println("IDE: " + ide);
        System.out.println("Secret code: " +
            Math.abs(ide.hashCode() % 10000));
    }
}



class Demo
{
    public static void main(String args[])
    {
        System.out.println(3+ 4 +5);
        System.out.println("3 + 4 +5");
    }
}



public class RectangleDemo6
{
    public static void main(String[] args)
    {
       Rectangle box1 = new Rectangle(60,90,20,30);
       Rectangle box2 = new Rectangle(80,120,20,30);
       box1.draw();
       box2.draw();
    }
}