package stepDefinations;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.CommonComponents;
import pom.LoginPage;

public class StepLogin extends StepBaseClass {

    private LoginPage lp;

    @Given("the browser is open and the URL is entered")
    public void theBrowserIsOpenAndTheUrlIsEntered() {
        setup();
        lp = new LoginPage(driver);
    }

    @When("the valid username and password are entered")
    public void theValidUsernameAndPasswordAreEntered() {
        lp.enterUserNameAndPassword("admin@bc.com", "Admin@12");
    }

    @When("the Login button is clicked")
    public void theLoginButtonIsClicked() {
        lp.clickLoginButton();
    }

    @Then("the landing page text is validated")
    public void theLandingPageTextIsValidated() {
    	CommonComponents CC=new CommonComponents(driver);
    	String text = CC.getSuccessMessage();
        Assert.assertEquals(text, "Login Successfully !");
    }

    @When("a valid username and an invalid password are entered")
    public void aValidUsernameAndAnInvalidPasswordAreEntered() {
        lp.enterUserNameAndPassword("admin@bc.com", "Admin@1");
    }

    @Then("the error page is validated")
    public void theErrorPageIsValidated() {
        String text = lp.getFailureMessage();
        Assert.assertEquals(text, "Invalid email or password");
    }

    @When("an invalid username and a valid password are entered")
    public void anInvalidUsernameAndAValidPasswordAreEntered() {
        lp.enterUserNameAndPassword("admin@b.com", "Admin@12");
    }

    @When("both the username and password fields are left empty")
    public void bothTheUsernameAndPasswordFieldsAreLeftEmpty() {
        lp.enterUserNameAndPassword("", "");
    }

    @Then("verify the warning message")
    public void verifyTheWarningMessage() {
        // Add code here to validate the warning message
    }

    @When("close the browser")
    public void closeTheBrowser() {
        tearDown();
    }
}
