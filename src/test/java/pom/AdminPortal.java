package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.Constructor;

public class AdminPortal extends Constructor {
   WebDriver driver;
   public AdminPortal(WebDriver driver)
    {
	super(driver);
    }
@FindBy(xpath="//input[@id='login_email']")                WebElement emailfield;
@FindBy(xpath="//input[@id='login_password']")             WebElement passwordfield;
@FindBy(xpath="//button[@id='login_submit']")              WebElement signinButton;
@FindBy(xpath="//a[text()='Forgot Password?']")            WebElement forgotLink;
@FindBy(xpath="//div[@class='navbar_sidebar']/ul/li/a/span[2]") List<WebElement> sideBar; 
@FindBy(xpath="//input[@type='search']")                   WebElement searchField;
@FindBy(xpath="//div[@class='three-dots-div dropbtn']")    WebElement kebabIcon;
@FindBy(xpath="//div[@class='dropdown-content']/a/span")   WebElement kebabIconOption;
@FindBy(xpath="//div[@class='vertical_sidebar']//li/a")    List<WebElement> settingPageOption;
@FindBy(xpath="(//div[@class='ohr_flow_type_wrapper int_checkbox datatable_check']/..)[1]/div/label") List<WebElement> widgetButtons;


}
