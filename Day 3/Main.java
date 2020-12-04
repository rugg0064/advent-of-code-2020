import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main
{
    static ArrayList<ArrayList<Boolean>> map = new ArrayList<ArrayList<Boolean>>();
    public static void main(String[] args) throws FileNotFoundException
    {
        int downSlope = 1;
        int rightSlope = 3;

        File f = new File("input.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine())
        {
            String line = sc.next();
            if(line.length() == 0) continue;
            ArrayList<Boolean> newLine = new ArrayList<Boolean>();
            map.add(newLine);
            for(char c : line.toCharArray())
            {
                newLine.add( c == '#' );
            }
        }

        int[] rightSlopes = {1, 3, 5, 7, 1};
        int[] downSlopes =  {1, 1, 1, 1, 2};
        LinkedList<Integer> collisions = new LinkedList<Integer>();
        for(int i = 0; i < rightSlopes.length; i++)
        {
            int c = testSlope(rightSlopes[i], downSlopes[i]);
            System.out.printf("Right %d, Down %d = %d%n", rightSlopes[i], downSlopes[i], c);
            collisions.add(c);
        }
        int accumulator = 1;
        for(int c : collisions)
        {
            accumulator *= c;
        }
        System.out.printf("Product: %d%n", accumulator);
    }

    private static int testSlope(int rightSlope, int downSlope)
    {
        int width = map.get(0).size();
        int height = map.size();

        int col = 0;
        int row = 0;
        int collisions = 0;
        while(row < height)
        {
            if(map.get(row).get(col))
            {
                collisions++;
            }
            row += downSlope;
            col += rightSlope;
            if(col > width-1)
            {
                col -= width;
            }
        }
        return collisions;
    }
}
