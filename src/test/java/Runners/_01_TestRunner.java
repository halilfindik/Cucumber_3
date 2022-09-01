package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/_01_Login.feature"}, // feature'ların files'ını path olarak verilecek
        glue = {"StepDefinitions"} // Step definitions'ın klasörünü yazıyoruz
)
public class _01_TestRunner extends AbstractTestNGCucumberTests {

// browser tipi vermek için rapora ek parametre eklemek için sonra kullanacağız
}
