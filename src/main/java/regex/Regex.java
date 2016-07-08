package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by srikanth.kannan on 3/12/16.
 */
public class Regex {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter your regex (type exit to stop) :");
            String next = scanner.next();
            if("exit".equalsIgnoreCase(next))
                break;
            Pattern pattern = Pattern.compile(next);
            System.out.println("Enter your string to search : ");
            Matcher matcher = pattern.matcher(scanner.next());
            boolean found = false;
            while(matcher.find()){
                System.out.printf("Found the text %s starting at %d and ending at %d\n",
                        matcher.group(), matcher.start(), matcher.end());
                found = true;
            }
            if(!found){
                System.out.printf("No match found\n");
            }
        }
    }
}
