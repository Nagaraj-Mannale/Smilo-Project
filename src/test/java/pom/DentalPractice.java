package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.Constructor;

public class DentalPractice extends Constructor {
   WebDriver driver;
   public DentalPractice(WebDriver driver)
    {
	super(driver);
    }

@FindBy(xpath="//div[@class='navbar_sidebar']/ul/li/a/span[2]") List<WebElement> sideBar; 
@FindBy(xpath="//h4[text()='Dental Practice']")            WebElement pageName;
@FindBy(xpath="//input[@type='search']")                   WebElement searchField;
@FindBy(xpath="//div[@class='three-dots-div dropbtn']")    WebElement kebabIcon;
@FindBy(xpath="//div[@class='dropdown-content']/a/span")   WebElement kebabIconOption;
@FindBy(xpath="//div[@class='vertical_sidebar']//li/a")    List<WebElement> settingPageOption;
@FindBy(xpath="(//div[@class='ohr_flow_type_wrapper int_checkbox datatable_check']/..)[1]/div/label") List<WebElement> widgetButtons;

public void titleNames(String title)
{     
	for(WebElement page:sideBar)
	{
		if(page.getText().equals(title))
		{
			page.click();
		}
	}
}
public String pageName(String name)
{
	return pageName.getText();
}
public void kebabIcon()
{
	kebabIcon.click();
}
public void kebabIconOptions()
{
//	for(WebElement kebabIconOption:kebabIconOption)
}
}
