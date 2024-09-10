package pom;

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
    
    public String getCategoryEmptyPageText() {
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
    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr/td[3]//span[2]")   WebElement statusText;
    @FindBy(xpath = "//a[text()='Add New']")                  WebElement addButton;
    @FindBy(xpath = "//button[@type='button']")               WebElement kebabIcon;
    @FindBy(xpath = "//span[@class='material-symbols-outlined']") List<WebElement> kebabOptionsED;
    @FindBy(xpath = "//button[text()='Save Order']")          WebElement saveOrder;
   
    public String getCategoryFirstRecordName()
        {return categoryName.getText();}

    public String getCategoryFirstRecordStatus() 
        {return statusText.getText();}

    public String getCatHomePageHeading() 
        {return catHomePageHeading.getText();}

    public void clickAddButton() 
        {addButton.click();}  
      
    public void selectKebabOption(String optionText) {
    	kebabIcon.click();
    	for (WebElement option : kebabOptionsED) {
            if (option.getText().equals(optionText)) {
            	option.click(); break;   }   }   }

               
    public void clickSaveOrder() 
        { saveOrder.click();}
  
    @FindBy(xpath = "//input[@id='name']")        WebElement categoryNameInput;
    @FindBy(xpath = "//span[@class='slider toggle']")WebElement sliderStatus;
    //Category Add Page
    @FindBy(xpath = "//a[text()='Add Category']") WebElement addPageHeading;
    @FindBy(xpath = "//select[@id='type']")       WebElement selectType;
    
    @FindBy(xpath = "//a[text()='Cancel']")       WebElement btnCancel;
    
    public String getCatAddPageHeading() {
        return addPageHeading.getText(); }

    public void enterCategoryName(String name) {
        categoryNameInput.clear();
        categoryNameInput.sendKeys(name);      }

    public void selectCategoryType(String type) {
        Select select = new Select(selectType);
        select.selectByVisibleText(type);       }

    public void toggleSliderStatus() {
        sliderStatus.click();        }

    public void clickCancelButton() {
        btnCancel.click();          }
    
    //Product page
    @FindBy(xpath="////a[text()='Products']") WebElement pHomePageText;
    public String productHomePagetext() { 
    	return pHomePageText.getText(); }
    
    //Service Page
    @FindBy(xpath="//a[text()='Services']")WebElement serviceHomeText;
    public String serviceHomePagetext()   { 
    	return serviceHomeText.getText(); }
    
    @FindBy(xpath="//select[@id='cate']") WebElement selectCategory;
    @FindBy(xpath="//select[@id='gst']")  WebElement selectGST;
    @FindBy(xpath="//input[@id='time']")  WebElement timeTaken;
    @FindBy(xpath="//input[@id='sqft']")  WebElement paintServicePrice;
    @FindBy(xpath="//div[@role='textbox']/p") WebElement tagTextfield;
    @FindBy(xpath="//select[@id='mall']")  WebElement serviceAvailability;
    @FindBy(xpath="//input[@id='e_time']") WebElement estimateTime;	
    @FindBy(xpath="//input[@id='video']") WebElement videoLink;

    public void selectCategoryOption(String category) {
        Select select = new Select(selectCategory);
        select.selectByVisibleText(category);
    }

    public void selectGSTOption(String gst) {
        Select select = new Select(selectGST);
        select.selectByVisibleText(gst);
    }

    public void enterTimeTaken(String time) {
        timeTaken.clear();
        timeTaken.sendKeys(time);
    }

    public void enterPaintServicePrice(String price) {
        paintServicePrice.clear();
        paintServicePrice.sendKeys(price);
    }

    public void enterTagText(String tag) {
        tagTextfield.clear();
        tagTextfield.sendKeys(tag);
    }

    public void selectServiceAvailability(String availability) {
        Select select = new Select(serviceAvailability);
        select.selectByVisibleText(availability);
    }

    public void enterEstimateTime(String eTime) {
        estimateTime.clear();
        estimateTime.sendKeys(eTime);
    }
    
    @FindBy(xpath="//th[text()='Mall Name']/../../../tbody/tr/td[1]")                 List<WebElement> selectMall;
    @FindBy(xpath="//th[text()='Mall Name']/../../../tbody/tr/td[3]")                 List<WebElement> selectCheckBox;
    @FindBy(xpath="//label[text()='Price*']/following-sibling::input")                List<WebElement> price ;
    @FindBy(xpath="//label[text()='Special Price']/following-sibling::input")         List<WebElement> specialPrice;
    @FindBy(xpath="//label[text()='Service Price in Mall']/following-sibling::input") List<WebElement> servicePriceInMall;
    public void selectMall(String name) {
    int count=0;
    for(WebElement mall:selectMall)
    {
    	count++;
    	if(mall.getText().equalsIgnoreCase(name))
    	{
    		break;
    	}
    }
    int CCount=0;
    for(WebElement Check:selectCheckBox)
    {
    	CCount++;
    	if(CCount==count)
    	{
    		Check.click();
    	}
    }
    }

    public void enterPrice(int index, String priceValue) {
        price.get(index).clear();
        price.get(index).sendKeys(priceValue);
    }

    public void enterSpecialPrice(int index, String specialPriceValue) {
        specialPrice.get(index).clear();
        specialPrice.get(index).sendKeys(specialPriceValue);
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
    