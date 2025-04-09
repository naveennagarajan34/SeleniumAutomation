package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		features = "src/test/resources/features", 		// Path to feature files
		glue = {"utilities", "steps"}, 											// Package containing step definitions
		tags = "@logout",
		plugin = { 
					"pretty", 											// Prints detailed logs in the console
					"html:target/cucumber-reports.html", 				// Generates an HTML report
					"json:target/cucumber-reports.json",				// Generates a JSON report
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		monochrome = true 												// Makes console output more readable
)
public class RunnerClass extends AbstractTestNGCucumberTests{
	
}
