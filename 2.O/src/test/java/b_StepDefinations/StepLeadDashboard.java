package b_StepDefinations;

import java.awt.AWTException;

import org.junit.Assert;

import b_BasePage.ClassObjects;
import io.cucumber.java.en.*;

public class StepLeadDashboard {
//	  private static String leadId="";
	  private String leadName="Tester";
	  private String leadMail="nagaraj@rokkun.io";
	  int Today=0;
	  int Week=0;
	  int Month=0;
	 @When("get the today this week and this month generated count data")
	    public void getTodayThisWeekAndThisMonthData() {
	         Today=Integer.parseInt(ClassObjects.DB.getLeadGeneratedDataByColumnHeaders("Today"));
	         Week=Integer.parseInt(ClassObjects.DB.getLeadGeneratedDataByColumnHeaders("This Week"));
	         Month=Integer.parseInt(ClassObjects.DB.getLeadGeneratedDataByColumnHeaders("This Month"));
	        
	       
	    }
	    @And("add the new lead")
	    public void add_the_new_lead() {
	    	ClassObjects.LD.clickAddButton();
	    	ClassObjects.LD.setLeadName(leadName);
	        ClassObjects.LD.selectLeadStatus("Contact Made");
	        ClassObjects.LD.setEmail(leadMail);
	        ClassObjects.LD.setMobile("4567891234");
	        ClassObjects.LD.setAddressLabel("Banglore");
	        ClassObjects.LD.setAddress("Bengaluru");
	        ClassObjects.LD.selectCity("Bengaluru");
	        ClassObjects.CC.clickOnSaveButton();
	    }

	    @And("navigate to the dashboard")
	    public void go_to_the_dashboard() {
	    	ClassObjects.CC.selectPageLink("Dashboard");
	    }

	    @Then("verify the lead generated count data")
	    public void verifyLeadGeneratedData(){
	    	int today=Integer.parseInt(ClassObjects.DB.getLeadGeneratedDataByColumnHeaders("Today"));
	        int week=Integer.parseInt(ClassObjects.DB.getLeadGeneratedDataByColumnHeaders("This Week"));
	        int month=Integer.parseInt(ClassObjects.DB.getLeadGeneratedDataByColumnHeaders("This Month"));
	        System.out.println(Today+" "+today);  
	        System.out.println(Week+" "+week);  
	        System.out.println(Month+" "+month);  
	        Assert.assertEquals(Today+1,today);
	        Assert.assertEquals(Week+1,week);
	        Assert.assertEquals(Month+1,month);
	    }	
	    
//lead Converted
	    @When("get the today this week and this month converted count data")
	    public void getTodayThisWeekAndThisMonthConvertedCountData() {
	    	Today=Integer.parseInt(ClassObjects.DB.getLeadConvertedDataByColumnHeaders("Today"));
	        Week=Integer.parseInt(ClassObjects.DB.getLeadConvertedDataByColumnHeaders("This Week"));
	        Month=Integer.parseInt(ClassObjects.DB.getLeadConvertedDataByColumnHeaders("This Month"));
	        System.out.println(Today+""+Week+""+Month);
	    }

	    @And("select one lead and click on convert button")
	    public void selectOneLeadAndClickOnConvertButton() throws AWTException {
	       ClassObjects.CC.searchField("Sandeep Sharma");
	       leadName=ClassObjects.LD.getfirstRecordName();
	       ClassObjects.LD.clickonCheckBox();
	       ClassObjects.LD.clickConvertButton();
	       Assert.assertNotSame(ClassObjects.CC.getSuccessMessage(), "Email id exists in customer! ");
	    }
	    @And("navigate to the customer page")
	    public void navigateToTheCustomerPage() {
	    	ClassObjects.CC.selectPageLink("Customer");
	    }

	    @Then("verify the converted lead in the customer page")
	    public void verifyConvertedLeadInCustomerPage() throws AWTException {
	    	ClassObjects.CC.searchField(leadName);
	    	Assert.assertEquals(leadName,ClassObjects.LD.getfirstRecordName() );
	    }
	    @Then("verify the lead converted count data")
	    public void verifyLeadConvertedData() {
	    	int today=Integer.parseInt(ClassObjects.DB.getLeadConvertedDataByColumnHeaders("Today"));
	        int week=Integer.parseInt(ClassObjects.DB.getLeadConvertedDataByColumnHeaders("This Week"));
	        int month=Integer.parseInt(ClassObjects.DB.getLeadConvertedDataByColumnHeaders("This Month"));
	        System.out.println(Today+" "+today);  
	        System.out.println(Week+" "+week);  
	        System.out.println(Month+" "+month);  
	        Assert.assertEquals(Today+1,today);
	        Assert.assertEquals(Week+1,week);
	        Assert.assertEquals(Month+1,month);
	    }
	    
	    
	    
}
