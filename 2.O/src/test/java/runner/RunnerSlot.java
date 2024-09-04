package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		    features ="src/test/resources/Feature file/Slot.feature",
		    glue="stepDefinations",
		    plugin= {
					"pretty",                               // Generates readable console output
			        "html:target/cucumber-reports.html",    // Generates HTML report
			        "json:target/cucumber-reports.json",    // Generates JSON report
			        "junit:target/cucumber-reports.xml"     // Generates JUnit XML report
			    },
			    monochrome = true,
			    dryRun = false)

public class RunnerSlot {

}
