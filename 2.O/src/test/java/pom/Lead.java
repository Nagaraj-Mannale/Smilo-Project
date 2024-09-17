package pom;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import basePage.Constructor;

public class Lead extends Constructor {

    public Lead(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Import']")      private WebElement btnImport;
    @FindBy(xpath = "//a[text()='Add']")              private WebElement btnAdd;            
    @FindBy(xpath = "//button[@id='convert_button']") private WebElement btnConvert;
    @FindBy(xpath = "//button[text()='Delete']")      private WebElement btnDelete;    
    @FindBy(xpath = "//a[@id='export_btn']")          private WebElement linkExport;        
    @FindBy(xpath="(//span[text()='Lead'])[2]")       private WebElement HomePageText;
    @FindBy(xpath="(//td[@id='td-lead-id'])[1]")      private WebElement firstRecordleadId;
    @FindBy(xpath="(//td[@id='td-lead-name'])[1]")    private WebElement firstRecordName;
    @FindBy(xpath="(//td[@id=\"td-email\"])[1]")      private WebElement firstRecordMail;
    
    public String getfirstRecordMail() {
    	return firstRecordMail.getText();
    }
    
    public String getfirstRecordName() {
    	return firstRecordName.getText();
    }
    
    public String getFirstRecordLeadId() {
    	return firstRecordleadId.getText();
    }
    
    public String getLeadHomePageText(){
        return HomePageText.getText();
    }
    public void clickImportButton() {

    }
    public void clickAddButton() {
        btnAdd.click();
    }

    public void clickConvertButton() {
        btnConvert.click();
    }

    public void clickDeleteButton() {
        btnDelete.click();
    }

    public void clickExportLink() {
        linkExport.click();
    }
    @FindBy(xpath="(//a[text()='Lead'])[2]/../../span[4]/a")private WebElement leadInsidePageText;
    @FindBy(xpath="//Select[@id='status']")        private WebElement dropStatus;
    @FindBy(xpath="//label[@class='brws-img-btn']")private WebElement uploadPhoto;
    @FindBy(xpath="//input[@id='name']")           private WebElement fieldLeadName;
    @FindBy(xpath="//select[@id='status']")        private WebElement dropLeadStatus;
    @FindBy(xpath="//input[@id='email']")          private WebElement fieldEmail;
    @FindBy(xpath="//input[@id='mobile']")          private WebElement fieldMobile;
    @FindBy(xpath="//input[@id='lead_lable']")     private WebElement fieldLabel;
    @FindBy(xpath="//input[@id='lead_address']")   private WebElement fieldAddress;
    @FindBy(xpath="//select[@id='city']")          private WebElement dropCity;
    @FindBy(xpath="//select[@id='areaSelect']")    private WebElement dropLocality;
    @FindBy(xpath="//input[@id='pin']")            private WebElement fieldPostalCode;

    public String getLeadAddViewEditPageText() {
        return leadInsidePageText.getText();
    }
    public void selectLeadStatus(String status) {
    	Select select=new Select(dropStatus);
    	select.selectByVisibleText(status);
    }
    public void uploadPhoto(String filePath) {
        uploadPhoto.click();  
        uploadPhoto.sendKeys(filePath);// You can use this if your framework allows auto-upload
    }
    public void setLeadName(String leadName) {
        fieldLeadName.clear();
        fieldLeadName.sendKeys(leadName);
    }
    public void setLeadStatus(String status) {
        Select dropdown = new Select(dropLeadStatus);
        dropdown.selectByVisibleText(status);
    }
    public void setEmail(String email) {
        fieldEmail.clear();
        fieldEmail.sendKeys(email);
    }
    public void setMobile(String mobile) {
        fieldMobile.clear();
        fieldMobile.sendKeys(mobile);
    }
    public void setLabel(String label) {
        fieldLabel.clear();
        fieldLabel.sendKeys(label);
    }

    public void setAddress(String address) {
        fieldAddress.clear();
        fieldAddress.sendKeys(address);
    }

    public void selectCity(String city) {
        Select dropdown = new Select(dropCity);
        dropdown.selectByVisibleText(city);
    }

    public void selectLocality(String locality) {
        Select dropdown = new Select(dropLocality);
        dropdown.selectByVisibleText(locality);
    }

    public void setPostalCode(String postalCode) {
        fieldPostalCode.clear();
        fieldPostalCode.sendKeys(postalCode);
    }
//Add Car and Adress
    @FindBy(xpath="//ul[@class='hr-sub-nav-ul loader']/li") private List<WebElement> viewPageTabsLinks;
    
    public void selectViewPageTabs(String tab) {
    	for(WebElement link:viewPageTabsLinks)  {
    	if(link.getText().equalsIgnoreCase(tab)) {
    			link.click();break;     } 	}   }
    
    @FindBy(xpath="//button[text()='Add Address']") private WebElement buttonAddAddress;
    @FindBy(xpath="//input[@id='lead_lable']")      private WebElement fieldAddressLabel;
    @FindBy(xpath="//span[text()='computer']/../..//span") private List<WebElement> leadkebabOptions;
    @FindBy(xpath="//button[@class=' primary-btn car_add_btn']") private WebElement btnAddCar;
    @FindBy(xpath="//input[@id='regno']")      private WebElement registerNumber;
    @FindBy(xpath="//select[@id='brand_id']")  private WebElement dropCarBrand;
    @FindBy(xpath="//select[@id='model']")     private WebElement dropModel;
    @FindBy(xpath="//input[@id='year']")       private WebElement fieldYear;
    @FindBy(xpath="//button[@class='edit-btn']/a") private WebElement ViewPageEditIcon;
    @FindBy(xpath="//p[text()='No lead Found!']")  private WebElement deletePageText;
    @FindBy(xpath="//input[@id='selected_leads']") private WebElement checkBox;
    
    public void clickonCheckBox()
    {
    	checkBox.click();
    }
    public String getDeletePageText()    {
    return deletePageText.getText();
    }
    public void clickOnViewPageEditIcon()    {
    ViewPageEditIcon.click();
    }
    
    public void clickAddAddress() {
    buttonAddAddress.click();
    }

    public void setAddressLabel(String label) {
        fieldAddressLabel.clear();
        fieldAddressLabel.sendKeys(label);
    }

    public void clickOnKebabOption(String option) {
        boolean elementClicked = false;
        int retries = 3; // Retry up to 3 times if StaleElementReferenceException occurs

        while (!elementClicked && retries > 0) {
            try {for (WebElement element : leadkebabOptions) {	
              if (element.getText().equalsIgnoreCase(option)) {
                 JavascriptExecutor js = (JavascriptExecutor) driver;
                 js.executeScript("arguments[0].click();", element);
                 elementClicked = true;break;  // Exit loop once element is clicked
                    } } } 
            catch (StaleElementReferenceException e) {
                retries--;  // Decrement the retry count and re-find elements
                // Re-find elements in case DOM changed
                leadkebabOptions = driver.findElements(By.xpath("//span[text()='computer']/../..//span"));
                if (retries == 0) {
                    throw e;  // Throw exception if max retries are reached
                }
            }
        }
    }


    public void clickAddCar() {
     btnAddCar.click();
    }

    public void setRegisterNumber(String regNo) {
        registerNumber.clear();
        registerNumber.sendKeys(regNo);
    }

    public void selectCarBrand(String brand) {
        Select dropdown = new Select(dropCarBrand);
        dropdown.selectByVisibleText(brand);
    }

    public void selectCarModel(String model) {
        Select dropdown = new Select(dropModel);
        dropdown.selectByVisibleText(model);
    }

    public void setCarYear(String year) {
        fieldYear.clear();
        fieldYear.sendKeys(year);
    }
 
    
}
