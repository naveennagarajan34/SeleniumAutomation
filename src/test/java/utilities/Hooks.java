package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private ExtentReports extent = ExtentReport.getReporter();
    private ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {
        test = extent.createTest(scenario.getName());
    }

//    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            test.log(Status.FAIL, "Scenario Failed: " + scenario.getName());
            // You can add a screenshot here (if using Selenium)
        } else {
            test.log(Status.PASS, "Scenario Passed: " + scenario.getName());
        }
        extent.flush();
    }
}
