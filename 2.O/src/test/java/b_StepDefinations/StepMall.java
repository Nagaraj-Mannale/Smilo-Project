package b_StepDefinations;

import java.awt.AWTException;

import org.testng.Assert;

import b_BasePage.ClassObjects;
import b_BasePage.StepBaseClass;
import io.cucumber.java.en.*;
public class StepMall extends StepBaseClass {


    private String MallName = "AutoCumMan1";
    private String ModifyMallName = "AutoCumMan";


    @When("the MallUser link and mall tab is clicked")
    public void clickMallUserLinkAndMallTab() {
     ClassObjects.CC.selectPageLink("Mall Settings");
     ClassObjects.MS.selectTabBylinks("Malls");
    }

    @Then("the Mall page text is validated")
    public void validateMallPageText() {
        String text = ClassObjects.MS.GetMallHomePageName();
        Assert.assertEquals(text.trim(), "Malls", "The mall page text is not valid.");
    }

    @When("the Add Mall button is clicked")
    public void clickAddMallButton() {
    	ClassObjects.MS.clickAddMall();
    }

    @Then("the user is on the Add Mall page")
    public void verifyUserIsOnAddMallPage() {
        
    }

    @When("all the necessary data is filled for new Mall")
    public void fillInAllNecessaryData() throws AWTException, InterruptedException {
    	ClassObjects.MS.setName(MallName);
    	ClassObjects.MS.selectCity("Bidar");
    	ClassObjects.MS.selectArea("Noubad");
    	ClassObjects.MS.setCustomerNumber("1254876523");
    	ClassObjects.MS.setSupervisorNumber("4561237892");
    	ClassObjects.MS.selectStatus("Enabled");
    	ClassObjects.MS.selectLocation("Select all");
    	ClassObjects.MS.selectMallGroupDrop("Public");
    }

    @Then("the new Mall is verified")
    public void verifyNewMall() throws AWTException {
    	ClassObjects.CC.searchField(MallName);
        String text = ClassObjects.MS.GetFirstRecUserName();
        Assert.assertEquals(text.trim(), MallName, "The new mall name is not valid.");
    }

   // Scenario: Verify Mall Edit Functionality
    @When("a Mall is selected and the Edit button is clicked")
    public void selectMallAndClickEdit() throws AWTException{
    	ClassObjects.CC.searchField(MallName);
        ClassObjects.MS.clickEdit();
    }

    @When("the Mall name is modified and the Save button is clicked")
    public void modifyMallNameAndClickSave() throws InterruptedException {
    	ClassObjects.MS.setName(ModifyMallName);
    	Thread.sleep(2000);
    	ClassObjects.CC.clickOnSaveButton();
    }

    @Then("the modified mall name is verified")
    public void verifyModifiedMallName() throws AWTException {
    	ClassObjects.CC.searchField(ModifyMallName);
        String text = ClassObjects.MS.GetFirstRecUserName();
        Assert.assertEquals(text.trim(), ModifyMallName, "The modified mall name is not valid.");
    }

 // Scenario: Verify Mall Delete Functionality
    @When("a mall is selected and the delete button is clicked")
    public void selectMallAndClickDelete() throws AWTException {
    	ClassObjects.CC.searchField(ModifyMallName);
    	ClassObjects.MS.clickDelete();
    	ClassObjects.CC.deletePopupHandle("Yes");
    	
    }

    @Then("the mall should no longer appear in the list")
    public void verifyMallIsDeleted() throws AWTException {
    	//ClassObjects.CC.searchField(ModifyMallName);
    	String text=ClassObjects.CC.getSuccessMessage();
    	Assert.assertEquals(text.trim(), "Mall deleted", "The mall is not deleted");
    	
    }
}
