import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Created by srikanth.kannan on 7/13/15.
 */
public class MergeSort {
    public static final Logger LOGGER  = LoggerFactory.getLogger(MergeSort.class);

    public static void main(String args[])
    {
        MergeSort mergeSort = new MergeSort();
        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        arrayList1.add(0, 1);
        arrayList1.add(1, 3);
        arrayList1.add(2, 6);

        ArrayList<Integer> arrayList2 = new ArrayList<Integer>(10);
        arrayList2.add(0, 2);
        arrayList2.add(1, 4);
        arrayList2.add(2, 5);

        int[] inputArray = {10,13,5,12,4,6};
        //int[] mergeResult = mergeSort.mergeArrayList(arrayList1, arrayList2);
        mergeSort.mergeSort(inputArray);
        //System.out.print(mergeResult);
    }

    public int[] mergeSort(int[] inputArray){
        int sizeOfArray = inputArray.length;
        if(sizeOfArray <= 1){
            return inputArray;
        }
        int middleIndex = sizeOfArray /2;
        int[] leftHalfArray = new int[middleIndex];
        for(int i =0, k=0; i<middleIndex; i++, k++){
            leftHalfArray[k] = inputArray[i];
        }
        int[] rightHalfArray = new int[sizeOfArray - middleIndex];
        for(int j=middleIndex,k=0; j<sizeOfArray; j++,k++){
            rightHalfArray[k] = inputArray[j];
        }
        mergeSort(leftHalfArray);
        mergeSort(rightHalfArray);
        return mergeArrays(leftHalfArray, rightHalfArray);
    }


    /** Given 2 sorted ArrayLists, merge the results */
    public int[] mergeArrayList(ArrayList<Integer> array1, ArrayList<Integer> array2) {
        //ArrayList<Integer> result = new ArrayList<Integer>();
        int sizeArray1 = array1.size();
        int sizeArray2 = array2.size();
        int totalSize = sizeArray1 + sizeArray2;
        int []result = new int[totalSize];
        int inversionCount =0;
        /** base cases */
        if(array1.isEmpty() && !array2.isEmpty()){
            for(int i = 0; i <sizeArray2; i++){
                result[i] = array2.get(i);
                System.out.println("result[" + i + "] = " + result[i]);
            }
            return result;
        }
        else if(array2.isEmpty() && !array1.isEmpty()){
            for(int i = 0; i <sizeArray1; i++){
                result[i] = array1.get(i);
                System.out.println("result[" + i + "] = " + result[i]);
            }
            return result;
        }
        else if(array1.isEmpty()  && array2.isEmpty() ){
            return null;
        } /** base cases */
        else {
            for (int k = 0, i = 0, j = 0; k < totalSize; k++) {
                /** if the left array's value is less than the right array's value  */
                if (i < sizeArray1 && j < sizeArray2) {
                    if (array1.get(i) <= array2.get(j)) {
                        result[k] = array1.get(i);
                        //result.add(k, array1.get(i));
                        i++;
                    } else {
                        result[k] = array2.get(j);
                        j++;
                        inversionCount = inversionCount + (sizeArray1 - i);
                        System.out.println("inversionCount = " + inversionCount);
                    }
                } else if (j >= sizeArray2) { // if the array2 is exhausted, copy from array 1
                    result[k] = array1.get(i);
                    i++;
                } else if (i >= sizeArray1) { // if the array1 is exhausted, copy from array 2
                    result[k] = array2.get(j);
                    j++;
                }
                System.out.println("result[" + k + "] = " + result[k]);
                LOGGER.info("result[" + k + "] = " + result[k]);
            }//for
        }
        return result;
    }//mergeArrayList

    public int[] mergeArrays(int[] array1, int[] array2) {
        //ArrayList<Integer> result = new ArrayList<Integer>();
        int sizeArray1 = array1.length;
        int sizeArray2 = array2.length;
        int totalSize = sizeArray1 + sizeArray2;
        int []result = new int[totalSize];
        int inversionCount =0;
        /** base cases */
        if(array1.length == 0 && array2.length > 0){
            for(int i = 0; i <sizeArray2; i++){
                result[i] = array2[i];
                System.out.println("result[" + i + "] = " + result[i]);
            }
            return result;
        }
        else if(array2.length == 0 && array1.length > 0){
            for(int i = 0; i <sizeArray1; i++){
                result[i] = array1[i];
                System.out.println("result[" + i + "] = " + result[i]);
            }
            return result;
        }
        else if(array1.length == 0  && array2.length == 0 ){
            return null;
        } /** base cases */
        else {
            for (int k = 0, i = 0, j = 0; k < totalSize; k++) {
                /** if the left array's value is less than the right array's value  */
                if (i < sizeArray1 && j < sizeArray2) {
                    if (array1[i] <= array2[j]) {
                        result[k] = array1[i];
                        //result.add(k, array1.get(i));
                        i++;
                    } else {
                        result[k] = array2[j];
                        j++;
                        inversionCount = inversionCount + (sizeArray1 - i);
                        System.out.println("inversionCount = " + inversionCount);
                    }
                } else if (j >= sizeArray2) { // if the array2 is exhausted, copy from array 1
                    result[k] = array1[i];
                    i++;
                } else if (i >= sizeArray1) { // if the array1 is exhausted, copy from array 2
                    result[k] = array2[j];
                    j++;
                }
                System.out.println("result[" + k + "] = " + result[k]);
                LOGGER.info("result[" + k + "] = " + result[k]);
            }//for
        }
        return result;
    }//merge

    public int[] merge(int[] array1, int[] array2, int sizeArray1, int sizeArray2) {
        //ArrayList<Integer> result = new ArrayList<Integer>();
        int totalSize = sizeArray1 + sizeArray2;
        int []result = new int[totalSize];
        int inversionCount =0;
        /** base cases */
        if(array1.length == 0 && array2.length > 0){
            for(int i = 0; i < sizeArray2; i++){
                result[i] = array2[i];
                System.out.println("result[" + i + "] = " + result[i]);
            }
            return result;
        }
        else if(array2.length == 0 && array1.length > 0){
            for(int i = 0; i < sizeArray1; i++){
                result[i] = array1[i];
                System.out.println("result[" + i + "] = " + result[i]);
            }
            return result;
        }
        else if(array1.length == 0  && array2.length == 0 ){
            return null;
        } /** base cases */
        else {
            for (int k = 0, i = 0, j = 0; k < totalSize; k++) {
                /** if the left array's value is less than the right array's value  */
                if (i < sizeArray1 && j < sizeArray2) {
                    if (array1[i] <= array2[j]) {
                        result[k] = array1[i];
                        //result.add(k, array1.get(i));
                        i++;
                    } else {
                        result[k] = array2[j];
                        j++;
                        inversionCount = inversionCount + (sizeArray1 - i);
                        System.out.println("inversionCount = " + inversionCount);
                    }
                } else if (j >= sizeArray2) { // if the array2 is exhausted, copy from array 1
                    result[k] = array1[i];
                    i++;
                } else if (i >= sizeArray1) { // if the array1 is exhausted, copy from array 2
                    result[k] = array2[j];
                    j++;
                }
                System.out.println("result[" + k + "] = " + result[k]);
                LOGGER.info("result[" + k + "] = " + result[k]);
            }//for
        }
        return result;
    }//merge
}
