package stepDefinations;

import java.awt.AWTException;

import org.testng.Assert;

import io.cucumber.java.en.*;

public class StepSlot 
{
	@When("the MallUser link and Slot tab is clicked")
	public void theMallUserLinkAndSlotTabIsClicked() {
	     ClassObjects.CC.selectPageLink("Mall Settings");
	     ClassObjects.MS.selectTabBylinks("Slots");
	}

	@Then("the Slot page text is validated")
	public void theSlotPageTextIsValidated() {
		String text = ClassObjects.CC.getHomePageText();
	    Assert.assertEquals(text.trim().equalsIgnoreCase("Mall Slots"), true, "The lead page text is not valid.");  
	}

	@When("the Add Slot button is clicked")
	public void theAddSlotButtonIsClicked() {
	     ClassObjects.MS.clickAddSlot();
	}

	@Then("the user is on the Add Slot page")
	public void theUserIsOnTheAddSlotPage() {
//		String text = ClassObjects.MS.getSlotAddPageText();
//		Assert.assertEquals(text.trim(), "Add Slot", "The new mall name is not valid.");
	}
    
    String mall = "Retest Mall-- HSR Layout, Bengaluru";
    String openingTime = "12";
    String closingTime = "2";
    
	@When("all the necessary data is filled for new Slot")
	public void allTheNecessaryDataIsFilledForNewSlot() throws AWTException {
	     ClassObjects.MS.selectSlotMall(mall);
	     ClassObjects.MS.setOpeningTime(openingTime);
	     ClassObjects.MS.setClosingTime(closingTime);
	     ClassObjects.MS.setSlotLimit("25");
	     ClassObjects.MS.selectSlotInterval("15 minutes");
	     ClassObjects.MS.clickSave();
	}

	@Then("the new Slot is verified")
	public void theNewSlotIsVerified() throws AWTException {
		ClassObjects.CC.searchField(mall);
        String text = ClassObjects.MS.getSlotHomeMallNameOpeningAndClosingTimeTexy();
        Assert.assertEquals(text.trim(), mall + " " + openingTime + " " + closingTime, "The new mall name is not valid.");
	}

	@When("a Slot is selected and the Edit button is clicked")
	public void aSlotIsSelectedAndTheEditButtonIsClicked() {
	     
	}

	@When("the Slot name is modified and the Save button is clicked")
	public void theSlotNameIsModifiedAndTheSaveButtonIsClicked() {
	     
	}

	@Then("the modified Slot name is verified")
	public void theModifiedSlotNameIsVerified() {
	     
	}
	
}
