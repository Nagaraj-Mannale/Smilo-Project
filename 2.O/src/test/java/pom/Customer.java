package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.Constructor;

public class Customer extends Constructor 
{
 public Customer(WebDriver driver){
	super(driver);                }
 
 @FindBy(xpath="//a[@id='editCust']/../..") List<WebElement> iconpageKebabs;

}