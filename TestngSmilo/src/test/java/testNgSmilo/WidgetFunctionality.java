package testNgSmilo;

import static testNgSmilo.CommonData.getJs;
import static testNgSmilo.CommonData.getWait;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})

@Epic("EPIC-001")
@Feature("Widget Flow")
public class WidgetFunctionality extends Browserlaunch {
    
   
 	@BeforeTest
	void launchTheBrowser()
	{
		launchBrowser();
		String browser="app-d1.smilo.health/get-started/Y14SKx4JtPwfs4J1VurWgMu3PXgVzWttUo1GTyKwPsNQCJE8j7";//CommonData.widgetTokens("Nagaraj Ind");//"v2widget.tech-active.com/get-started/smgfJN9E0JXgBVGdyHgJsTZef3tQ9XleLXTM9FZe7qWJrsiDQI";////////
		driver.get("https://"+browser);
		
		
	}
  	@Test(priority=0 ,description = "Verify the uploading functionality")
  	@Description("Ensure images are uploading correctly")
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
              	 getWait().until(ExpectedConditions.visibilityOf(element));
              	 element.click();
        		   
        	   }
     	}
    	@Test(priority=2 , description="Verify the contact upload info")
    	@Description("Ensure user info saving correctly")
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
    	
    	@Test(priority=3 , description="Verify the finalPageUrl")
    	@Description("Ensure after filling user info user are redirecting to final page")
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

    //PaymentAccesReportPage Download Report via email
	    driver.findElement(By.xpath("//button[text()=' Book Now ']")).click();//book an appointment
        driver.findElement(By.xpath("//button[text()=' Get Now ']")).click();//book
	    WebElement element=driver.findElement(By.xpath("//button[text()=' Download Report ']"));
        getWait().until(ExpectedConditions.visibilityOf(element));
	    getJs().executeScript("arguments[0].scrollIntoView(true);", element);
	    
        element.click();
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@class='close']")).click();
	    element.click();
	    driver.findElement(By.xpath("//input[@id='flexRadioDefault3']")).click();
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    driver.findElement(By.xpath("//button[@class='close']")).click();
    	}}