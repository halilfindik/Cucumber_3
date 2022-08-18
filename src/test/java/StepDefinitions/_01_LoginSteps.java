package StepDefinitions;

import Pages.DialogContent;
import Utilities.Gwd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _01_LoginSteps {
    DialogContent dc=new DialogContent();

    @Given("Navigate to basqar")
    public void navigateToBasqar() {
        Gwd.getDriver().get("https://demo.mersys.io/");
        Gwd.getDriver().manage().window().maximize();
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {

        WebDriverWait wait=new WebDriverWait(Gwd.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(dc.username));

        dc.findAndSend("username","richfield.edu");
        dc.findAndSend("password","Richfield2020!");
        dc.findAndClick("loginButton");

    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        dc.findAndContainsText("dashboard","Dashboard");
    }
}
