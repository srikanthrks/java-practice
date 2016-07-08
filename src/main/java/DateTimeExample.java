import java.util.Calendar;
import java.util.Date;

/**
 * Created by srikanth.kannan on 1/23/16.
 */
public class DateTimeExample {

    public static void main(String args[]){
        Date date1 = Calendar.getInstance().getTime();
        Calendar calendar2 = Calendar.getInstance(); calendar2.add(Calendar.DATE, -2);
        Date date2 = calendar2.getTime();
        System.out.println("difference = " + findDifference(date1, date2));
    }
    public static long findDifference(Date date1, Date date2){
        int diffInt = (int) (date1.getTime() - date2.getTime())/86_400_000;
        return diffInt;
    }
}
