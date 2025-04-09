package testNgSmilo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonData extends WidgetLaunch {

	public static String RandomString=RandomStringUtils.randomAlphanumeric(3); //----------------->CreationOfRandomString
	public static WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(120));//------->Wait Element
    public static JavascriptExecutor js=(JavascriptExecutor) driver;           //----------------->JavaScriptExecutor
	
	
	
	public static ArrayList<String>imagedata=new ArrayList<String>(Arrays.asList(
		"/home/active35/Downloads/5Images/1st.jpeg",
		"/home/active35/Downloads/5Images/2nd.jpeg",
		"/home/active35/Downloads/5Images/3rd.jpeg",
		"/home/active35/Downloads/5Images/4th.jpeg",
		"/home/active35/Downloads/5Images/5th.jpeg",
		"/home/active35/Downloads/5Images/1st.jpeg"));
		
	
	
	public static String widgetTokens(String name)
	{
		String token="";
		switch(name)
		{
		case "Jyoti Ind"      :token="get-started/Y14SKx4JtPwfs4J1VurWgMu3PXgVzWttUo1GTyKwPsNQCJE8j7";break;
		case "Jyoti Aus"      :token="get-started/PUFvqWKKt4HI86UZx5wzD29aUWXgZwnUXrJlTj6oCDhlLUBhdN";break;
		case "Chetan Ind"     :token="get-started/E8ofS6LFsTYPMp0rlLOzFPySAj5of9K0jfXsQThyD4OsKaElvT";break;
		case "MangalPande Ind":token="get-started/smgfJN9E0JXgBVGdyHgJsTZef3tQ9XleLXTM9FZe7qWJrsiDQI";break;
		case "Nagaraj Ind"    :token="get-started/n9UyYRbhUU3yBR17pXjoMKwBPirr5NPS5V4J0AFTe8r60SyXAB";break;
		default:System.out.println("Label is not match with the token to send");
		
		}
		token="v2widget.tech-active.com/"+token;
		return token;
	}
	
	
}
