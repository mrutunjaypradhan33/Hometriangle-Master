package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@class='font-medium select-none text-white']")
    WebElement linkProfile;

    public void clickProfile() {
        linkProfile.click();
    }

    @FindBy(xpath = "//h4[text()='Bangalore']")
    WebElement linkLocation;

    public void clickLocation() {
        linkLocation.click();
    }

    @FindBy(xpath = "/html/body/div[12]/div/div/div/div[2]/div[1]/div[2]/button/div/div/p")
    WebElement linkCity;

    public void clickCity() {
        linkCity.click();

    }

    public void validation(String a) {
        if (a.equals("https://hometriangle.com/bangalore")) {
            System.out.println("Successfully naviget to Hometriangle...");
        } else {
            System.out.println("Unsuccessful naviget to HOmetriangle...");
            Assert.assertTrue(false);
        }
    }

}
