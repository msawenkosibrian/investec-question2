package za.co.investec.util;

public final class StringUtils {

	private StringUtils() {}
	
	public static boolean isEmpty(String str) {
		
		if (str == null || str.isEmpty()) {
			return true;
		}
		return false;
	}
}
