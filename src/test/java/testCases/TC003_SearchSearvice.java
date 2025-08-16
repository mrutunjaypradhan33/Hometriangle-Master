package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.LoginWithSession;
import pageObjects.Servicepage;
import testBase.BaseClass;

public class TC003_SearchSearvice extends BaseClass {
    @Test
    public void search() throws InterruptedException {
        Reporter.log("******* Starting TC003_SearchSearvice ******", true);
        try {
            LoginWithSession ls = new LoginWithSession(driver);
            Reporter.log("Search for service...", true);
            ls.searchTxt();
            ls.searchTxt1();
            ls.services();
            Servicepage sv = new Servicepage(driver);
            Reporter.log("Validating expected message...", true);
            sv.validation(driver.getCurrentUrl());
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
        Reporter.log("******* Finshed TC003_SearchSearvice ******", true);
    }

}
