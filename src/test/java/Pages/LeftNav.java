package Pages;

import Utilities.Gwd;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent{

    public LeftNav() {
        PageFactory.initElements(Gwd.getDriver(),this);
    }

    @FindBy(xpath="(//span[text()='Setup'])[1]")
    public WebElement setupOne;

    @FindBy(xpath="//span[text()='Parameters']")
    public WebElement parameters;

    @FindBy(xpath="//span[text()='Countries']")
    public WebElement countries;

    WebElement myElement;
    public void findAndClick(String strElement) {
        switch (strElement) {
            case "setupOne"     : myElement=setupOne; break;
            case "parameters"   : myElement=parameters; break;
            case "countries"    : myElement=countries; break;
        }
        clickFunction(myElement);
    }
}
