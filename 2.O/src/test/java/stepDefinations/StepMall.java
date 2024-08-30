package stepDefinations;

import java.awt.AWTException;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pom.CommonComponents;
import pom.MallSetting;

public class StepMall extends StepBaseClass {

    private CommonComponents CC;
    private MallSetting MS;
    private String MallName = "Automative Mall";
    private String ModifyMallName = "AutoCumMan";

    public void setDriver() {
        CC = new CommonComponents(driver);
        MS = new MallSetting(driver);
    }

    // Scenario: Successful Login with Valid Credentials
    @When("the MallUser link and mall tab is clicked")
    public void clickMallUserLinkAndMallTab() {
        CC.selectPageLink("Mall Settings");
        MS.selectTabBylinks("Malls");
    }

    @Then("the Mall page text is validated")
    public void validateMallPageText() {
        String text = CC.getHomePageText();
        Assert.assertEquals(text.trim(), "Malls", "The mall page text is not valid.");
    }

    // Scenario: Verify Mall Add Functionality
    @When("the Add Mall button is clicked")
    public void clickAddMallButton() {
        MS.clickAddMall();
    }

    @Then("the user is on the Add Mall page")
    public void verifyUserIsOnAddMallPage() {
        // Implement verification that the user is on the Add Mall page
    }

    @When("all the necessary data is filled for new Mall")
    public void fillInAllNecessaryData() {
        MS.setName(MallName);
        MS.selectCity("Bidar");
        MS.selectArea("Noubad");
        MS.setCustomerNumber("1254876523");
        MS.setSupervisorNumber("4561237892");
        MS.selectStatus("Active");
        MS.selectLocation("Select all");
        MS.selectGroup("Public");
    }

    @Then("the new Mall is verified")
    public void verifyNewMall() {
        String text = MS.GetFirstRecUserName();
        Assert.assertEquals(text.trim(), MallName, "The new mall name is not valid.");
    }

    // Scenario: Verify Mall Edit Functionality
    @When("a Mall is selected and the Edit button is clicked")
    public void selectMallAndClickEdit() throws AWTException {
        CC.searchField(MallName);
        MS.clickEdit();
    }

    @When("the Mall name is modified and the Save button is clicked")
    public void modifyMallNameAndClickSave() {
        MS.setName(ModifyMallName);
        MS.clickSave();
    }

    @Then("the modified mall name is verified")
    public void verifyModifiedMallName() {
        String text = MS.GetFirstRecUserName();
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
