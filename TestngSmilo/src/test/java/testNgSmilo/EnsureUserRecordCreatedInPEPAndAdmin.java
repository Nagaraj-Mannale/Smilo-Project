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
import org.testng.asserts.SoftAssert;

public class EnsureUserRecordCreatedInPEPAndAdmin {
	public static WebDriver driver;
	   
 	@BeforeTest
	void launchTheBrowser()
	{
		
		String browser=CommonData.widgetTokens("Jyoti Ind	");//"v2widget.tech-active.com/get-started/smgfJN9E0JXgBVGdyHgJsTZef3tQ9XleLXTM9FZe7qWJrsiDQI";//
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
  	    static String mail;
  	    @Test(priority=2)
    	void ContactInfo()
    	{
//	    //ContactPage
	    driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Tester");
	    driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("N");
    
         mail="test"+CommonData.RandomString.toLowerCase()+"@gmail.com";
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(mail);
	    driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
    	}
    	@Test(priority=3)
    	void EnsureWeAreOnfinalCardPage()
    	{
	    getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='img-block']/img")));
	    Assert.assertEquals(driver.getCurrentUrl(), "https://v2widget.tech-active.com/payment-access-report");
	    System.out.println(driver.getCurrentUrl());
	    driver.quit();
        }
    	//Entering into the PEP Portal
    	//SoftAssert sa=new SoftAssert();
  
        @Test(priority=4)
        void EnsureReportPresentInPEP()
        {
        	String browser="v2pep.tech-active.com";
      		driver=Browserlaunch.launchBrowser(browser);
      		driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("smilotester@gmail.com");
      		WebElement element=driver.findElement(By.xpath("//input[@id='login_password']"));
      		getWait().until(ExpectedConditions.visibilityOf(element));
      		element.sendKeys("Ind@123");
      		driver.findElement(By.xpath("//button[@id='login_submit']")).click();
      		driver.findElement(By.xpath("//span[@class='sub_icon white icon-users']")).click();
      		
      	    String Pmail=driver.findElement(By.xpath("//table[@id='user_table']/tbody/tr[1]/td[5]")).getText();
      		Assert.assertEquals(mail,Pmail);

//      		//driver.findElement(By.xpath("//span[text()='Reports']")).click();
//      		String currentMail = driver.findElement(By.xpath("(//td[text()='Widget'])[1]/../td[3]")).getText();	
//      	    sa.assertEquals(mail, currentMail);
//      	    //driver.quit();
        		
        }
        //Entering into the AdminPortal
       
        SoftAssert sa=new SoftAssert();
        @Test(priority = 5)
        
        void VerifyTheRecordInTheAdminPortal() throws InterruptedException
        {
        	AdminLogin	admin=new AdminLogin();
        	WebDriver driver=admin.launchTheAdminBrowser("v2admin.tech-active.com");
        	admin.EntermailAndPassword();
        	admin.ExtractTheMailOtpAndPassIntoTheOtpFields();
        	//sa.assertEquals("https://v2admin.tech-active.com/", driver.getCurrentUrl());
        	driver.findElement(By.xpath("//a[@href='https://v2admin.tech-active.com/user']")).click();
        	String firstRecordMail=driver.findElement(By.xpath("(//ul[@class='actions_list']/../..)[1]/td[3]")).getText();
        	Assert.assertEquals(mail,firstRecordMail);
           sa.assertAll();
        }
       


  	}


	
	
	
