package datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by srikanth.kannan on 5/9/16. Dropbox
 */
public class PageHitCounter {

    static Map<Long, Integer> hitMap = new HashMap<>();

    public static void main(String args[]){
        PageHitCounter.logHit();

    }

    // called every time someone visits your site
    public static void logHit(){
        long key = System.currentTimeMillis();
        int value = 0 ;
        value = hitMap.get(key)== null ? 0: value++;
        hitMap.put(key, value);
    }

    // returns the number of hits to your site in the last 5 minutes
    public static int getHits(){
        long currTime = System.currentTimeMillis();//currentTime
        int hits = 0;
        long key; int value;
        for(Map.Entry<Long, Integer>entry : hitMap.entrySet()){
            key = entry.getKey();
            if(key < currTime && key > (currTime - 5*60*1000) ){
                value = entry.getValue();
                hits = hits + value;
            }
        }
        return hits;
    }

    private class subClass extends PageHitCounter{

    }

}
