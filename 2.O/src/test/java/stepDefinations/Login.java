package stepDefinations;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pom.P_LoginPage;


public class Login extends BaseClass 
{      
     Login(WebDriver driver)
     {
    	// super (driver);
     }
	    P_LoginPage lp;
        @Given("the browser is open and the URL is entered")
        public void the_browser_is_open_and_the_url_is_entered() 
        {
            
        }

        @When("the valid username and password are entered")
        public void the_valid_username_and_password_are_entered() {
        	P_LoginPage lp = new P_LoginPage(driver);
            lp.enterUserNameAndPassword("admin@bc.com", "Admin@12");
        }

        @When("the Login button is clicked")
        public void the_login_button_is_clicked() {
            lp.loginButton();
        }

        @Then("the landing page text is validated")
        public void the_landing_page_text_is_validated() {
        	 String text = lp.getHomePageText();
             Assert.assertEquals("DashBoard", text);
        }

        @When("a valid username and an invalid password are entered")
        public void a_valid_username_and_an_invalid_password_are_entered() {
            
        }

        @Then("the error page is validated")
        public void the_error_page_is_validated() {
            
        }

        @When("an invalid username and a valid password are entered")
        public void an_invalid_username_and_a_valid_password_are_entered() {
            
        }

        @When("a valid username and password are entered")
        public void a_valid_username_and_password_are_entered() {
            
        }

        @When("the Cancel button is clicked")
        public void the_cancel_button_is_clicked() {
            
        }

        @Then("the page text is validated")
        public void the_page_text_is_validated() {
            
        }

        @When("both the username and password fields are left empty")
        public void both_the_username_and_password_fields_are_left_empty() {
            
        }    
        
        
  
    
}