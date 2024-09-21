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
	
	public String getOrderServiceData(String header) {
	    int index = -1;
	    ArrayList<WebElement>headerLinks=new ArrayList<WebElement>(orderServiceColumnHeader);
	    ArrayList<WebElement>serviceData=new ArrayList<WebElement>(todayWeekYearOrderServiceData);
	    
	    for(WebElement headerlink:headerLinks)
	    {
	    	if(headerlink.getText().equalsIgnoreCase(header))
	    	{
	    		index=headerLinks.indexOf(headerlink);break;
	    	}
	    }
	    
	    if (index != -1 && index < serviceData.size()) 
	         {return serviceData.get(index).getText(); }
	    else {System.out.println("Header not found or data index out of bounds.");return null;}       
	 }
	     	
	
	@FindBy(xpath="//table[@aria-label='Sales Generated']/thead//th")List<WebElement> salesGeneratedColumnHeader;
	@FindBy(xpath="//table[@aria-label='Sales Generated']/tbody//td")List<WebElement> todayWeekYearOrderSalesData;
    public String getSalesGenereatedData(String header)
    {   String Data="";
    	ArrayList<WebElement> headers=new ArrayList<WebElement>(salesGeneratedColumnHeader);
    	ArrayList<WebElement> data=new ArrayList<WebElement>(todayWeekYearOrderSalesData);
    	
    	for(int i=0;i<headers.size();i++)
    	{
    		if(headers.get(i).getText().trim().equalsIgnoreCase(header))
    		{
    			Data=data.get(i).getText().replace("₹","").replace("Rs. ","").trim();
    			break;
    		}
    	}
    	return Data;
    }

	@FindBy(xpath="//table[@aria-label='Lead Generated']/thead//th") List<WebElement> leadGeneratedColumnHeader;
	@FindBy(xpath="//table[@aria-label='Lead Generated']/tbody//td") List<WebElement> todayWeekYearLeadsData;
	
	public String getLeadGeneratedDataByColumnHeaders(String header) {
		 int index = -1;
	     ArrayList<WebElement> listheader = new ArrayList<>(leadGeneratedColumnHeader);
	     ArrayList<WebElement> listData = new ArrayList<>(todayWeekYearLeadsData);
	     
	     for(WebElement headerlink : listheader){
	            if(headerlink.getText().equalsIgnoreCase(header)) 
	              {
	              index = listheader.indexOf(headerlink);break; 
	              } 
	         }
	            	              
	     if(index != -1 && index < listData.size()) 
	        {return listData.get(index).getText();}
	     else{System.out.println("Header not found or data index out of bounds.");return null;}       
	 }
	
	@FindBy(xpath="//table[@aria-label='Lead Converted']/thead//th") List<WebElement> leadConvertedColumnHeader;
	@FindBy(xpath="//table[@aria-label='Lead Converted']/tbody//td") List<WebElement> todayWeekYearConvertedLeadsData;
	
	public String getLeadConvertedDataByColumnHeaders(String header) {
		int index = -1;
		ArrayList<WebElement>listOFHeaderLinks=new ArrayList<WebElement>(leadConvertedColumnHeader);
		ArrayList<WebElement>listOFData=new ArrayList<WebElement>(todayWeekYearConvertedLeadsData);
	    for(WebElement headerlink:listOFHeaderLinks)
	    {
	    	if(headerlink.getText().equalsIgnoreCase(header))
	    	{
	    		index=listOFHeaderLinks.indexOf(headerlink);break;
	    	}
	    }
	    if(index != -1 && index < listOFData.size()) 
	       {return listOFData.get(index).getText();}
	    else{System.out.println("Header not found or data index out of bounds.");return null;}       
	 }
	
	@FindBy(xpath="//*[@id='chartContainer2']")WebElement ServiceOrdersByStageWhenDiagram;
	
	
	
//	@FindBy(xpath="//*[@id='chartContainer2']")WebElement ServiceOrdersByStageWhenDiagram;
//	@FindBy(xpath="//*[@id='chartContainer2']")WebElement ServiceOrdersByStageWhenDiagram;
//	@FindBy(xpath="")WebElement a;
//	@FindBy(xpath="")WebElement a;
	
	
}
