package stepDefinations;

import pom.Analytics;
import pom.CommonComponents;
import pom.Customer;
import pom.Lead;
import pom.LoginPage;
import pom.MallSetting;
import pom.Orders;
import pom.Serviceman;

public class ClassObjects extends StepBaseClass 
{
    public static CommonComponents CC;
    public static LoginPage LP;
    public static Lead LD;
    public static Analytics AL;
    public static Customer CR;
    public static MallSetting MS;
    public static Orders OR;
    public static Serviceman SM;

    public ClassObjects() {
        // Constructor to initialize all page objects
        CC = new CommonComponents(driver);
        LP = new LoginPage(driver);
        LD = new Lead(driver);
        AL = new Analytics(driver);
        CR = new Customer(driver);
        MS = new MallSetting(driver);
        OR = new Orders(driver);
        SM = new Serviceman(driver);
    }
}
