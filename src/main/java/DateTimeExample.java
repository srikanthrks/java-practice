import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by srikanth.kannan on 1/23/16.
 */
public class DateTimeExample {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String args[]){
        Date date1 = Calendar.getInstance().getTime();
        Calendar calendar2 = Calendar.getInstance(); calendar2.add(Calendar.DATE, -2);
        Date date2 = calendar2.getTime();
        System.out.println("difference = " + findDifference(date1, date2));
        //dateTimeJODA();
        String dateString = getDateString(2017, 06, 10, 10, 0, 0, 0);
        System.out.println(dateString);
    }

    /**
     * return the difference between two jave.util.Date instances in integer
     * @param date1
     * @param date2
     * @return
     */
    public static long findDifference(Date date1, Date date2){
        int diffInt = (int) (date1.getTime() - date2.getTime())/86_400_000;
        return diffInt;
    }

    public static void dateTimeJODA(){
        dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime dateTime = new DateTime(DateTimeZone.getDefault());
        System.out.println("dateTime = " + dateTime.toString(dateTimeFormatter));
    }

    public static String getDateString(int year, int month, int day, int hour, int min, int sec, int millisec){
        DateTime dateTime = new DateTime().withYear(year).withMonthOfYear(month).withDayOfMonth(day).withHourOfDay(hour)
                .withMinuteOfHour(min).withSecondOfMinute(sec).withMillisOfSecond(millisec);
        return dateTime.toString(dateTimeFormatter);

    }
}
