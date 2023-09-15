package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features/AlertHandling.feature",
		glue= {"stepDefinitions"}
//		plugin = {"pretty", "json:target/cucumber-reports/jsonReport.json"} //"html:target/cucumber-reports/report.html"
//		tags = "@rtc"
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	
}