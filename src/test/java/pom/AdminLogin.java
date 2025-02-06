package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.Constructor;

public class AdminLogin extends Constructor
{
	private WebDriverWait wait;
	public AdminLogin(WebDriver driver)
      {
	  super(driver);
	  this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
      }

	@FindBy(xpath="//input[@id='login_email']")                             WebElement emailfield;
	@FindBy(xpath="//input[@id='login_password']")                          WebElement passwordfield;
	@FindBy(xpath="//button[@id='login_submit']")                           WebElement signinButton;
	@FindBy(xpath="//a[text()='Forgot Password?']")                         WebElement forgotLink;
	@FindBy(xpath="//label[@id='login_email-error']")                       WebElement emailEmptyMsg;
	@FindBy(xpath="//label[@id='login_password-error']")                    WebElement pwdEmptyMsg;
	@FindBy(xpath="(//div[text()='Email address/Password is invalid'])[1]") WebElement emailOrPwdErrorMsg;
	@FindBy(xpath="//h3[text()='Dashboard          ']")                     WebElement dashboardPageText;
	
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
}

