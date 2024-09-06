package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import basePage.Constructor;
public class Setting extends Constructor
{
  public Setting(WebDriver driver)
  {
	super(driver);
  }
  @FindBy(xpath="//ul[@class='sub-nav-ul loader']/li")List<WebElement> settingPageLinks;
  public void clickOnSettinglink(String page)  {
  for(WebElement link:settingPageLinks)  {
	  if(link.getText().equalsIgnoreCase(page))  {
		  link.click();break;  }  }  }
  
  @FindBy(xpath="//a[text()='Catagories']/../../li")List<WebElement> optionsOfProductandService; 
  public void selectProductandServiceOption(String page) {
	  for(WebElement link:optionsOfProductandService){
		 if(link.getText().equalsIgnoreCase(page)){
			 link.click();link.click();break; }	}  }
 
//Category Page
  @FindBy(xpath="//div[@class='icon-heading second-heading' and contains(text(),'Category')]") WebElement HomePageHeading;
  @FindBy(xpath="//tbody[@class='ui-sortable']/tr/td[2]") WebElement catName;
  @FindBy(xpath="//tbody[@class='ui-sortable']/tr/td[3]//span[2]")WebElement statustext;
  @FindBy(xpath="//a[text()='Add New']")        WebElement addButton;
  @FindBy(xpath="//button[@type='button']")     WebElement kebabIcon;
  @FindBy(xpath="//div[@class='dropdown-content_list_options']/a")List<WebElement> kebaboptionsED;
  @FindBy(xpath="//button[text()='Save Order']")WebElement  saveOrder;

public String getCategoryFirstRecordName()
{
	return catName.getText();
}
public String getCategoryFirstRecordStatus()
{
	return statustext.getText();
}
public String getHomePageHeading() {
   return HomePageHeading.getText();
}

public void clickAddButton() {
   addButton.click();
}

public void selectKebabOption(String optionText) {
	for (WebElement option : kebaboptionsED) {
       if (option.getText().equals(optionText)) {
    	   kebabIcon.click();
    	   option.click();break; }  }  }

public void clickSaveOrder() {
   saveOrder.click();
}

  //addPage
  @FindBy(xpath="//div[@class='icon-heading second-heading']")WebElement addPageHeading;//Use for 3 pages
  @FindBy(xpath="//input[@id='name']")          WebElement  categoryName;
  @FindBy(xpath="//select[@id='type']")         WebElement  selectType;
  @FindBy(xpath="//span[@class='slider toggle']")WebElement sliderStatus;
  @FindBy(xpath="//button[text()='Save']")      WebElement  btnSave;
  @FindBy(xpath="//a[text()='Cancel']")         WebElement  btnCancel;

public String getAddPageHeading() {
   return addPageHeading.getText();
}

public void enterCategoryName(String name) {
   categoryName.clear();
   categoryName.sendKeys(name);
}

public void selectCategoryType(String type) {
   Select select = new Select(selectType);
   select.selectByVisibleText(type);
}

public void toggleSliderStatus() {
   sliderStatus.click();
}

public void clickSaveButton() {
   btnSave.click();
}

public void clickCancelButton() {
   btnCancel.click();
}


}
