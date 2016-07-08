import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * Created by srikanth.kannan on 2/5/16.
 */
public class MultiMapsExample {

    public static void main(String args[]){
        testMultimapEquals();

    }

    public static boolean testMultimapEquals(){
        Multimap<String, Object> arrayListMultimap1 = ArrayListMultimap.create();
        arrayListMultimap1.put("key1", 1);
        Multimap<String, Object> arrayListMultimap2 = ArrayListMultimap.create();
        arrayListMultimap2.put("key1", 1);
        boolean result = arrayListMultimap1.equals(arrayListMultimap2);
        System.out.println("result = " + result);
        return result;
    }

    public boolean compareMultimap(Multimap<String, String> multimap1, Multimap multimap2){
        boolean result = false;
        //check if the multimap1 and multimap2 are not null. If not, then return false
        //get # of keys in multimap1 and multimap2
        //for each key in multimap1,
        //check if key in multimap1 is in multimap2, if not return false
        // the # of values of a key in multimap != # of values in multimap2, if not return false
        // for eachvalue in the key compare the
        return result;
    }
}
