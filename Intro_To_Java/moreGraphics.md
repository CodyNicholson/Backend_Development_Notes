To construct a line:
Line Segment = new Line(x1, y1, x2, y2);
segment.draw();

Circle/Ellipse:
Ellipse egg = new Ellipse(x,y,width,height);

Text/Wordart:
Text message = new Text(x,y,"Udacity");



Top Secret Crate:

public class TopSecret
{
    public static void main(String[] args)
    {
        Rectangle frontFace = new Rectangle(20, 30 ,100, 40);
        Line leftLine = new Line(20, 30, 50, 10);
        Line topLine = new Line(50, 10, 150, 10);
        Line middleLine = new Line(120, 30, 150, 10);
        Line rightLine = new Line(150, 10, 150, 50);
        Line bottomLine = new Line(120, 70, 150, 50);

        frontFace.draw();
        leftLine.draw();
        topLine.draw();
        middleLine.draw();
        rightLine.draw();
        bottomLine.draw();

        Text TopSecret = new Text(20,30, "TOP SECRET");
        TopSecret.draw();

    }
}



Color:

box.setColor(new Color(0,0,0)); or box.setColor(Color.BLACK);
box.draw();
box.fill();