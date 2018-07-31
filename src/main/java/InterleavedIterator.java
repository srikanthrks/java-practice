import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * created by srikanth.kannan on 2/12/18
 */
public class InterleavedIterator<E> implements Iterator<E> {
    private List<Iterator<E>> iterList = new ArrayList<>();
    int iterIndex = 0;

    @SuppressWarnings("unchecked")
    public InterleavedIterator(Iterator<E> ... iterators) {
        this.iterList = Arrays.asList(iterators);
    }

    @Override public boolean hasNext() {
        for(Iterator<E> iterator : iterList){
            if(iterator.hasNext()) {
                return true;
            }
        }
        return false;
    }

    @Override public E next() {
        int newIteratorSize = this.iterList.size();
        for(int i = 0; i < newIteratorSize; i++){
            int newIterIndex = (this.iterIndex + i) % newIteratorSize;
            if(iterList.get(newIterIndex).hasNext()){
                E val = iterList.get(newIterIndex).next();
                iterIndex = newIterIndex + 1 % newIteratorSize;
                return val;
            }

        }
        throw new NoSuchElementException();
    }

    @Override public void remove() {

    }

    public static void main(String[] args) {
        Iterator<String> it1 = Arrays.asList("foo", "bar", "cat", "dog").iterator();
        Iterator<String> it2 = Arrays.asList("a", "b").iterator();
        InterleavedIterator<String> inter = new InterleavedIterator<>(it1, it2);
        while (inter.hasNext()){
            String next = inter.next();
            System.out.println(next);
        }

        DateTimeZone dateTimeZone = DateTimeZone.forID("Etc/GMT-5");
        DateTime dateTime  = DateTime.now().withZoneRetainFields(dateTimeZone).withZone(dateTimeZone);
        System.out.println("date = " + dateTime);
    }
}
