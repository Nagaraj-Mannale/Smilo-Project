package stepDefinations;

import org.testng.Assert;

import basePage.ClassObjects;
import basePage.StepBaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepLogin extends StepBaseClass {

    @Given("the browser is open and the URL is entered")
    public void theBrowserIsOpenAndTheUrlIsEntered() {
        setup();
    }

    @When("the valid username and password are entered")
    public void theValidUsernameAndPasswordAreEntered() {
        ClassObjects.LP.enterUserNameAndPassword("admin@bc.com", "Admin@12");
    }

    @When("the login button is clicked")
    public void theLoginButtonIsClicked() {
        ClassObjects.LP.clickLoginButton();
    }

    @Then("the landing page text is validated")
    public void theLandingPageTextIsValidated() {
        String text = ClassObjects.CC.getSuccessMessage();
        Assert.assertEquals(text, "Login Successfully !");
    }

    @When("a valid username and an invalid password are entered")
    public void aValidUsernameAndAnInvalidPasswordAreEntered() {
        ClassObjects.LP.enterUserNameAndPassword("admin@bc.com", "Admin@1");
    }

    @Then("the error page is validated")
    public void theErrorPageIsValidated() {
        String text = ClassObjects.LP.getFailureMessage();
        Assert.assertEquals(text, "Invalid email or password");
    }

    @When("an invalid username and a valid password are entered")
    public void anInvalidUsernameAndAValidPasswordAreEntered() {
        ClassObjects.LP.enterUserNameAndPassword("admin@b.com", "Admin@12");
    }

    @When("both the username and password fields are left empty")
    public void bothTheUsernameAndPasswordFieldsAreLeftEmpty() {
        ClassObjects.LP.enterUserNameAndPassword("", "");
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
