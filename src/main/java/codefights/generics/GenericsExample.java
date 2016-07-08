package codefights.generics;

/**
 * Created by srikanth.kannan on 6/5/16.
 */
public class GenericsExample {

    public static void main(String args[]){
        Integer intArray[] = {2,3,46,7,32};
        printArray(intArray);
        String strArray[] = {"tom", "cat", "cher"};
        printArray(strArray);
    }
    //generic method which accept an array of any object
    public static <T> void printArray(T[] array){
        System.out.println("printing array elements of type :" + array.getClass() );
        for(T element : array){
            System.out.println(element);
        }
    }
}
