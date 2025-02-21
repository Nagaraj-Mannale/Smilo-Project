package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/AdminFeaures/DentalPractice.feature",
		glue="stepDefination",
		plugin= {
				"pretty",                             
		         "html:target/cucumber-reports.html"
		}, 	
		monochrome = true,                         // Clean console output
		    dryRun = false                        // If true, checks mappings without executing
			//tags = "@smoke"                    // Filter scenarios by tags (if needed)
		
		
		)


public class RunnerPractitioner {

}
