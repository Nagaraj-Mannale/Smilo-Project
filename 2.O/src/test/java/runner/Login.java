package runner;

	import org.junit.runner.RunWith;
	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "./Feature file", // Path to your feature files
	    glue = "stepDefinitions",                 // Package containing step definitions
	    plugin = {                                // Reporting plugins
	        "pretty",                             // Generates readable console output
	        "html:target/cucumber-reports.html",  // Generates HTML report in the specified path
	        "json:target/cucumber-reports.json",  // Generates JSON report
	        "junit:target/cucumber-reports.xml"   // Generates JUnit XML report
	    }
//	    monochrome = true,                        // Makes the console output more readable
//	    tags = "@SmokeTest",                      // Executes scenarios with this tag
//	    dryRun = false                            // Checks the mappings between feature files and step definitions without executing the tests
	)
	public class Login { {
	}
}
