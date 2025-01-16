package b_StepDefinations;

import java.awt.AWTException;

import org.testng.Assert;

import b_BasePage.ClassObjects;
import io.cucumber.java.en.*;

public class StepProduct {
	@When("the Settings link is clicked, followed by the Serv&Cat tab, then Product")
	public void theLinkIsClickedFollowedByTheTabThen() {
		 ClassObjects.CC.selectPageLink("Settings");
	        ClassObjects.SG.clickOnSettingLink("Product & Services");
	        ClassObjects.SG.selectProductAndServiceOption("Product");
	}

	@Then("the Product page text is validated")
	public void theProductPageTextIsValidated() {
	  Assert.assertEquals(ClassObjects.SG.productHomePagetext(),"Products");  
	}

	@When("the Add Product button is clicked")
	public void AddProductButtonIsClicked() {
	    ClassObjects.SG.clickAddButton();
	}

	@Then("the user should be redirected to the Product Add page")
	public void theUserShouldBeRedirectedToTheProductMallPage() {
		 Assert.assertEquals(ClassObjects.SG.getProductAddPageText(),"Add Product");
	}
    String ProductName="Chain Cover";
	@When("the user enters all necessary data on the Product General page")
	public void allTheNecessaryDataIsEnteredForTheNewProduct() {
	    ClassObjects.SG.enterCatOrProduOrServiceName(ProductName);
	    ClassObjects.SG.enterHSNNumber("12345");
	    ClassObjects.SG.selectServicePageCategoryOption("Products");
	    ClassObjects.SG.selectGSTOption("18.0");
	    ClassObjects.SG.enterQuantity("15");
	    ClassObjects.SG.enterMaxQuantity("20");
	    ClassObjects.SG.toggleSliderForStatus();
	    ClassObjects.SG.enterTagText("abcde");
	}
    @When("the user enters the Product price based on the segment")
    public void UserEntersTheProductPriceBasedOnTheSegment()
    {
    	
    }
    @When("the user uploads the Product image")
	public void UserUploadsTheProductImage() {
	    
	}
    @When("the user uploads the product video link")
	public void UserUploadsTheProductVideoLink() {
    	ClassObjects.SG.enterVideoLink("https://product vidio.com");
	}
    @When("the user either adds the new service or clicks the Cancel button to return to the Product home page")
   	public void ReturnTotheProductHomePage() {
    	ClassObjects.CC.clickOnCancelButton();
   	}
	@Then("the newly added Product is verified")
	public void theNewlyAddedProductIsVerified() throws AWTException {
		ClassObjects.CC.searchField(ProductName);
		Assert.assertEquals(ClassObjects.SG.getProductFirstRecordtext(),ProductName);
		}

	@When("a Product is selected and the Edit button is clicked")
	public void aProductIsSelectedAndTheEditButtonIsClicked() throws AWTException {
		ClassObjects.CC.searchField(ProductName);
		ClassObjects.CC.selectKebabOption("Edit");
	}
    String modifyProductName="Back Wheel";
	@When("the Product name is modified")
	public void theProductNameIsModified() {
	ClassObjects.SG.enterCatOrProduOrServiceName(modifyProductName);
	    
	}
	@When("return to the Product home page")
	public void returnToTheProductHomePage() {
	ClassObjects.SG.clickOnSettingLink("Product & Services");
	ClassObjects.SG.selectProductAndServiceOption("Product");
  
	}
	@Then("the modified Product name is verified")
	public void theModifiedProductNameIsVerified() {
	Assert.assertEquals(ClassObjects.SG.getProductFirstRecordtext(),modifyProductName);
	}
	@When("a Product is selected and the Delete button is clicked")
	public void aProductIsSelectedAndTheDeleteButtonIsClicked() throws AWTException {
		ClassObjects.CC.searchField(modifyProductName);
		ClassObjects.CC.selectKebabOption("delete");
		ClassObjects.CC.deletePopupHandle("yes");
	}

	@Then("the Product should no longer appear in the list")
	public void theProductShouldNoLongerAppearInTheList() throws AWTException {
		ClassObjects.CC.searchField(modifyProductName); 
		Assert.assertEquals(ClassObjects.SG.getCatProdAndServicePageEmptyText(),"No Records Found!");
	}


}
