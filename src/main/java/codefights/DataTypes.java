package codefights;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by srikanth.kannan on 4/5/16.
 */
public class DataTypes {

    public static void main(String [] args){
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
        Pattern pattern = Pattern.compile("[^z]");
        Scanner scan = new Scanner(System.in);
        /* Declare second integer, double, and String variables. */
        int j;
        double e;
        String t;
        /* Read and save an integer, double, and String to your variables.*/
        j = scan.nextInt();
        e = scan.nextDouble();
        //Pattern pattern = Pattern.compile();
        //Matcher matcher = pattern.matcher(scan.next());
        //t = matcher.group();
        System.out.println("hasNextLine() = " + scan.hasNext());
        t = scan.next();
        System.out.println("hasNextLine() = " + scan.hasNext());
        /* Print the sum of both integer variables on a new line. */
        System.out.println(i+j);
        /* Print the sum of the double variables on a new line. */
        System.out.println(d+e);
        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
        System.out.println(s+t);
        scan.close();

    }
}
