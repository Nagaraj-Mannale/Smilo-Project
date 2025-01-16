package b_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import b_BasePage.Constructor;

public class Analytics extends Constructor
{
	public Analytics(WebDriver driver)	{
		super(driver);              	}
	
@FindBy (xpath="//a[text()=' Services']/../../li") WebElement linksAnalytic;
@FindBy(xpath="//button[text()='Export']")         WebElement btnExport;
public void exportBtn()
{
	btnExport.click();	
}
	
}
