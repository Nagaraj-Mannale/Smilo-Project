package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePage.Constructor;
//For first record id name and email follow the lead page 

public class Customer extends Constructor 
{
 public Customer(WebDriver driver){
	super(driver);                }
 
 @FindBy(xpath="//p[text()='No Customer Found!']") WebElement emptyPageText;
 
 public String CusEmptyPageText(){
 return emptyPageText.getText();
 }
 

}