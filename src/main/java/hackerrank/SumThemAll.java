package hackerrank;

import java.util.Scanner;

/**
 * Created by srikanth.kannan on 6/5/16.
 */
public class SumThemAll {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        System.out.println("len = " + len);
        int sum =0, i=0;
        while(i<len){
            sum = sum + scanner.nextInt();
            i++;
        }
        System.out.println(sum);
        scanner.close();
    }
}
