package leetcode;

import java.util.*;

/**
 * Created by srikanth.kannan on 7/25/16.
 */
public class TwoSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of array elements : ");
        int arrayLen = scanner.nextInt();
        int inputArray[] = new int[arrayLen];
        int target = 0;
        System.out.println("Enter the array elements");
        for(int i=0; i < arrayLen; i++){
            inputArray[i] = scanner.nextInt();
        }
        System.out.print("Enter the target element : ");
        target = scanner.nextInt();
        scanner.close();
        int[] outArray = TwoSums.twoSumsUsingMap(inputArray, target);
        if(outArray !=null && outArray.length > 0){
            System.out.println("Indices of the elements adding up to target are : ");
            for(int i : outArray){
                System.out.println(i);
            }
        }
        else {
            System.out.println("Sum of no 2 elements in the array equals the target!");
        }
    }

    /**
     * This method takes an integer array and a target which could be the sum of any two elements in
     * the array, if any, and returns the indices of the elements summing up to the target
     * @param arr - integer array, e.g., [5,1,2,3,4]
     * @param target - any valid integer, e.g., 7
     * @return -
     */
    public static int[] twoSumsArray(int[] arr, int target){
        int [] indexArr = null;
        int [] copyArr = null;
        if(arr != null){
            int len = arr.length;
            Arrays.copyOf(arr, len);// copy of the original array
            Arrays.sort(arr);//nlogn
            int startPos = 0;
            int endPos = len-1;
            int start;
            int end;
            while(startPos < endPos ){
                start = arr[startPos];
                end = arr[endPos];
                if(start+end > target){
                    endPos--;
                    continue;
                }
                else if (start+end < target){
                    startPos++;
                    continue;
                }
                else{
                    indexArr = new int[]{startPos, endPos};
                    break;
                }
            }
        }
        return indexArr;
    }

    /**
     * This method takes an integer array and a target which could be the sum of any two elements in
     * the array, if any, and returns the indices of the elements summing up to the target
     * @param nums - integer array [5,1,2,3,4]
     * @param target - any valid integer, e.g., 7
     * @return - [1,3] or [4,5]
     */
    public static int[] twoSumsUsingMap(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int index[] = null;
        if(nums != null){
            index = new int[2];
            int len = nums.length;
            for(int i=0; i<len; i++){
                if(hashMap.containsKey(nums[i])){
                    index[0] = hashMap.get(nums[i])+1;
                    index[1] = i+1;
                }
                hashMap.put(target-nums[i],i);
            }
        }
        return index;
    }
}
