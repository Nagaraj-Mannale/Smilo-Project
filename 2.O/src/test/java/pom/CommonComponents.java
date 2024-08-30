package pom;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePage.Constructor;

public class CommonComponents extends Constructor {

    public CommonComponents(WebDriver driver) {
        super(driver);                        }

    @FindBy(xpath = "//div[@class='logo-container']/following-sibling::nav//li")
    private List<WebElement> allPageLinks;

    @FindBy(xpath = "//Select[@id='showDropdown']")  
    private WebElement dropPagination;

    @FindBy(xpath = "//input[@id='search']")         
    private WebElement fieldSearch;

    @FindBy(xpath = "//Select[@id='city']")          
    private WebElement dropCity;

    @FindBy(xpath = "//input[@id='from_date']")      
    private WebElement dateFrom;

    @FindBy(xpath = "//input[@id='to_date']")        
    private WebElement dateTo; 

    @FindBy(xpath = "(//button[@type='button'])[1]") 
    private WebElement firstRecordKebabIcon;

    @FindBy(xpath = "(//Select[@id='showDropdown']/../../../../div/div)[1]")   
    private WebElement txtHomePage;

    @FindBy(xpath = "//button[@id='clear_button']")    
    private WebElement btnReset;

    @FindBy(xpath = "//button[text()='SET']")          
    private WebElement btnSet;

    @FindBy(xpath = "//p[@class='alert-heading text-semibold second-heading text-center mt-0 mb-0']")  
    private WebElement txtEmptyPage;

    @FindBy(xpath = "(//a[@class='page-link'])[3]") 
    private WebElement iconNextPage;

    @FindBy(xpath = "(//a[@class='page-link'])[4]") 
    private WebElement iconLastPage;
    
    @FindBy(xpath = "//input[@id='confirmYes']") 
    private WebElement popupDeleteYes;
    
    @FindBy(xpath = "//input[@id='confirmNo']") 
    private WebElement popupDeleteNo;
    
    @FindBy(xpath = "//div[@class='toast-message']")
    private WebElement succesfulMessage;
    
    public String getSuccessMessage() {
        waitElementVisibility(succesfulMessage, Duration.ofSeconds(10));
        return succesfulMessage.getText();
    }
    
    public void deletePopupHandle(String order)
    {
    	switch(order.trim().toLowerCase()) {
    	case "yes":popupDeleteYes.click();break;
    	case "no":popupDeleteNo.click();break;
    	default:System.out.println("Given order is not good");
    	}}
    	    

    public void selectPageLink(String page)  {
        for (WebElement link : allPageLinks) {
            if (link.getText().trim().equalsIgnoreCase(page)) {
                link.click();
                break;
            }    }    }

    public void searchField(String value) throws AWTException {
        fieldSearch.sendKeys(value);
        keyboardAction();
    }

    public String getHomePageText() {
        return txtHomePage.getText();
    }

    public void clickResetButton() {
        btnReset.click();
    }

    public void clickSetButton() {
        btnSet.click();
    }

    public String getEmptyPageText() {
        return txtEmptyPage.getText();
    }

    public void clickNextPageButton() {
        iconNextPage.click();
    }

    public void clickLastPageButton() {
        iconLastPage.click();
    }
}
