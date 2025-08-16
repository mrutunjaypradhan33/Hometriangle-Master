package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginWithSession extends BasePage {

    public LoginWithSession(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@class='font-medium select-none text-white']")
    WebElement linkProfile;

    public void clickProfile() {
        linkProfile.click();
    }

    @FindBy(xpath = "//h4[text()='Sign out']")
    WebElement linkLogout;

    public void clickLogout() {
        linkLogout.click();
    }

    @FindBy(xpath = "(//button[.//p[text()='What service do you need?']])[2]")
    WebElement searchtxt;

    public void searchTxt() {
        searchtxt.click();
    }

    @FindBy(xpath = "//input[@type='text']")
    WebElement searchtxt1;

    public void searchTxt1() {
        searchtxt1.sendKeys("House cleaning");
    }

    @FindBy(xpath = "//a[normalize-space()='House Cleaning']")
    WebElement service;

    public void services() {
        service.click();
    }

    public void validation(String s) {
        if (s.equals("Hire top rated service professionals in Bangalore")) {
            System.out.println("succefully naviget to Home page...");
        } else {
            System.out.println("Unsuccessfull naviget to home page...");
            Assert.assertTrue(false);
        }
    }

    @FindBy(xpath = "//h4[text()='Profile']")
    WebElement profilePage;

    public void profiilePagelink() {
        profilePage.click();
    }

    public void validationProfile(String s) {
        if (s.equals("https://hometriangle.com/dashboard/profile")) {
            System.out.println("succefully naviget to Profile page ...");
        } else{
            System.out.println("Unsuccessfull naviget to profile page...");
            Assert.assertTrue(false);
        }
    }

    @FindBy(xpath = "//h4[text()='My requests']")
    WebElement requestPageLink;

    public void requestPage() {
        requestPageLink.click();
    }

    @FindBy(xpath = "//h4[text()='Payment History']")
    WebElement paymentHistoryLink;

    public void PaymentHistoryPage() {
        paymentHistoryLink.click();
    }

    @FindBy(xpath = "//a[normalize-space()='Contact Us']")
    WebElement contactUsLink;

    public void contactUsPage() {
        contactUsLink.click();
    }

}
