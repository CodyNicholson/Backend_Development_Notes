package javaExampleCode;

import java.util.ArrayList;
import java.util.Scanner;

public class Form {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int keepGoing = 1;
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> cities = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();

        while(keepGoing == 1)
        {
            System.out.print("Enter a name: ");
            String input = in.nextLine();
            if(input.length() > 8)
            {
                input = input.substring(0,8);
            }
            names.add(input);
            System.out.println();

            System.out.print("Enter a city: ");
            input = in.nextLine();
            if(input.length() > 12)
            {
                input = input.substring(0,12);
            }
            cities.add(input);
            System.out.println();

            System.out.print("Enter a color: ");
            in.nextLine();
            if(input.length() > 7)
            {
                input = input.substring(0,7);
            }
            colors.add(input);
            System.out.println();

            System.out.print("To stop entering data type 'Stop' and press enter: ");
            System.out.println();
            if(in.nextLine().toLowerCase().equals("stop"))
            {
                keepGoing = 0;
            }
        }

        System.out.println("  Name  |    City    | Color ");
        System.out.println("-----------------------------");
        for (int i = 0; i < names.size(); i++)
        {
            System.out.printf("%8s|%12s|%7s", names.get(i), cities.get(i), colors.get(i));
            System.out.println();
        }
        in.close();
    }
}