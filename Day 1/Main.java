import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        ArrayList<Integer> values = new ArrayList<Integer>();

        File f = new File("input.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNext())
        {
            values.add(Integer.parseInt(sc.next()));
        }

        partOne:
        for(int a : values)
        {
            for(int b : values)
            {
                if(a==b) continue;
                if(a+b == 2020)
                {
                    System.out.printf("Two values: {%d, %d}, product: %d%n", a, b, a*b);
                    break partOne;
                }
            }
        }

        partTwo:
        for(int a : values)
        {
            for(int b : values)
            {
                if(a==b) continue;
                for(int c : values)
                {
                    if(c==b || c==a) continue;
                    if(a+b+c == 2020)
                    {
                        System.out.printf("Three values: {%d, %d, %d}, product: %d%n", a, b, c, a*b*c);
                        break partTwo;
                    }
                }
            }
        }
    }
}
