import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File f = new File("input.txt");
        Scanner sc = new Scanner(f);

        LinkedList<String> passportStrings = new LinkedList<String>();
        while(sc.hasNextLine())
        {
            StringBuilder sb = new StringBuilder();
            String line = "";
            while(sc.hasNextLine() && ! ((line=sc.nextLine()).equals("")))
            {
                if(sb.length() > 0)
                {
                    sb.append(" ");
                }
                sb.append(line);
            }
            passportStrings.add(sb.toString());
        }

        int sum = 0;
        for(String passportString : passportStrings)
        {
            sum += isValid(passportString) ? 1 : 0;
        }
        System.out.printf("No. of valid: %d%n", sum);

    }

    public static boolean isValid(String input)
    {
        String[] fields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        boolean[] bools = new boolean[fields.length];
        for(boolean b : bools) b = false;

        //Cid is part of passport but we ignore for our north pole travels
        String[] split = input.split(" ");
        tokenLoop:
        for(String s : split)
        {
            for(int i = 0; i < fields.length; i++)
            {
                if(s.contains(fields[i]))
                {
                    bools[i] = true;
                    continue tokenLoop;
                }
            }
        }
        
        for(boolean b : bools) 
        {
            if(!b)
            {
                return false;
            }
        }
        return true;
    }
}
