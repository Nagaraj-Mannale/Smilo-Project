package stepDefination;

import org.openqa.selenium.WebDriver;

import basePage.BaseClass;
import io.cucumber.java.en.*;
import pom.Widget;

public class WidgetFlow extends BaseClass{
	WebDriver driver;
	Widget wi=new Widget(driver);

@Given("launch the browser")
public void LaunchTheBrowser() {
    setup("v2widget.tech-active.com/get-started/n9UyYRbhUU3yBR17pXjoMKwBPirr5NPS5V4J0AFTe8r60SyXAB");
}

@When("enter the url")
public void EnterTheUrl() {
    
}

@Then("verify the content")
public void VerifyTheContent() {
    System.out.print("lakhan");
}
	
}
