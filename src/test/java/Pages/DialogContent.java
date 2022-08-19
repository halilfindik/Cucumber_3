package Pages;

import Utilities.Gwd;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(Gwd.getDriver(), this);
    }

    @FindBy(id="mat-input-0")
    private WebElement username;

    @FindBy(id="mat-input-1")
    private WebElement password;

    @FindBy(css="button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath="(//span[contains(text(),'Dashboard')])[2]")
    private WebElement dashboard;

    @FindBy(css = "[class='svg-inline--fa fa-plus']")
    private WebElement addCountryButton;

    @FindBy(css = "[id='ms-text-field-2']>input")
    private WebElement newCountryNameInput;

    @FindBy(css = "[id='ms-text-field-3']>input")
    private WebElement newCountryCodeInput;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement newCountrySaveButton;

    @FindBy(xpath = "//*[text()='Country successfully created']")
    private WebElement countryAddSuccessMessageOld;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement countryAddSuccessMessage;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    private WebElement alreadyExists;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDialog;

    WebElement myElement;
    public void findAndSend(String strElement, String value) {
        switch (strElement)
        {
            case "username"             : myElement=username; break;
            case "password"             : myElement=password; break;
            case "newCountryNameInput"  : myElement=newCountryNameInput; break;
            case "newCountryCodeInput"  : myElement=newCountryCodeInput; break;
            case "shortName"            : myElement=shortName; break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {
        switch (strElement)
        {
            case "loginButton"          : myElement=loginButton; break;
            case "addCountryButton"     : myElement=addCountryButton; break;
            case "newCountrySaveButton" : myElement=newCountrySaveButton; break;
            case "closeDialog"          : myElement=closeDialog; break;
        }
        clickFunction(myElement);
    }
    public void findAndContainsText(String strElement, String text) {
        switch (strElement)
        {
            case "dashboard"                : myElement = dashboard; break;
            case "countryAddSuccessMessage" : myElement = countryAddSuccessMessage; break;
            case "alreadyExists"            : myElement = alreadyExists; break;
        }
        verifyContainsText(myElement, text);
    }
}