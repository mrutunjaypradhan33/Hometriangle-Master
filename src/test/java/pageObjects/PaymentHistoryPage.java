package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PaymentHistoryPage extends BasePage {
     public PaymentHistoryPage(WebDriver driver) {
          super(driver);
     }

     public void validationPaymentHistory(String s) {
          if (s.equals("https://hometriangle.com/dashboard/payments")) {
               System.out.println("Successfully navigate to Payment History Page...");
          } else {
               System.out.println("UnSuccessful navigate to Payment History Page...");
               Assert.assertTrue(false);
          }
     }

}
