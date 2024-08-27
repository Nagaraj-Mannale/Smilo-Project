package runner;

	import org.junit.runner.RunWith;
	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "src/test/resources/Feature file/Login.feature",
	    glue = "stepDefinations",                 // Package containing step definitions
	    plugin = {   
	    		"html:target/login.html"// Reporting plugins

	    },
	    monochrome = true,                        // Makes the console output more readable
//	    tags = "@SmokeTest",                      // Executes scenarios with this tag
        dryRun = false                            // Checks the mappings between feature files and step definitions without executing the tests
	)
	public class Runner_Login 
	{ 
	
}
//	 plugin = {   
//	    		"html:target/login.html"// Reporting plugins
//    "pretty",                             // Generates readable console output
//    "html:target/cucumber-reports.html",  // Generates HTML report in the specified path
//    "json:target/cucumber-reports.json",  // Generates JSON report
//    "junit:target/cucumber-reports.xml"   // Generates JUnit XML report
