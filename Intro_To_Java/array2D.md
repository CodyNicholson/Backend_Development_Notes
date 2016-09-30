In a 2D array there are two values for every one element in the array

A 2D array is defined as:

arrayType[][] arrayName = new arrayType[intRows][intColumns]

Example:

double[][] prices = new double[3][2];



Setting values:


double[][] prices =
{
    {12.12, 432.2342},
    {3.2, 123.65},
    {436465.4, 8769.0}
};

// Three rows, two columns



Getting a value:


double r = prices[0][1];

// This will get the value at row 0, column 1



To get the number of rows:

prices.length;


To get the number of columns:

prices.[0].length;



To print the whole 2d array:

for (int row = 0; row < prices.length; row++)
{
    for (int column = 0; column < prices[0].length; column++)
    {
        System.out.printf("%10.3f", prices[row][column]);
    }
    System.out.println();
}



Example Code:


import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeBook
{
    private ArrayList<String> students;
    private int numStudents;
    private ArrayList<String> topics;
    private int numTopics;
    private double[][] grades;

    public GradeBook(String file)
    {
        students = new ArrayList<String>();
        topics = new ArrayList<String>();
        readScoresFromFile(file);
    }

    /**
     * Adds up all the scores for one student and returns the result.
     * Only works for a valid student index.
     * @param studentIndex the row for the student whose total you want.
     * @return the sum of that student's scores, or -1 if the index is bad.
     */
    public double totalForStudent(int studentIndex)
    {
        double sum = 0;
        for (int i = 0; i < grades[studentIndex].length; i++)
        {
            sum = sum + grades[studentIndex][i];
        }
        return sum;
    }