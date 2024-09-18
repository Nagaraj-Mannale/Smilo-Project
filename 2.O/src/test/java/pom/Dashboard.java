package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePage.Constructor;

public class Dashboard extends Constructor {

	public Dashboard(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//table[@aria-label='Order Service']/thead//span")List<WebElement> orderServiceColumnHeader;
	@FindBy(xpath="//table[@aria-label='Order Service']/tbody//span")List<WebElement> todayWeekYearOrderServiceData;
	
	public String getOrderServiceColumnHeaders(String header) {
	    int index = -1;
	    for (int i = 0; i < orderServiceColumnHeader.size(); i++) 
	    {
	        WebElement link = orderServiceColumnHeader.get(i);
	    if  (link.getText().equalsIgnoreCase(header)) 
	     {index = i; break; }                                     
	    } 
	    
	    if (index != -1 && index < todayWeekYearOrderServiceData.size()) 
	         {return todayWeekYearOrderServiceData.get(index).getText(); }
	    else {System.out.println("Header not found or data index out of bounds.");return null;}       
	 }
	     	
	
	@FindBy(xpath="//table[@aria-label='Sales Generated']/thead//th")List<WebElement> salesGeneratedColumnHeader;
	@FindBy(xpath="//table[@aria-label='Sales Generated']/tbody//td")List<WebElement> todayWeekYearOrderSalesData;
	
	public void getSalesGeneratedColumnHeaders(String header) {
    	for(WebElement link:salesGeneratedColumnHeader)  {
    	if(link.getText().equalsIgnoreCase(header)) {
    			link.click();break;     } 	}   }
	

	@FindBy(xpath="//table[@aria-label='Lead Generated']/thead//th") List<WebElement> leadGeneratedColumnHeader;
	@FindBy(xpath="//table[@aria-label='Lead Generated']/tbody//td") List<WebElement> todayWeekYearLeadsData;
	public void getLeadGeneratedColumnHeaders(String header) {
    	for(WebElement link:leadGeneratedColumnHeader)  {
    	if(link.getText().equalsIgnoreCase(header)) {
    			link.click();break;     } 	}   }
	
	@FindBy(xpath="//table[@aria-label='Lead Converted']/thead//th") List<WebElement> leadConvertedColumnHeader;
	@FindBy(xpath="//table[@aria-label='Lead Converted']/tbody//td") List<WebElement> todayWeekYearConvertedLeadsData;
	public void getLeadConvertedColumnHeaders(String header) {
    	for(WebElement link:leadConvertedColumnHeader)  {
    	if(link.getText().equalsIgnoreCase(header)) {
    			link.click();break;     } 	}   }
	
	@FindBy(xpath="//*[@id='chartContainer2']")WebElement ServiceOrdersByStageWhenDiagram;
	
	
	
//	@FindBy(xpath="//*[@id='chartContainer2']")WebElement ServiceOrdersByStageWhenDiagram;
//	@FindBy(xpath="//*[@id='chartContainer2']")WebElement ServiceOrdersByStageWhenDiagram;
//	@FindBy(xpath="")WebElement a;
//	@FindBy(xpath="")WebElement a;
	
	
}
