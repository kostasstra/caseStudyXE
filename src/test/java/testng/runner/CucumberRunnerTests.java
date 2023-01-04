package testng.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "testng.definitions",
        plugin = {"pretty", "html:test-output", "json:target/cucumber/cucumber.json", "html:target/cucumber-html-report"})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

}
