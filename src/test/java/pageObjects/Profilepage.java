package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Profilepage extends BasePage {

    public Profilepage(WebDriver driver) {
        super(driver);
    }

    public void validationMyrequest(String s) {
        if (s.equals("https://hometriangle.com/dashboard/projects")) {
            System.out.println("successfully naviget to My request page ...");
        } else {
            System.out.println("naviget Unsuccessful to My request page...");
            Assert.assertTrue(false);
        }
    }

    @FindBy(xpath = "//p[text()=' Payments ']")
    WebElement paymetLink;

    public void paymentLink() {
        paymetLink.click();
    }

}
