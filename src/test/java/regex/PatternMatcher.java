package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
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

    private void testUrlPattern(){
        String[] sites = new String[] { "www1.google.com", "www.google2.co", "www.google.com/maps/" };
        Pattern pattern = Pattern.compile("^[a-z,A-Z\\d]{3,4}\\.\\w*\\.[a-z,A-z]{2,}(/.*)*");
        for (String s : sites) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.matches()) { // find of it matches
                System.out.println(matcher.group());
            }
        }
    }
}
