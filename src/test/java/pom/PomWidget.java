package pom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.Constructor;

public class PomWidget extends Constructor {

	private WebDriverWait wait;

	public PomWidget(WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}

	@FindBy(xpath = "//a[text()='Home']")                       	 WebElement getStartedPageText;
	@FindBy(xpath = "//button[text()=' Start Now ']")     	         WebElement startNowButton;
	@FindBy(xpath = "//h1[text()='Select reason for your visit']")	 WebElement purposeOfVisitText;
	@FindBy(xpath = "//div[@id='general_checkup']/../div//label/h3") List<WebElement> visitPageCards;
	@FindBy(xpath = "//button[text()=' Continue ']")	             WebElement visitPageContinueButton;
	@FindBy(xpath = "//h1[text()='Consent & Agree']")      	         WebElement consentAgreementPageText;
	@FindBy(xpath = "//span[text()='Continue']")     	             WebElement consentAgreementPageContinueButton;
	@FindBy(xpath = "//div[@id='general_checkup']//h3")	             List<WebElement> selectPreferencepageCards;
	
	public Map<Integer, List<String>> cardCountWithName() {
	    List<String> cardsName = new ArrayList<>();
	    int cardCount = 0;
	    wait.until(ExpectedConditions.visibilityOfAllElements(selectPreferencepageCards));
	    for (WebElement card : selectPreferencepageCards) {
	        cardsName.add(card.getText().trim());
	        cardCount++;                                  }

	    Map<Integer, List<String>> result = new HashMap<>();
	    result.put(cardCount, cardsName);
	    return result;
	}
		
	

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

	@FindBy(xpath = "//h1[text()='Select Your Preferences']")	WebElement preferencePageText;
	@FindBy(xpath = "//div[@class='checkbox']/../label/h3")	    List<WebElement> preferencePageCards;
	@FindBy(xpath = "//button[text()=' Continue ']")     	    WebElement preferencePageContinueButton; 
	@FindBy(xpath = "//h1[text()=' Upload Your Image ']")       WebElement uploadPageText;
	//@FindBy(xpath = "//div[@class='upload_image_div']")     //WebElement uploadPageSpace;
	@FindBy(xpath = "//input[@type='file']")	                List<WebElement> uploadPageSpace;
	@FindBy(xpath="//div[@class='imgupload_sample']")           List<WebElement> uploadPageSamplePicture;

	public String preferencePageText() {
		return preferencePageText.getText();
	}

	public void selectOHRCard(String cardName) {
		selectCard(preferencePageCards, cardName);
	}

	private void selectCard(List<WebElement> cards, String cardName) {
		for (WebElement card : cards) {
			if (card.getText().equalsIgnoreCase(cardName)) {
				card.click();
				break;
			}
		}
	}
	
	public void preferenceContBtn() {
		preferencePageContinueButton.click();
	}

	public String uploadPageText() {
		return uploadPageText.getText();
	}
	@FindBy(xpath ="//span[text()=' Done ']")	                 WebElement doneButton;
	@FindBy(xpath ="//span[@class='save_continue_btn_span']/..")	         WebElement getYourResultButton;
	@FindBy(xpath ="//span[@class='save_continue_btn_span']/..")        WebElement saveAndContinueButton;
	
	public static int CountOfuploadingImage=0;
	public void uploadPageSpace(List<String> imagePath) throws InterruptedException{
		
		for(int i=0;i<uploadPageSamplePicture.size();i++)
		{
			CountOfuploadingImage=uploadPageSamplePicture.size();
 //			File file = new File(path);
//	        if (file.exists())
			if(uploadPageSamplePicture.get(i).isDisplayed())
			{
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].style.display='block';",uploadPageSpace.get(i));
				uploadPageSpace.get(i).sendKeys(imagePath.get(i));
				
		        wait.until(ExpectedConditions.elementToBeClickable(doneButton));
				doneButton.click();
				js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='save_continue_btn_span']/..")));
				if (saveAndContinueButton.isDisplayed()) {
				    wait.until(ExpectedConditions.elementToBeClickable(saveAndContinueButton));
				    js.executeScript("arguments[0].click();", saveAndContinueButton);
				} 
				
			}
		
		 }
		
		}
	
		
	


	@FindBy(xpath = "//h3[text()='Enter Your Details']")	    WebElement contactPageText;
	@FindBy(xpath = "//input[@placeholder='First Name']")	    WebElement firstNameField;
	@FindBy(xpath = "//input[@placeholder='Last Name']")	    WebElement lastNameField;
	@FindBy(xpath = "//input[@placeholder='Email Address']")	WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']/preceding-sibling::div[1]/div[2]//li") List<WebElement> countriesCodeField;
	@FindBy(xpath = "//input[@placeholder='Mobile Number']")                     WebElement mobileField;
	@FindBy(xpath = "//span[text()='Submit']") 	                                 WebElement submitButton;

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
		wait.until(ExpectedConditions.visibilityOf(accessReportPageImage));
		return accessReportPageImage.isDisplayed();
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

	@FindBy(xpath = "//h4[text()='Find A Dentist Near You']")
	WebElement appointmentCard;
	@FindBy(xpath = "//button[text()=' Book Now ']")
	WebElement appointmentCardBookNowButton;
	@FindBy(xpath = "//h4[text()='Get Special Offers']")
	WebElement getofferCard;
	@FindBy(xpath = "//button[text()=' Get Now ']")
	WebElement offerCardGetNow;

	public String getcardtext(String name) {
		String result = "";
		if ("appointment".equalsIgnoreCase(name)) {
			result = appointmentCard.getText();
		} else if ("offer".equalsIgnoreCase(name)) {
			result = getofferCard.getText();
		} else if ("All".equalsIgnoreCase(name)) {
			result = appointmentCard.getText() + " " + getofferCard.getText();
		}
		return result;
	}

}
