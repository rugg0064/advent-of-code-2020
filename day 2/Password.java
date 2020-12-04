public class Password
{
    private int a, b;
    private char c;
    private String password;
    public Password(int a, int b, char c, String password)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.password = password;
    }

    public boolean isValid()
    {
        int count = 0;
        for(char pc : this.password.toCharArray())
        {
            if(pc == c)
            {
                count++;
            }
        }
        return (a <= count && count <= b);
    }

    public boolean isValid2()
    {
        boolean pos1 = password.charAt(a-1) == c;
        boolean pos2 = password.charAt(b-1) == c;
        return (pos1 || pos2) && !(pos1 && pos2);
    }

    public String toString()
    {
        return String.format("%d-%d %c: %s", a, b, c, password);
    }
}