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
    public WebElement username;

    @FindBy(id="mat-input-1")
    public WebElement password;

    @FindBy(css="button[aria-label='LOGIN']")
    public WebElement loginButton;

    @FindBy(xpath="(//span[contains(text(),'Dashboard')])[2]")
    public WebElement dashboard;

    @FindBy(css = "[class='svg-inline--fa fa-plus']")
    public WebElement addCountryButton;

    @FindBy(css = "[id='ms-text-field-2']>input")
    public WebElement newCountryNameInput;

    @FindBy(css = "[id='ms-text-field-3']>input")
    public WebElement newCountryCodeInput;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement newCountrySaveButton;

    @FindBy(css = "[class='ng-star-inserted']>div")
    public WebElement countryAddSuccessMessage;

    WebElement myElement;
    public void findAndSend(String strElement, String value) {
        switch (strElement)
        {
            case "username"             : myElement=username; break;
            case "password"             : myElement=password; break;
            case "newCountryNameInput"  : myElement=newCountryNameInput; break;
            case "newCountryCodeInput"  : myElement=newCountryCodeInput; break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {
        switch (strElement)
        {
            case "loginButton"          : myElement=loginButton; break;
            case "addCountryButton"     : myElement=addCountryButton; break;
            case "newCountrySaveButton" : myElement=newCountrySaveButton; break;
        }
        clickFunction(myElement);
    }
    public void findAndContainsText(String strElement, String text) {
        switch (strElement)
        {
            case "dashboard" : myElement=dashboard; break;
            case "countryAddSuccessMessage" : myElement=countryAddSuccessMessage; break;
        }
        verifyContainsText(myElement, text);
    }

}
