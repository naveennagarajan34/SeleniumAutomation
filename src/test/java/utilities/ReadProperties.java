package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

	public String getProperty(String key) {
		Properties prop = new Properties();
		String value;
		try {
			FileInputStream fileInputStream = new FileInputStream("configuration.properties");
			prop.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		value = prop.getProperty(key);
		return value;
	}
}
