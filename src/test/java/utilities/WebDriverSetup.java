package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.Scenario;


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
	public void tearDown(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            takeScreenshotOnFailure(scenario);
        }
		if (driver != null) {
			Thread.sleep(Duration.ofSeconds(2));
//			driver.quit();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	private void takeScreenshotOnFailure(Scenario scenario) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String scenarioName = scenario.getName().replaceAll(" ", "_");
        String fileName = scenarioName + "_" + timestamp + ".png";

        String path = System.getProperty("user.dir") + "/screenshots/";
        File screenshotDir = new File(path);
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(path + fileName);

        try {
            FileHandler.copy(src, dest);
            System.out.println("📸 Screenshot saved at: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("❌ Failed to save screenshot: " + e.getMessage());
        }
    }
}
