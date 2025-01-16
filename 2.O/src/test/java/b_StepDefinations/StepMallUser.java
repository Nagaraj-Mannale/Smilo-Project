package b_StepDefinations;

import java.awt.AWTException;
import org.testng.Assert;

import b_BasePage.ClassObjects;
import b_BasePage.StepBaseClass;
import io.cucumber.java.en.*;


public class StepMallUser extends StepBaseClass {

	@When("the MallUser link is clicked")
	public void theMallUserLinkIsClicked() {
		ClassObjects.CC.selectPageLink("Mall Settings");
	}

	@Then("the User page text is validated")
	public void theMallPageTextIsValidated() {
	      Assert.assertEquals(ClassObjects.MS.getUserHomePageText(),"Users");
	}

	@When("the Add User button is clicked")
	public void theAddMallButtonIsClicked() {
		ClassObjects.MS.clickAddUser();
	}

	@Then("the user is on the Add User page")
	public void theUserIsOnTheAddMallPage() {
	    Assert.assertEquals(ClassObjects.MS.getUserAddPageText(),"Add User");
  
	}
     String Usermail="tester@5gmail.com";
	@When("all the necessary data is filled")
	public void allTheNecessaryDataIsFilled() throws AWTException {
		ClassObjects.MS.setNameMobileMailPassword("Tester","1234567890",Usermail,"Tester@123");
		ClassObjects.MS.selectStatus("Active");
		ClassObjects.MS.selectGroup("Select all");
		ClassObjects.MS.selectCity("Bidar");
		ClassObjects.MS.selectArea("Noubad");
		ClassObjects.MS.selectMall("Mall8");
	}

	@When("the Save button is clicked")
	public void theSaveButtonIsClicked() {
		ClassObjects.CC.clickOnSaveButton();
	}

	@Then("the new MallUser is verified")
	public void theNewMallUserIsVerified() {
		Assert.assertEquals(ClassObjects.MS.GetFirstRecUserName(),"Tester");
	}

	@When("a user is selected and the Edit button is clicked")
	public void aUserIsSelectedAndTheEditButtonIsClicked() throws AWTException {
		ClassObjects.CC.searchField(Usermail);
	    ClassObjects.MS.clickEdit();
	}
    String ModifiedUserName="Tester2";
	@When("the Username is modified")
	public void theUserNameIsModified() {
		ClassObjects.MS.setName(ModifiedUserName);
	}

	@Then("the modified user name is verified")
	public void theModifiedUserNameIsVerified() throws AWTException {
		ClassObjects.CC.searchField(Usermail);
	    Assert.assertEquals(ClassObjects.MS.GetFirstRecUserName(),ModifiedUserName);
	    }
	@When("a user is selected and the delete button is clicked")
	public void selectUserAndClickDelete() throws AWTException {
		ClassObjects.CC.searchField(ModifiedUserName);
		ClassObjects.MS.clickDelete();
		ClassObjects.CC.deletePopupHandle("yes");
		 String text = ClassObjects.CC.getSuccessMessage();
		 Assert.assertEquals(text.trim().equalsIgnoreCase("deleted"), true, "The user is not deletec.");
		 
	}
	@Then("the user should no longer appear in the list")
	public void verifyUserIsDeletedByName() throws AWTException {
	ClassObjects.CC.searchField(Usermail);
    Assert.assertEquals(ClassObjects.MS.getUserPageEmptyText(),"No Users Found!");
		
	}
	
	
	
}
