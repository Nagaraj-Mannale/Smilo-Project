package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.Constructor;

public class Serviceman extends Constructor
{
public Serviceman(WebDriver driver)
{
	super(driver);
}
@FindBy(xpath="//a[text()='Add Serviceman']") WebElement btnAdd;
	public void addButton()      {
		 btnAdd.click();         }
@FindBy(xpath="//div[@class='icon-heading second-heading']") WebElement txtAddpage;

}
