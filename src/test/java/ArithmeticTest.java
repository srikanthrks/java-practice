
import org.junit.Assert;
import org.testng.annotations.Test;

public class ArithmeticTest {

    @Test
    public void testFareEstimator() throws Exception {
    }


    @Test
    public void testIsSorted(){
        Assert.assertTrue(Arithmetic.isSorted(12345));
        Assert.assertFalse(Arithmetic.isSorted(92345));
        Assert.assertTrue(Arithmetic.isSorted(00000));
        Assert.assertFalse(Arithmetic.isSorted(12321));
    }

}