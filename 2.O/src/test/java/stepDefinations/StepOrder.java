package stepDefinations;


import basePage.ClassObjects;
import io.cucumber.java.en.*;
import pom.CommonComponents;

public class StepOrder {
        private static String FromDate=null;
        private static String ToDate=null;
	    @When("the order link is clicked")
	    public void clickOnOrderLink() {
		  ClassObjects.CC.selectPageLink("Order");
	    }

	    @And("the current date filter is applied")
	    public void applyCurrentDateFilter()  {
	    	FromDate=CommonComponents.todayFormatted;
	    	ToDate=CommonComponents.todayFormatted.substring(0,2);
	        ClassObjects.CC.enterFromDateAndToDate(FromDate, ToDate);
	        ClassObjects.CC.clickSetButton();
	    }

	    @And("the Sub Total data is collected except cancel order")
	    public void collectSubTotalData() {
	        ClassObjects.OR.getSubTotal();
	    }

	    @And("the cancel request status filter is applied")
	    public void applyCancelRequestStatusFilter() {
	       
	    }

	    @And("the updated Sub Total data is collected and subtracted from the previously collected value")
	    public void collectAndSubtractUpdatedSubTotalData() {
	       
	    }

	    @And("the current week date filter is applied")
	    public void applyCurrentWeekDateFilter()  {
	    	ToDate=CommonComponents.todayFormatted.substring(0,2);
	    	FromDate=CommonComponents.mondayFormatted;
	    	ClassObjects.CC.enterFromDateAndToDate(FromDate, ToDate);
	    	ClassObjects.CC.clickSetButton();
	    }

	    @And("the current month date filter is applied")
	    public void applyCurrentMonthDateFilter() {
	     
	    }
	    @And("calculate the Total data with and without GST")
	    public void calculateTotalWithAndWithoutGst() {
	     
	    }
//	    @And("navigate to the dashboard")
//	    public void navigateToTheDashboard() {
//	     
//	    }
	    @Then("verify the data with dashboard data")
	    public void verifytheDataWithDashboardData() {
	     
	    }
	    
}
