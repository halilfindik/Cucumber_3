package Pages;

import Utilities.Gwd;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent extends Parent{
    public FormContent() {
        PageFactory.initElements(Gwd.getDriver(), this);
    }

    //@FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[1]") // hocanın versiyon
    @FindBy(xpath = "(//div[contains(@class,'mat-select-arrow ng-tns-')])[1]")
    private WebElement academicPeriod;

    //@FindBy(xpath="//span[contains(text(),' 2021-2022 ')]")
    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement academicPeriod1;

    //@FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[3]") // hocanın versiyon
    @FindBy(xpath = "(//div[contains(@class,'mat-select-arrow ng-tns-')])[2]")
    private WebElement gradeLevel;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement gradeLevel1;

    @FindBy(xpath = "//*[@class='mat-select-arrow ng-tns-c93-536']")
    private WebElement schoolBoxTick;

    WebElement myElement;

    public void findAndClick(String strElement) {
        switch (strElement)
        {
            case "academicPeriod"      : myElement=academicPeriod; break;
            case "academicPeriod1"     : myElement=academicPeriod1; break;
            case "gradeLevel"          : myElement=gradeLevel; break;
            case "gradeLevel1"         : myElement=gradeLevel1; break;
        }
        clickFunction(myElement);

        //if (myElement == academicPeriod || myElement == gradeLevel)
        //    Gwd.Bekle(2);
    }
}
