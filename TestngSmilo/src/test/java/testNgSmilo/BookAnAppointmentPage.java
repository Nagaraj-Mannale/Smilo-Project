package testNgSmilo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class BookAnAppointmentPage extends Browserlaunch
{
	 WebDriver driver;
	BookAnAppointmentPage(WebDriver driver)
	{
		this.driver=driver;
	}
@Test
void clickOnBookanAppointPage()
{
	driver.findElement(By.xpath("//button[text()=' Book Now ']")).click();
}
@Test
void createAnPatient()
{
	
	WebElement Title=driver.findElement(By.xpath("//select[@id='title']"));//dropdown
	Select sel=new Select(Title);
	sel.selectByVisibleText("Mr ");
	driver.findElement(By.xpath("//input[@id='first_name']"));//first name
	driver.findElement(By.xpath("//input[@id='last_name']"));//last name
	driver.findElement(By.xpath("//button[@type='button']")).click();//calender
	WebElement months=driver.findElement(By.xpath("//select[@title='Select month']"));//month
	WebElement years=driver.findElement(By.xpath("//select[@title='Select year']")); //year
	Select year=new Select(years);
	Select month=new Select(months);
	year.selectByVisibleText("1996");
	month.selectByVisibleText("Oct");
	String date="6";
	List<WebElement> dates=driver.findElements(By.xpath("//div[@role='gridcell']/div"));//dates
	for(int i=0;i<dates.size();i++)
	{
	  if(dates.get(i).getText().trim().equals(date))
	  {
		  dates.get(i).click();
		  break;
	  }
	}
	driver.findElement(By.xpath("//input[@id='email_address']")).getText();//emailfield	
	driver.findElement(By.xpath("//div[@role='combobox']"));//country code button
	driver.findElement(By.xpath("//div[@role='combobox']/..//li/span[1]"));//countrycode option
	WebElement gender=driver.findElement(By.xpath("//select[@id='gender']"));//gender
	Select gend=new Select(gender);
	gend.selectByVisibleText("Male ");
	driver.findElement(By.xpath("//div[@class='text_box']/textarea")).sendKeys("Bangalore");//Home Adress
	driver.findElement(By.xpath("//input[@id='post_code']")).sendKeys("560068");//postcode
	driver.findElement(By.xpath("//button[@type='submit']")).click();//submit
}
}
