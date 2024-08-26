package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.Constructor;

public class LeadPom extends Constructor
{
 public LeadPom(WebDriver driver)
  {
	super(driver);
  }

 @FindBy(xpath="(//span[text()='Lead'])[2]")     WebElement leadPageText;
 @FindBy(xpath="//button[text()='Import']" )     WebElement btnImport;
 @FindBy(xpath="//a[text()='Add']")              WebElement btnAdd;
 @FindBy(xpath="//button[@id='convert_button']") WebElement btnConvert;
 @FindBy(xpath="//button[text()='Delete']")      WebElement btnDelete;
 @FindBy(xpath="//a[@id='export_btn']")          WebElement linkExport;
 public String getText() {
 return leadPageText.getText();}
 public void importButton()   {
	 btnImport.click();       }
 public void addButton()      {
	 btnAdd.click();          }
 public void convertButton()  {
	 btnConvert.click();      }
 public void deleteButton()   {
	 btnDelete.click();       }
 public void exportLink()     {
	 linkExport.click();      }

 @FindBy(xpath="//Select[@id='status']") WebElement dropStatus;

}
