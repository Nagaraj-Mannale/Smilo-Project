package stepDefinations;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pom.CommonComponents;
import pom.LeadPom;

public class StepLead extends StepBaseClass
{
	CommonComponents CC;
	LeadPom lead;
	
	@When("the lead link is clicked")
	public void the_lead_link_is_clicked() {
		CC = new CommonComponents(driver);
		CC.selectPageLink("Lead");
	}
	
	@Then("the lead page text is validated")
	public void the_lead_page_text_is_validated() {  
	    String txt = CC.getHomePageTxt();
	    Assert.assertEquals(txt.trim().equalsIgnoreCase("Lead"), true, "The lead page text is not valid.");
	}

	@When("the Import button is clicked")
	public void the_import_button_is_clicked() {
	    
	}

	@When("the Add button is clicked")
	public void the_add_button_is_clicked() {
	   lead=new LeadPom(driver);
	   lead.addButton();
	}

	@Then("the lead add page text is validated")
	public void the_lead_add_page_text_is_validated() {
	   String txt= lead.getText();
	   Assert.assertEquals(txt.trim().equalsIgnoreCase("Add Leads"), true, "The lead page text is not valid.");
	}

	@When("the user navigates back to the lead home page")
	public void the_user_navigates_back_to_the_lead_home_page() {
		CC = new CommonComponents(driver);
		CC.selectPageLink("lead");
	}

	@When("the Convert button is clicked")
	public void the_convert_button_is_clicked() {
	    
	}

	@When("the Delete button is clicked")
	public void the_delete_button_is_clicked() {
	    
	}

	@When("the Export link is clicked")
	public void the_export_link_is_clicked() {
	    
	}

	@When("the page limit is set to {int}, {int}, and {int}")
	public void the_page_limit_is_set_to_and(Integer int1, Integer int2, Integer int3) {
	    
	}

	@Then("the records on the page are verified")
	public void the_records_on_the_page_are_verified() {
	    
	}

	@When("the reset button is clicked")
	public void the_reset_button_is_clicked() {
	    
	}

	@Then("verify the page limit is set correctly")
	public void verify_the_page_limit_is_set_correctly() {
	    
	}

	@When("the city dropdown is applied")
	public void the_city_dropdown_is_applied() {
	    
	}

	@Then("verify the city column reflects the selected city")
	public void verify_the_city_column_reflects_the_selected_city() {
	    
	}

	@When("the lead is searched by name")
	public void the_lead_is_searched_by_name() {
	    
	}

	@Then("validate the received records")
	public void validate_the_received_records() {
	    
	}

	@When("the From date and To date are set")
	public void the_from_date_and_to_date_are_set() {
	    
	}

	@When("the set button is clicked")
	public void the_set_button_is_clicked() {
	    
	}

	@Then("verify the received records meet the applied filter criteria")
	public void verify_the_received_records_meet_the_applied_filter_criteria() {
	    
	}

	@When("the View button is clicked")
	public void the_view_button_is_clicked() {
	    
	}

	@Then("verify the lead view page is displayed")
	public void verify_the_lead_view_page_is_displayed() {
	    
	}

	@When("the Edit button is clicked")
	public void the_edit_button_is_clicked() {
	    
	}

	@Then("verify the lead edit page is displayed")
	public void verify_the_lead_edit_page_is_displayed() {
	    
	}

	@Then("verify the record is deleted")
	public void verify_the_record_is_deleted() {
	    
	}

	@Given("the user logs out of the account")
	public void the_user_logs_out_of_the_account() {
	    
	}

}
