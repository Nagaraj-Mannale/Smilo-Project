package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.Constructor;

public class PomAdminLogin extends Constructor
{
	private WebDriverWait wait;
	public PomAdminLogin(WebDriver driver)
      {
	  super(driver);
	  this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
      }

	@FindBy(xpath="//input[@id='login_email']")                             WebElement emailfield;
	@FindBy(xpath="//input[@id='login_password']")                          WebElement passwordfield;
	@FindBy(xpath="//button[@id='login_submit']")                           WebElement signinButton;

	
	public String dashboardPageText()
	{
		wait.until(ExpectedConditions.visibilityOf(dashboardPageText));
		return dashboardPageText.getText().trim();
	}
	public void emailField(String email)
	{
		emailfield.sendKeys(email);
	}
	 
	public void passwordField(String pwd)
	{
		passwordfield.sendKeys(pwd);
	}
	
	public void signInButton()
	{
		signinButton.click();
	}
	 
	@FindBy(xpath="//a[text()='Forgot Password?']")                         WebElement forgotLink;
	@FindBy(xpath="//label[@id='login_email-error']")                       WebElement emailEmptyMsg;
	@FindBy(xpath="//label[@id='login_password-error']")                    WebElement pwdEmptyMsg;
	@FindBy(xpath="(//div[text()='Email address/Password is invalid'])[1]") WebElement emailOrPwdErrorMsg;
	@FindBy(xpath="//h3[text()='Dashboard          ']")                     WebElement dashboardPageText;
	@FindBy(xpath="//input[@name='otp_number[]']")                          List<WebElement> otpfield;
	@FindBy(xpath="//button[@id='otp_section_submit']")                     WebElement otpverifybutton;             
	
	public void forgotLink()
	{
		forgotLink.click();
	}
	public String errorMsg(String msg)
	{
		String result;
		switch(msg.toLowerCase())
		{
		case("email empty"): result=emailEmptyMsg.getText(); break;
		case("pwd empty")  : result=pwdEmptyMsg.getText();   break;
		case("both empty") : result=emailEmptyMsg.getText()+" "+pwdEmptyMsg.getText(); break;
		default            : result=emailOrPwdErrorMsg.getText(); break;
		}
		return result;	
	
 }
    public void otpEnter(String num)
    {
    	int i=0;
    	for(WebElement field:otpfield)
    	{
    	
    	while(i<num.length())
    	{
    		field.sendKeys(Character.toString(num.charAt(i)));
    		i++;
    		break;
    	}
    	}
    }
     public void clickOnverify()
     {
    	 otpverifybutton.click();
     }

}

