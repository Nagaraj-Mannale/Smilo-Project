package stepDefinations;

import java.awt.AWTException;

import org.testng.Assert;

import io.cucumber.java.en.*;

public class StepCategory {
	@When("the Settings link is clicked, followed by the Serv&Cat tab, then Category")
	public void theLinkIsClickedFollowedByTheTabThen() {
	   ClassObjects.CC.selectPageLink("Settings");
	   ClassObjects.SG.clickOnSettinglink("Product & Services");
	   ClassObjects.SG.selectProductandServiceOption("Categories");
	}

	@Then("the Category page text is validated")
	public void theCategoryPageTextIsValidated() {
	   String text=ClassObjects.SG.getHomePageHeading();
	   System.out.println(text);
	   Assert.assertEquals(text.trim().equalsIgnoreCase("Category"), true, "The Category page text is not valid.");
	}

	@When("the Add Category button is clicked")
	public void theButtonIsClicked() {
	   ClassObjects.SG.clickAddButton();
	}

	@Then("the user should be redirected to the Category add page")
	public void theUserShouldBeRedirectedToTheCategoryMallPage() {
		String text=ClassObjects.SG.getAddPageHeading();
		Assert.assertEquals(text.trim().equalsIgnoreCase("Add Category"), true, "The lead page text is not valid.");
		}
     String CategoryName="Auto Category";
	@When("all the necessary data is entered for the new Category")
	public void allTheNecessaryDataIsEnteredForTheNewCategory() {
		ClassObjects.SG.enterCategoryName(CategoryName);
		ClassObjects.SG.selectCategoryType("Service");
		ClassObjects.SG.toggleSliderStatus();
		ClassObjects.SG.clickSaveButton();
	}

	@Then("the newly added Category is verified")
	public void theNewlyAddedCategoryIsVerified() throws AWTException {
		ClassObjects.CC.searchField(CategoryName);
		String text=ClassObjects.SG.getCategoryFirstRecordName();
		Assert.assertEquals(text.trim().equalsIgnoreCase(CategoryName), true, "The lead page text is not valid.");
	}
	String ModifyCategoryName="Category";
	@When("a Category is selected and the Edit button is clicked")
	public void aCategoryIsSelectedAndTheEditButtonIsClicked() throws AWTException {
		ClassObjects.CC.searchField(ModifyCategoryName);
		ClassObjects.SG.selectKebabOption("Edit");
	}
	
	@When("the Category name is modified and the Save button is clicked")
	public void theCategoryNameIsModifiedAndTheButtonIsClicked() {
	   ClassObjects.SG.enterCategoryName(ModifyCategoryName);
	   ClassObjects.SG.toggleSliderStatus();
	   ClassObjects.SG.clickSaveButton();
	}

	@Then("the modified Category name is verified")
	public void theModifiedCategoryNameIsVerified() throws AWTException {
		ClassObjects.CC.searchField(ModifyCategoryName);
		String text=ClassObjects.SG.getCategoryFirstRecordName();
		String Statustext=ClassObjects.SG.getCategoryFirstRecordStatus();
		Assert.assertEquals(Statustext.trim().equalsIgnoreCase("Disabled"), true, "The status is not get changed");
		Assert.assertEquals(text.trim().equalsIgnoreCase(ModifyCategoryName), true, "The modfiy category text is not valid.");
	}

	@When("a Category is selected and the Delete button is clicked")
	public void aCategoryIsSelectedAndTheDeleteButtonIsClicked() throws AWTException {
		ClassObjects.CC.searchField(ModifyCategoryName);
		ClassObjects.SG.selectKebabOption("Delete");
	}
	
	@Then("the Category should no longer appear in the list")
	public void theCategoryShouldNoLongerAppearInTheList() throws AWTException {
		ClassObjects.CC.searchField(ModifyCategoryName);
		String text=ClassObjects.CC.getEmptyPageText();
		Assert.assertEquals(text.trim().equalsIgnoreCase("No Records Found!"), true, "The modfiy category text is not valid.");

	}



}
