package testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageObjects.LoginWithSession;
import pageObjects.PaymentHistoryPage;
import testBase.BaseClass;

public class TC006_PaymentHistoryPage extends BaseClass {
    @Test
    public void paymentHistory() {
        Reporter.log("****** Stated TC006_PaymentHistoryPage ******", true);
        try {
            LoginWithSession ls = new LoginWithSession(driver);
            ls.clickProfile();
            Reporter.log("Click on profile Logo...", true);
            ls.PaymentHistoryPage();
            Reporter.log("Click on Payment History Page...", true);
            Reporter.log("Validating expected page...", true);
            PaymentHistoryPage ph = new PaymentHistoryPage(driver);
            ph.validationPaymentHistory(driver.getCurrentUrl());
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }
}
