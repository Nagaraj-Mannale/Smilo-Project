package pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import basePage.Constructor;

public class Widget extends Constructor {

	public WebDriver driver;

	public Widget(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Home']")
	WebElement getStartedPageText;
	@FindBy(xpath = "//button[text()=' Start Now ']")
	WebElement startNowButton;
	@FindBy(xpath = "//h1[text()='Select reason for your visit']")
	WebElement purposeOfVisitText;
	@FindBy(xpath = "//div[@id='general_checkup']/../div//label/h3")
	List<WebElement> visitPageCards;
	@FindBy(xpath = "//button[text()=' Continue ']")
	WebElement visitPageContinueButton;
	@FindBy(xpath = "//h1[text()='Consent & Agree']")
	WebElement consentAgreementPageText;
	@FindBy(xpath = "//span[text()='Continue']")
	WebElement consentAgreementPageContinueButton;

	public String getStartedPageText() {
		return getStartedPageText.getText();
	}

	public void startNowBtn() {
		startNowButton.click();
	}

	public String purposeOfVisitPageText() {
		return purposeOfVisitText.getText();
	}

	public void clickOnResonVisitCard(String cardName)

	{
		for (WebElement Card : visitPageCards) {
			if (Card.getText().equalsIgnoreCase(cardName)) {
				Card.click();
			}
		}
	}

	public void VisitContBtn() {
		visitPageContinueButton.click();
	}

	public String consentAgreementPageText() {
		return consentAgreementPageText.getText();
	}

	public void consentAgreeContBtn() {
		consentAgreementPageContinueButton.click();
	}

	@FindBy(xpath = "//h1[text()='Select Your Preferences']")
	WebElement preferencePageText;
	@FindBy(xpath = "//div[@class='checkbox']/../label/h3")
	List<WebElement> preferencePageCards;
	@FindBy(xpath = "//button[text()=' Continue ']")
	WebElement preferencePageContinueButton;
	@FindBy(xpath = "//h1[text()=' Upload Your Image ']")
	WebElement uploadPageText;
	@FindBy(xpath = "//div[@class='upload_image_div']")
	WebElement uploadPageSpace;
	@FindBy(xpath = "//span[text()=' Done ']")
	WebElement doneButton;
	@FindBy(xpath = "//span[text()='Get your Results']")
	WebElement frontPageResultButton;

	public String preferencePageText() {
		return preferencePageText.getText();
	}

	public void selectOHRCard(String cardName) {
		for (WebElement card : preferencePageCards) {
			if (card.getText().equalsIgnoreCase(cardName)) {
				card.click();
			}
		}
	}

	public void preferenceContBtn() {
		preferencePageContinueButton.click();
	}

	public String uploadPageText() {
		return uploadPageText.getText();
	}

	public void uploadPageSpace() throws AWTException, InterruptedException {
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", uploadPageSpace );
		uploadPageSpace.click();
		Robot rb=new Robot();
		  rb.keyPress(KeyEvent.VK_CAPS_LOCK);
		  //Thread.sleep(500);
          //rb.keyPress(KeyEvent.VK_TAB);
          Thread.sleep(500);  // Hold ALT+TAB for half a second
          rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
        //  rb.keyRelease(KeyEvent.VK_ALT);
//
//		Thread.sleep(2000);
//		rb.keyPress(KeyEvent.VK_ALT);
//		rb.keyPress(KeyEvent.VK_TAB);
//		rb.keyRelease(KeyEvent.VK_ALT);
//		rb.keyRelease(KeyEvent.VK_TAB);
//		int i=1;
//		while(i<=8)
//		{
//			rb.keyPress(KeyEvent.VK_TAB);
//			rb.keyRelease(KeyEvent.VK_TAB);
//			Thread.sleep(2000);
//			i++;
//		}
//		uploadPageSpace.sendKeys(imagePath);
//        Thread.sleep(2000);
//        
//        rb.keyPress(KeyEvent.VK_ENTER);
//        Thread.sleep(2000);
//        rb.keyRelease(KeyEvent.VK_ENTER);
      //  doneButton.click();

	}

	/*public void doneBtn() {
		doneButton.click();
	}*/

	public void FrontPageResultBtn() {
                                                                                     
	}

	@FindBy(xpath = "//h3[text()='Enter Your Details']")
	WebElement contactPageText; //
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstNameField;
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastNameField;
	@FindBy(xpath = "//input[@placeholder='Email Address']")
	WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']/preceding-sibling::div[1]/div[2]//li")
	List<WebElement> countriesCodeField;
	@FindBy(xpath = "//input[@placeholder='Mobile Number']")
	WebElement mobileField;
	@FindBy(xpath = "//span[text()='Submit']")
	WebElement submitButton;

	public String contactPageText() {
		return contactPageText.getText();
	}

	public void firstNameField(String name) {
		firstNameField.sendKeys(name);
	}

	public void lastNameField(String name) {
		lastNameField.sendKeys(name);
	}

	public void emailField(String email) {
		emailField.sendKeys(email);
	}

	public void countriesCodeField(String Code) {
		for (WebElement code : countriesCodeField) {
			if (code.getText().equalsIgnoreCase(Code)) {
				code.click();
			}
		}
	}

	public void mobileField(String number) {
		mobileField.sendKeys(number);
	}

	public void submitButton() {
		submitButton.click();
	}

	@FindBy(xpath = "//h1[text()=' What’s Next ']")
	WebElement accessReportPageText;
	@FindBy(xpath = "//h4[text()='Download Your Oral Health Report']")
	WebElement downloadCard;
	@FindBy(xpath = "//button[text()=' Download Report ']")
	WebElement downloadreportButton;
	@FindBy(xpath = "//input[@type='radio'][1]")
	WebElement downloadEmailRadioButton;
	@FindBy(xpath = "//input[@type='radio'][1]")
	WebElement downloadwhatsapplRadioButton;
	@FindBy(xpath = "//button[text()=' Confirm ']")
	WebElement ReportConfirmationBtn;
	@FindBy(xpath = "//h2[text()='Report Shared']")
	WebElement reportsentConfirmationReport;

	public String accessReportPageText() {
		return accessReportPageText.getText();
	}

	public void DownloadReportCard(String option) {
		downloadreportButton.click();

		if (option.equalsIgnoreCase("email")) {
			downloadEmailRadioButton.click();
		} else {
			downloadwhatsapplRadioButton.click();
		}

		ReportConfirmationBtn.click();
	}

	public String reportSentConfirmationMsg() {
		return reportsentConfirmationReport.getText();
	}

}
