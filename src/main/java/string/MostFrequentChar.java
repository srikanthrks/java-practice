package string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by srikanth.kannan on 6/19/17.
 */
public class MostFrequentChar {
    public static void main(String[] args) {
        Assert.assertEquals('l', getMostFrequentChar("Hello World"));
        Assert.assertEquals('H', getMostFrequentChar("Hello World HH"));
        Assert.assertEquals(0, getMostFrequentChar(""));
        Assert.assertEquals('*', getMostFrequentChar("**123*343"));
    }


    public static char getMostFrequentChar(String inputStr) {
        // check for null or empty string
        char freqChar = 0;
        if (inputStr != null && !inputStr.isEmpty()) {
            Map<Character, Integer> freqMap = new LinkedHashMap<>(); // preserves the order of Key entered
            // iterate  until the length
            char[] charArr = inputStr.toCharArray();
            int len = charArr.length;
            // building the frequency Map for each character in the given STring
            for (int i = 0; i < len; i++) {
                Character key = charArr[i];
                if (freqMap.get(key) == null) { // if the char is not found
                    freqMap.put(key, 1); // it is the first occurrence
                } else { // if the key is present, increment it count by 1
                    freqMap.put(key, freqMap.get(key) + 1);
                }
            }
            Set<Map.Entry<Character, Integer>> entrySet = freqMap.entrySet();
            int max = 0;
            // finding the max frequency
            for (Map.Entry mapEntry : entrySet) {
                int value = (int) mapEntry.getValue();
                if (value >= max) {
                    max = value;
                }
            }
            // finding the first key (Chararcter)  for a given value (frequency)
            for (Map.Entry mapEntry : entrySet) {
                if(Objects.equals(max, mapEntry.getValue())){
                    freqChar = (char) mapEntry.getKey();
                    break;
                }
            }

        }//if
        return freqChar;
    }

    @Test
    public void testMostFrequentChar(){
        Assert.assertEquals('l', getMostFrequentChar("Hello World"));
        Assert.assertEquals('H', getMostFrequentChar("Hello World HH"));
        Assert.assertEquals(0, getMostFrequentChar(""));
        Assert.assertEquals('*', getMostFrequentChar("**123*343"));
    }
}
