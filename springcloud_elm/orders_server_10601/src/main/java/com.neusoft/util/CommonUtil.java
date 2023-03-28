package com.neusoft.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CommonUtil {
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		return sdf.format(calendar.getTime());
	}

	public static String creditsValidDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar nowDate = Calendar.getInstance();
		nowDate.add(Calendar.YEAR, 1);
		return sdf.format(nowDate.getTime());
	}

}