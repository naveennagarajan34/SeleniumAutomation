package runner;

import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
	    features = "src/test/resources/features", // Directory instead of single file
	    glue = {"steps", "utilities"}, // Order matters - steps first
	    plugin = { 
	        "pretty",
	        "html:target/cucumber-reports.html",
	        "json:target/cucumber-reports.json",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    },
	    tags = "@DOK_106 or @DOK_107",
	    monochrome = true
	)
	public class RunnerClass extends AbstractTestNGCucumberTests {
	    @BeforeClass
	    public static void setup() {
	        System.setProperty("cucumber.publish.quiet", "true");
	    }
	}
