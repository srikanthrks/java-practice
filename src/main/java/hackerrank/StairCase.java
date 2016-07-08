package hackerrank;

/**
 * Created by srikanth.kannan on 3/12/16.
 */
public class StairCase {

    public static void main(String [] args){
        stairCase(6);
    }

    static void stairCase(int n) {
        for(int i=1; i <= n;i++){
            StringBuilder stringBuilder = new StringBuilder("");
            for(int j=1; j <= i; j++){
                stringBuilder.append("#");
            }
            System.out.printf("%"+n+"s", stringBuilder);
            System.out.println();
        }
    }
}
