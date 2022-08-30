package StepDefinitions;

import Utilities.Gwd;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @Before
    public void before() {
        System.out.println("Scenario is started...");
    }
    @After
    public void after(Scenario scenario) {

        System.out.println("Scenario is over...");
        System.out.println("Scenario result : "+scenario.getStatus());
        System.out.println("Scenario isFailed? : "+scenario.isFailed());

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd.MM.yy");

        if (scenario.isFailed()) {
            // klasöre
            TakesScreenshot screenshot= (TakesScreenshot) Gwd.getDriver();
            File ssFile=screenshot.getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(ssFile,
                        new File(String.format("target/FailedScreenShots/" + scenario.getId() + date.format(formatter)+".png")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // ekran görüntüsü al senaryo hatalı ise koyacağız
        Gwd.quitDriver();
    }
}
