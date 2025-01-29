package stepDefination;

import basePage.BaseClass;
import io.cucumber.java.en.*;
import pom.DentalPractice;

public class StepPractitioner 
{
    DentalPractice dp;
	@When("the user navigates to the Practitioner page")
	public void the_user_navigates_to_the_practitioner_page() {
	    dp=new DentalPractice(BaseClass.driver);
	    dp.titleNames("Dental Practice");
	    
	}

	@Then("the user should be on the Practitioner page")
	public void the_user_should_be_on_the_practitioner_page() {
	    
	}

	@When("the user clicks the Add button")
	public void the_user_clicks_the_add_button() {
	    
	}

	@Then("the user should be redirected to the Company Info page")
	public void the_user_should_be_redirected_to_the_company_info_page() {
	    
	}

	@When("the user fills in all required details and clicks the Continue button")
	public void the_user_fills_in_all_required_details_and_clicks_the_continue_button() {
	    
	}

	@Then("the user should be on the Contact Info page")
	public void the_user_should_be_on_the_contact_info_page() {
	    
	}

	@Then("the user should be on the Settings page")
	public void the_user_should_be_on_the_settings_page() {
	    
	}

	@Then("the user should be redirected to the Home page, and the newly created practitioner should be listed")
	public void the_user_should_be_redirected_to_the_home_page_and_the_newly_created_practitioner_should_be_listed() {
	    
	}
	
}
