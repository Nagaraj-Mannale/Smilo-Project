package stepDefinations;

import java.awt.AWTException;
import org.testng.Assert;
import io.cucumber.java.en.*;
public class StepLead extends StepBaseClass {
 	  private static String leadId="";
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
      leadId=ClassObjects.LD.getFirstRecordLeadId();
      Assert.assertEquals(ClassObjects.LD.getfirstRecordName(),leadName);
      Assert.assertEquals(ClassObjects.LD.getfirstRecordMail(),leadMail);
      System.out.println(ClassObjects.LD.getfirstRecordName()+" "+ClassObjects.LD.getfirstRecordMail());
    }
    
    @When("the View button is clicked")
    public void theViewButtonIsClicked() throws AWTException {
     ClassObjects.CC.searchField(leadId);
     Assert.assertEquals(ClassObjects.LD.getfirstRecordMail(),leadMail);
     ClassObjects.CC.clickOnKebabIcon();
 	 ClassObjects.LD.clickOnKebabOption("computer");
    }
    
    @Then("verify the lead view page is displayed")
    public void verifyTheLeadViewPageIsDisplayed() {
    Assert.assertEquals(ClassObjects.LD.getLeadAddViewEditPageText(),"View Lead");
    }
    
    @When("the Edit button is clicked")
    public void theEditButtonIsClicked() throws AWTException {
    ClassObjects.LD.clickOnViewPageEditIcon();

    }

    @Then("verify the lead edit page is displayed")
    public void verifyTheLeadEditPageIsDisplayed() {
    Assert.assertEquals(ClassObjects.LD.getLeadAddViewEditPageText(),"Edit Lead");
    }

    @When("modify the leadName")
    public void modifyTheLeadName()  {
    ClassObjects.LD.setLeadName(modifyLeadName);
    }
    
    @When("Validate the modified lead")
    public void validateTheModifiedLead()throws AWTException {
    ClassObjects.CC.searchField(leadId);
    Assert.assertEquals(ClassObjects.LD.getfirstRecordName(),modifyLeadName);
    }

    @When("select one lead and the Delete button is clicked")
    public void theDeleteButtonIsClicked() throws AWTException {
    ClassObjects.CC.searchField(leadId);
    ClassObjects.CC.clickOnKebabIcon();
    ClassObjects.LD.clickOnKebabOption("Delete");
    ClassObjects.CC.deletePopupHandle("Yes");
   
    }

    @Then("verify the record is deleted")
    public void verifyTheRecordIsDeleted() throws AWTException{
    ClassObjects.CC.searchField(leadId);
    Assert.assertEquals(ClassObjects.LD.getDeletePageText(),"No lead Found!");
    ClassObjects.CC.clickResetButton();
    }
    
    @When("select one check box")
    public void thePageLimitIsSetToAnd() throws AWTException{
    	leadId=ClassObjects.LD.getFirstRecordLeadId();
    	leadMail=ClassObjects.LD.getfirstRecordMail();
    	ClassObjects.CC.searchField(leadId);  
      	ClassObjects.LD.clickonCheckBox();
    }
    
    @When("home delete button is clicked")
    public void theExportLinkIsClicked() {
      ClassObjects.LD.clickDeleteButton();
      ClassObjects.CC.deletePopupHandle("yes");
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
