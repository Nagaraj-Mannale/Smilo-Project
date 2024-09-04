package pom;


import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import basePage.Constructor;
import stepDefinations.ClassObjects;

public class MallSetting extends Constructor 
{
   public MallSetting(WebDriver driver)
   {
	super(driver);
   }
   @FindBy(xpath="(//a[text()='Users'])[2]/../../li")List<WebElement> tabLinksOfMallsetting;
   public void selectTabBylinks(String tab)      {
       for (WebElement option : tabLinksOfMallsetting) {
           if (option.getText().equalsIgnoreCase(tab)){
               option.click(); break; }   }   }
   //Home Page button
   @FindBy(xpath="//button[@class='dropbtn_list_options action_btn_container']") WebElement kebabIcon;
   @FindBy(xpath="//a[text()='Add User']/..")        WebElement btnAddUser;
   @FindBy(xpath="//button[text()='Add Mall']")      WebElement btnAddMall;
   @FindBy(xpath="//button[text()='Add Slot']")      WebElement btnAddSlot;
   @FindBy(xpath="//span[text()='delete']")          WebElement btnDelete;
   @FindBy(xpath="//span[text()='edit']")            WebElement btnEdit;
   public void clickAddUser() {
       btnAddUser.click();
   }

   public void clickAddMall() {
       btnAddMall.click();
   }

   public void clickAddSlot() {
       btnAddSlot.click();
   }

   public void clickDelete() {
       kebabIcon.click();
	   btnDelete.click();
	   
   }

   public void clickEdit() {
	   kebabIcon.click();
       btnEdit.click();
   }
   //All Commpon Code For Add page
   @FindBy(xpath="//input[@id='name']")          WebElement fieldName;
   @FindBy(xpath="//select[@id='status']")       WebElement dropStatus;
   @FindBy(xpath="//select[@id='citySelect']")   WebElement dropCity;
   @FindBy(xpath="//select[@id='areaSelect']")   WebElement dropArea;
   @FindBy(xpath="//button[text()='Save']")      WebElement btnSave;

   public void setName(String name) {
       fieldName.clear();
       fieldName.sendKeys(name);
   }
   
   public void selectStatus(String Status) {
	   Select status=new Select(dropStatus);
	   status.selectByVisibleText(Status);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,1000)");
	  
   }
   
   public void selectCity(String City) {
	   Select city=new Select(dropCity);
       city.selectByVisibleText(City);
   }
   
   public void selectArea(String Area) {
	  Select area=new Select(dropArea);
	  area.selectByVisibleText(Area);
   }

   public void clickSave() {
       btnSave.click();
   }
   
   //User Add Page
   @FindBy(xpath="//div[@class='icon-heading second-heading']") WebElement addpagetxt;
   @FindBy(xpath="//input[@id='mobile']")  WebElement fieldMobile;
   @FindBy(xpath="//input[@id='email']")   WebElement fieldMail;
   @FindBy(xpath="//input[@id='password']")WebElement fieldPassword;
   
   public String userAddPageText() {
	   return addpagetxt.getText();
   }
   
   public void setNameMobileMailPassword(String name, String mobile, String email, String password) 
       {
	   fieldName.clear();
       fieldName.sendKeys(name);
	   fieldMobile.clear();
       fieldMobile.sendKeys(mobile); 
       fieldMail.clear();
       fieldMail.sendKeys(email);
       fieldPassword.clear();
       fieldPassword.sendKeys(password);
       }
   public void setMobile(String mobile) {
	   fieldMobile.clear();
       fieldMobile.sendKeys(mobile);
       }
   
   public void setEmail(String email) {
	   fieldMail.clear();
       fieldMail.sendKeys(email);
       }

    public void setPassword(String password) {
       fieldPassword.clear();
       fieldPassword.sendKeys(password);
       }  
   //User Add page
   @FindBy(xpath="//span[text()='Select group']")          WebElement UserdropGroup;
   @FindBy(xpath="//div[@id='groupDropDownMenu']/div")List<WebElement> optionsGroup;
   @FindBy(xpath="//select[@id='mallSelect']")   WebElement dropMall;
   @FindBy(xpath="//a[text()='Cancel']")         WebElement btnCancel;

   public void selectGroup(String group)       {
       UserdropGroup.click();
       for (WebElement option : optionsGroup) {
           if (option.getText().equalsIgnoreCase(group)){
               option.click(); break; }   }   }

   public void selectMall(String Mall) {
	   Select mall=new Select(dropMall);
       mall.selectByVisibleText(Mall);        
   }

   public void clickCancel() {
       btnCancel.click();    }

   //Mall Add Page
   @FindBy(xpath="//select[@id='group']")                  WebElement malldropGroup;
   @FindBy(xpath="//input[@id='customer_number']")         WebElement numberCustomer;
   @FindBy(xpath="//input[@id='supervisor_number']")       WebElement numberSuprevisor;
   @FindBy(xpath="//span[text()='Select Sub Locations']")  WebElement dropLocation;
   @FindBy(xpath="//div[@class='label-div cities']/label") WebElement txtsublocation;
   @FindBy(xpath="//input[@id='selectAll']/../../div")List<WebElement> optionSubLocation;
   @FindBy(xpath="(//table[@class='data-table']//tbody)[1]/tr/td[2]")WebElement userName;
  
   public String GetFirstRecUserName() {
	   return userName.getText();
   }
   
   public void setCustomerNumber(String number) {
       numberCustomer.clear();
       numberCustomer.sendKeys(number);
   }

   public void setSupervisorNumber(String number) {
       numberSuprevisor.clear();
       numberSuprevisor.sendKeys(number);
       
   }
  
   public void selectLocation(String location) {
       dropLocation.click();
       for (WebElement option : optionSubLocation) {
           if (option.getText().equalsIgnoreCase(location)){
               option.click();txtsublocation.click(); break; }   }   }
  
   public void selectMallGroupDrop(String group) {
	   Select mall=new Select(malldropGroup);
       mall.selectByVisibleText(group);   
   }
   
 //Slot Add
   @FindBy(xpath="//h2[@class='heading2']") WebElement slotAddPagetex;
   @FindBy(xpath="//select[@id='mall']")    WebElement selectSlotMall;
   @FindBy(xpath="//select[@id='intervel']")WebElement dropSlotInterval;
   @FindBy(xpath="//input[@id='opentime']") WebElement fieldOpeningTime;
   @FindBy(xpath="//input[@id='closetime']")WebElement fieldClosingTime;
   @FindBy(xpath="//input[@id='limit']")    WebElement fieldSlotLimit;
   @FindBy(xpath="(//table[@class='data-table']//tbody)[1]/tr/td[1]")WebElement slotHomeMallName;
   @FindBy(xpath="(//table[@class='data-table']//tbody)[1]/tr/td[2]")WebElement OpeningTime;
   @FindBy(xpath="(//table[@class='data-table']//tbody)[1]/tr/td[3]")WebElement ClosingTime;
   public String getSlotHomeMallNameOpeningAndClosingTimeTexy() {
	   return slotHomeMallName.getText()+" "+OpeningTime.getText()+" "+ClosingTime.getText();
   } 
   
   
   public String getSlotAddPageText() {
	   return slotAddPagetex.getText();
   } 
   
   public void selectSlotMall(String mall) {
	   Select mallSlot=new Select(selectSlotMall);
       mallSlot.selectByVisibleText(mall);
   }
   
   public void selectSlotInterval(String interval) {
	   Select SlotInterval=new Select(dropSlotInterval);
	   SlotInterval.selectByVisibleText(interval); }

   public void setOpeningTime(String time) throws AWTException {
       fieldOpeningTime.sendKeys(time);  
       ClassObjects.CR.keyboardAction("Enter");   
       }

   public void setClosingTime(String time)throws AWTException {
       fieldClosingTime.sendKeys(time);  
       ClassObjects.CR.keyboardAction("Enter");}

   public void setSlotLimit(String limit)  {
	   fieldSlotLimit.click();
	   fieldSlotLimit.clear();
       fieldSlotLimit.sendKeys(limit);     }
}
