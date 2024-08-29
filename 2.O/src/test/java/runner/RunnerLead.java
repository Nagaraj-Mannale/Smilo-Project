package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Feature file/Lead.feature",
    glue = "stepDefinations",
    plugin = {
        "html:target/cucumber-reports.html",
        "json:target/cucumber-reports.json",
        "junit:target/cucumber-reports.xml"
    },
    monochrome = true,
    dryRun = false
)
public class RunnerLead {
    // No additional code needed here
}
