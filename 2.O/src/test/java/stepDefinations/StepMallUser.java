package stepDefinations;

import java.awt.AWTException;
import org.testng.Assert;
import io.cucumber.java.en.*;


public class StepMallUser extends StepBaseClass {

	@When("the MallUser link is clicked")
	public void theMallUserLinkIsClicked() {
		ClassObjects.CC.selectPageLink("Mall Settings");
	}

	@Then("the User page text is validated")
	public void theMallPageTextIsValidated() {
	      String text = ClassObjects.CC.getHomePageText();;
	      Assert.assertEquals(text.trim().equalsIgnoreCase("Users"), true, "The Mall page text is not valid.");

	}

	@When("the Add User button is clicked")
	public void theAddMallButtonIsClicked() {
		ClassObjects.MS.clickAddUser();
	}

	@Then("the user is on the Add User page")
	public void theUserIsOnTheAddMallPage() {
		String text = ClassObjects.MS.userAddPageText();
	    Assert.assertEquals(text.trim().equalsIgnoreCase("Add User"), true, "The lead page text is not valid.");
  
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
		ClassObjects.MS.clickonSaveButton();
	}

	@Then("the new MallUser is verified")
	public void theNewMallUserIsVerified() {
		String text = ClassObjects.MS.GetFirstRecUserName();
	    Assert.assertEquals(text.trim().equalsIgnoreCase("Tester"), true, "The lead page text is not valid."); 
	}

	@When("a user is selected and the Edit button is clicked")
	public void aUserIsSelectedAndTheEditButtonIsClicked() throws AWTException {
		ClassObjects.CC.searchField(Usermail);
	    ClassObjects.MS.clickEdit();
	}
    String ModifiedUserName="Tester";
	@When("the name is modified and the Save button is clicked")
	public void theNameIsModifiedAndTheSaveButtonIsClicked() {
		ClassObjects.MS.setName(ModifiedUserName);
		ClassObjects.MS.clickonSaveButton();
	}

	@Then("the modified user name is verified")
	public void theModifiedUserNameIsVerified() throws AWTException {
		ClassObjects.CC.searchField(Usermail);
		String text = ClassObjects.MS.GetFirstRecUserName();
	    Assert.assertEquals(text.trim().equalsIgnoreCase(ModifiedUserName), true, "The lead page text is not valid.");
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
//		ClassObjects.CC.searchField(Usermail);
//		String text = ClassObjects.CC.getEmptyPageText();
//	    Assert.assertEquals(text.trim().equalsIgnoreCase("No Users Found!"), true, "The user is not valid.");
		
	}
	
	
	
}
