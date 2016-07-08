/**
 * Created by srikanth.kannan on 1/18/16.
 */
public class Arithmetic {
    public static void main(String args[]){
        //System.out.print(isOdd(6));
        //System.out.println(digitSum(9));
        //System.out.println(fareEstimator(30, 7, new double[] {0.2}, new double[] {1.1})[0]);
        int[][] trainingData = {{4,-1}, {0, 0}, {5,-1}};
        //System.out.println(companyBotStrategy(trainingData));
        System.out.print("factorial = " + factorial(7));
        //System.out.println("factorial = " + factorialNonRecursive(7));
    }

    public static int isOdd(int num)
    {
        return (num & 1); // e.g 0000 1111 & 0000 0001 = 1
    }

    public static int digitSum(int n) { //codefights
        int sum = 0;
        if(n<0){
            return 0;
        }
        else{
            int reminder;
            while(n > 0){
                reminder = n%10;
                sum = sum + reminder;
                n = n/10;
                System.out.println("reminder = " + reminder + " n = " + n);
            }
        }
        return sum;
    }

    //codefights - UberBot
    public static double[] fareEstimator(int ride_time, int ride_distance, double[] cost_per_minute, double[] cost_per_mile) {
        double[] fateEstimate;
        int costMinSize = cost_per_minute.length;
        int costMileSize = cost_per_mile.length;
        if(costMinSize == costMileSize){
            fateEstimate = new double[costMileSize];
            for(int i=0; i < costMileSize; i++){
                fateEstimate[i] = cost_per_minute[i] * ride_time +  cost_per_mile[i] * ride_distance;
            }
            return fateEstimate;
        }
        else{
            return null;
        }
    }//fareEstimator

    //codefights - CodeFights - find the score
    static double companyBotStrategy(int[][] trainingData) {
        double score = 0.0;
        int count = 0;
        if(trainingData != null){
            int rowCount = trainingData.length;
            int colCount = 0;
            for(int i=0; i < rowCount; i++){
                colCount = trainingData[i].length;
                int currScore = trainingData[i][colCount-1];
                if(currScore <= 0){
                    continue;
                }
                else {
                    count++;
                    score += trainingData[i][0];
                }
            }//for
            System.out.println("count = " + count);
        }
        return (score > 0 ? score/count : 0.0);
    }

    String[] taskMaker(String[] source, int challengeId) {
        String [] returnStr = new String[10];
        return returnStr;
    }

    /**
     * Recursive way of find the factorial of a number
     * @param n
     * @return
     */
    public static int factorial(int n) throws IllegalArgumentException{
        if(n<0){
            throw new IllegalArgumentException("Cannot find factorial of a negative number");
        }
        else if(n==0){
            return 1;
        }
        else{
            return n * factorial(n-1);
        }
    }

    /**
     * Non-recursive way of finding the factorial of a number
     * @param n
     * @return
     */
    public static int factorialNonRecursive(int n){
        int fact = 1;
        if(n < 0){
            throw new IllegalArgumentException("Cannot find factorial of a negative number");
        }
        else if(n==0){
            fact = 1;
        }
        while(!(n<1)){
            fact = n * (n-1);
            n = n-1;
        }
        return fact;
    }

}
