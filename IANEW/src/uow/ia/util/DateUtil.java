/**
 * 
 */
package uow.ia.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.sun.org.glassfish.external.statistics.Statistic;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.javaIdentifierType;

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
	
	/**
	 * @author Quang
	 * 01/09/2014 modified to throw back null if date is either "" or null
	 * @param date
	 * @return Date
	 * @throws ParseException
	 */
	public static Date yyyymmddDate(String date) throws ParseException {
		if(date.equals("") || date == null || date.isEmpty()){
			return null;
		}
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
	
	
	/**
	 * for saving
	 * @author Kim To
	 * 
	 */
	public static java.sql.Date ddmmyyyySqlDate(String date) throws ParseException {
		java.sql.Date sqlDate = null;
		java.util.Date utilDate = ddmmyyyyDate(date);
		if (utilDate != null) {
			sqlDate = new java.sql.Date(utilDate.getTime());
		} else {
			return null;
		}
		
		return sqlDate;
	}
	
	/**
	 * @author Kim To
	 */
	public static java.sql.Date yyyymmddSqlDate(String date) throws ParseException {
		java.sql.Date sqlDate = null;
		java.util.Date utilDate = yyyymmddDate(date);
		if (utilDate != null) {
			sqlDate = new java.sql.Date(utilDate.getTime());
		} else {
			return null;
		}
		
		return sqlDate;
	}
}
