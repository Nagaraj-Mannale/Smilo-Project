package basePage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Constructor {
    public static WebDriver driver;

    public Constructor(WebDriver driver){
        Constructor.driver = driver;
        PageFactory.initElements(driver, this);
     }
    
@FindBy(xpath="//div[@class='logo-container']/following-sibling::nav//li")
    private List<WebElement> allPageLinks;

public void waitElementHelper(WebElement element,Duration time)
{
    WebDriverWait wait=new WebDriverWait(driver, time);
    wait.until(ExpectedConditions.visibilityOf(element));
}

public void waitElementHelper(List<WebElement> elements,Duration time)
{
    WebDriverWait wait=new WebDriverWait(driver, time);
    wait.until(ExpectedConditions.visibilityOfAllElements(elements));
}

public void waitElementHelper(By element,Duration time)
{
    WebDriverWait wait=new WebDriverWait(driver, time);
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
}
}
