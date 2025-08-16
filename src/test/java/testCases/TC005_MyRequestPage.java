package testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.LoginWithSession;
import pageObjects.Profilepage;
import testBase.BaseClass;

public class TC005_MyRequestPage extends BaseClass {

    @Test
    public void myRequest() {
        Reporter.log("******* Starting TC005_MyRequest ******", true);

        try {
            LoginWithSession ls = new LoginWithSession(driver);
            ls.clickProfile();
            Reporter.log("Click on Profile Loga...", true);
            ls.requestPage();
            Reporter.log("Click on My Request Link...", true);
            Reporter.log("Validating expected page...", true);
            Profilepage pp = new Profilepage(driver);
            pp.validationMyrequest(driver.getCurrentUrl());
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
        Reporter.log("******* Fineshed TC005_MyRequest ******", true);
    }

}
