package testCase;

import org.junit.Test;
import org.junit.Assert;
import pom.P_LoginPage;

public class Login extends BaseClass {

    @Test
    public void loginToPage() {
        P_LoginPage lp = new P_LoginPage(driver);
        lp.enterUserNameAndPassword("admin@bc.com", "Admin@12");
        String text = lp.getHomePageText();
        Assert.assertEquals("DashBoard", text);
    }
}