package smiloPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Smilowidget {
	WebDriver driver;
	public Smilowidget(WebDriver driver)	{
		this.driver=driver;       	}
	
@FindBy(xpath="//h1[text()=' Start Your Oral']")             WebElement getStartedPageText;
@FindBy(xpath="//h1[text()='Select reason for your visit']") WebElement purposeOfVisitText;
@FindBy(xpath="//div[@id='general_checkup']/../div")         List<WebElement> visitPageCards;
@FindBy(xpath="//h1[text()='Consent & Agree']")              WebElement consentAgreementPageText;
@FindBy(xpath="//h1[text()='Select Your Preferences']")      WebElement selectPreferencePageText;
@FindBy(xpath="//div[@id='general_checkup']/../div")         List<WebElement> preferencePageCards;
@FindBy(xpath="//h1[text()=' Upload Your Image ']")          WebElement uploadPageText;


@FindBy(xpath="//button[text()=' Start Now ']")              WebElement getStartedPageButton;
@FindBy(xpath="//button[text()=' Continue ']")               WebElement visitPageContinueButton;
@FindBy(xpath="//span[text()='Continue']")                   WebElement consentAgreementPageContinueButton;
@FindBy(xpath="//button[text()=' Continue ']")               WebElement preferencePageContinueButton;
@FindBy(xpath="//div[@class='upload_image_div']")            WebElement uploadPageSpace;
@FindBy(xpath="//span[text()=' Done ']")                     WebElement doneButton;
@FindBy(xpath="//span[text()='Get your Results']")           WebElement frontPageResultButton;
@FindBy(xpath="//span[text()='Submit']")                     WebElement submitButton;

public void StartNowBtn()
 {getStartedPageButton.click();}

public void VisitContBtn()
 {visitPageContinueButton.click();}

public void ConsentAgreeContBtn()
 {consentAgreementPageContinueButton.click();}

public void PreferenceContBtn()
 {preferencePageContinueButton.click();}

public void uploadPageSpace()
 {uploadPageSpace.click();}

public void DoneBtn()
 {doneButton.click();}

public void FrontPageResultBtn()
 {
	frontPageResultButton.click();
 }

public void SubmitButton()
 {
	submitButton.click();
 }
@FindBy(xpath="//div[@class='banner-content']")              WebElement contactPageText;
@FindBy(xpath="//input[@placeholder='First Name']")          WebElement firstNameField;
@FindBy(xpath="//input[@placeholder='Last Name']")           WebElement lastNameField;
@FindBy(xpath="//input[@placeholder='Email Address']")       WebElement emailField;
@FindBy(xpath="//span[text()='United States']/../../li")     List<WebElement> countriesField;
@FindBy(xpath="//input[@placeholder='Mobile Number']")       WebElement mobileField;
public void FirstNameField(String name)
  {
	firstNameField.sendKeys(name);
  }

public void LastNameField(String name)
  {
	lastNameField.sendKeys(name);
  }

public void EmailField(String email)
  {
	emailField.sendKeys(email);
  }

public void MobileField(String number)
 {
	mobileField.sendKeys(number);
 }

@FindBy(xpath="//h3[text()=' Your Smile Check Rating ']")        WebElement accessReportPageText;
@FindBy(xpath="//h4[text()='Download Your Oral Health Report']") WebElement downloadCard;
@FindBy(xpath="//button[text()=' Download Report ']")            WebElement reportButton;
@FindBy(xpath="//button[text()=' Confirm ']")                    WebElement ReportConfirmationBtn;

public void DownloadCard()
 {
	downloadCard.click();
 }
public void reportButton()
 {
	reportButton.click();
 }
public void ReportConfirmationBtn()
 {
	ReportConfirmationBtn.click();
 }

}

