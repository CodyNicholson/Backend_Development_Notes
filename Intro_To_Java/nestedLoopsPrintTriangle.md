public class TrianglePattern
{
    public static void main(String[] args)
    {
        // Please do not modify this line.
        int numberOfRows = 5;

        for (int i = 1; i <= numberOfRows; i++)
        {
            for (int r = 0; r < i; r++)
            {
                System.out.print("[]");
            }
            System.out.println();
        }

    }
}