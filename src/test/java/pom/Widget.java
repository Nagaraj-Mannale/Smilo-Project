package pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.Constructor;

public class Widget extends Constructor {

	private WebDriverWait wait;

	public Widget(WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
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

	// Refactored to use the reusable method
	public void clickOnVisitCard(String cardName) {
		selectCard(visitPageCards, cardName);
	}

	public void visitContBtn() {
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
		selectCard(preferencePageCards, cardName);
	}

	public void preferenceContBtn() {
		preferencePageContinueButton.click();
	}

	public String uploadPageText() {
		return uploadPageText.getText();
	}

	public void uploadPageSpace() throws AWTException {
		uploadPageSpace.click();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.quit();

		Robot rb = new Robot();

		int i = 1;
		while (i <= 8) {
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			i++;
		}

		// Press ENTER
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		// Press ENTER again
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		// Pass string through Robot class
		typeString(rb, "1st");

		// Press ENTER after typing
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(100);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.delay(100);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		wait.until(ExpectedConditions.elementToBeClickable(doneButton));
		doneButton.click();
	}

	public static void typeString(Robot rb, String text) {
		for (char c : text.toCharArray()) {
			typeCharacter(rb, c);
		}
	}

	public static void typeCharacter(Robot rb, char c) {
		try {
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
			if (keyCode == KeyEvent.VK_UNDEFINED) {
				System.out.println("Cannot type character: " + c);
				return;
			}
			rb.keyPress(keyCode);
			rb.keyRelease(keyCode);
			rb.delay(100); // Small delay for typing effect

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void selectCard(List<WebElement> cards, String cardName) {
		for (WebElement card : cards) {
			if (card.getText().equalsIgnoreCase(cardName)) {
				card.click();
				break;
			}
		}
	}

	public void FrontPageResultBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(frontPageResultButton));
		frontPageResultButton.click();
	}

	@FindBy(xpath = "//h3[text()='Enter Your Details']")
	WebElement contactPageText;
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

	public void countriesCodeField(String code) {
		selectCountryCode(countriesCodeField, code);
	}

	private void selectCountryCode(List<WebElement> codes, String code) {
		for (WebElement c : codes) {
			if (c.getText().equalsIgnoreCase(code)) {
				c.click();
				break;
			}
		}
	}

	public void mobileField(String number) {
		mobileField.sendKeys(number);
	}

	public void submitButton() {
		submitButton.click();
		// Add WebDriverWait to ensure the next page loads properly
		// wait.until(ExpectedConditions.urlContains("nextPage"));
	}

	@FindBy(xpath = "//img[@src='assets/images/severe_g.png']")
	WebElement accessReportPageImage;
	@FindBy(xpath = "//h4[text()='Download Your Oral Health Report']")
	WebElement downloadCard;
	@FindBy(xpath = "//button[text()=' Download Report ']")
	WebElement downloadReportButton;
	@FindBy(xpath = "//input[@type='radio'][1]")
	WebElement downloadEmailRadioButton;
	@FindBy(xpath = "//input[@type='radio'][1]")
	WebElement downloadWhatsappRadioButton;
	@FindBy(xpath = "//button[text()=' Confirm ']")
	WebElement reportConfirmationBtn;
	@FindBy(xpath = "//h2[text()='Report Shared']")
	WebElement reportSentConfirmationReport;

	public boolean accessReportPageText() {
		System.out.println("My work1");
		wait.until(ExpectedConditions.visibilityOf(accessReportPageImage));
		System.out.println("My work2");
		boolean a= accessReportPageImage.isDisplayed();
		System.out.println("My work3");
	    return a;
	}

	public void downloadReportCard(String option) {
		downloadReportButton.click();
		if (option.equalsIgnoreCase("email")) {
			downloadEmailRadioButton.click();
		} else {
			downloadWhatsappRadioButton.click();
		}
		reportConfirmationBtn.click();
	}

	public String reportSentConfirmationMsg() {
		return reportSentConfirmationReport.getText();
	}
}
