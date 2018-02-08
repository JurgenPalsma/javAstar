import java.util.*;
import java.io.*;

public class FormatChecker
{
    public static void main(String args[])
    {
        try (BufferedReader br = new BufferedReader(new FileReader(args[0])))
        {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null)
            {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            StringTokenizer st = new StringTokenizer(sb.toString());
            if (parse_opening_bracket(st))
                System.out.println("ok");
            else
                System.out.println("problem");
        }
        catch (IOException e)
        {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }

    public static boolean parse_opening_bracket(StringTokenizer st)
    {
        if (st.hasMoreTokens())
        {
            String token = st.nextToken(" |0|1|2|3|4|5|6|7|8|9");
            if (token.equals("("))
            {
                System.out.print("(");
                return parse_x(st);
            }
            else return false;
        }
        else return true;
    }

    public static boolean parse_x(StringTokenizer st)
    {
        if (st.hasMoreTokens())
        {
            String token = st.nextToken(" |,");
            int x = Integer.parseInt(token);
            if (0 <= x && x < 24)
            {
                System.out.print(x + "");
                return parse_comma(st);
            }
            else return false;
        }
        else
        {
            return false;
        }
    }

    public static boolean parse_comma(StringTokenizer st)
    {
        if (st.hasMoreTokens())
        {
            String token = st.nextToken(" |0|1|2|3|4|5|6|7|8|9");
            if (token.equals(","))
            {
                System.out.print(", ");
                return parse_y(st);
            }
            else return false;
        }
        else return false;
    }

    public static boolean parse_y(StringTokenizer st)
    {
        if (st.hasMoreTokens())
        {
            String token = st.nextToken(" |)");
            int y = Integer.parseInt(token);
            if (0 <= y && y < 24)
            {
                System.out.print(y + "");
                return parse_closing_bracket(st);
            }
            else return false;
        }
        else return false;
    }

    public static boolean parse_closing_bracket(StringTokenizer st)
    {
        if (st.hasMoreTokens())
        {
            String token = st.nextToken(" |" + System.lineSeparator());
            if (token.equals(")"))
            {
                System.out.print(") ");
                return parse_opening_bracket(st);
            }
            else return false;
        }
        else return false;
    }

}