package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by srikanth.kannan on 3/10/16.
 */
public class Anagram {

    //private static final Logger LOGGER = LoggerFactory.getLogger(string.Anagram.class);

    public static void main(String[] args){
        //LOGGER.info("is anagram " + isAnagram("",""));
        //System.out.println("\nis anagram :" + isAnagram("cat", "tac"));
        //System.out.println("\nis Palindrome :" + isStringReverse("nursesrun"));
        //isStringReverse();
        boolean isAnagram = isAnagramUsingOneMap("madam", "mmaadm");
        if(isAnagram) System.out.println("Anagram");
        else System.out.println("Not Anagrams");
    }

    public static boolean isAnagram(String str1, String str2){
        if(str1 == null && str2 == null && str1.length() != str2.length()) {
            return false;
        }
            char[] charArr1 = str1.toCharArray();
            char[] charArr2 = str2.toCharArray();
        Arrays.sort(charArr1);//O(nlogn)
        Arrays.sort(charArr2);
        System.out.println("charArr1");
        for(char c1 : charArr1){
            System.out.print(c1);
        }
        System.out.println("\ncharArr2");
        for(char c2 : charArr2){
            System.out.print(c2);
        }
        return Arrays.equals(charArr1,charArr2);
    }

    /**
     * Case sensitive string reverse check
     * @param str1
     * @return
     */
    public static boolean isStringReverse(String str1){
        if(str1 == null || str1.trim().length() == 0) {
            return false;
        }
        char[] charArr1 = str1.toCharArray();
        int length = str1.length();
        System.out.println(length + "/2 = " + length/2);

        for(int i=0, j=length-1; i < length/2 && j>=length/2 ; i++, j--){
            if(charArr1[i] != charArr1[j])
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
    static boolean isAnagramUsingOneMap(String A, String B) {
        //Complete the function
        if(A == null || B == null && A.length() != B.length())
            return false;
        char[] charArr1 = A.toLowerCase().toCharArray();
        char[] charArr2 = B.toLowerCase().toCharArray();
        Map<Character,Integer> charMap1 = new HashMap<>();
        for(int i=0; i< charArr1.length; i++){
            char key1 = charArr1[i];
            //System.out.println("key1 = " + key1);
            int value1 = (charMap1.get(key1) == null ? 1 : charMap1.get(key1)+1);
            charMap1.put(key1, value1);
            char key2 = charArr2[i];
            //System.out.println("key2 = " + key2);
            int value2 = (charMap1.get(key2) == null ? -1 : charMap1.get(key2)-1);
            charMap1.put(key2, value2);
        }
        System.out.println("charMap1 = " + charMap1);
        for(char key : charMap1.keySet()){
            if(charMap1.get(key)!= 0)
                return false;
        }
        return true;
    }

}
