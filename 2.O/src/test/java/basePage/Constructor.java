package basePage;

import java.util.List;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Constructor {
    protected WebDriver driver;

    public Constructor(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);}
    
@FindBy(xpath="//div[@class='logo-container']/following-sibling::nav//li")
    private List<WebElement> allPageLinks;

public void clickOnLinks(String currentLink) {
        for (WebElement link : allPageLinks) {
            try{
           	 if(link.getText()==currentLink) {
               	link.click();                }
                // Optional: Add a wait if needed to handle page load or dynamic content
                // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                // wait.until(ExpectedConditions.urlToBe("expected_url_after_click"));
                // Optionally, you can add a step to navigate back or refresh the page if needed
                // driver.navigate().back();
                
            } catch (ElementNotInteractableException e) {
                System.out.println("Link not interactable: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error clicking link: " + e.getMessage());
            } }}
}
