package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.Constructor;

public class CommonComponents extends Constructor
{
	public CommonComponents(WebDriver driver){
		       super(driver);                }
	
	 @FindBy(xpath="//Select[@id='showDropdown']")  WebElement dropPagination;
	 @FindBy(xpath="//Select[@id='city']")          WebElement dropCity;//payment for payment mode
	 @FindBy(xpath="//input[@id='from_date']")      WebElement dateFrom;
	 @FindBy(xpath="//input[@id='to_date']")        WebElement dateTO;
	
	 @FindBy(xpath="//input[@id='search']")         WebElement txtSearch;
	 @FindBy(xpath="(//button[@type='button'])[1]") WebElement firstRecordKebabIcon;
	 @FindBy(xpath="(//Select[@id='showDropdown']/../../../../div/div)[1]")   WebElement txtHomePage;
	 public String getext()        {
	 return txtHomePage.getText(); }
	 
	 public void searchField(String val) {
		 txtSearch.sendKeys(val);        }
	 
	 @FindBy(xpath="//button[text()='SET']")      WebElement btnSet;
	 @FindBy(xpath="//button[@id='clear_button']")WebElement btnReset;
	 @FindBy(xpath="(//a[@class='page-link'])[3]")WebElement iconNextPage;
	 @FindBy(xpath="(//a[@class='page-link'])[4]")WebElement iconLastPage;

	 public void setButton(){
		 btnSet.click();    }
	 
	 public void resetButton(){
		 btnReset.click();    }

	 public void nextPageButton(){
		 iconNextPage.click();   }
	 
	 public void lastPageButton(){
		 iconLastPage.click();   }
	 
	}
	
