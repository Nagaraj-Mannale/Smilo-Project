package b_pom;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import b_BasePage.ClassObjects;
import b_BasePage.Constructor;

public class Orders extends Constructor
{
	public Orders(WebDriver driver) 
	{
		super(driver);
	}

//HomePage
@FindBy(xpath="//a[text()='Orders']")WebElement homePageText;
@FindBy(xpath="//td[@id='td-lead-id']/preceding-sibling::td")WebElement firstRecordMainOrderId;
@FindBy(xpath="//td[@id='td-lead-id']")WebElement firstRecordSubOrderId;
@FindBy(xpath="//td[@id='td-email']")  WebElement customerName;
@FindBy(xpath="//td[@id='td-mobile']") List<WebElement> subTotal;
@FindBy(xpath="//td[@id='td-mobile']/following-sibling::td[1]")List<WebElement> orderTotal;
@FindBy(xpath="//td[@id='td-mobile']/following-sibling::td[2]")List<WebElement> orderStatus;
@FindBy(xpath="//td[@id='td-mobile']/following-sibling::td[3]")List<WebElement> orderFrom;



public String getHomePageText() 
 {return homePageText.getText();}

public String getFirstRecordMainOrderId() 
 {return firstRecordMainOrderId.getText();}


public String getFirstRecordSubOrderId() 
 {return firstRecordSubOrderId.getText();}


public String getCustomerName() 
 {return customerName.getText();}

public double getSubTotal() {
    ArrayList<WebElement> TotalOrders = new ArrayList<WebElement>(orderTotal);
    ArrayList<WebElement> OrderStatus = new ArrayList<WebElement>(orderStatus);
    double totalOrder = 0.0;
    for (int i = 0; i < OrderStatus.size(); i++) {
        WebElement status = OrderStatus.get(i);
      if(!status.getText().trim().equals("Cancelled Order") && i<TotalOrders.size()) { 
          try {totalOrder+=Double.parseDouble(TotalOrders.get(i).getText().trim());} 
	      catch(Exception e) {System.out.println("Invalid number format "+TotalOrders.get(i).getText().trim());}
       } 
    }    		  
    	  
      

   
    boolean hasNextPage=ClassObjects.CC.handlePages(">");
    if(hasNextPage==true)
    {
    totalOrder+=getSubTotal();
    }
  
    return totalOrder;
}



//
//public String getOrderTotal() {
//    return orderTotal.getText();
//}
//
//public String getOrderStatus() {
//    return orderStatus.getText();
//}
//
//public String getOrderFrom() {
//    return orderFrom.getText();
//}

//ViewPage
@FindBy(xpath="//a[text()='View Orders']")                WebElement txtViewPage;
@FindBy(xpath="//div[@class='card-details-edit']//a")List<WebElement> viewPagelinks;
@FindBy(xpath="//li[text()='General']")                   WebElement tabGeneral;
@FindBy(xpath="//button[text()='Update Status']") WebElement updateStatusButton;

public String getViewPageText() {
    return txtViewPage.getText();
}

public void clickOnViewPageLinks(String linkName) {
    for (WebElement link : viewPagelinks) {
    if(link.getText().equalsIgnoreCase(linkName)) {
    link.click(); } } }

public void clickOnGeneralTab() {
    tabGeneral.click();
}
public void clickUpdateStatusButton() {
    updateStatusButton.click();
}


}