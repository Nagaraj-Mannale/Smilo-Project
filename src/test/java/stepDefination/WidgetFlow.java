package stepDefination;

import java.awt.AWTException;

import org.junit.Assert;
import basePage.BaseClass;
import io.cucumber.java.en.*;
import pom.Widget;


public class WidgetFlow extends BaseClass {
	
	public static Widget wi;
    
    @Given("launch the browser and enter the URL")
    public void launchBrowserAndEnterUrl() {
        
    	setup("v2widget.tech-active.com");
    }

    @Then("ensure your on the first page")
    public void ensureYouAreOnFirstPageContent() {
    	 wi=new Widget(driver);
        Assert.assertEquals(wi.getStartedPageText(), "Home");
    }

    @When("click on get start button")
    public void clickOnGetStartedButton() {
        wi.startNowBtn();
    }

    @Then("ensure your on the second page")
    public void ensureYouAreOnSecondPage() {
        Assert.assertEquals(wi.purposeOfVisitPageText(), "Select reason for your visit");
    }

    @When("select one card and click on the continue button")
    public void selectOneCardAndClickContinue() throws InterruptedException {
        wi.clickOnResonVisitCard("General Checkup");
        Thread.sleep(2000);
        wi.VisitContBtn();
    }

    @Then("ensure your on the third page")
    public void ensureYouAreOnThirdPage() {
        Assert.assertEquals(wi.consentAgreementPageText(), "Consent & Agree");
    }

    @When("click on the continue button")
    public void clickOnContinueButton() {
        wi.consentAgreeContBtn();
    }

    @Then("ensure your on the fourth page")
    public void ensureYouAreOnFourthPage() {
        Assert.assertEquals(wi.preferencePageText(), "Select Your Preferences");
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

    @When("upload an image from your local space")
    public void uploadImageFromLocalSpace() throws AWTException, InterruptedException {
        wi.uploadPageSpace("/home/active35/Downloads/1st.jpeg");
    }

    @When("click on the get result button")
    public void clickOnResultButton() {
            wi.FrontPageResultBtn();
    }

    @Then("ensure you are on the contact info page")
    public void ensureYouAreOnContactInfoPage() {
        Assert.assertEquals(wi.contactPageText(), "Enter Your Details");
    }

    @When("fill all the necessary information and click on the submit button")
    public void fillContactInfoAndSubmit() {
        wi.firstNameField("John");
        wi.lastNameField("Doe");
        wi.emailField("john.doe@example.com");
        wi.mobileField("1234567890");
        wi.submitButton();
    }

    @Then("Ensure you are on the result page with cards")
    public void ensureYouAreOnResultPageWithCards() {
        Assert.assertEquals(wi.accessReportPageText(), " What’s Next ");
    }

    @Then("verify the all cards buttons are enabled")
    public void verifyAllCardButtonsAreEnabled() {
        // Implement this method to check button statuses.
    }
}
