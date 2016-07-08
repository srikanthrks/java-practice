package regex;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by srikanth.kannan on 6/22/16.
 */
public class PatternMatcher {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Enter a number to check the \"[0-9].[0-9]+\" pattern. Enter exit to stop");
        Pattern pattern = Pattern.compile("\\d+.\\d+");
        while(true){
            input = scanner.next();
            if(input.equalsIgnoreCase("exit")) break;
            pattern.matcher(input);
            System.out.println("matches = " +  pattern.matcher(input).matches());
        }
        scanner.close();
    }
}
