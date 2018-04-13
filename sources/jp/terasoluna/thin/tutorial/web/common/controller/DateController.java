package jp.terasoluna.thin.tutorial.web.common.controller;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateController {

	public static String YMDHMSs = "yyyy-MM-dd HH:mm:ss.S";

	public static String YMDHMSS = "YYYYMMDDHHmmss";

	public static String YYMM = "yyMM";
	public static String YM = "yy/MM";
	public static String YyM = "yyyy/MM";


	/**
	 * Date to String
	 * @author yangfangzheng
	 * */
	public static String getDateToString(Date date, String format){

		String dateStr = null;
		DateFormat sdf = new SimpleDateFormat(format);

		try {
		    dateStr = sdf.format(date);
		} catch (Exception e) {
	        e.printStackTrace();
		}

		return dateStr;
	}
	/**
	 * String to timestamp
	 * @author yangfangzheng
	 * */
	public static Timestamp getStringToTimestamp(String dateString){
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try {
			ts = Timestamp.valueOf(dateString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ts;
	}
    /**
     * String to Date
     * @author yangfangzheng
     */
	public static Date getStringToDate(String dateString,  String format){
		Date date = null;
		try
		{
		    SimpleDateFormat sdf = new SimpleDateFormat(format);
		    date = sdf.parse(dateString);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return date;
	}
}
