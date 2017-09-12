package interviewcake;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by srikanth.kannan on 9/11/17.
 */
public class Fibonacci {

    public static final Logger LOGGER = Logger.getLogger("Fibonacci");

    public static void main(String args[]){
        /*Assert.assertEquals(recursiveFibonacci(0),1);
        Assert.assertEquals(recursiveFibonacci(1),1);
        Assert.assertEquals(recursiveFibonacci(2),2);*/
        long currTimeInMilliSeconds = System.currentTimeMillis();
        int n = 46; // 45

        int expected = 1836311903; // 1134903170
        int actual = itertativeFibonacci(n);
        Assert.assertEquals(actual, expected);
        long newTimeInMilliSeconds = System.currentTimeMillis();
        LOGGER.info("fibonacci (" + n + ") = " + actual +
                " time elapsed = " + TimeUnit.MILLISECONDS.toSeconds(newTimeInMilliSeconds-currTimeInMilliSeconds));
        //System.out.println("time elapsed = " + TimeUnit.MILLISECONDS.toSeconds(newTimeInMilliSeconds-currTimeInMilliSeconds));

    }

    public static int recursiveFibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        else {
            return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
        }
    }

    public static int recursiveMemoizedFibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        else {
            Map<Integer,Integer> mem = new HashMap<>();
            // store the intermediat result
            if(mem.get(n) != null){
                return mem.get(n);
            }
            else{
                int result = recursiveMemoizedFibonacci(n - 1) + recursiveMemoizedFibonacci(n - 2);
                mem.put(n, result);
                return result;
            }
        }
    }

    public static int itertativeFibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int curr = 0, prev = 1, prevPrev = 0;
        for(int i = 1; i < n; i++){
            curr = prev + prevPrev;
            prevPrev = prev;
            prev = curr;
        }
        return curr;
    }

    @DataProvider(parallel = true)
    public Object[][] inputDataProvider(){
        Object[][] input = new Object[][]{{0,0}, {1,1}, {2,1}, {3,2}, {4,3}, {5,5}, {45, 1134903170}};
        return input;
    }

    @Test(dataProvider = "inputDataProvider")
    public void recursiveFibonacciTest(int n, int expected){
        long currTimeInMilliSeconds = System.currentTimeMillis();
        int actual = recursiveFibonacci(n);
        Assert.assertEquals(actual, expected);
        long newTimeInMilliSeconds = System.currentTimeMillis();
        LOGGER.info("fibonacci (" + n + ") = " + actual +
                " time elapsed = " + TimeUnit.MILLISECONDS.toSeconds(newTimeInMilliSeconds-currTimeInMilliSeconds));
    }

    @Test(dataProvider = "inputDataProvider")
    public void recursiveMemoizedFibonacciTest(int n, int expected){
        long currTimeInMilliSeconds = System.currentTimeMillis();
        int actual = recursiveMemoizedFibonacci(n);
        Assert.assertEquals(actual, expected);
        long newTimeInMilliSeconds = System.currentTimeMillis();
        LOGGER.info("fibonacci (" + n + ") = " + actual +
                " time elapsed = " + TimeUnit.MILLISECONDS.toSeconds(newTimeInMilliSeconds-currTimeInMilliSeconds));
    }

    @Test(dataProvider = "inputDataProvider")
    public void itertativeFibonacciTest(int n, int expected){
        long currTimeInMilliSeconds = System.currentTimeMillis();
        int actual = itertativeFibonacci(n);
        Assert.assertEquals(actual, expected);
        long newTimeInMilliSeconds = System.currentTimeMillis();
        LOGGER.info("fibonacci (" + n + ") = " + actual +
                " time elapsed = " + TimeUnit.MILLISECONDS.toSeconds(newTimeInMilliSeconds-currTimeInMilliSeconds));
    }

}
