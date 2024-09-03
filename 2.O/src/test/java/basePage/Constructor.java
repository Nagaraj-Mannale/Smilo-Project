package basePage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Constructor {
    protected WebDriver driver;

    public Constructor(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void keyboardAction(String key) throws AWTException
    {if(key.equalsIgnoreCase("Enter"))
    {
    	Robot rt=new Robot();
    	rt.keyPress(KeyEvent.VK_ENTER);
    	rt.keyRelease(KeyEvent.VK_ENTER);
    }
    else
    {
    	Robot rt=new Robot();
    	rt.keyPress(KeyEvent.VK_DOWN);
    	rt.keyRelease(KeyEvent.VK_DOWN);
    }
    }
    
    
    public void waitElementVisibility(WebElement element, Duration time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementVisibility(List<WebElement> elements, Duration time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitElementVisibility(By locator, Duration time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
