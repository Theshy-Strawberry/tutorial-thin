package jp.terasoluna.thin.tutorial.web.common.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class GetWorkDay {

    public static int workDays(String start, String end, List<Date> listHolidays){
        int resultCount = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        start = start + " " + "00:00:00";
        end = end + " " + "24:00:00";
        Date datestart = null;
        Date dateend = null;

        Calendar sdate = Calendar.getInstance();
        Calendar edate = Calendar.getInstance();
        Calendar bsdate = Calendar.getInstance();
        Calendar aedate = Calendar.getInstance();

        try {
            datestart = sdf.parse(start);
            dateend = sdf.parse(end);

            sdate.setTime(datestart);
            edate.setTime(dateend);
            bsdate.setTime(datestart);
            aedate.setTime(dateend);

            Calendar date1 = getNextMonday(sdate);
            Calendar date2 = getNextMonday(edate);

            int bfcount = getDaysBetween(bsdate,date1) - 2;
            if(bfcount < 0){
                bfcount = 0;
            }
            int afcount = getDaysBetween(aedate,date2) - 2;
            if(afcount < 0){
                afcount = 0;
            }
            int count = getDaysBetween(date1,date2);

            count = count / 7 * 5;

            int holidays = getHolidaysInMillis(start, end, listHolidays);

            resultCount = count + bfcount - afcount - holidays;


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultCount;
    }

    /**
     * 根据传入的当前时间计算下一个周一
     * @param cal
     * @return
     */
    private static Calendar getNextMonday(Calendar cal) {
        int addnum = 9 - cal.get(Calendar.DAY_OF_WEEK);
        if (addnum == 8)
            // 将周日设为1
            addnum = 1;
        cal.add(Calendar.DATE, addnum);
        return cal;
    }

    /**
     * 根据传入的开始与结束时间计算两个日期之间的实际天数，支持跨年
     * @param start
     * @param end
     * @return
     */
    public static int getDaysBetween(Calendar start, Calendar end) {
        if (start.after(end)) {
            Calendar swap = start;
            start = end;
            end = swap;
        }
        int days = end.get(Calendar.DAY_OF_YEAR) - start.get(Calendar.DAY_OF_YEAR);
        int y2 = end.get(Calendar.YEAR);
        if (start.get(Calendar.YEAR) != y2) {
            start = (Calendar) start.clone();
            do {
                days += start.getActualMaximum(Calendar.DAY_OF_YEAR);
                start.add(Calendar.YEAR, 1);
            } while (start.get(Calendar.YEAR) != y2);
        }
        return days;
    }

    /**
     * 根据传入的日期和假期一览获取这段时间的假期天数
     * @param start
     * @param end
     * @param listHolidays
     * @return
     */
    private static int getHolidaysInMillis(String start, String end,
            List<Date> listHolidays) {
        if (listHolidays == null)
            return new Integer(0);
        Iterator<Date> iterator = listHolidays.iterator();
        int daysofH = 0;
        while (iterator.hasNext()) {
            Date hdate = iterator.next();
            String holiday = DateController.getDateToString(hdate,"yyyy/MM/dd HH:mm:ss");
            if(holiday.compareTo(start) >= 0 && holiday.compareTo(end) <= 0){
                daysofH = daysofH + 1;
            }
        }
        /*

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date datestart = null;
        Date dateend = null;
        Calendar scalendar = Calendar.getInstance();
        Calendar ecalendar = Calendar.getInstance();
        int daysofH = 0;
        try {
            datestart = sdf.parse(start);
            dateend = sdf.parse(end);
            scalendar.setTime(datestart);
            ecalendar.setTime(dateend);

            if (listHolidays == null)
                return new Integer(0);
            Iterator<Date> iterator = listHolidays.iterator();
            while (iterator.hasNext()) {
                Calendar ca = Calendar.getInstance();
                Date hdate = iterator.next();
                ca.setTime(hdate);
                if (ca.after(scalendar) && ca.before(ecalendar)) {
                    daysofH = daysofH + 1;
                } else if (ca.getTimeInMillis() == scalendar.getTimeInMillis()) {
                    daysofH = daysofH + 1;
                } else if (ca.getTimeInMillis() == ecalendar.getTimeInMillis()) {
                    daysofH = daysofH + 1;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new Integer(0);
        }*/
        return daysofH;
    }

    /**
     * 取得年月YYYY/MM
     */
    public static String getYearMonth(String date){

        String ym = "";
        if(date != null){
            String[] date1 = date.split("/");
            if(date1[1].length() == 1){
                date1[1] = "0" + date1[1];
            }
            ym = date1[0] + "/" + date1[1];
        }
        return ym;
    }

    /**
     * 取得该月的最后一天
     * @param datestr
     * @param format
     * @return
     */
    public static int maxDays(String datestr,String format){
        int maxday = 0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            date = sdf.parse(datestr);
            Calendar sdate = Calendar.getInstance();
            sdate.setTime(date);
            maxday = sdate.getActualMaximum(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return maxday;
    }

    /**
     * 取得年月日
     * @param datestr
     * @return
     */
    public static String getYearMonthDay(String datestr){
        String[] date = null;
        if(datestr != null){
            date = datestr.split(" ");
        }
        return date[0];
    }

    /**
     * 取得时分秒
     * @param datestr
     * @return
     */
    public static String getHms(String datestr){
        String[] date = null;
        if(datestr != null){
            date = datestr.split(" ");
        }
        return date[1];
    }

    /**
     * 返回标准的时分秒
     * @param datestr
     * @return
     */
    public static String getBztime(String datestr){
        String str = "";
        if(datestr != null){
            String[] time = datestr.split(" ");
            String time1 = time[1];
            if(time1 != null){
                String[] time2 = time1.split(":");
                String time3 = time2[0];
                if(time3.length() == 1){
                    time3 = "0" + time3;
                }
                str = time3 + ":" + time2[1] + ":" + time2[2];
            }

        }
        return str;
    }

    /**
     * 取得下一个月
     * @param datestr
     * @return
     */
    public static String getNextMonth(String datestr){

        String dateStr = "";
        if(datestr != null){
            Date datestart = null;
            Calendar sdate = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
            try {
                datestart = sdf.parse(datestr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            sdate.setTime(datestart);
            sdate.add(Calendar.MONTH, +1);
            dateStr = sdf.format(sdate.getTime());
        }
        return dateStr;
    }
    /**
     * 取得前一个月
     * @param datestr
     * @return
     */
    public static String getBeforeMonth(String datestr){

        String dateStr = "";
        if(datestr != null){
            Date datestart = null;
            Calendar sdate = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
            try {
                datestart = sdf.parse(datestr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            sdate.setTime(datestart);
            sdate.add(Calendar.MONTH, -1);
            dateStr = sdf.format(sdate.getTime());
        }
        return dateStr;
    }
    /**
     * 取得下一天
     * @param datestr
     * @return
     */
    public static String getNextDay(String datestr){

        String dateStr = "";
        if(datestr != null){
            Date datestart = null;
            Calendar sdate = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            try {
                datestart = sdf.parse(datestr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            sdate.setTime(datestart);
            sdate.add(Calendar.DAY_OF_YEAR, +1);
            dateStr = sdf.format(sdate.getTime());
        }
        return dateStr;
    }
}