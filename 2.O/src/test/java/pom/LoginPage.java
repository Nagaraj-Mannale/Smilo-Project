package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePage.Constructor;
import java.time.Duration;

public class LoginPage extends Constructor {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='email']")
    private WebElement tfUserName;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement tfPwd;

    @FindBy(xpath = "//button[@name='sign-in']")
    private WebElement btnLogin;

    @FindBy(xpath = "//div[text()='Admin']/../p")
    private WebElement loginFailedMessage;

    public void enterUserNameAndPassword(String username, String password) {
        tfUserName.sendKeys(username);
        tfPwd.sendKeys(password);
    }

    public void clickLoginButton() {
        btnLogin.click();
    }

    

    public String getFailureMessage() {
        waitElementVisibility(loginFailedMessage, Duration.ofSeconds(10));
        return loginFailedMessage.getText();
    }
}
