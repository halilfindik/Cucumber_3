package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _04_CitizenshipSteps {
    LeftNav leftNav=new LeftNav();
    DialogContent dialogContent=new DialogContent();
    @And("Navigate to Citizenship Page")
    public void navigateToCitizenshipPage() {
        leftNav.findAndClick("setupOne");
        leftNav.findAndClick("parameters");
        leftNav.findAndClick("citizenShip"); // sadece bu değişti; bu locator tanımlanacak
    }

    @When("User a Citizenship name as {string} short name as {string}")
    public void userACitizenshipNameAsShortNameAs(String name, String shortName) {
        dialogContent.findAndClick("addCountryButton");
        dialogContent.findAndSend("newCountryNameInput",name);
        dialogContent.findAndSend("shortName",shortName);
        dialogContent.findAndClick("newCountrySaveButton");
    }

    @Then("Already exists message should be displayed")
    public void alreadyExistsMessageShouldBeDisplayed() {
        dialogContent.findAndContainsText("alreadyExists","already exists");
    }

    @And("Click on close button")
    public void clickOnCloseButton() {
        dialogContent.findAndClick("closeDialog");
    }
}
