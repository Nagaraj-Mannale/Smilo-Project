package stepDefination;

import java.awt.AWTException;

import org.testng.Assert;
import basePage.BaseClass;
import io.cucumber.java.en.*;
import pom.DentalPractice;

public class StepPractitioner 
{
   private static DentalPractice dp;

    @When("the user navigates to the Practitioner page")
    public void theUserNavigatesToThePractitionerPage() {
        dp = new DentalPractice(BaseClass.driver);
        dp.titleNames("Dental Practice");
    }

    @Then("the user should be on the Practitioner page")
    public void theUserShouldBeOnThePractitionerPage() {
        Assert.assertEquals(dp.PractitionerHomepageName(), "Dental Practice");
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
        dp.emailField("teser@gmail.com");
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
    
    @When("the user searches for the practitioner and clicks the edit button")
    public void the_user_searches_for_the_practitioner_and_clicks_the_edit_button() throws AWTException {
        dp.searchfield("smilotester@gmail.com");
        dp.kebabIcon();
        dp.kebabIconOptions("edit");
    }

    @When("updates the required company info and clicks continue")
    public void updates_the_required_company_info_and_clicks_continue() {
        dp.clickOnContinueOrSaveOrCancelButton("first");
    }

   
    @When("the user updates the required contact info and clicks continue")
    public void the_user_updates_the_required_contact_info_and_clicks_continue() {
        dp.clickOnContinueOrSaveOrCancelButton("second");
    }

    @When("the user saves the changes on the settings page")
    public void the_user_saves_the_changes_on_the_settings_page() {
        dp.widgetButtons("Smile Check-in");
    	dp.ohrFlow("Normal Flow");
    	dp.CTA("Request for an appointment");
    	dp.d4w("N");
    	dp.dentally("N");
    	dp.corePractice("N");
    	dp.dabour("y");
    	dp.requiredOhrimages("1");
        
    }

    @Then("the user should be redirected to the home page with a success message")
    public void the_user_should_be_redirected_to_the_home_page_with_a_success_message() {
        
    }
    
    
    
    
    
    
    
}
