package jdk.date;

import java.util.Calendar;

public class CalendarTime {

    public static void main(String[] args) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        int day = cal.get(java.util.Calendar.DATE);
        int month = cal.get(java.util.Calendar.MONTH) + 1;
        int year = cal.get(java.util.Calendar.YEAR);
        int dow = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int dom = cal.get(java.util.Calendar.DAY_OF_MONTH);
        int doy = cal.get(java.util.Calendar.DAY_OF_YEAR);

        System.out.println("getTime: " + cal.getTime());
        System.out.println("Calendar.DATE: " + day);
        System.out.println("Calendar.MONTH: " + month);
        System.out.println("Calendar.YEAR: " + year);
        System.out.println("Calendar.DAY_OF_WEEK: " + dow);
        System.out.println("DAY_OF_MONTH: " + dom);
        System.out.println("DAY_OF_YEAR: " + doy);
    }
}