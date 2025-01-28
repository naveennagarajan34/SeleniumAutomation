package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebDriverSetup {

	static WebDriver driver;
	private BrowserClass browserObject = new BrowserClass();
	private ReadProperties readPropObject = new ReadProperties();

	@Before
	public void setUp() {
		driver = browserObject.openBrowser(driver, readPropObject.getProperty("browser"));
	}

	@After
	public void tearDown() throws InterruptedException {
		if (driver != null) {
			Thread.sleep(Duration.ofSeconds(10));
//			driver.quit();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
