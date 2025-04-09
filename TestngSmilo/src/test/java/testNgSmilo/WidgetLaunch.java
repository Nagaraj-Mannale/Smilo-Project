package testNgSmilo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WidgetLaunch {
    public static WebDriver driver;
 	@BeforeTest
	void launchTheBrowser()
	{
		
		String browser="v2widget.tech-active.com";//CommonData.widgetTokens("Nagaraj Ind");
		driver=Browserlaunch.launchBrowser(browser);
		
	}
  	@Test(priority=0)
  	void navigateToUploadpage()
  	{
  		
		//GetStartPage
  		driver.findElement(By.xpath("//button[text()=' Start Now ']")).click();
  		
  		//PurposeOfVisitPage
  		driver.findElement(By.xpath("//h3[text()='General Checkup']")).click();
  		driver.findElement(By.xpath("//button[text()=' Continue ']")).click();
  		
  		//ConsentAgreementpage
  		
  		WebElement ele1=driver.findElement(By.xpath("//span[text()='Continue']"));
  		CommonData.js.executeScript("arguments[0].click();",ele1);
  		
  		if(driver.getCurrentUrl().contains("https://v2widget"))
  		 {
  		 //Select-PreferencePage
  		  driver.findElement(By.xpath("//h3[text()='Oral Health Rating']")).click();
  		  driver.findElement(By.xpath("//button[text()=' Continue ']")).click();
 		 }
  		
  		List<WebElement> uploadSpace=driver.findElements(By.xpath("//input[@type='file']"));             	   
    	for(int i=0;i<uploadSpace.size();i++)
        	   {
        		 CommonData.js.executeScript("arguments[0].style.display='block';",uploadSpace.get(i));
        		 uploadSpace.get(i).sendKeys(CommonData.imagedata.get(i));
        		 driver.findElement(By.xpath("//span[text()=' Done ']")).click();
              	 driver.findElement(By.xpath("//span[@class='save_continue_btn_span']")).click(); 
        		   
        	   }
     	}
    	@Test(priority=2)
    	void ContactInfo()
    	{
//	    //ContactPage
	    driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Tester");
	    driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("N");
    
        String mail="test"+CommonData.RandomString.toLowerCase()+"@gmail.com";
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(mail);
	    driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
    	}
    	
    	@Test(priority=3)
    	void EnsureWeAreOnfinalCardPage()
    	{
	    CommonData.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='img-block']/img")));
	    Assert.assertEquals(driver.getCurrentUrl(), "https://v2widget.tech-active.com/payment-access-report");
	    System.out.println(driver.getCurrentUrl());
           }
    	}