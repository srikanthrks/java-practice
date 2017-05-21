package string;

import hackerrank.StringOperations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnagramTest {
    private String str1;
    private String str2;

    @Before
    public void setUp() throws Exception {
        str1 = "anagram";
        str2 = "margana";
    }

    @Test
    public void testIsAnagramUsingOneMap() throws Exception {
        Assert.assertEquals("Passed" ,true, StringOperations.isAnagramUsingOneMap(str1, str2));
    }
}