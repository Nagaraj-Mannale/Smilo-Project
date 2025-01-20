package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import basePage.BaseClass;
import io.cucumber.java.en.*;

public class WidgetFlow extends BaseClass{
	public WidgetFlow(WebDriver driver) {
		super(driver);
		}

	WebDriver driver;
	

	@Given("launch the browser and enter the URL")
	public void launchBrowserAndEnterUrl() {
	    setup("get-started/n9UyYRbhUU3yBR17pXjoMKwBPirr5NPS5V4J0AFTe8r60SyXAB");
	}

	@Then("ensure you're on the first page content")
	public void ensureYouAreOnFirstPageContent() {
	    Assert.assertEquals(getStartedPageText(), "Start Your Oral Health Check Now");
	}

	@When("click on get started button")
	public void clickOnGetStartedButton() {
		startNowBtn();
	}

	@Then("ensure you're on the second page")
	public void ensureYouAreOnSecondPage() {
	    Assert.assertEquals(purposeOfVisitPageText(), "Select reason for your visit");
	}

	@When("select one card and click on the continue button")
	public void selectOneCardAndClickContinue() {
		clickOnResonVisitCard("General Checkup");
	    VisitContBtn();
	}

	@Then("ensure you're on the third page")
	public void ensureYouAreOnThirdPage() {
	    Assert.assertEquals(consentAgreementPageText(), "Consent & Agree");
	}

	@When("click on the continue button")
	public void clickOnContinueButton() {
		consentAgreeContBtn();
	}

	@Then("ensure you're on the fourth page")
	public void ensureYouAreOnFourthPage() {
	    Assert.assertEquals(preferencePageText(), "Select Your Preferences");
	}

	@When("select the OHR card and click on the continue button")
	public void selectOhrCardAndClickContinue() {
	    selectOHRCard("Oral Health Rating");
	    preferenceContBtn();
	}

	@Then("ensure you are on the upload image page")
	public void ensureYouAreOnUploadImagePage() {
	    Assert.assertEquals(uploadPageText(), "Upload Your Image");
	}

	@When("upload an image from your local space")
	public void uploadImageFromLocalSpace() {
	    uploadPageSpace(); // Code to handle file upload
	}

	@When("click on the available button")
	public void clickOnAvailableButton() {
	    doneBtn();
	}

	@Then("ensure you are on the contact info page")
	public void ensureYouAreOnContactInfoPage() {
	    Assert.assertEquals(contactPageText(), "Uploaded Successfully");
	}

	@When("fill all the necessary information and click on the submit button")
	public void fillContactInfoAndSubmit() {
	    firstNameField("John");
	    lastNameField("Doe");
	    emailField("john.doe@example.com");
	    mobileField("1234567890");
	    submitButton();
	}

	@Then("ensure you are on the result page with cards")
	public void ensureYouAreOnResultPageWithCards() {
	    Assert.assertEquals(accessReportPageText(), "Your Smile Check Rating");
	}

	@Then("verify that all card buttons are enabled")
	public void verifyAllCardButtonsAreEnabled() {
	   
	}

	
}
