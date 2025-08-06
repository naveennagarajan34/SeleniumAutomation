package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	Properties prop = new Properties();
	String filePath = "src/test/resources/config/config.properties";

	public void setProperty(String key, String value) {
		try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
			prop.setProperty(key, value); // Set key-value pairs
			prop.store(outputStream, "Configuration Settings");
			System.out.println("Properties file updated successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred while writing to the properties file: " + e.getMessage());
		}
	}

	public String getProperty(String key) {
		Properties prop = new Properties();
		String value;
		try {
			FileInputStream fileInputStream = new FileInputStream("src/test/resources/config/config.properties");
			prop.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		value = prop.getProperty(key);
		return value;
	}
}
