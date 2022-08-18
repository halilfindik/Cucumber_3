package Pages;

import Utilities.Gwd;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class Parent {
    public void sendKeysFunction(WebElement element, String value)
    {
        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }
    public void clickFunction(WebElement element)
    {
        waitUntilVisible(element);
        scrollToElement(element);
        element.click();
    }
    public void waitUntilVisible(WebElement element) {
        WebDriverWait wait=new WebDriverWait(Gwd.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js=(JavascriptExecutor) Gwd.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public void verifyContainsText(WebElement element, String text) {
        waitUntilVisible(element);
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }
}