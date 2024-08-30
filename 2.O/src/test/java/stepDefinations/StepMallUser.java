package stepDefinations;

import java.awt.AWTException;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pom.CommonComponents;
import pom.MallSetting;

public class StepMallUser extends StepBaseClass {

	private MallSetting MS;
	private CommonComponents CC;
	
	public StepMallUser()	{
	 CC=new CommonComponents(driver);
	 MS=new MallSetting(driver);
	}
	@When("the MallUser link is clicked")
	public void theMallUserLinkIsClicked() {
	   CC.selectPageLink("Mall Settings");
	}

	@Then("the User page text is validated")
	public void theMallPageTextIsValidated() throws InterruptedException {
	      String text = CC.getHomePageText();;
	      Assert.assertEquals(text.trim().equalsIgnoreCase("Users"), true, "The lead page text is not valid.");

	}

	@When("the Add User button is clicked")
	public void theAddMallButtonIsClicked() {
	    MS.clickAddUser();
	}

	@Then("the user is on the Add User page")
	public void theUserIsOnTheAddMallPage() {
		String text = MS.userAddPageText();
	    Assert.assertEquals(text.trim().equalsIgnoreCase("Add User"), true, "The lead page text is not valid.");
  
	}
     String UserName="Tester";
	@When("all the necessary data is filled")
	public void allTheNecessaryDataIsFilled() {
	    MS.setNameMobileMailPassword(UserName,"1234567890","tester@1gmail.com","Tester@123");
	    MS.selectStatus("Active");
	    MS.selectGroup("Select all");
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
		String text = MS.GetFirstRecUserName();
	    Assert.assertEquals(text.trim().equalsIgnoreCase(UserName), true, "The lead page text is not valid."); 
	}

	@When("a user is selected and the Edit button is clicked")
	public void aUserIsSelectedAndTheEditButtonIsClicked() throws AWTException {
	    CC.searchField(UserName);
		MS.clickEdit();
	}
    String ModifiedUserName="Tester2";
	@When("the name is modified and the Save button is clicked")
	public void theNameIsModifiedAndTheSaveButtonIsClicked() {
	    MS.setName(ModifiedUserName);
	    MS.clickSave();
	}

	@Then("the modified user name is verified")
	public void theModifiedUserNameIsVerified() {
		String text = MS.GetFirstRecUserName();
	    Assert.assertEquals(text.trim().equalsIgnoreCase(ModifiedUserName), true, "The lead page text is not valid.");
	}
	@When("a user is selected and the delete button is clicked")
	public void selectUserAndClickDelete() throws AWTException {
		 CC.searchField(ModifiedUserName);
		 MS.clickDelete();
		 CC.deletePopupHandle("yes");
		 String text = CC.getSuccessMessage();
		 Assert.assertEquals(text.trim().equalsIgnoreCase("deleted"), true, "The user is not deletec.");
		 
	}
	@Then("the user should no longer appear in the list")
	public void verifyUserIsDeletedByName() throws AWTException {
		CC.searchField(ModifiedUserName);
		String text = CC.getEmptyPageText();
	    Assert.assertEquals(text.trim().equalsIgnoreCase("No Users Found!"), true, "The user is not valid.");
		
	}
	
	
	
}
