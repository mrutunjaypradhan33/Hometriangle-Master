package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "phone-number")
    WebElement txtPhone;

    @FindBy(xpath = "//button[text()='Send Otp']")
    WebElement btnSendOtp;

    public void clickSendOtp() {
        btnSendOtp.click();
    }

    public void setPhone(String phone) {
        txtPhone.sendKeys(phone);
    }

    @FindBy(id="otp")
    WebElement txtotp;
    
    public void setopt(String otp){
     txtotp.sendKeys(otp);
    }

    @FindBy(xpath = "//span[text()='Login']")
    WebElement btnLogin;

    public void clickLogin() {
        btnLogin.click();
    }

}
