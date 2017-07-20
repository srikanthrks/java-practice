package codefights.generics;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * Created by srikanth.kannan on 5/31/16.
 */
public class GenericMapExample {
    public static void main(String args[]){
        Map<String, Object> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", "String");
        map.put("key3", 1.0);
        map.put("key4", 1);
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        System.out.println("map.entrySet = " + entrySet);
        for(Map.Entry entry: entrySet){
            System.out.println("key = " + entry.getKey());
            System.out.println("value = "+ entry.getValue().getClass());
        }
        compareTypes(map.get("key1"), map.get("key4"));
        System.out.format("%10.3f%n", Math.PI);   // -->  "     3.142"
    }

    /**
     * compareTypes two Objects types
     * @param a
     * @param b
     * @return
     */
    private static boolean compareTypes(Object a, Object b){
        boolean result = false;
        if(a == null || b == null){
            return false;
        }
        Class<?> aClass = a.getClass();
        Class<?> bClass = b.getClass();
        if(aClass.toString().equals(bClass.toString())){
            result = true;
            System.out.println("Object a of type " +aClass.toString() + " is = Object b of type " + bClass.toString() );
        }
        else{
            System.out.println("Object a of type " +aClass + " is != Object b of type " + bClass );
        }
        return result;
    }

    private static boolean compareMultimaps(Multimap<String, String> multimap1, Multimap<String, String> multimap2, int roundingPlaces,
                                            int roundingMode){
        boolean overallResult = true;
        if(multimap1.size() != multimap2.size()){
            System.out.println(">>>>> Multimaps are not equal. Will still try to match the common keys in both");
            //return false;
        }
        Set<String> keySet1 = multimap1.keySet();
        for(String key : keySet1){//iterating of one multimap
            //Iterator valuesIterator = multimap1.get(key).iterator();
            List<String> valuesForKeyMap1 = (List<String>) multimap1.get(key);
            List<String> valuesForKeyMap2 = (List<String>) multimap2.get(key);
            int valuesSizeForKeyMap1 = valuesForKeyMap1.size();
            int valuesSizeForKeyMap2 = valuesForKeyMap2.size();
            if(valuesSizeForKeyMap2 > 0 && valuesSizeForKeyMap1 == valuesSizeForKeyMap2){// to ensure the key has some values in multimap2
                for(int i=0; i <valuesSizeForKeyMap1; i++){
                    String value1 = valuesForKeyMap1.get(i);
                    String value2 = valuesForKeyMap2.get(i);
                    boolean thisResult;
                    if(value1.contains(".")){//to identify a floating/Double
                        BigDecimal bigDecimal1 = new BigDecimal(value1).setScale(roundingPlaces, BigDecimal.ROUND_HALF_UP);
                        BigDecimal bigDecimal2 = new BigDecimal(value2).setScale(roundingPlaces, BigDecimal.ROUND_HALF_UP);
                        int compareResult = bigDecimal1.compareTo(bigDecimal2);
                        thisResult = compareResult == 0 ? true : false;
                        System.out.println(key + " = " + bigDecimal1 + " | " + bigDecimal2 + " | compareResult = " + thisResult);
                    }
                    else{
                        thisResult = value1.equals(value2);
                        System.out.println(key + " = " + value1 + " | " + value2 + " | compareResult = " + thisResult);
                    }
                    overallResult = overallResult && thisResult;
                }//for
            }
            else{
                System.out.println(">>>>> values which do not match for " + key);
                System.out.println("multimap1[" + key + "] values = " + valuesForKeyMap1);
                System.out.println("multimap2[" + key + "] values = " + valuesForKeyMap2);
            }
        }
        return overallResult;
    }

    @Test
    public void testCompareMultiMap(){
        Multimap<String, String> multimap1 = ArrayListMultimap.create();
        multimap1.put("key1", "123.40001");
        multimap1.put("key1", "234.50");
        multimap1.put("key2", "some");
        //multimap1.put("key3", "5");
        Multimap<String, String> multimap2 = ArrayListMultimap.create();
        multimap2.put("key1", "123.4");
        multimap2.put("key1", "234.51");
        multimap2.put("key2", "some");
        //multimap2.put("key3", "5");
        System.out.println("result = " + compareMultimaps(multimap1, multimap2, 2, BigDecimal.ROUND_HALF_UP));
    }
}
