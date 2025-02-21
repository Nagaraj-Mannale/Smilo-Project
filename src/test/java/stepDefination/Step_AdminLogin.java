package stepDefination;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pom.AdminLogin;
import basePage.*;
public class Step_AdminLogin {
    AdminLogin al;
	
	@Given("the user launches the browser and enters the application URL")
	public void launch_the_browser_and_enter_the_url() {
	    BaseClass.setup("v2admin.tech-active.com");
	}

	@When("enter the email and pwd and click on the signin button")
	public void enter_the_email_and_pwd_and_click_on_the_signin_button()  {
	    al=new AdminLogin(BaseClass.driver);
	    al.emailField("nagaraj@rokkun.io");
	    al.passwordField("Ind@123");
	    al.signInButton();
	}
    @Then("extract the otp from mail and enter into the otp fields and click on the save button")
    public void verifyOtp()
    {
    	al.otpEnter(ReadGmailOTP.fetchOTP());
    	System.out.println(ReadGmailOTP.fetchOTP());
    	al.clickOnverify();
    }
	@Then("ensure user on the dashboard page")
	public void ensure_user_on_the_dashboard_page() {
		Assert.assertEquals(al.dashboardPageText(),"Dashboard");
		System.out.println("verified");
	}
}
