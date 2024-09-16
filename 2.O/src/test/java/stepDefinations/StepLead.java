package stepDefinations;

import java.awt.AWTException;

import org.testng.Assert;
import io.cucumber.java.en.*;


public class StepLead extends StepBaseClass {
 
	 // private String leadId="";
	  private String leadName="Tester";
	  private String leadMail="nagaraj@rokkun.io";
	  private String modifyLeadName="tester2";
	    
    @When("the lead link is clicked")
    public void theLeadLinkIsClicked() {
        ClassObjects.CC.selectPageLink("Lead");
    }
    
    @Then("the lead page text is validated")
    public void theLeadPageTextIsValidated() {
         Assert.assertEquals(ClassObjects.LD.getLeadHomePageText(),"Lead");
        // leadId=ClassObjects.LD.getFirstRecordLeadId();
    }

    @When("the Add button is clicked")
    public void theAddButtonIsClicked() {
        ClassObjects.LD.clickAddButton();
    }

    @Then("the lead add page text is validated")
    public void theLeadAddPageTextIsValidated() {
      Assert.assertEquals(ClassObjects.LD.getLeadAddViewEditPageText(),"Add"); //Add lead
    }
  
    @When("enter the all necessary data to create lead")
    public void theConvertButtonIsClicked() {
      ClassObjects.LD.setLeadName(leadName);
      ClassObjects.LD.selectLeadStatus("Contact Made");
      ClassObjects.LD.setEmail(leadMail);
      ClassObjects.LD.setMobile("4567891234");
      ClassObjects.LD.setAddressLabel("Banglore");
      ClassObjects.LD.setAddress("Bengaluru");
      ClassObjects.LD.selectCity("Bengaluru");
      ClassObjects.CC.clickOnSaveButton();
    }
    
    @Then("Validate the new added lead")
    public void validateTheNewAddedLead() throws AWTException {
      //ClassObjects.CC.searchField(leadName);
      Assert.assertEquals(ClassObjects.LD.getfirstRecordName(),leadName);
      Assert.assertEquals(ClassObjects.LD.getfirstRecordMail(),leadMail);
      System.out.println(ClassObjects.LD.getfirstRecordName()+" "+ClassObjects.LD.getfirstRecordMail());
    }
    
//    @When("the View button is clicked")
//    public void theViewButtonIsClicked() throws AWTException {
//     ClassObjects.CC.searchField(leadName);
//     ClassObjects.LD.clickOnKebabOption("View");
//    }
//    
//    @Then("verify the lead view page is displayed")
//    public void verifyTheLeadViewPageIsDisplayed() {
//    Assert.assertEquals(ClassObjects.LD.getLeadAddViewEditPageText(),"View Lead");
//    }
    
    @When("the Edit button is clicked")
    public void theEditButtonIsClicked() throws AWTException {
//    ClassObjects.LD.clickOnViewPageEditIcon();
    	ClassObjects.CC.searchField(leadName);
    	
    	ClassObjects.CC.clickOnKebabIcon();
    	ClassObjects.LD.clickOnKebabOption("Edit");
    }

    @Then("verify the lead edit page is displayed")
    public void verifyTheLeadEditPageIsDisplayed() {
    Assert.assertEquals(ClassObjects.LD.getLeadAddViewEditPageText(),"Edit Leads");
    }

    @When("modify the leadmailid")
    public void modifyTheLeadMailId() {
  	ClassObjects.LD.setLeadName(modifyLeadName);
    }
    
    @When("Validate the modified lead")
    public void validateTheModifiedLead() {
    Assert.assertEquals(ClassObjects.LD.getfirstRecordMail(),modifyLeadName);
    }

    @When("the Delete button is clicked")
    public void theDeleteButtonIsClicked() {
    ClassObjects.LD.clickOnKebabOption("Delete");
    ClassObjects.CC.deletePopupHandle("Yes");
    }

    @Then("verify the record is deleted")
    public void verifyTheRecordIsDeleted() throws AWTException {
    ClassObjects.CC.searchField(modifyLeadName);	
    Assert.assertEquals(ClassObjects.LD.getDeletePageText(),"No lead Found!");
    }
    
    @When("the Export link is clicked")
    public void theExportLinkIsClicked() {
        // lead.clickExportLink();
    }

    @When("the page limit is set to {int}, {int}, and {int}")
    public void thePageLimitIsSetToAnd(Integer int1, Integer int2, Integer int3) {
        // Implement logic for setting page limit
    }

    @Then("the records on the page are verified")
    public void theRecordsOnThePageAreVerified() {
      
    }

    @When("the reset button is clicked")
    public void theResetButtonIsClicked() {
    	ClassObjects.CC.clickResetButton();
    }

    @Then("verify the page limit is set correctly")
    public void verifyThePageLimitIsSetCorrectly() {
       
    }

    @When("the city dropdown is applied")
    public void theCityDropdownIsApplied() {
        
    }

    @Then("verify the city column reflects the selected city")
    public void verifyTheCityColumnReflectsTheSelectedCity() {
       
    }

    @When("the lead is searched by name")
    public void theLeadIsSearchedByName() throws AWTException{
    	ClassObjects.CC.searchField("Lead Name");
    }

    @Then("validate the received records")
    public void validateTheReceivedRecords() {
       
    }

    @When("the From date and To date are set")
    public void theFromDateAndToDateAreSet() {
        // Implement logic to set the From and To dates
    }

    @When("the set button is clicked")
    public void theSetButtonIsClicked() {
    	ClassObjects.CC.clickSetButton();
    }

    @Then("verify the received records meet the applied filter criteria")
    public void verifyTheReceivedRecordsMeetTheAppliedFilterCriteria() {

    }

    @Given("the user logs out of the account")
    public void theUserLogsOutOfTheAccount() {
        // Implement logic for logging out of the account
    }




}
