package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.Constructor;

public class CommonComponents extends Constructor
{
	public CommonComponents(WebDriver driver){
		       super(driver);                }
	
	@FindBy(xpath="//div[@class='logo-container']/following-sibling::nav//li")
	  List<WebElement> allPageLinks;
	public void selectPageLink(String page)  {
    	for(WebElement links:allPageLinks)
    	{
    		if(links.getText().trim().equalsIgnoreCase(page))
    		{
    			links.click();
    			break;
    		}
    	}
    }
	
	
	 @FindBy(xpath="//Select[@id='showDropdown']")  WebElement dropPagination;
	 @FindBy(xpath="//input[@id='search']")         WebElement txtSearch;
	 @FindBy(xpath="//Select[@id='city']")          WebElement dropCity;//payment for payment mode
	 @FindBy(xpath="//input[@id='from_date']")      WebElement dateFrom;
	 @FindBy(xpath="//input[@id='to_date']")        WebElement dateTO; 
	 @FindBy(xpath="(//button[@type='button'])[1]") WebElement firstRecordKebabIcon;
	 
	
	 
	 public void searchField(String val) {
		 txtSearch.sendKeys(val);        }
	 
	 @FindBy(xpath="(//Select[@id='showDropdown']/../../../../div/div)[1]")   WebElement txtHomePage;
	 @FindBy(xpath="//button[@id='clear_button']")    WebElement btnReset;
	 @FindBy(xpath="//button[text()='SET']")    WebElement btnSet;
	 
	 public String getHomePageTxt()     { 
	      return txtHomePage.getText(); }
	 
	 public void resetButton() {
		  btnReset.click();    }
	 
	 public void setButton() {
		  btnSet.click();    }
	  
	 
	 @FindBy(xpath="//p[@class='alert-heading text-semibold second-heading text-center mt-0 mb-0']")WebElement txtEmptyPage;  
	 @FindBy(xpath="(//a[@class='page-link'])[3]")WebElement iconNextPage;
	 @FindBy(xpath="(//a[@class='page-link'])[4]")WebElement iconLastPage;
	 public String getTxtForEmptyPage()        
     {
	 return txtEmptyPage.getText();}
	 
	 public void nextPageButton(){
		 iconNextPage.click();   }
	 
	 public void lastPageButton(){
		 iconLastPage.click();   }
	 
	 
	    
	    
	  
	 
	}
	
