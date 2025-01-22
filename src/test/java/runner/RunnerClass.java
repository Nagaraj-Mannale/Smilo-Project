package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features", 
        glue = "stepDefination",   
      plugin = {
         "pretty",                             
         "html:target/cucumber-reports.html",  
         "json:target/cucumber-reports.json",  
         "junit:target/cucumber-reports.xml"   
                },
    monochrome = true,                         // Clean console output
    dryRun = false,                           // If true, checks mappings without executing
    tags = "@smoke"                          // Filter scenarios by tags (if needed)
)
public class RunnerClass {
    // No additional code is needed. Cucumber does the magic here.
}




