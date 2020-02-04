package logic.utils;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateAndTimeUtils {

	public static String getDateString() {
		LocalDate date = getCurrentDate();
		/* The parsed date format is "YYYY-MM-DD" */
		String parsedDate = date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth();
		return parsedDate;
	}

	public static String getTimeString() {
		LocalTime time = getCurrentTime();
		/* The parsed time format is "HH:MM:SS" */
		String parsedTime = time.getHour() + ":" + time.getMinute() + ":" + time.getSecond();
		return parsedTime;
	}

	private static LocalDate getCurrentDate() {
		return LocalDate.now();

	}

	private static LocalTime getCurrentTime() {
		return LocalTime.now();
	}
}
