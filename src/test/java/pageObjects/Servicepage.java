package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Servicepage extends BasePage {

    public Object searchTxt;

    public Servicepage(WebDriver driver) {
        super(driver);
    }

    public void validation(String v) {
        if (v.equals("https://hometriangle.com/bangalore/house-cleaning?cart=true")) {
            System.out.println("Successfully Naviget to House cleaning page...");
        } else {
            System.out.println("Naviget Unsuccessful to House cleaning page...");
            Assert.assertTrue(false);
        }
    }

}
