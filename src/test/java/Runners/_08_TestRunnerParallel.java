package Runners;

import Utilities.Gwd;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@CucumberOptions(
        tags = "@Regression",
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"}
)
@Listeners({ExtentITestListenerClassAdapter.class})

public class _08_TestRunnerParallel extends AbstractTestNGCucumberTests {

    @BeforeClass // (alwaysRun = true) bazı java versiyon hataları için, BROWSER bulamadım hatası verdiğinde msg: Optional olarak ekle
    @Parameters("browser")
    public void beforeClass(String browserName)
    {
        Gwd.threadBrowserName.set(browserName);
        // burada browser set edilecek
        // bu threade browsername set edildi.
    }

//    @AfterClass(alwaysRun = true) // bazı java versiyon hatalırı için, alternatif browser kapatma
//    public void afterClass() {
//        GWD.quitDriver();
//    }

}
