package iqschool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 余运基
 * @date 2018-08-28 日期工具类
 * 
 */

public class DateUtil {

	// 今天日期字符串
	public static String todayString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = formatter.format(new Date());
		return dateStr;
	}

	// 今天日期字符串
	public static String todayString2() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = formatter.format(new Date());
		return dateStr;
	}

	// 当前时间 +2小时
	public static String todayString3() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR, 8);
		// 当前时间 +2小时
		String dateStr = formatter.format(calendar.getTime());
		return dateStr;
	}

	// 当前时间 +5分钟
	public static String todayString4() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, 5);
		// 当前时间 +5分钟
		String dateStr = formatter.format(calendar.getTime());
		return dateStr;
	}

	// 当前时间 时分秒
	public static String todayString5() {
		SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
		String dateStr = formatter.format(new Date());
		return dateStr;
	}
	// 当前时间+10秒
	public static String todayString6() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.SECOND, 10);
		// 当前时间 +5分钟
		String dateStr = formatter.format(calendar.getTime());
		return dateStr;
	}
	
	// 今天日期字符串
	public static String today() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = formatter.format(new Date());
		return dateStr;
	}

	// 明天 日期字符串
	public static String tomorrow() {
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 1);
		// 明天
		String tomorrow = formatter2.format(calendar.getTime());
		return tomorrow;
	}

	// 后天 日期字符串
	public static String afterTomorrow() {
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 2);

		// 后天
		String afterTomorrow = formatter2.format(calendar.getTime());
		return afterTomorrow;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(todayString());
		System.out.println(todayString3());
		System.out.println(todayString6());

	}

}
