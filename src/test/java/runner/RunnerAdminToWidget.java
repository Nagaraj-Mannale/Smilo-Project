package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Widget_Features/AdminToWidget.feature",
		glue="stepDefination",
		plugin= {
				"pretty",
				"html:target/admintoWidget.html"
		},
		monochrome=false
			
		
		)

public class RunnerAdminToWidget {

}
