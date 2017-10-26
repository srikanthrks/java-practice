import java.util.Hashtable;
import java.util.Map;

/**
 * Created by srikanth.kannan on 9/12/17.
 */
public class CompositeKey {
    public static void main(String[] args) {

        Map<myKey, Double> compositeKeyMap = new Hashtable<>();
        myKey myKey1 = new myKey("key1", "key1.1", 1.02343);
        myKey myKey2 = new myKey("key2", "key2.1", 2.03434);
        compositeKeyMap.put(myKey1, myKey1.value);
        compositeKeyMap.put(myKey2, myKey2.value);
        System.out.println("compositeKeyMap = " + compositeKeyMap);
        System.out.println("mykey1 = " + myKey1 + " value = " + compositeKeyMap.get(myKey1));
    }

    static class myKey{

        @Override public String toString() {
            return "myKey{" +
                    "key1='" + key1 + '\'' +
                    ", key2='" + key2 + '\'' +
                    ", value='" + String.format("%.2f", value) + '\'' +
                    '}';
        }

        private String key1;
        private String key2;
        private double value;

        public myKey(String key1, String key2, double value){
            this.key1 = key1;
            this.key2 = key2;
            this.value = value;
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            myKey myKey = (myKey) o;

            if (Double.compare(myKey.getValue(), getValue()) != 0)
                return false;
            if (getKey1() != null ? !getKey1().equals(myKey.getKey1()) : myKey.getKey1() != null)
                return false;
            return getKey2() != null ? getKey2().equals(myKey.getKey2()) : myKey.getKey2() == null;
        }

        @Override public int hashCode() {
            int result;
            long temp;
            result = getKey1() != null ? getKey1().hashCode() : 0;
            result = 31 * result + (getKey2() != null ? getKey2().hashCode() : 0);
            temp = Double.doubleToLongBits(getValue());
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        public String getKey1() {
            return key1;
        }

        public void setKey1(String key1) {
            this.key1 = key1;
        }

        public String getKey2() {
            return key2;
        }

        public void setKey2(String key2) {
            this.key2 = key2;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
}
