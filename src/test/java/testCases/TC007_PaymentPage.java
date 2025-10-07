package testCases;
//This page Removed from application
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.LoginWithSession;
import pageObjects.PaymentPage;
import pageObjects.Profilepage;
import testBase.BaseClass;

public class TC007_PaymentPage extends BaseClass {

    @Test
    public void paymentPage() {
        try {
            Reporter.log("****** Stated TC0007_PaymentPage *****", true);
            LoginWithSession lw = new LoginWithSession(driver);
            lw.clickProfile();
            Reporter.log("Click on profile logo...",true);
            lw.profiilePagelink();
            Reporter.log("Click on profile link...",true);
            Profilepage pf = new Profilepage(driver);
            pf.paymentLink();
            Reporter.log("Click on payment page link...",true);
            PaymentPage pp = new PaymentPage(driver);
            Reporter.log("Validating expected page...",true);
            pp.validationPaymentPage(driver.getCurrentUrl());
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
        Reporter.log("****** Finshed TC0007_PaymentPage *****", true);

    }

}
