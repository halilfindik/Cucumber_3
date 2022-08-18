package FeatureFiles;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
        dialogContent.findAndClick("addCountryButton");
        dialogContent.findAndSend("newCountryNameInput","Turks and Caicos Islands");
        dialogContent.findAndSend("newCountryCodeInput","TCI");
        dialogContent.findAndClick("newCountrySaveButton");
    }
    @Then("Success message should be displayed")
    public void successMessageDisplayed() {
        dialogContent.findAndContainsText("countryAddSuccessMessage","Country successfully created");
    }
}
