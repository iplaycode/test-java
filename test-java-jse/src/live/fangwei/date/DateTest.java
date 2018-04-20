package live.fangwei.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateTest {

    /**
     * Method main
     *
     * Hello.It's 2005-03-21
     * 
     * @param args
     *
     */
    public static void main(String[] args) {
        DateTest d = new DateTest();
        d.getDate1();
        d.getDate2();
        System.out.println(d.getTodayDateTime());
        System.out.println(d.getWeek());
    }

    public void getDate1() {
        // String now = new SimpleDateFormat("yyyy-MM-dd E").format(new Date());
        String now = new SimpleDateFormat("yyyy-MM-dd E").format(Calendar.getInstance().getTime());
        System.out.println("Hello.It's " + now);
    }

    public void getDate2() {
        String now = new SimpleDateFormat("yyyy-MM-dd E").format(new Date());
        // String now = new SimpleDateFormat("yyyy-MM-dd
        // E").format(Calendar.getDateTimeInstance());
        System.out.println("Hello.It's " + now);
    }

    public String getTodayDateTime() {
        Calendar calendar = GregorianCalendar.getInstance(Locale.US);
        DateFormat dateFormatter = DateFormat.getDateTimeInstance();
        String dateTime = dateFormatter.format(calendar.getTime());
        return dateTime;
    }

    public String getWeek() {
        Calendar calendar = GregorianCalendar.getInstance(Locale.CHINA);
        DateFormat dateFormatter = DateFormat.getDateInstance();
        String week = dateFormatter.format(calendar.get(GregorianCalendar.DAY_OF_WEEK) + "");
        return week;
    }
}
