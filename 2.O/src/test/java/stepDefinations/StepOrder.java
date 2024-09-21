package stepDefinations;


import org.testng.Assert;

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
	    double TotalSalesGeneratedForSingleDay,TotalSalesGeneratedForWeek,TotalSalesGeneratedForMonth = 0.0;
	    @And("the Sub Total data is collected except cancel order for {string}")
	    public void collectSubTotalData(String period) {
	        double subTotal = ClassObjects.OR.getSubTotal();
	        switch (period.toLowerCase()) {
	            case "day":
	                TotalSalesGeneratedForSingleDay = subTotal;
	                break;
	            case "week":
	                TotalSalesGeneratedForWeek = subTotal;
	                break;
	            case "month":
	                TotalSalesGeneratedForMonth = subTotal;
	                break;
	            default:
	                System.out.println("Invalid period: " + period);
	        }
	        ClassObjects.CC.clickResetButton();
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
	    	ClassObjects.CC.enterFromDateAndToDate("01-09-2024", ToDate);
	    	ClassObjects.CC.clickSetButton();
	    }
	    double orderServiceForDay,orderServiceForweek,orderServiceForMonth=0;
	    double GST=.18;
	    @And("calculate the Order Services")
	    public void calculateTotalWithAndWithoutGst() {
	    	orderServiceForDay=TotalSalesGeneratedForSingleDay-(TotalSalesGeneratedForSingleDay*GST);
	    	orderServiceForweek=TotalSalesGeneratedForWeek-(TotalSalesGeneratedForWeek*GST);
	    	orderServiceForMonth=TotalSalesGeneratedForMonth-(TotalSalesGeneratedForMonth*GST);
	     }
	    
	    Double Salestoday,SalesWeek,SalesMonth=0.0;
	    @And("get the data from the dashboard")
	    public void getDataFromTheDashboard() {
	     Salestoday = Double.parseDouble(ClassObjects.DB.getSalesGenereatedData("Today"));
	      SalesWeek = Double.parseDouble(ClassObjects.DB.getSalesGenereatedData("This Week"));
	     SalesMonth = Double.parseDouble(ClassObjects.DB.getSalesGenereatedData("This Month"));
	    }
	    @Then("verify the data with dashboard data")
	    public void verifytheDataWithDashboardData() {
	     Assert.assertEquals(TotalSalesGeneratedForSingleDay,Salestoday);
	     Assert.assertEquals(TotalSalesGeneratedForWeek,SalesWeek);
	     Assert.assertEquals(TotalSalesGeneratedForMonth,SalesMonth);
	    }
	    
}
