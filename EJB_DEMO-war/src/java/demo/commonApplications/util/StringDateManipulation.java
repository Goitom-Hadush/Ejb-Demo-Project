package et.gov.insa.erp.commonApplications.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author INSA
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringDateManipulation {

    private static long currentYear, currentMonth, currentDate;
    private static final long year1999 = 1999, year1999_1stDate = 1, year1999_1stMonth = 1;

    /**
     * Creates a new instance of StringDateManipulation
     */
    public StringDateManipulation() {
    }

    /**
     * Changes the current date in GC to String format yyyy-MM-dd
     *
     * @return returns the java.util.Date() as yyyy-MM-dd
     */
    public static String currentDateInGC() {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date curDate = new java.util.Date();
        return format.format(curDate);
    }

    public static String currentYearInGC() {
        DateFormat format = new SimpleDateFormat("yyyy");
        java.util.Date curYear = new java.util.Date();

        return format.format(curYear);
    }

    public static String arrangeDateFormat(String _date) {
        String day = _date.replace("/", "-").substring(0, _date.replace("/", "-").indexOf('-'));
        String month = _date.replace("/", "-").substring(_date.replace("/", "-").indexOf('-') + 1, _date.replace("/", "-").lastIndexOf('-'));
        String year = _date.replace("/", "-").substring(_date.replace("/", "-").lastIndexOf('-') + 1);
        _date = year + "-" + month + "-" + day;
        return _date;
    }

    /**
     * Calls the method toDayInEc(currentDateInGC())
     *
     * @return toDayInEc(currentDateInGC())
     * @see #currentDateInGC()
     * @see #todayInEC(String todayInGC)
     */
    public static String todayInEC() throws ParseException {
        return todayInEC(currentDateInGC());
    }

    /**
     * reads the date of the client machien and change it to Ethiopian date
     *
     * @param todayInGC the current date in GC
     * @return returns the current date in EC with 'yyyy-MM-dd' format
     *
     */
    public static String todayInEC(String todayInGC) throws ParseException {

        long noYear;
        currentYear = year1999;     // starting date's year
        currentMonth = year1999_1stMonth;
        currentDate = year1999_1stDate;

        /**
         * number of milliseconds Date.valueOf(todayInGC).getTime() returns the
         * MilliSecond of current date Date.valueOf("2006-09-11").getTime()
         * returns the MilliSecond of 2006-09-11 date which is Meskerm
         * 01/01/2006 in EC and Calculate the difference
         */
        java.sql.Date sqlDate = new java.sql.Date(getParseStringToDate(todayInGC).getTime());
        java.sql.Date sqlDate2 = new java.sql.Date(getParseStringToDate("2006/09/11").getTime());
        long noOfDaysFromStart = sqlDate.getTime() - sqlDate2.getTime();

        /**
         * number of days To calculate number of days the given milliSecond
         * above 1 day = 24hr; 1hr = 60min; 1min = 60sec; 1sec = 1000milsec; by
         * Multiplying 1000 * 60 * 60 * 24 and divide the given milliSecond by
         * them it gives number of date
         */
        noOfDaysFromStart /= (1000 * 60 * 60 * 24);

        /**
         * Move years number of years in the gap Multiplying noOfDaysFromStart
         * by 365.25 0.25 is the lip year
         */
        noYear = (4 * noOfDaysFromStart) / (((4 * 365) + 1));
        currentYear += noYear;

        noOfDaysFromStart = (noOfDaysFromStart - ((noYear * ((4 * 365) + 1)) / 4));

        //Move months
        if ((noOfDaysFromStart % 30) == 0) {
            currentMonth = (noOfDaysFromStart / 30);
        } else {
            currentMonth += (noOfDaysFromStart / 30);
        }

        if ((noOfDaysFromStart % 30) == 0) {
            currentDate = 30;
        } else {
            currentDate += (noOfDaysFromStart % 30);
        }

        String dateString;

        String _dateSeparator = "-";
        String _monthSeparator = "-";
        if (currentDate < 10) {
            _dateSeparator = "-0";
        }
        if (currentMonth < 10) {
            _monthSeparator = "-0";
        }

        dateString = currentYear + _monthSeparator + currentMonth + _dateSeparator + currentDate;

        return dateString;
    }

    public static String addCurrentMonthGC(int nuMonth, String todayInGC) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(format.parse(todayInGC));
        cal.add(Calendar.MONTH, nuMonth);
        return format.format(cal.getTime());
    }

    public static String addMonthGC(int nuMonth, String todayInGC) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy/MM");
        Calendar cal = Calendar.getInstance();
        cal.setTime(format.parse(todayInGC));
        cal.add(Calendar.MONTH, nuMonth - 1);
        return format.format(cal.getTime());
    }

    public static String addCurrentYearGC(int nuMonth, String todayInGC) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(format.parse(todayInGC));
        cal.add(Calendar.YEAR, nuMonth);
        return format.format(cal.getTime());
    }

    public static String addCurrentMonthEC(int nuMonth, String todayInGC) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(format.parse(todayInEC(todayInGC)));
        cal.add(Calendar.MONTH, nuMonth);
        return format.format(cal.getTime());
    }

    public static String addCurrentYearEC(int nuYear, String todayInGC) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(format.parse(todayInEC(todayInGC)));
        cal.add(Calendar.YEAR, nuYear);
        return format.format(cal.getTime());
    }

    public static String getMonthDifference(String startDateInGC, String endDateInGC) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(format.parse(startDateInGC));
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(format.parse(endDateInGC));
        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        return String.valueOf(diffMonth);
    }

    public static String getMonthDiff(String startDateInGC, String endDateInGC) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy/MM");
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(format.parse(startDateInGC));
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(format.parse(endDateInGC));
        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        return String.valueOf(diffMonth + 1);
    }

    public static String getDateDifference(String startDateInGC, String endDateInGC) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(format.parse(startDateInGC));
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(format.parse(endDateInGC));
        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.DATE) - startCalendar.get(Calendar.DATE);
        return String.valueOf(diffMonth);
    }

    public static Date getParseStringToDate(String dateVale) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = format.parse(dateVale);
        return date;
    }

    public static Date getParseStringToMonth(String dateVale) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy/MM");
        Date date = format.parse(dateVale);
        return date;
    }

    public static String getParseDateYearFormat(String dateVale) {
        String resultDate = "";
        try {
            DateFormat format = new SimpleDateFormat("MMMM dd/yyyy");
            resultDate = format.format(getParseStringToDate(dateVale));
            return resultDate;
        } catch (Exception e) {
            return resultDate;
        }

    }

    public static Date getParseStringToDateYearMonth(String dateVale) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy/MM");
        Date date = format.parse(dateVale);
        return date;
    }

    public static String getParseDateFormat(String dateVale) {
        String resultDate = "";
        try {
            DateFormat format = new SimpleDateFormat("MMMM y");
            resultDate = format.format(getParseStringToDateYearMonth(dateVale));
            return resultDate;
        } catch (Exception e) {
            return resultDate;
        }

    }

    public static int compareTwoDate(String dateVale, String dateVale2) {
        int dateStatus = 0;
        try {
            DateFormat format = new SimpleDateFormat("yyyy/MM");
            java.util.Date date1 = format.parse(dateVale);
            java.util.Date date2 = format.parse(dateVale2);
            if (date1.after(date2)) {
                dateStatus = 1;
            } else if (date1.before(date2)) {
                dateStatus = 2;
            } else {
                dateStatus = 0;
            }
        } catch (Exception e) {
        }
        return dateStatus;
    }

    public static int compareYear(Date dateVale) {
        DateFormat format = new SimpleDateFormat("yyyy");
        String resultDate = currentYearInGC();
        if (resultDate.equalsIgnoreCase(format.format(dateVale))) {
            return 1;
        } else {
            return 0;
        }
    }

    public static String subDateToCurrentDateGC(String date, int nuDates) {
        try {
            DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(format.parse(date));
            cal.add(Calendar.MONTH, nuDates);
            return format.format(cal.getTime());
        } catch (Exception e) {
            return null;
        }
    }

    public static String addCurrentDateGC(int nuMonth, String todayInGC) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(format.parse(todayInGC));
        cal.add(Calendar.DATE, nuMonth);
        return format.format(cal.getTime());
    }

    public static String getMonth(String nuMonth) throws ParseException {
        String monthName = "";
        switch (nuMonth) {
            case "01":
                monthName = "January";
                break;
            case "02":
                monthName = "February";
                break;
            case "03":
                monthName = "March";
                break;
            case "04":
                monthName = "April";
                break;
            case "05":
                monthName = "May";
                break;
            case "06":
                monthName = "June";
                break;
            case "07":
                monthName = "July";
                break;
            case "08":
                monthName = "August";
                break;
            case "09":
                monthName = "September";
                break;
            case "10":
                monthName = "October";
                break;
            case "11":
                monthName = "November";
                break;
            case "12":
                monthName = "December";
                break;
        }
        return monthName;

    }
}
