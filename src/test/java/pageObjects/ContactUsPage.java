package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactUsPage extends BasePage {

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void validation(String c) {
        if (c.equals("https://hometriangle.com/contact")) {
            System.out.println("Succefully neviget to ContactUs page...");
        } else {
            System.out.println("Unsuccessfull navigate to ContactUs page");
            Assert.assertTrue(false);
        }
    }
}
