package stepDefination;

import java.awt.AWTException;

import org.testng.Assert;
import basePage.BaseClass;
import io.cucumber.java.en.*;
import pom.PomDentalPractice;

public class StepPractitioner 
{
   private static PomDentalPractice dp;

    @When("the user navigates to the Practitioner page")
    public void theUserNavigatesToThePractitionerPage() {
        dp = new PomDentalPractice(BaseClass.driver);
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
        Assert.assertEquals(dp.FirstAndSecondpageName("companyinfo"), "Company Info");
    }

    @When("the user fills in all required details and clicks the Continue button")
    public void theUserFillsInAllRequiredDetailsAndClicksTheContinueButton() {
        dp.practiceName("My Practice");
        dp.licenceNumber("12527");
        dp.emailField("teser@gmail.com");
    }

    @Then("the user should be on the Contact Info page")
    public void theUserShouldBeOnTheContactInfoPage() {
     Assert.assertEquals(dp.FirstAndSecondpageName("contactinfo"),"Add Primary Contact");    }

    @Then("the user should be on the Settings page")
    public void theUserShouldBeOnTheSettingsPage() {
    	Assert.assertEquals(dp.FirstAndSecondpageName("settings"),"Settings");

    }
  
    @Then("the user should be redirected to the Home page, and the newly created practitioner should be listed")
    public void theUserShouldBeRedirectedToTheHomePageAndTheNewlyCreatedPractitionerShouldBeListed() {
        // Implement logic for validation
    }
    
    @When("the user searches for the practitioner and clicks the edit button")
    public void the_user_searches_for_the_practitioner_and_clicks_the_edit_button() throws AWTException {
        dp.searchfield("chethan@rokkun.io");
        dp.kebabIcon();
        dp.kebabIconOptions("edit");
    }

    @When("updates the required company info and clicks continue")
    public void updates_the_required_company_info_and_clicks_continue() {
    	dp.clickOnContinueOrSaveOrCancelButton("continue");
    }

   
    @When("the user updates the required contact info and clicks continue")
    public void the_user_updates_the_required_contact_info_and_clicks_continue() {
        dp.clickOnContinueOrSaveOrCancelButton("save");
    }

    @When("the user saves the changes on the settings page")
    public void the_user_saves_the_changes_on_the_settings_page() {
        dp.checkTheButton("Smile Check-in");
    	dp.ohrFlow(0);
    	dp.CTAToSelectAndUnselect("Request for an appointment","select");
    	//dp.d4w("N");
    	//dp.dentally("N");
    	//dp.corePractice("N");
    	dp.dabour("y");
    	dp.requiredOhrimages("1");
    	dp.clickOnContinueOrSaveOrCancelButton("save");
        
    }

    @Then("the user should be redirected to the home page with a success message")
    public void the_user_should_be_redirected_to_the_home_page_with_a_success_message() {
        Assert.assertEquals(true, dp.successfulmessage("modify"));
    }
    
        @When("navigate to the setting page")
        public void navigateToSettingsPage(){
            dp.settingPageTabs("Settings");
        }

        @Then("ensure that atleast two widget buttons are selected; if not, make it two")
        public void ensureWidgetButtonSelectedAsTwo()
        {
        	dp.countSelectedButtons();
        }
        
        @When("uncheck the OHR button if it selected previously")
        public void uncheckOhrButtonIfSelected() {
            dp.uncheckTheButton("Oral Health Rating ( OHR )");
        }

        @Then("all components except dabour should hidden")
        public void verifyComponentsExceptDabourHidden() {
            Assert.assertEquals(true, dp.presenceOfDabour());
            Assert.assertEquals(false,dp.presenceOfD4w());
        }

        @When("select the OHR button")
        public void selectTheOHRWidgetButton()
        {
        	dp.checkTheButton("Oral Health Rating ( OHR )");
        }
        @Then("verify all the components are displayed")
        public void componentsAreDisplayed()
        {
        	System.out.println(dp.allComponentPresence());
        	Assert.assertEquals(true, dp.allComponentPresence());
        }
        
        @When("select OHR widget button and select the OHR normal flow")
        public void selectOhrNormalFlow() {
        	dp.checkTheButton("Oral Health Rating ( OHR )");
        	dp.ohrFlow(0);  //0=Normal flow //1=Reverse  //2=Lean
        }

        @Then("CTA Purchase a detailed report option should be hide")
        public void verifyCtaPurchaseDetailedReportHidden() {
            Assert.assertEquals(false,dp.PresenceOfCtaOptions("Purchase a detailed report"));
        }

        @When("the user selects \"Request for an Appointment\" in CTA")
        public void selectRequestForAppointmentInCTA() {
            dp.CTAToSelectAndUnselect("Request for an appointment","select");
        }

        @Then("D4W and CorePractice options should be displayed")
        public void verifyD4wOptionsDisplayed() {
            Assert.assertEquals(dp.presenceofd4wandCorePractice(),true);
        }

        @When("the user selects D4W as \"Yes\"")
        public void selectD4wAsYes() {
            dp.d4w("Yes");
        }

        @Then("the D4W Practice ID field should be displayed and enabled")
        public void verifyD4wPracticeIdDisplayed() {
            Assert.assertEquals(dp.presenceOfD4w(),true);
        }

        @When("the user unchecks \"Request for an Appointment\" if selected")
        public void uncheckRequestForAppointmentIfSelected() {
            dp.CTAToSelectAndUnselect("Request for an appointment","unselect");
        }

        @Then("D4W and corepractice options should not be displayed")
        public void verifyD4wOptionsNotDisplayed() {
            Assert.assertEquals(dp.presenceofd4wandCorePractice(), false);
        }
        @When("select OHR widget button and select the OHR \"Reverse flow\"")
        public void clickOnTheReverseFlow()
        {
        	dp.ohrFlow(1);
        }
        @Then("\"Purchase a detailed report\" option should displayed")
        public void validateTheCtaoption()
        {
        	Assert.assertEquals(dp.PresenceOfCtaOptions("Purchase a detailed report"), true);
        }
        @When("the user selects \"Purchase a Detailed Report\" option")
        public void selectPurchaseDetailedReportOption() {
            dp.CTAToSelectAndUnselect("Purchase a Detailed Report","select");
        }

        @Then("the Payment option should be displayed")
        public void verifyPaymentOptionDisplayed() {
            Assert.assertEquals(dp.presenceOfPaymentDetails(), true);
        }

        @When("the user unselects \"Purchase a Detailed Report\" option")
        public void unselectPurchaseDetailedReportOption() {
            dp.CTAToSelectAndUnselect("Purchase a Detailed Report", "unselect");
        }

        @Then("the Payment option should not be displayed")
        public void verifyPaymentOptionNotDisplayed() {
            Assert.assertEquals(dp.presenceOfPaymentDetails(), false);
        }
        
        //Admin to widget flow
        @Then("capture the changes in the setting page and click on the save button")
        public void captureTheChangesOnSettingPage()
        {
        	
        }
    }

    
    
    
    
    
    
    
    
    

