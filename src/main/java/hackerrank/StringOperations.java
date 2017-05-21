package hackerrank;

import java.util.*;

/**
 * Created by srikanth.kannan on 4/9/16.
 */
public class StringOperations {

    public static void main(String args[]){
        //isStringReverse();
        boolean isAnagram = isAnagramUsingTwoMaps("madam", "maadm");
        if(isAnagram) System.out.println("Anagram");
        else System.out.println("Not Anagrams");
        List<String> permutations = getPermutations("world");
        System.out.println("permutations = " + permutations);
    }

    /**
     * Find if the entered String reads the same in reverse. aka palindrome
     */
    //hacker rank - String Reverse
    public static void isStringReverse(){
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        char[] charArr = A.toCharArray();
        System.out.println("string = " + A);
        int length = charArr.length;
        boolean isReverse = true;
        for(int i=0, j=length-1; i < length/2 && j>=length/2 ; i++, j--){
            if(charArr[i] != charArr[j]){
                System.out.println(charArr[i] + "!=" + charArr[j]);
                isReverse = false;
                break;
            }
        }
        if(isReverse)
            System.out.println("Yes");
        else
            System.out.println("No");

    }

    /**
     * This will compare 2 Strings to check if they are Anagrams that is defined as having
     * the same characters in the same frequency.  //hacker rank
     * @param A
     * @param B
     * @return
     */
    static boolean isAnagramUsingTwoMaps(String A, String B) {
        //Complete the function
        if(A == null || B == null){
            return false;
        }
        if(A.length() != B.length()){
            return false;
        }
        char[] charArr1 = A.toLowerCase().toCharArray();
        char[] charArr2 = B.toLowerCase().toCharArray();
        Map<Character,Integer> charMap1 = new HashMap<>();
        Map<Character,Integer> charMap2 = new HashMap<>();
        for(int i=0; i< charArr1.length; i++){
            char key1 = charArr1[i];
            //System.out.println("key1 = " + key1);
            int value1 = (charMap1.get(key1) == null ? 1 : charMap1.get(key1)+1);
            charMap1.put(key1, value1);
            char key2 = charArr2[i];
            //System.out.println("key2 = " + key2);
            int value2 = (charMap2.get(key2) == null ? 1 : charMap2.get(key2)+1);
            charMap2.put(key2, value2);
        }
        System.out.println("charMap1" + charMap1);
        System.out.println("charMap2" + charMap2);
        for(char key : charMap1.keySet()){
            if(charMap1.get(key)!= charMap2.get(key))
                return false;
        }
        return true;
    }

    /** hacker rank
     * This will compare 2 Strings to check if they are Anagrams that is defined as having
     * the same characters in the same frequency
     * Note: same as isAnagramUsingTwoMaps, but uses only one HashMap
     * @param A
     * @param B
     * @return
     */
    public static boolean isAnagramUsingOneMap(String A, String B) {
        //Complete the function
        if(A == null || B == null){
            return false;
        }
        if(A.length() != B.length()){
            return false;
        }
        char[] charArr1 = A.toLowerCase().toCharArray();
        char[] charArr2 = B.toLowerCase().toCharArray();
        Map<Character,Integer> charMap1 = new HashMap<>();
        for(int i=0; i< charArr1.length; i++){
            char key1 = charArr1[i];
            // if the char from the first array is found then add +1 to the value, else assign 1
            int value1 = (charMap1.containsKey(key1) ? charMap1.get(key1)+1 : 1);
            charMap1.put(key1, value1);
            char key2 = charArr2[i];
            // if the char from the second array is found then subtract 1 to the value, else assign -1
            int value2 = (charMap1.containsKey(key2) ? charMap1.get(key2)-1 : -1);
            charMap1.put(key2, value2);
        }
        System.out.println("charMap1 = " + charMap1);
        for(char key : charMap1.keySet()){
            if(charMap1.get(key)!= 0)
                return false;
        }
        return true;
    }

    public static ArrayList<String> getPermutations(String s) {
        ArrayList<String> permutations = new ArrayList<String>();
        if (s == null) { // error case
            return null;
        } else if (s.length() == 0) { // base case
            permutations.add("");
            return permutations;
        }
        char first = s.charAt(0); // get the first character
        String remainder = s.substring(1); // remove the first character
        ArrayList<String> words = getPermutations(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                permutations.add(insertCharAt(word, first, j));
            }
        }
        return permutations;
    }
    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }
}
