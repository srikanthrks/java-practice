package string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hackerrank.StringOperations;

public class AnagramTest {
    private String str1;
    private String str2;
    private String str3;
    private String str4;

    @Before
    public void setUp() throws Exception {
        str1 = "anagram";
        str2 = "margana";
        str3 = "hello";
        str4 = "lynx";
    }

    @Test
    public void testIsAnagramUsingOneMap() throws Exception {
        Assert.assertEquals("Passed" ,true, StringOperations.isAnagramUsingOneMap(str1, str2));
    }

    @Test
    public void testFindNumberNeededToMakeAnagram2(){
        Assert.assertEquals("Passed", 0, Anagram.numberNeededToMakeAnagram2(str1, str2));
        Assert.assertEquals("Passed", 7, Anagram.numberNeededToMakeAnagram2(str3, str4));

    }

}