package stepDefinations;

import java.awt.AWTException;

import org.testng.Assert;

import io.cucumber.java.en.*;
public class StepMall extends StepBaseClass {


    private String MallName = "Automative Mall";
    private String ModifyMallName = "AutoCumMan";


    @When("the MallUser link and mall tab is clicked")
    public void clickMallUserLinkAndMallTab() {
     ClassObjects.CC.selectPageLink("Mall Settings");
     ClassObjects.MS.selectTabBylinks("Malls");
    }

    @Then("the Mall page text is validated")
    public void validateMallPageText() {
        String text = ClassObjects.CC.getHomePageText();
        Assert.assertEquals(text.trim(), "Malls", "The mall page text is not valid.");
    }

  // Scenario: Verify Mall Add Functionality
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
    public void verifyNewMall() {
        String text = ClassObjects.MS.GetFirstRecUserName();
        Assert.assertEquals(text.trim(), MallName, "The new mall name is not valid.");
    }

   // Scenario: Verify Mall Edit Functionality
    @When("a Mall is selected and the Edit button is clicked")
    public void selectMallAndClickEdit() throws AWTException, InterruptedException {
    	ClassObjects.CC.searchField(MallName);
        ClassObjects.MS.clickEdit();
    }

    @When("the Mall name is modified and the Save button is clicked")
    public void modifyMallNameAndClickSave() {
    	ClassObjects.MS.setName(ModifyMallName);
    	ClassObjects.MS.clickSave();
    }

    @Then("the modified mall name is verified")
    public void verifyModifiedMallName() {
        String text = ClassObjects.MS.GetFirstRecUserName();
        Assert.assertEquals(text.trim(), ModifyMallName, "The modified mall name is not valid.");
    }

 // Scenario: Verify Mall Delete Functionality
    @When("a mall is selected and the delete button is clicked")
    public void selectMallAndClickDelete() {
        // Implement selecting a mall and clicking the delete button
    }

    @Then("the mall should no longer appear in the list")
    public void verifyMallIsDeleted() {
        // Implement verification that the mall is no longer in the list
    }
}
