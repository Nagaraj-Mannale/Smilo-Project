package testNgSmilo;

import static testNgSmilo.CommonData.getJs;
import static testNgSmilo.CommonData.getWait;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WidgetFunctionality {
    public static WebDriver driver;
   
 	@BeforeTest
	void launchTheBrowser()
	{
		
		String browser="app-d1.smilo.health/get-started/9dkd6uZ8B8KD46a3HTiBtQbs87nYpOKDjftWHdsHuv1saU13IE";//CommonData.widgetTokens("Nagaraj Ind");//"v2widget.tech-active.com/get-started/smgfJN9E0JXgBVGdyHgJsTZef3tQ9XleLXTM9FZe7qWJrsiDQI";//
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
  		getJs().executeScript("arguments[0].click();",ele1);
  		
  		if(driver.getCurrentUrl().contains("https://v2widget"))
  		 {
  		 //Select-PreferencePage
  		  driver.findElement(By.xpath("//h3[text()='Oral Health Rating']")).click();
  		  driver.findElement(By.xpath("//button[text()=' Continue ']")).click();
 		 }
  		
  		List<WebElement> uploadSpace=driver.findElements(By.xpath("//input[@type='file']"));             	   
    	for(int i=0;i<uploadSpace.size();i++)
        	   {
        		 getJs().executeScript("arguments[0].style.display='block';",uploadSpace.get(i));
        		 uploadSpace.get(i).sendKeys(CommonData.imagedata.get(i));
        		 driver.findElement(By.xpath("//span[text()=' Done ']")).click();
              	 WebElement element=driver.findElement(By.xpath("//span[@class='save_continue_btn_span']"));
              	getJs().executeScript("arguments[0].scrollIntoView(true);",element );
              	 element.click();
        		   
        	   }
     	}
    	@Test(priority=2)
    	void ContactInfo()
    	{
//	    //ContactPage
	    driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Tester");
	    driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("N");
    
       // String mail="test"+CommonData.RandomString.toLowerCase()+"@gmail.com";
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("nagaraj@rokkun.io");
	    
		if(driver.getCurrentUrl().contains("v2widget"))
	    {
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
	    }
	    else if(driver.getCurrentUrl().contains("app-d1"))
	    {
	      driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("7760633081");
	    }
	    
		driver.findElement(By.xpath("//button[@type='submit']")).click();
    	}
    	
    	@Test(priority=3)
    	void EnsureWeAreOnfinalCardPage()
    	{
    		if(driver.getCurrentUrl().contains("v2widget"))
    		{
	         getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='img-block']/img")));
	          Assert.assertEquals(driver.getCurrentUrl(), "https://v2widget.tech-active.com/payment-access-report");
	          System.out.println(driver.getCurrentUrl());
           }
    		else
    		{
    		    getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='img-block']/img")));
    		    Assert.assertEquals(driver.getCurrentUrl(), "https://app-d1.smilo.health/payment-access-report");
    		    System.out.println(driver.getCurrentUrl());
    		}

//	    //PaymentAccesReportPage Download Report via email
//	    
//	    WebElement element=driver.findElement(By.xpath("//button[text()=' Download Report ']"));
//	    wait.until(ExpectedConditions.visibilityOf(element));
//	    js.executeScript("arguments[0].scrollIntoView(true);", element);
//	    element.click();
//	    driver.findElement(By.xpath("//button[@type='submit']")).click();
    	}}