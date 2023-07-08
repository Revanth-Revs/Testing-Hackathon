package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"pretty",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"html:target/HTML-Report/HTMLReport.html",
				"json:target/JSON-Report/JSONReport.json",
				"testng:target/XML-Report/XML-Report.xml"
				},
		glue= {"stepDefinations"},
		features= {"src/test/resources/features"},
		tags= "@logins",
		monochrome = true
		
		
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
