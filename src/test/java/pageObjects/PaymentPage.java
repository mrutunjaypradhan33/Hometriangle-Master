package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PaymentPage extends BasePage {

  public PaymentPage(WebDriver driver) {
    super(driver);
  }

  public void validationPaymentPage(String s) {
    if (s.equals("https://hometriangle.com/dashboard/payments/overview")) {
      System.out.println("Successfully navigate to Payment page...");
    } else {
      System.out.println("Naviget Unsuccessfull naviget to payment page...");
      Assert.assertTrue(false);
    }
  }

}
