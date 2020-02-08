package logic.utils;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateAndTimeUtils {
	
	private DateAndTimeUtils() {}
	
	public static String getDateString() {
		LocalDate date = getCurrentDate();
		/* The parsed date format is "YYYY-MM-DD" */
		return date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth();
	}

	public static String getTimeString() {
		LocalTime time = getCurrentTime();
		/* The parsed time format is "HH:MM:SS" */
		return time.getHour() + ":" + time.getMinute() + ":" + time.getSecond();
	}

	private static LocalDate getCurrentDate() {
		return LocalDate.now();

	}

	private static LocalTime getCurrentTime() {
		return LocalTime.now();
	}
}
