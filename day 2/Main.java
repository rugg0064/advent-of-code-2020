import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        LinkedList<Password> pwds = new LinkedList<Password>();

        File f = new File("input.txt");
        Scanner sc = new Scanner(f);

        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            String[] splitted = line.split("[- :]");
            Password pwd = new Password(Integer.parseInt(splitted[0]),
                Integer.parseInt(splitted[1]), splitted[2].charAt(0), 
                splitted[4]);
            pwds.add(pwd);
        }

        int count1 = 0;
        int count2 = 0;
        for(Password pwd : pwds)
        {
            count1 += pwd.isValid() ? 1 : 0;
            count2 += pwd.isValid2() ? 1 : 0;
        }

        System.out.printf("Part 1: %s%n", count1);
        System.out.printf("Part 2: %s%n", count2);
    }
}
