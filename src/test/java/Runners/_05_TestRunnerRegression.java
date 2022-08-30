package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        tags = "@Regression or @SmokeTest", // or olduğundan herhangi birinin olması yeterli
        // and olduğunda her ikisinin de aynı anda olması durumunda çalışır
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"}
)

public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
} // browser tipi vermek için rapora ek parametre eklemek için sonra kullanacağız
