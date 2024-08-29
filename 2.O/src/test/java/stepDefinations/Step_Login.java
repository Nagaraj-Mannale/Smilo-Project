package stepDefinations;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.LoginPage;

public class Step_Login extends StepBaseClass {

    private LoginPage lp;

    @Given("the browser is open and the URL is entered")
    public void the_browser_is_open_and_the_url_is_entered() {
        setup();
        lp = new LoginPage(driver);
    }

    @When("the valid username and password are entered")
    public void the_valid_username_and_password_are_entered() {
        lp.enterUserNameAndPassword("admin@bc.com", "Admin@12");
    }

    @When("the Login button is clicked")
    public void the_login_button_is_clicked() {
        lp.clickLoginButton();
    }

    @Then("the landing page text is validated")
    public void the_landing_page_text_is_validated() {
        String text = lp.getSuccessMessage();
        Assert.assertEquals(text, "Login Successfully !");
    }

    @When("a valid username and an invalid password are entered")
    public void a_valid_username_and_an_invalid_password_are_entered() {
        lp.enterUserNameAndPassword("admin@bc.com", "Admin@1");
    }

    @Then("the error page is validated")
    public void the_error_page_is_validated() {
        String text = lp.getFailureMessage();
        Assert.assertEquals(text, "Invalid email or password");
    }

    @When("an invalid username and a valid password are entered")
    public void an_invalid_username_and_a_valid_password_are_entered() {
        lp.enterUserNameAndPassword("admin@b.com", "Admin@12");
    }

    @When("both the username and password fields are left empty")
    public void both_the_username_and_password_fields_are_left_empty() {
        lp.enterUserNameAndPassword("", "");
    }

    @Then("verify the warning message")
    public void verify_the_warning_message() {
        // Add code here to validate the warning message
    }

    @When("close the browser")
    public void close_the_browser() {
        tearDown();
    }
}
