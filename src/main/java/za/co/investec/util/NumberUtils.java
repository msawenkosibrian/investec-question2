package za.co.investec.util;

public final class NumberUtils {

	private NumberUtils() {}
	
	public static boolean isNumeric(String str) {
		
		
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		try {
			Integer.parseInt(str);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
}
