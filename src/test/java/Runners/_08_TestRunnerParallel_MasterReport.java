package Runners;

import Utilities.Gwd;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        tags = "@Regression",
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"},
        plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}
        // masterthought report için
)
public class _08_TestRunnerParallel_MasterReport extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true) // bazı java versiyon hatalırı için
    @Parameters("browser")
    public void beforeClass(String browser)
    {
        Gwd.threadBrowserName.set(browser);
       //burada browser set edilecek
        // bu threade browsername set edildi.
    }

}
