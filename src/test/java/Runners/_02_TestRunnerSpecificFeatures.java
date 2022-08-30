package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = {"src/test/java/FeatureFiles/_01_Login.feature",
                    "src/test/java/FeatureFiles/_02_Country.feature"
                    },
        glue = {"StepDefinitions"},
        dryRun = true // true olduğunda testi çalıştırma sadece feature'lara ait
                      // steplerin varlığını kontrol eder
                      // false olduğunda testleri çalıştırır
)
public class _02_TestRunnerSpecificFeatures extends AbstractTestNGCucumberTests {
} // browser tipi vermek için rapora ek parametre eklemek için sonra kullanacağız
