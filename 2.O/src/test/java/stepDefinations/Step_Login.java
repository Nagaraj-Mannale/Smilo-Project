package stepDefinations;
	
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.LoginPage;


public class Step_Login extends StepBaseClass 
{      
	
        @Given("the browser is open and the URL is entered")
        public void the_browser_is_open_and_the_url_is_entered() 
        {
            setup();
        }

        @When("the valid username and password are entered")
        public void the_valid_username_and_password_are_entered() {
        	lp = new LoginPage(driver);
            lp.enterUserNameAndPassword("admin@bc.com", "Admin@12");
        }

        @When("the Login button is clicked")
        public void the_login_button_is_clicked() {
        	if(lp==null)
            lp = new LoginPage(driver);
            lp.loginButton();
        }

        @Then("the landing page text is validated")
        public void the_landing_page_text_is_validated() throws InterruptedException {
        	 String text = lp.successfulmsg();
             Assert.assertEquals("Login Successfully !", text);
          //  CommonComponents cc=new CommonComponents(driver);
//            Thread.sleep(3000);
//            cc.selectPageLink("lead");
//            Thread.sleep(3000);
        }

        @When("a valid username and an invalid password are entered")
        public void a_valid_username_and_an_invalid_password_are_entered() {
        	if(lp==null)
            lp = new LoginPage(driver);
        	lp.enterUserNameAndPassword("admin@bc.com", "Admin@1");
        }

        @Then("the error page is validated")
        public void the_error_page_is_validated() 
        {
        	String text = lp.loginFailedlmsg();
            Assert.assertEquals("Invalid email or password", text);
        	    
        }

        @When("an invalid username and a valid password are entered")
        public void an_invalid_username_and_a_valid_password_are_entered() {
        	if(lp==null)
                lp = new LoginPage(driver);
        	lp.enterUserNameAndPassword("admin@b.com", "Admin@12");
        }

        @When("both the username and password fields are left empty")
        public void both_the_username_and_password_fields_are_left_empty() {
        	if(lp==null)
                lp = new LoginPage(driver);
        	lp.enterUserNameAndPassword("", "");
        }  
        @Then("verify the warning message")
        public void the_page_text_is_validated() {
            
        }
        @When("close the browser")
        public void ClosetheBrowser()
        {
        	tearDown();
        }
        
        
  
    
}