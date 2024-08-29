package stepDefinations;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pom.CommonComponents;
import pom.MallSetting;

public class StepMallUser extends StepBaseClass {

	MallSetting MS;
	CommonComponents CC;
	@When("the MallUser link is clicked")
	public void theMallUserLinkIsClicked() {
	   CC=new CommonComponents(driver);
	   CC.selectPageLink("Mall Settings");
	}

	@Then("the Mall page text is validated")
	public void theMallPageTextIsValidated() throws InterruptedException {
	      String text = CC.getHomePageText();;
	      Assert.assertEquals(text.trim().equalsIgnoreCase("Users"), true, "The lead page text is not valid.");

	}

	@When("the Add Mall button is clicked")
	public void theAddMallButtonIsClicked() {
		MS=new MallSetting(driver);
	    MS.clickAddUser();
	}

	@Then("the user is on the Add Mall page")
	public void theUserIsOnTheAddMallPage() {
		String text = MS.userAddPageText();
	    Assert.assertEquals(text.trim().equalsIgnoreCase("Add User"), true, "The lead page text is not valid.");
  
	}

	@When("all the necessary data is filled")
	public void allTheNecessaryDataIsFilled() {
	    MS.setNameMobileMailPassword("Tester","12345","tester@1gmail.com","Tester@123");
	    MS.selectStatus("Active");
	    MS.selectGroup("selectAll");
	    MS.selectCity("Bidar");
	    MS.selectArea("Noubad");
	    MS.selectMall("Mall8");
	}

	@When("the Save button is clicked")
	public void theSaveButtonIsClicked() {
	  MS.clickSave();
	}

	@Then("the new MallUser is verified")
	public void theNewMallUserIsVerified() {
	    
	}

	@When("a user is selected and the Edit button is clicked")
	public void aUserIsSelectedAndTheEditButtonIsClicked() {
	    // Implement the action to select a user and click the Edit button
	    // Example:
	    // mallSetting.selectUser("User Name");
	    // mallSetting.clickEdit();
	}

	@When("the name is modified and the Save button is clicked")
	public void theNameIsModifiedAndTheSaveButtonIsClicked() {
	    // Implement the action to modify the user's name and click Save
	    // Example:
	    // mallSetting.modifyUserName("New User Name");
	    // mallSetting.clickSave();
	}

	@Then("the modified user name is verified")
	public void theModifiedUserNameIsVerified() {
	    // Implement the action to verify the modified user name
	    // Example:
	    // assertTrue(mallSetting.isUserNameModified("New User Name"));
	}

	
	
	
}
