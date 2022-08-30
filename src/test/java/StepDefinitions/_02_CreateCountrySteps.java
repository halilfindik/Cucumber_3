package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CreateCountrySteps {
    LeftNav leftNav=new LeftNav();
    DialogContent dialogContent=new DialogContent();

    @And("Navigate to Country Page")
    public void navigateToCountryPage() {
        leftNav.findAndClick("setupOne");
        leftNav.findAndClick("parameters");
        leftNav.findAndClick("countries");
    }

    @When("Create a country")
    public void createACountry() {
        String randomGenName= RandomStringUtils.randomAlphabetic(8);
        String randomGenCode= RandomStringUtils.randomAlphanumeric(4);

        dialogContent.findAndClick("addButton");
        dialogContent.findAndSend("nameInput",randomGenName);
        dialogContent.findAndSend("codeInput",randomGenCode);
        dialogContent.findAndClick("saveButton");
    }
    @Then("Success message should be displayed")
    public void successMessageDisplayed() {
        dialogContent.findAndContainsText("successMessage","success");
    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code) {
        dialogContent.findAndClick("addButton");
        dialogContent.findAndSend("nameInput",name);
        dialogContent.findAndSend("codeInput",code);
        dialogContent.findAndClick("saveButton");
    }
}
