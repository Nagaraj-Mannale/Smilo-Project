package pom;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import basePage.Constructor;

public class Setting extends Constructor {

    public Setting(WebDriver driver) {
        super(driver);    }
    
    @FindBy(xpath="//h4[text()='No Records Found!']")         WebElement catDeletetext;
    @FindBy(xpath="//button[text()='Save Changes']")          WebElement saveChangesButton;
    @FindBy(xpath = "//ul[@class='sub-nav-ul loader']/li")    List<WebElement> settingPageLinks;  
    @FindBy(xpath = "(//div[@class='sub-dropdown'])[2]/ul/li/a")List<WebElement> optionsOfProductAndService;
    
    public String getCatProdAndServicePageEmptyText() {
        return catDeletetext.getText();
    }

    public void clickSaveChangesButton() {
        saveChangesButton.click();  
        }
  
    public void clickOnSettingLink(String page) {
        for (WebElement link : settingPageLinks) {
            if (link.getText().equalsIgnoreCase(page)) {
                link.click();break;  }   }   }

    public void selectProductAndServiceOption(String page) {
        for (WebElement link : optionsOfProductAndService) {
            	if (link.getText().equalsIgnoreCase(page)) {
                link.click();break;  }  }  }
                
// Category Page
    @FindBy(xpath = "//a[text()='Category']")                 WebElement catHomePageHeading;
    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr/td[2]") WebElement categoryName;
    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr/td[3]//span[2]") WebElement statusText;
    @FindBy(xpath = "//a[text()='Add New']")                  WebElement addButton;//Service And Subscription Add Button
    @FindBy(xpath = "//button[text()='Save Order']")          WebElement saveOrder;
   
    public String getCategoryFirstRecordName()
        {return categoryName.getText();}

    public String getCategoryFirstRecordStatus() 
        {return statusText.getText();}

    public String getCatHomePageHeading() 
        {return catHomePageHeading.getText();}

    public void clickAddButton() 
        {addButton.click();}  
          
    public void clickSaveOrder() 
        { saveOrder.click();}
  
    @FindBy(xpath = "//input[@id='name']")        WebElement nameInput;
    @FindBy(xpath = "//span[@class='slider toggle']")WebElement sliderStatus;
    
//Category Add Page
    @FindBy(xpath = "//a[text()='Add Category']") WebElement addPageHeading;
    @FindBy(xpath = "//select[@id='type']")       WebElement selectTypeOfCategory;
    
    
    public String getCatAddPageHeading() {
        return addPageHeading.getText(); }

    public void enterCatOrProduOrServiceName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);      }

    public void selectCategoryTypeEitherProductOrService(String type) {
        Select select = new Select(selectTypeOfCategory);
        select.selectByVisibleText(type);       }

    public void toggleSliderForStatus() {
        sliderStatus.click();           }
    
//Product Home and Add page
    @FindBy(xpath="//th[text()='Product ID']/../../../tbody//td[2]")private WebElement prodFirstRecordText;
    @FindBy(xpath="//a[text()='Products']")   private WebElement productHomePageText;
    @FindBy(xpath="//a[text()='Add Product']")private WebElement productAddPageText;
    @FindBy(xpath="//input[@id='quantity']")  private WebElement fieldQuantity;
    @FindBy(xpath="//input[@id='hsn']")       private WebElement fieldHsn;
    @FindBy(xpath="//input[@id='max']")       private WebElement maxQuntity;
    
    public String getProductAddPageText(){ 
    return productAddPageText.getText(); }
    
    public String getProductFirstRecordtext(){ 
    return prodFirstRecordText.getText();    }
    
    public String productHomePagetext()  { 
    return productHomePageText.getText();}
    
    public void enterQuantity(String name){
    	fieldQuantity.clear();
    	fieldQuantity.sendKeys(name);     }
    
    public void enterHSNNumber(String name){
    	fieldHsn.clear();
    	fieldHsn.sendKeys(name);           }
    
    public void enterMaxQuantity(String name){
    	maxQuntity.clear();
    	maxQuntity.sendKeys(name);           }
  
//Home Service Page
    @FindBy(xpath="//th[text()='Service ID']/../../../tbody//td[2]") WebElement serviceFirstRecordText;
    @FindBy(xpath="//a[text()='Services']")    private WebElement serviceHomeText;
    @FindBy(xpath="//a[text()='Add Service']") private WebElement serviceAddPageText;
     
    public String getServiceFirstRecordtext(){ 
    return serviceFirstRecordText.getText(); }
   
    public String getServiceHomePagetext(){ 
    return serviceHomeText.getText();     }
   
    public String getServiceAddPagetext(){ 
    return serviceAddPageText.getText(); }
    
//Add Service Page    
    @FindBy(xpath="//select[@id='cate']") private WebElement selectCategory;
    @FindBy(xpath="//select[@id='gst']")  private WebElement selectGST;
    @FindBy(xpath="//input[@id='time']")  private WebElement timeTaken;
    @FindBy(xpath="//input[@id='sqft']")  private WebElement paintServicePrice;
    @FindBy(xpath="//div[@role='textbox']/p") WebElement tagTextfield;
    @FindBy(xpath="//select[@id='mall']") private WebElement serviceAvailabilityOption;
    @FindBy(xpath="//input[@id='e_time']")private WebElement estimateTime;	
    @FindBy(xpath="//input[@id='video']") private WebElement videoLink;

    public void selectServicePageCategoryOption(String category) {
        Select select = new Select(selectCategory);
        select.selectByVisibleText(category);      }

    public void selectGSTOption(String gst) {
        Select select = new Select(selectGST);
        select.selectByVisibleText(gst);    }

    public void enterTimeTaken(String time) {
        timeTaken.clear();
        timeTaken.sendKeys(time);           }

    public void enterPaintServicePrice(String price) {
        paintServicePrice.clear();
        paintServicePrice.sendKeys(price);           }

    public void enterTagText(String tag) {
        tagTextfield.clear();
        tagTextfield.sendKeys(tag);      }

    public void selectServiceAvailability(String availability) {
        Select select = new Select(serviceAvailabilityOption);
        select.selectByVisibleText(availability);              }

    public void enterEstimateTime(String eTime) {
        estimateTime.clear();
        estimateTime.sendKeys(eTime);           }

//Add Service Page   
    @FindBy(xpath="//th[text()='Mall Name']/../../../tbody/tr/td[1]")                 List<WebElement> selectMall;
    @FindBy(xpath="//th[text()='Mall Name']/../../../tbody/tr/td[3]/input")                 List<WebElement> selectCheckBox;
    @FindBy(xpath="//label[text()='Price*']/following-sibling::input")                List<WebElement> price ;
    @FindBy(xpath="//label[text()='Special Price']/following-sibling::input")         List<WebElement> specialPrice;
    @FindBy(xpath="//label[text()='Service Price in Mall']/following-sibling::input") List<WebElement> servicePriceInMall;
    @FindBy(xpath="//div[@class='hr-sub-nav-container']//li")                         List<WebElement> serviceEditPageTabLinks;
    
    public void clickOnServiceEditPageLinks(String name){
    	for(WebElement tab:serviceEditPageTabLinks)    {
    		if(tab.getText().equalsIgnoreCase(name))  {
    			tab.click();break;     		          }}}
    
    public void selectavailableMall(String name) {
        int index = -1;
        ArrayList<WebElement> listM = new ArrayList<>(selectMall);
        ArrayList<WebElement> list = new ArrayList<>(selectCheckBox);
          for(WebElement mall : listM) {
          if(mall.getText().equalsIgnoreCase(name)) {
              index = listM.indexOf(mall);
              break; } }
            list.get(index).click();
              } 

    public void enterPrice(int index, String priceValue) {
        price.get(index).clear();
        price.get(index).sendKeys(priceValue);
    }

    public void enterSpecialPrice() {
        
    }

    public void enterServicePriceInMall(int index, String servicePriceValue) {
        servicePriceInMall.get(index).clear();
        servicePriceInMall.get(index).sendKeys(servicePriceValue);
    }

    public void enterVideoLink(String link) {
        videoLink.clear();
        videoLink.sendKeys(link);
    }
}
    