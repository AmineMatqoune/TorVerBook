package logic.utils;

public class TestUtils {

	private TestUtils() {
	}

	public static boolean isRunningTest() {
		Boolean isRunningTest = true;
		try {
			Class.forName("org.junit.Test");
		} catch (ClassNotFoundException e) {
			isRunningTest = false;
		}
		return isRunningTest;
	}

}
