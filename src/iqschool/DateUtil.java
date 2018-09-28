package iqschool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ���˻�
 * @date 2018-08-28 ���ڹ�����
 * 
 */

public class DateUtil {

	// ���������ַ���
	public static String todayString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = formatter.format(new Date());
		return dateStr;
	}

	// ���������ַ���
	public static String todayString2() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = formatter.format(new Date());
		return dateStr;
	}

	// ��ǰʱ�� +2Сʱ
	public static String todayString3() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR, 8);
		// ��ǰʱ�� +2Сʱ
		String dateStr = formatter.format(calendar.getTime());
		return dateStr;
	}

	// ��ǰʱ�� +5����
	public static String todayString4() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, 5);
		// ��ǰʱ�� +5����
		String dateStr = formatter.format(calendar.getTime());
		return dateStr;
	}

	// ��ǰʱ�� ʱ����
	public static String todayString5() {
		SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
		String dateStr = formatter.format(new Date());
		return dateStr;
	}
	// ��ǰʱ��+10��
	public static String todayString6() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.SECOND, 10);
		// ��ǰʱ�� +5����
		String dateStr = formatter.format(calendar.getTime());
		return dateStr;
	}
	
	// ���������ַ���
	public static String today() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = formatter.format(new Date());
		return dateStr;
	}

	// ���� �����ַ���
	public static String tomorrow() {
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 1);
		// ����
		String tomorrow = formatter2.format(calendar.getTime());
		return tomorrow;
	}

	// ���� �����ַ���
	public static String afterTomorrow() {
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 2);

		// ����
		String afterTomorrow = formatter2.format(calendar.getTime());
		return afterTomorrow;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(todayString());
		System.out.println(todayString3());
		System.out.println(todayString6());

	}

}
