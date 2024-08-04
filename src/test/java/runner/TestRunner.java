package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features = {"src/test/java/features"} , plugin = {
		"pretty",
		"json:target/cucumber.json",
		"html:target/site/cucumber-pretty.html"
		},
        glue = "steps",
        tags = "")
public class TestRunner extends AbstractTestNGCucumberTests {


    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}