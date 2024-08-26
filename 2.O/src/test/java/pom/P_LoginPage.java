package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import basePage.Constructor;

import java.time.Duration;

public class P_LoginPage extends Constructor
{
    public P_LoginPage(WebDriver driver) 
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='email']")
    WebElement tfUserName;

    @FindBy(xpath = "//input[@name='password']")
    WebElement tfPwd;

    @FindBy(xpath = "//button[@name='sign-in']")
    WebElement btnLogin;

    @FindBy(xpath = "//a[text()='DashBoard']")
    WebElement txtDashboard;

    public void enterUserNameAndPassword(String username, String pwd) 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(tfUserName));
        tfUserName.sendKeys(username);
        tfPwd.sendKeys(pwd);
        btnLogin.click();
    }
    public void loginButton() 
    {
  
        btnLogin.click();
    }

    public String getHomePageText() 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(txtDashboard));

        return txtDashboard.getText();
    }
}
