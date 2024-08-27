package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import basePage.Constructor;

import java.time.Duration;

public class LoginPage extends Constructor
{
    public LoginPage(WebDriver driver) 
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='email']")      WebElement tfUserName;
    @FindBy(xpath = "//input[@name='password']")   WebElement tfPwd;
    @FindBy(xpath = "//button[@name='sign-in']")   WebElement btnLogin;
    @FindBy(xpath = "//a[text()='DashBoard']")     WebElement txtDashboard;
    
    public void enterUserNameAndPassword(String username, String pwd) 
    {
        tfUserName.sendKeys(username);
        tfPwd.sendKeys(pwd);
    }
    public void loginButton() 
    {
        btnLogin.click();
    }
    @FindBy(xpath="//div[@class='toast-message']") WebElement succesfulMessage;
    @FindBy(xpath="//div[text()='Admin']/../p")    WebElement loginFailedmessage;
    
    public String successfulmsg() 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(succesfulMessage));
        return succesfulMessage.getText();
    }
    
    public String loginFailedlmsg() 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginFailedmessage));
        return loginFailedmessage.getText();
    }
}
