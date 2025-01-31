package stepDefination;

import org.testng.Assert;
import basePage.BaseClass;
import io.cucumber.java.en.*;
import pom.DentalPractice;

public class StepPractitioner 
{
    DentalPractice dp;

    @When("the user navigates to the Practitioner page")
    public void theUserNavigatesToThePractitionerPage() {
        dp = new DentalPractice(BaseClass.driver);
        dp.titleNames("Dental Practice");
    }

    @Then("the user should be on the Practitioner page")
    public void theUserShouldBeOnThePractitionerPage() {
        Assert.assertEquals(dp.HomepageName(), "Dental Practice");
    }

    @When("the user clicks the Add button")
    public void theUserClicksTheAddButton() {
        dp.addPracticeBtn();
    }

    @Then("the user should be redirected to the Company Info page")
    public void theUserShouldBeRedirectedToTheCompanyInfoPage() {
        Assert.assertEquals(dp.FirstAndSecondpageName("first"), "Company Info");
    }

    @When("the user fills in all required details and clicks the Continue button")
    public void theUserFillsInAllRequiredDetailsAndClicksTheContinueButton() {
        dp.practiceName("My Practice");
        dp.licenceNumber("12527");
        dp.emailField("");
    }

    @Then("the user should be on the Contact Info page")
    public void theUserShouldBeOnTheContactInfoPage() {
        // Implement logic for validation
    }

    @Then("the user should be on the Settings page")
    public void theUserShouldBeOnTheSettingsPage() {
        // Implement logic for validation
    }

    @Then("the user should be redirected to the Home page, and the newly created practitioner should be listed")
    public void theUserShouldBeRedirectedToTheHomePageAndTheNewlyCreatedPractitionerShouldBeListed() {
        // Implement logic for validation
    }
}
