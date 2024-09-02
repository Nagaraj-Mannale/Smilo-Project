package stepDefinations;

import java.awt.AWTException;

import org.testng.Assert;
import io.cucumber.java.en.*;


public class StepLead extends StepBaseClass {
 

    @When("the lead link is clicked")
    public void theLeadLinkIsClicked() {
        ClassObjects.CC.selectPageLink("Lead");
    }

    @Then("the lead page text is validated")
    public void theLeadPageTextIsValidated() {
        String text = ClassObjects.CC.getHomePageText();
        Assert.assertEquals(text.trim().equalsIgnoreCase("Lead"), true, "The lead page text is not valid.");
    }

    @When("the Import button is clicked")
    public void theImportButtonIsClicked() {
    	ClassObjects.LD.clickImportButton();
    }

    @When("the Add button is clicked")
    public void theAddButtonIsClicked() {
//        lead = new Lead(driver);
        ClassObjects.LD.clickAddButton();
    }

    @Then("the lead add page text is validated")
    public void theLeadAddPageTextIsValidated() {
        String text = ClassObjects.LD.getText();
        Assert.assertEquals(text.trim().equalsIgnoreCase("Add Leads"), true, "The lead add page text is not valid.");
    }

    @When("the user navigates back to the lead home page")
    public void theUserNavigatesBackToTheLeadHomePage() {
    	ClassObjects.CC.selectPageLink("Lead");
    }

    @When("the Convert button is clicked")
    public void theConvertButtonIsClicked() {
        // lead.clickConvertButton();
    }

    @When("the Delete button is clicked")
    public void theDeleteButtonIsClicked() {
        // lead.clickDeleteButton();
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
        // Implement logic to verify the records on the page
    }

    @When("the reset button is clicked")
    public void theResetButtonIsClicked() {
    	ClassObjects.CC.clickResetButton();
    }

    @Then("verify the page limit is set correctly")
    public void verifyThePageLimitIsSetCorrectly() {
        // Implement logic to verify the page limit
    }

    @When("the city dropdown is applied")
    public void theCityDropdownIsApplied() {
        // Implement logic for applying the city dropdown filter
    }

    @Then("verify the city column reflects the selected city")
    public void verifyTheCityColumnReflectsTheSelectedCity() {
        // Implement logic to verify the city column
    }

    @When("the lead is searched by name")
    public void theLeadIsSearchedByName() throws AWTException {
    	ClassObjects.CC.searchField("Lead Name");
    }

    @Then("validate the received records")
    public void validateTheReceivedRecords() {
        // Implement logic to validate the received records
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
        // Implement logic to verify the received records based on filter criteria
    }

    @When("the View button is clicked")
    public void theViewButtonIsClicked() {
        // Implement logic for clicking the View button
    }

    @Then("verify the lead view page is displayed")
    public void verifyTheLeadViewPageIsDisplayed() {
        // Implement logic to verify the lead view page
    }

    @When("the Edit button is clicked")
    public void theEditButtonIsClicked() {
        // Implement logic for clicking the Edit button
    }

    @Then("verify the lead edit page is displayed")
    public void verifyTheLeadEditPageIsDisplayed() {
        // Implement logic to verify the lead edit page
    }

    @Then("verify the record is deleted")
    public void verifyTheRecordIsDeleted() {
        // Implement logic to verify the record deletion
    }

    @Given("the user logs out of the account")
    public void theUserLogsOutOfTheAccount() {
        // Implement logic for logging out of the account
    }
}
