package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserClass {

	public WebDriver openBrowser(WebDriver driver, String browser) { // later need to implement headless mode
		String driverPath = "src/test/Resources/drivers";
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless");
			System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
	        options.addArguments("--headless");
			System.setProperty("webdriver.edge.driver", driverPath + "/msedgedriver.exe");
			driver = new EdgeDriver(options);
		}
//		driver.manage().window().maximize();
		return driver;
	}
}
