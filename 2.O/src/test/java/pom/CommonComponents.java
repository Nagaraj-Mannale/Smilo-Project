package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePage.Constructor;

import java.awt.AWTException;
import java.util.List;

public class CommonComponents extends Constructor {

    public CommonComponents(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='logo-container']/following-sibling::nav//li")
    private List<WebElement> allPageLinks;
    @FindBy(xpath = "//input[@id='search']")     private WebElement fieldSearch;
    @FindBy(xpath = "//input[@id='confirmYes']") private WebElement popupDeleteYes;
    @FindBy(xpath = "//input[@id='confirmNo']")  private WebElement popupDeleteNo;
    @FindBy(xpath = "//div[@class='toast-message']") private WebElement succesfulMessage;
    @FindBy(xpath="//button[text()='Save']")         private WebElement btnSave;
    @FindBy(xpath = "//a[text()='Cancel']")          private WebElement btnCancel;
    @FindBy(xpath = "//div[@class='dropdown_list_options']/button") private WebElement kebabIcon;
    @FindBy(xpath = "//span[@class='material-symbols-outlined']")   private List<WebElement> kebabOptionsED;
   
    public void clickOnKebabIcon() { kebabIcon.click(); }
    public void selectKebabOption(String optionText) {
        kebabIcon.click();
        for (WebElement option : kebabOptionsED) {
        if (option.getText().equalsIgnoreCase(optionText)) {
        option.click();break; }  }  }

    public void selectPageLink(String page)  {
        for (WebElement link : allPageLinks) {
        if (link.getText().trim().equalsIgnoreCase(page)) {
        link.click();break;}  }  }     
            

    public void searchField(String value) throws AWTException {
        fieldSearch.clear();
        fieldSearch.sendKeys(value);
        keyboardAction("Enter");
    }

    public void deletePopupHandle(String order) {
        switch (order.trim().toLowerCase()) {
        case "yes": popupDeleteYes.click(); break;
        case "no": popupDeleteNo.click(); break;
        default: System.out.println("Given order is not good");
        }    }

    public String getSuccessMessage() { return succesfulMessage.getText(); }
    public void clickOnSaveButton() { btnSave.click(); }
    public void clickOnCancelButton() { btnCancel.click(); }

    @FindBy(xpath = "//button[@id='clear_button']")  private WebElement btnReset;
    @FindBy(xpath = "//button[text()='SET']")        private WebElement btnSet;   
    @FindBy(xpath = "//input[@id='from_date']")      private WebElement dateFrom;
    @FindBy(xpath = "//input[@id='to_date']")        private WebElement dateTo; 
    @FindBy(xpath = "//Select[@id='showDropdown']")  private WebElement dropPagination;
    @FindBy(xpath = "(//a[@class='page-link'])[3]")  private WebElement iconNextPage;
    @FindBy(xpath = "(//a[@class='page-link'])[4]")  private WebElement iconLastPage;
    
    public void clickResetButton() {
        btnReset.click();
    }

    public void clickSetButton() {
        btnSet.click();
    }

    public void clickNextPageButton() {
        iconNextPage.click();
    }

    public void clickLastPageButton() {
        iconLastPage.click();
    }
}
