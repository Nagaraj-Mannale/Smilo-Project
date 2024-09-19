package stepDefinations;

import java.awt.AWTException;

import org.testng.Assert;

import basePage.ClassObjects;
import io.cucumber.java.en.*;

public class StepService {
	@When("the Settings link is clicked, followed by the Serv&Cat tab, then Service")
	public void theLinkIsClickedFollowedByTheTabThen() {
		ClassObjects.CC.selectPageLink("Settings");
        ClassObjects.SG.clickOnSettingLink("Product & Services");
        ClassObjects.SG.selectProductAndServiceOption("Service");
	}

	@Then("the Service page text is validated")
	public void theServicePageTextIsValidated() {
		Assert.assertEquals(ClassObjects.SG.getServiceHomePagetext(), "Services");
	}

	@When("the Add Service button is clicked")
	public void theAddServiceButtonIsClicked( ) {
	    ClassObjects.SG.clickAddButton();
	}

	@Then("the user should be redirected to the Service Add page")
	public void theUserShouldBeRedirectedToTheServiceMallPage() {
	 Assert.assertEquals(ClassObjects.SG.getServiceAddPagetext(),"Add Service");
	}
   String ServiceName="OIL Change";
	@When("the user enters all necessary data on the General page")
	public void userEntersNecessaryDataOnGeneralPage() {
	    ClassObjects.SG.enterCatOrProduOrServiceName(ServiceName);
	    ClassObjects.SG.selectServicePageCategoryOption("Internal Wash");
	    ClassObjects.SG.selectGSTOption("18.0");
	    ClassObjects.SG.enterTimeTaken("15");
	    ClassObjects.SG.toggleSliderForStatus();
	    ClassObjects.SG.enterTagText("abcd");
	}
	@And("the user fills in the service availability data on the Availability page")
	public void userFillsServiceAvailabilityDataOnAvailabilityPage() {
	    
	}

	@And("the user enters the price based on the segment")
	public void userEntersPriceBasedOnSegment() {
	    
	}

	@And("the user uploads an image")
	public void userUploadsImage() {
	    
	}

	@And("the user uploads a video link")
	public void userUploadsVideoLink() {
	    ClassObjects.SG.enterVideoLink("https://www.vidio.link");
	}

	@And("the user either adds the new service or clicks the Cancel button to return to the home page")
	public void userAddsNewServiceOrClicksCancelButtonToReturnToHomePage() {
	    ClassObjects.CC.clickOnCancelButton();
	}
	
	@Then("the newly added service should be verified")
	public void theNewlyAddedServiceIsVerified() throws AWTException {
	 ClassObjects.CC.searchField(ServiceName);
	 Assert.assertEquals(ClassObjects.SG.getServiceFirstRecordtext(),ServiceName);
	}

	@When("a Service is selected and the Edit button is clicked")
	public void aServiceIsSelectedAndTheEditButtonIsClicked( ) throws AWTException {
		ClassObjects.CC.searchField(ServiceName);
		ClassObjects.CC.selectKebabOption("Edit");
		
	}
    String modifiedServiceName="Ghare Box Change";
	@When("the Service name is modified")
	public void theServiceNameIsModifiedAndTheButtonIsClicked( ) {
	 ClassObjects.SG.enterCatOrProduOrServiceName(modifiedServiceName);
	 ClassObjects.CC.clickOnSaveButton();
	 ClassObjects.SG.clickOnServiceEditPageLinks("Service Availability");
	 ClassObjects.SG.selectServiceAvailability("Home and Mall Service");
	 ClassObjects.SG.enterEstimateTime("15");
	 ClassObjects.SG.selectavailableMall("RMZ Millenia"); 
	}
	@When("get back to the Service home page")
	public void getBackTotheServiceHomePage() {
	 ClassObjects.SG.clickOnSettingLink("Product & Services");
     ClassObjects.SG.selectProductAndServiceOption("Service");
	}
	@Then("the modified Service name is verified")
	public void theModifiedServiceNameIsVerified() throws AWTException {
		ClassObjects.CC.searchField(modifiedServiceName);
		Assert.assertEquals(ClassObjects.SG.getServiceFirstRecordtext(),modifiedServiceName);
	}
	@When("a Service is selected and the Delete button is clicked")
	public void aServiceIsSelectedAndTheDeleteButtonIsClicked( ) throws AWTException {
		ClassObjects.CC.searchField(modifiedServiceName);
		ClassObjects.CC.selectKebabOption("delete");
		ClassObjects.CC.deletePopupHandle("yes");
	}

	@Then("the Service should no longer appear in the list")
	public void theServiceShouldNoLongerAppearInTheList() throws AWTException {
		ClassObjects.CC.searchField(modifiedServiceName);
		Assert.assertEquals(ClassObjects.SG.getCatProdAndServicePageEmptyText(),"No Records Found!");
	}
	


}
