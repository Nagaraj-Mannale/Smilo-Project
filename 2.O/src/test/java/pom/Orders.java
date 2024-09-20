package pom;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.Constructor;

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

public void getSubTotal() {
    ArrayList<WebElement> TotalOrders = new ArrayList<WebElement>(orderTotal);
    ArrayList<WebElement> OrderStatus = new ArrayList<WebElement>(orderStatus);
    double totalOrder = 0.0;

    // Print the size of both lists for debugging
    System.out.println("OrderStatus size: " + OrderStatus.size());
    System.out.println("TotalOrders size: " + TotalOrders.size());

    for (int i = 0; i < OrderStatus.size(); i++) {
        WebElement status = OrderStatus.get(i);

        // Print the status for debugging
        System.out.println("Status at index " + i + ": " + status.getText());

        // Skip if the status is "Cancelled Order"
        if (status.getText().trim().equalsIgnoreCase("Cancelled Order")) {
            System.out.println("Cancelled order at index " + i);
            continue; // Skip to the next iteration for cancelled orders
        }

        // Ensure the index exists in TotalOrders
        if (i < TotalOrders.size()) {
            WebElement order = TotalOrders.get(i);

            // Print the corresponding order total for debugging
            System.out.println("Order total at index " + i + ": " + order.getText());

            try {
                // Add the corresponding value from TotalOrders as a double
                totalOrder += Double.parseDouble(order.getText().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format at index " + i);
            }
        } else {
            System.out.println("No corresponding order total for status at index " + i);
        }
    }

    System.out.println("Final Total Order: " + totalOrder);
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