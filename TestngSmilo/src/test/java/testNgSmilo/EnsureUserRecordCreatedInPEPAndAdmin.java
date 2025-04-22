package testNgSmilo;


import static testNgSmilo.CommonData.getJs;
import static testNgSmilo.CommonData.getWait;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EnsureUserRecordCreatedInPEPAndAdmin extends Browserlaunch {
	 
	AdminLogin admin; 
 	@Test(priority=0)
	void launchTheBrowser()
	{
		launchBrowser();
		String browser=CommonData.widgetTokens("Jyoti Ind","d1");//"v2widget.tech-active.com/get-started/smgfJN9E0JXgBVGdyHgJsTZef3tQ9XleLXTM9FZe7qWJrsiDQI";//
		driver.get("https://"+browser);
		
		
	}
   @Test(priority=1)
  	void navigateTopPurposeOfVisitPage()
  	{
  		getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Virtual consult ']")));
  		System.out.println(driver.getCurrentUrl());
		//GetStartPage
  		if(driver.getCurrentUrl().equals("https://app-d1.smilo.health/select-service"))
  		{
          driver.findElement(By.xpath("//span[text()='Start now']")).click();
  		}
  		else
  		{
  		driver.findElement(By.xpath("//button[text()=' Start Now ']")).click();
  		}
  	}
  	@Test(priority=2)
  	void navigateToUploadImagePage()
  	{
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
  	}
  	@Test(priority=3)
  	void uploadImages()
  	{
  		List<WebElement> uploadSpace=driver.findElements(By.xpath("//input[@type='file']"));             	   
    	for(int i=0;i<uploadSpace.size();i++)
        	   {
        		 getJs().executeScript("arguments[0].style.display='block';",uploadSpace.get(i));
        		 uploadSpace.get(i).sendKeys(CommonData.imagedata.get(i));
        		 driver.findElement(By.xpath("//span[text()=' Done ']")).click();
              	 WebElement continueBtn=driver.findElement(By.xpath("//span[@class='save_continue_btn_span']"));
              	 getJs().executeScript("arguments[0].scrollIntoView(true);",continueBtn);
              	 try
              	 {
              		 getWait().until(ExpectedConditions.visibilityOf(continueBtn));
              		continueBtn.click();
              		
              	 }
              	 catch(Exception e)
              	 {
              		getJs().executeScript("arguments[0].click();", continueBtn);
              		continueBtn.click();
              	 }
              	
        		   
        	   }
     	}
  	    static String mail;
  	   @Test(priority =4)
  	  void ContactInfo()
  	{
//	    //ContactPage
	    driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Tester");
	    driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("N");
  
     // String mail="test"+CommonData.RandomString.toLowerCase()+"@gmail.com";
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("smilotester@gmail.com");
	    
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
    	@Test(priority=5)
    	void EnsureWeAreOnfinalCardPage()
    	{
	    getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='img-block']/img")));
	    Assert.assertEquals(true,driver.getCurrentUrl().contains("payment-access-report") );
	    System.out.println(driver.getCurrentUrl());
	    driver.quit();
        }
    	//Entering into the PEP Portal
    	//SoftAssert sa=new SoftAssert();
  
        @Test(priority=6)
        void EnsureReportPresentInPEP()
        {
        	
        	admin=new AdminLogin();
        	String browser="v2pep.tech-active.com";
      		admin.launchTheAdminBrowser(browser);
      		driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("jyoti@rokkun.io");
      		WebElement element=driver.findElement(By.xpath("//input[@id='login_password']"));
      		getWait().until(ExpectedConditions.visibilityOf(element));
      		element.sendKeys("Ind@123");
      		driver.findElement(By.xpath("//button[@id='login_submit']")).click();
      		driver.findElement(By.xpath("//span[@class='sub_icon white icon-users']")).click();
      		try
      		{
      		driver.findElement(By.xpath("//span[text()='Reports']")).click();
      		}
      		catch (Exception e) {
				WebElement ele=driver.findElement(By.xpath("//span[text()='Reports']"));
				getJs().executeScript("arguments[0].click();", ele);
			}
      		String Pmail=driver.findElement(By.xpath("//table[@id='user_table']/tbody/tr[1]/td[3]")).getText();
      		Assert.assertEquals(Pmail,"smilotester@gmail.com");
            driver.close();
        		
        }
        //Entering into the AdminPortal
       
        SoftAssert sa=new SoftAssert();
        @Test(priority = 7)
        void VerifyTheRecordInTheAdminPortal() throws InterruptedException
        {
        	admin=new AdminLogin();	
        	admin.launchTheAdminBrowser("v2admin.tech-active.com");
        	admin.EntermailAndPassword();
        	admin.ExtractTheMailOtpAndPassIntoTheOtpFields();
        	//sa.assertEquals("https://v2admin.tech-active.com/", driver.getCurrentUrl());
        	driver.findElement(By.xpath("//a[@href='https://v2admin.tech-active.com/user']")).click();
        	//getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://v2admin.tech-active.com/ohr_report']\"))")));
        	try
        	{
        		driver.findElement(By.xpath("//a[@href='https://v2admin.tech-active.com/ohr_report']")).click();
        	}
        	catch (Exception e) {
            	WebElement ele=driver.findElement(By.xpath("//a[@href='https://v2admin.tech-active.com/ohr_report']"));
                 getJs().executeScript("arguments[0].click();", ele);
			}
        	String firstRecordMail=driver.findElement(By.xpath("(//td[@class='sorting_1'])[1]/../td[3]")).getText();
        	Assert.assertEquals("smilotester@gmail.com",firstRecordMail);
           sa.assertAll();
           driver.quit();
        }
       
     @AfterMethod
     void takingScreenShot(ITestResult result)
     {
    	 if(ITestResult.FAILURE==result.getStatus())
    	 {
    		// takeScreenshot(driver);
    	 }
     }

  	}


	
	
	
