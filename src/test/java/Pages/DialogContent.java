package Pages;

import Utilities.Gwd;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath="//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath="//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath="//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath="//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priorityInput;

    @FindBy(xpath="//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCodeInput;

    @FindBy(xpath="//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    private WebElement alreadyExists;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDialog;

    @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix ng-tns-c74')]//input)[1]")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteDialogButton;

    @FindBy(xpath = "(//button[@class='consent-give'])[1]")
    private WebElement acceptCookies;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='firstName']//input")
    private WebElement firstNameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='lastName']//input")
    private WebElement lastNameInput;

    @FindBy(xpath = "(//*[contains(@class,'mat-select-arrow-wrapper ng')])[1]")
    private WebElement genderArrow;

    @FindBy(xpath = "(//*[contains(@class,'mat-select-arrow-wrapper ng')])[2]")
    private WebElement employeeTypeArrow;

    @FindBy(xpath = "(//*[contains(@class,'mat-select-arrow-wrapper ng')])[5]")
    private WebElement qualificationArrow;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement emptyOrTeacherOrPersonalID;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[2]")
    private WebElement maleOrSupervisorOrSecondaryTechnicalOrPassport;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[3]")
    private WebElement femaleOrOtherOrBachelorOrBirthCertificate;

    @FindBy(xpath = "//*[@formcontrolname='employeeId']")
    private WebElement employeeIDInput;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[4]")
    private WebElement master;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[5]")
    private WebElement phD;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[6]")
    private WebElement doctorOfScience;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[7]")
    private WebElement professor;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[8]")
    private WebElement aspirant;

    @FindBy(xpath = "(//*[contains(@class,'mat-select-arrow-wrapper ng')])[6]")
    private WebElement documentTypeArrow;

    @FindBy(xpath = "//*[@formcontrolname='documentNumber']")
    private WebElement documentNumber;





    WebElement myElement;
    public void findAndSend(String strElement, String value) {
        switch (strElement)
        {
            case "username"             : myElement=username; break;
            case "password"             : myElement=password; break;
            case "nameInput"            : myElement=nameInput; break;
            case "codeInput"            : myElement=codeInput; break;
            case "shortName"            : myElement=shortName; break;
            case "searchInput"          : myElement=searchInput; break;
            case "priorityInput"        : myElement=priorityInput; break;
            case "integrationCodeInput" : myElement=integrationCodeInput; break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {
        switch (strElement)
        {
            case "loginButton"          : myElement=loginButton; break;
            case "addButton"            : myElement=addButton; break;
            case "saveButton"           : myElement=saveButton; break;
            case "closeDialog"          : myElement=closeDialog; break;
            case "searchButton"         : myElement=searchButton; break;
            case "deleteButton"         : myElement=deleteButton; break;
            case "deleteDialogButton"   : myElement=deleteDialogButton; break;
            case "acceptCookies"        : myElement =acceptCookies; break;
        }
        clickFunction(myElement);
    }
    public void findAndContainsText(String strElement, String text) {
        switch (strElement)
        {
            case "dashboard"                : myElement = dashboard; break;
            case "successMessage"           : myElement = successMessage; break;
            case "alreadyExists"            : myElement = alreadyExists; break;
        }
        verifyContainsText(myElement, text);
    }
    public void searchAndDelete(String searchText) {
        findAndSend("searchInput",searchText); // arama kutucuğuna kelimeyi yaz
        findAndClick("searchButton"); // arama butonuna bas

        waitUntilLoading();

        findAndClick("deleteButton"); // silme butonuna bas
        findAndClick("deleteDialogButton"); // silmeyi onayla
    }
}