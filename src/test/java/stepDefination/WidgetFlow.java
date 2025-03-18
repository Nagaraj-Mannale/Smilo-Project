package stepDefination;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import basePage.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.PomWidget;

public class WidgetFlow extends BaseClass {

	private static PomWidget wi;


	@Given("launch the widget browser with the valid token")
	public void launchBrowserAndEnterUrl() {
		setup("v2widget.tech-active.com/get-started/E8ofS6LFsTYPMp0rlLOzFPySAj5of9K0jfXsQThyD4OsKaElvT");
		wi = new PomWidget(driver);
	
	}

	@Then("ensure your on getStarted page")
	public void ensureYouAreOnFirstPageContent() {
		Assert.assertEquals(wi.getStartedPageText(), "Home");
	}

	@When("click on get start button")
	public void clickOnGetStartedButton() {
		wi.startNowBtn();
	}

	@Then("ensure your on the purpose Of Visit Page")
	public void ensureYouAreOnSecondPage() {
		Assert.assertEquals(wi.purposeOfVisitPageText(), "Select reason for your visit");
	}

	@When("select one card and click on the continue button")
	public void selectOneCardAndClickContinue() throws InterruptedException {
		wi.clickOnVisitCard("General Checkup");
		Thread.sleep(2000);
		wi.visitContBtn();
	}

	@Then("ensure your on the consent Agreement page")
	public void ensureYouAreOnThirdPage() {
		Assert.assertEquals(wi.consentAgreementPageText(), "Consent & Agree");
	}

	@When("click on the continue button")
	public void clickOnContinueButton() {
		wi.consentAgreeContBtn();
	}

	@Then("ensure your on the preference Page")
	public void ensureYouAreOnFourthPage() {
		Assert.assertEquals(wi.preferencePageText(), "Select Your Preferences");
	}
	@Then("ensure the cards displaying according to configure in the admin portal")
	public void preferencePageAsPerTheAdminConfig()
	{
		System.out.println(wi.cardCountWithName());
		System.out.println(stepDefination.StepPractitioner.AdminWidgetButtonsDetails);
		Assert.assertEquals(wi.cardCountWithName(),stepDefination.StepPractitioner.AdminWidgetButtonsDetails);
	}

	@When("select the OHR card and click on the continue button")
	public void selectOhrCardAndClickContinue() {
		wi.selectOHRCard("Oral Health Rating");
		wi.preferenceContBtn();
	}

	@Then("ensure you are on the upload image page")
	public void ensureYouAreOnUploadImagePage() {
		Assert.assertEquals(wi.uploadPageText(), "Upload Your Image");
	}

	@When("upload images from your local space and click on result button")
	public void uploadImagesFromLocalSpace(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    // Get image paths from the data table
	    List<String> imageLoc = dataTable.asList(String.class);
	    wi.uploadPageSpace(imageLoc);
	}

	@Then("ensure you are on the contact info page")
	public void ensureYouAreOnContactInfoPage() {
		Assert.assertEquals(wi.contactPageText(), "Enter Your Details");
	}

	@When("fill all the necessary information and click on the submit button")
	public void fillContactInfoAndSubmit() {
		wi.firstNameField("Tester");
		wi.lastNameField("Rao");
		wi.emailField("nagaraj@rokkun.io");
		wi.mobileField("1234567890");
		wi.submitButton();
	}

	@Then("Ensure you are on the result page with cards")
	public void ensureYouAreOnResultPageWithCards() {
		Assert.assertEquals(wi.accessReportPageText(), true);
	}

	@Then("verify the all cards buttons are enabled")
	public void verifyAllCardButtonsAreEnabled() {
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		for (WebElement button : buttons) {
			Assert.assertTrue("Button is not enabled: " + button.getText(), button.isEnabled());
		}
	}
}
