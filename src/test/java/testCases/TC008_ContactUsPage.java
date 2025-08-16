package testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.LoginWithSession;
import testBase.BaseClass;

public class TC008_ContactUsPage extends BaseClass {

    @Test
    public void verify_ContactUs() {
        Reporter.log("****** Stated TC008_ContactUsPage ******", true);
        try {
            LoginWithSession ls = new LoginWithSession(driver);
            ls.contactUsPage();
            Reporter.log("Click to contactUs page...", true);
            Reporter.log("Validating expected message...", true);
            ContactUsPage cu = new ContactUsPage(driver);
            cu.validation(driver.getCurrentUrl());
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
        Reporter.log("****** fineshed TC008_ContactUsPage ******", true);
    }

}
