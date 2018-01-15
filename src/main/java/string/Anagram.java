package string;

import java.util.*;

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
//        boolean isAnagram = isAnagramUsingOneMap("madam", "mmaadm");
//        if(isAnagram) System.out.println("Anagram");
//        else System.out.println("Not Anagrams");
        //System.out.println("isPalindrome = " + isPalindrome("madam", "mmaad"));
        System.out.println("make Anagram = " + numberNeededToMakeAnagram2("cdesd", "aaaaa"));

    }

    /**
     * This method finds if 2 strings are anagrams by  converting them to a character array
     * and comparing the sorted versions of both the arrays. Thus it's run time is O(n.logn)
     * @param str1
     * @param str2
     * @return
     */
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

    public static boolean  isPalindrome(String someStr1, String someStr2){
        boolean result = true;
        if(someStr1 != null && !someStr1.isEmpty() && someStr2 !=null && !someStr2.isEmpty()){
            char[] charArray1 = someStr1.toCharArray();
            char[] charArray2 = someStr2.toCharArray();
            HashMap<Character, Integer> charFreqHashMap = new HashMap<>();
            for(char c : charArray1){
                if(!charFreqHashMap.containsKey(c)){
                    charFreqHashMap.put(c,1); // if a char is not found add it
                }
                else{
                    int freq = charFreqHashMap.get(c);
                    charFreqHashMap.put(c, freq+1);// if a char is found again then add 1
                }
            }
            for(char c : charArray2){
                if(!charFreqHashMap.containsKey(c)){
                    return false;
                }
                else{
                    int freq = charFreqHashMap.get(c);
                    charFreqHashMap.put(c, freq-1);// if a char is found again then add 1
                }

            }
            Set<Character> keySet = charFreqHashMap.keySet();
            for (Character character : keySet) {
                if(charFreqHashMap.get(character) !=0 ){
                    return false;
                }
            }
        }
        return result;
    }

    /** hackerRank: Make Anagrams
     * The method will return the number of characters that needs to be deleted to make them an anagram
     * @param first
     * @param second
     * @return
     */
    public static int numberNeededToMakeAnagram(String first, String second) {
        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();
        int deleteCount = 0;
        Map<Character, Integer> map1 = new Hashtable<>();
        int temp =0;
        for(char c : firstArr){
            temp = map1.containsKey(c) ? map1.get(c)+1: 1;
            map1.put(c, temp);
        }
        for(char c : secondArr) {
            temp = map1.containsKey(c) ? map1.get(c) - 1 : -1;
            map1.put(c, temp);
        }
        Set<Character> keySetAll = map1.keySet();
        for(char key : keySetAll){//for all the keys
            deleteCount += Math.abs(map1.get(key));
        }
        return deleteCount;
    }

    public static int numberNeededToMakeAnagram2(String first, String second) {
        int deleteCount = 0;
        char[] firstArray = first.toLowerCase().toCharArray();
        char[] secondArray = second.toLowerCase().toCharArray();
        int [] freqArr = new int[26];//alphabets
        for(char c : firstArray){
            freqArr[c - 'a'] ++; // increase the count of the character. 'c' - 'a' = (99 - 97) ASCII value
        }
        for(char c : secondArray){
            freqArr[c - 'a'] --; // decrease the count of the character
        }
        for(int charFreq : freqArr){
            deleteCount += Math.abs(charFreq); // get the absolute value of the frequency
        }
        return deleteCount;
    }

}
