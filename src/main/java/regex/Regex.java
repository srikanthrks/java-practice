package regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by srikanth.kannan on 3/12/16.
 */
public class Regex {
    public static void main(String[] args){
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter your regex (type exit to stop) :");
            //String next = scanner.next();
            String next = null;
            try {
                next = bufferedReader.readLine();

                if ("exit".equalsIgnoreCase(next))
                    break;
                Pattern pattern = Pattern.compile(next);
                System.out.println("Enter your string to search : ");
                next = bufferedReader.readLine();
                Matcher matcher = pattern.matcher(next);
                boolean found = false;
                while (matcher.find()) {
                    System.out.printf("Found the text %s starting at %d and ending at %d\n",
                            matcher.group(), matcher.start(), matcher.end());
                    found = true;
                }
                if (!found) {
                    System.out.printf("No match found\n");
                }
            }catch (IOException e) {
                System.out.println(" Exception : " +  e);
                e.printStackTrace();
            }
        }
    }
}
