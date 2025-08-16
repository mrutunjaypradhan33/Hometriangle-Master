package testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.LoginWithSession;
import testBase.BaseClass;

public class TC004_ProfilePage extends BaseClass {

    @Test
    public void profilePage() {
        Reporter.log("******* Starting TC004_ProfilePage ******", true);
        try {
            LoginWithSession ls = new LoginWithSession(driver);
            ls.clickProfile();
            Reporter.log("Click on Profile Loga...", true);
            ls.profiilePagelink();
            Reporter.log("Click on Profile LInk...", true);
            Reporter.log("Validate the expected page...", true);
            ls.validationProfile(driver.getCurrentUrl());
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
        Reporter.log("******* Finesghed TC004_ProfilePage ******", true);

    }

}
