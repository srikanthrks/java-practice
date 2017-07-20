package datatypes;

import java.math.BigDecimal;

/**
 * Created by srikanth.kannan on 7/20/17.
 */
public class BigDecimalExample {


    public static void main(String[] args) {
        compareBigDecimal("2889498.7", "2918393.687", 0, 1);

    }

    /**
     * returns  a
     * @param  - String  representation of value1 compared
     * @param value2 - String  representation of value2 compared
     * @param roundingPlacesValuesCompared - number of places after the decimal, if any, in value1 and value2
     * @param thresholdPercentForDiff - threshold that defines the acceptable difference in percentage. 9 means 9%
     * @return - boolean
     */
    public static boolean compareBigDecimal(String value1, String value2, int roundingPlacesValuesCompared, double thresholdPercentForDiff){
        boolean compareResult = false;
        int roundingMode = BigDecimal.ROUND_HALF_UP;
        BigDecimal bigDecimal1 = new java.math.BigDecimal("2889498.7").setScale(roundingPlacesValuesCompared, roundingMode);
        BigDecimal bigDecimal2 = new java.math.BigDecimal("2918393.687").setScale(roundingPlacesValuesCompared, roundingMode);
        double diff = Math.abs(Double.parseDouble(bigDecimal1.subtract(bigDecimal2).toString()));
        System.out.println("diff = " + diff);
        int result = bigDecimal1.compareTo(bigDecimal2);
        int roundingPlacesThreshold = 4;
        double diffPercent1 = 0, diffPercent2 = 0.0;
        if(result < 0){//bigDecimal1 < bigDecimal2
            diffPercent1 = Double.parseDouble(bigDecimal2.subtract(bigDecimal1).
                    divide(bigDecimal2, roundingPlacesThreshold, roundingMode).toString());
            System.out.println("diff % = " + diffPercent1);
        }
        else if (result > 0){//bigDecimal1 > bigDecimal2
            diffPercent2 = Double.parseDouble(bigDecimal1.subtract(bigDecimal1).
                    divide(bigDecimal1, roundingPlacesThreshold, roundingMode).toString());
            System.out.println("diff % = " + diffPercent2);
        }
        else{
            System.out.println("values are equal");
        }
        double thresholdPercent = thresholdPercentForDiff/100;
        if(Math.max(diffPercent1, diffPercent2) > thresholdPercent){
            System.out.println("diff % is > " + thresholdPercentForDiff);
        }
        return compareResult;
    }
}
