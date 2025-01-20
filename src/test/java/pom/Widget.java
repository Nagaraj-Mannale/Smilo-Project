package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Widget {

	WebDriver driver;
    
	public Widget(WebDriver driver)
     {
	   this.driver=driver;
     }

@FindBy(xpath="//h1[text()=' Start Your Oral']")             WebElement getStartedPageText;
@FindBy(xpath="//button[text()=' Start Now ']")              WebElement startNowButton;
@FindBy(xpath="//h1[text()='Select reason for your visit']") WebElement purposeOfVisitText;
@FindBy(xpath="//div[@id='general_checkup']/../div")         List<WebElement> visitPageCards;
@FindBy(xpath="//button[text()=' Continue ']")               WebElement visitPageContinueButton;
@FindBy(xpath="//h1[text()='Consent & Agree']")              WebElement consentAgreementPageText;
@FindBy(xpath="//span[text()='Continue']")                   WebElement consentAgreementPageContinueButton;
public String getStartedPageText()
{
	return getStartedPageText.getText();
}
public void startNowBtn()
{startNowButton.click();}
public String purposeOfVisitPageText()
{
	return purposeOfVisitText.getText();
}
public void clickOnResonVisitCard(String cardName)
{
	for(WebElement Card:visitPageCards)
	{
		if(Card.getText().equalsIgnoreCase(cardName))
		{
			Card.click();
		}
	}
}
public void VisitContBtn()
{visitPageContinueButton.click();}
public String consentAgreementPageText()
{
	return consentAgreementPageText.getText();
}
public void consentAgreeContBtn()
{consentAgreementPageContinueButton.click();}
	
@FindBy(xpath="//h1[text()='Select Your Preferences']")      WebElement preferencePageText;
@FindBy(xpath="//div[@id='general_checkup']/../div")         List<WebElement> preferencePageCards;
@FindBy(xpath="//button[text()=' Continue ']")               WebElement preferencePageContinueButton;
@FindBy(xpath="//h1[text()=' Upload Your Image ']")          WebElement uploadPageText;
@FindBy(xpath="//div[@class='upload_image_div']")            WebElement uploadPageSpace;
@FindBy(xpath="//span[text()=' Done ']")                     WebElement doneButton;
@FindBy(xpath="//span[text()='Get your Results']")           WebElement frontPageResultButton;
public String preferencePageText()
{
	return preferencePageText.getText();
}
public void selectOHRCard(String cardName)
{
  for(WebElement card:preferencePageCards)
  {
	  if(card.getText().equalsIgnoreCase(cardName))
	  {
		  card.click();
	  }
  }
}
public void preferenceContBtn()
{preferencePageContinueButton.click();}
public String uploadPageText()
{
	return uploadPageText.getText();
}
public void uploadPageSpace()
{uploadPageSpace.click();}
public void doneBtn()
{doneButton.click();}
public void FrontPageResultBtn()
{
	frontPageResultButton.click();
}

@FindBy(xpath="//div[@class='banner-content']")                            WebElement contactPageText;  //
@FindBy(xpath="//input[@placeholder='First Name']")                        WebElement firstNameField;
@FindBy(xpath="//input[@placeholder='Last Name']")                         WebElement lastNameField;
@FindBy(xpath="//input[@placeholder='Email Address']")                     WebElement emailField;
@FindBy(xpath="//input[@id='phone']/preceding-sibling::div[1]/div[2]//li") List<WebElement> countriesCodeField;
@FindBy(xpath="//input[@placeholder='Mobile Number']")                     WebElement mobileField;
@FindBy(xpath="//span[text()='Submit']")                                   WebElement submitButton;

public String contactPageText()
{
	return contactPageText.getText();
}
public void firstNameField(String name)
  {
	firstNameField.sendKeys(name);
  }
public void lastNameField(String name)
  {
	lastNameField.sendKeys(name);
  }
public void emailField(String email)
  {
	emailField.sendKeys(email);
  }
public void countriesCodeField(String Code)
{
	for(WebElement code:countriesCodeField)
	{
		if(code.getText().equalsIgnoreCase(Code))
		{
			code.click();
		}
	}
}
public void mobileField(String number)
 {
	mobileField.sendKeys(number);
 }
public void submitButton()
 {
	submitButton.click();
 }
@FindBy(xpath="//h3[text()=' Your Smile Check Rating ']")        WebElement accessReportPageText;
@FindBy(xpath="//h4[text()='Download Your Oral Health Report']") WebElement downloadCard;
@FindBy(xpath="//button[text()=' Download Report ']")            WebElement downloadreportButton;
@FindBy(xpath="//input[@type='radio'][1]")                       WebElement downloadEmailRadioButton;
@FindBy(xpath="//input[@type='radio'][1]")                       WebElement downloadwhatsapplRadioButton;
@FindBy(xpath="//button[text()=' Confirm ']")                    WebElement ReportConfirmationBtn;
@FindBy(xpath="//h2[text()='Report Shared']")                    WebElement reportsentConfirmationReport;

public String accessReportPageText()
{
	return accessReportPageText.getText();
}
public void DownloadReportCard(String option)
 {
	 downloadreportButton.click();
	 
	 if(option.equalsIgnoreCase("email")){
	 downloadEmailRadioButton.click();   }
	 else {
	 downloadwhatsapplRadioButton.click(); }
	 
	 ReportConfirmationBtn.click();
 }
public String reportSentConfirmationMsg()
{
	return reportsentConfirmationReport.getText();
}


}

