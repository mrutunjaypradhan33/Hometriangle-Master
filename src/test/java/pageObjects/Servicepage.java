package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Servicepage extends BasePage {

    public Object searchTxt;

    public Servicepage(WebDriver driver) {
        super(driver);
    }

    public void validation(String v) {
        if (v.equals("https://hometriangle.com/bangalore/house-cleaning")) {
            System.out.println("successfully Naviget to House cleaning page...");
        } else {
            System.out.println("Unsuccessful Naviget to House cleaning page...");
            Assert.assertTrue(false);
        }
    }

}
