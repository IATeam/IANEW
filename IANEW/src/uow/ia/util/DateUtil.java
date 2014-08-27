/**
 * 
 */
package uow.ia.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author ZhiYu Yang
 * @date 14/08/2014
 *
 */
public class DateUtil {
	
	private static String dateString = null;
	private static Date dateDate = null;
	
	public static String yyyymmddStr(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		dateString = formatter.format(date);
		return dateString;
	}
	
	public static String ddmmyyyyStr(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		dateString = formatter.format(date);
		return dateString;
	}
	
	public static Date yyyymmddDate(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		dateDate = formatter.parse(date);
		return dateDate;
	}
	
	public static Date ddmmyyyyDate(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		dateDate = formatter.parse(date);
		return dateDate;
	}
	
	public static Date yyyymmddhhmmssTodayDate() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dateDate = new Date();
		dateDate = formatter.parse(formatter.format(dateDate));
		return dateDate;
	}
	
	public static String yyyymmddhhmmssTodayString() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dateString = formatter.format(dateDate);
		return dateString;
	}
	
}
