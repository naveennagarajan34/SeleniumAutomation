package steps;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ProjectPage;
import utilities.WebDriverSetup;

public class ProjectsPageStepDefinitions {

	ProjectPage projectObject;
	
	private WebDriver driver; 

	public ProjectsPageStepDefinitions() {
		this.driver = WebDriverSetup.getDriver();
	}

	@And("select the {string} and click connect button")
	public void connectToTheGivenProject(String projectCode) {
		projectObject = new ProjectPage(driver);
		projectObject.connectToTheProject(projectCode);
	}
	
	@And("click on the connected project {string}")
	public void openTheConnectedProject(String projectCode) {
		projectObject = new ProjectPage(driver);
		projectObject.openProject(projectCode);
	}
	
	@Then("verify that the project is connected successfully")
	public void verifyThatProjectIsConnectedSuccessfully() {
		projectObject = new ProjectPage(driver);
		driver = projectObject.verifyProjectIsConnected();
	}
	

}
