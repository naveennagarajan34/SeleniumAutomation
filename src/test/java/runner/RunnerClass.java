package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/login.feature", 		// Path to feature files
		glue = "utilities", 										// Package containing step definitions
		plugin = { 
					"pretty", 											// Prints detailed logs in the console
					"html:target/cucumber-reports.html", 				// Generates an HTML report
					"json:target/cucumber-reports.json" 				// Generates a JSON report
		},
		monochrome = true 												// Makes console output more readable
)
public class RunnerClass extends AbstractTestNGCucumberTests{
	
}