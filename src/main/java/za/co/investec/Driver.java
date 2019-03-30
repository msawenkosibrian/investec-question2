package za.co.investec;

import java.io.File;

public class Driver {
	
	public static void main(String[] args) {
		
		ClassLoader classLoader = Driver.class.getClassLoader();
		File file = new File(classLoader.getResource("addresses.json").getFile());
		
		

	}
}
