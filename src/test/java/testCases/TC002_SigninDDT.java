package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LoginWithSession;
import utilities.DataProvider;

public class TC002_SigninDDT {
    public static WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters({ "os", "browser" })
    public void setup(String os, String br) throws IOException, InterruptedException {
        FileReader file = new FileReader(
                "C:\\Users\\DELL\\.vscode\\hometriangle\\hometriangle\\src\\test\\resouces\\config.properties");
        p = new Properties();
        p.load(file);
		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {

			switch (br.toLowerCase()) {
				case "chrome":
					driver = new ChromeDriver();
					break;
				case "edge":
					driver = new EdgeDriver();
					break;
				default:
					System.out.println("Invalid browser name..");
					return;
			}       
   
    }
         Reporter.log("Browser got launched...", true);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appURL"));
        // HomePage hp = new HomePage(driver);
        // Thread.sleep(3000);
        // hp.clickCity();
}


    @Test(dataProvider = "LoginData", dataProviderClass = DataProvider.class)

    public void verify_signinDDT(String phoneno, String otp, String exp) throws InterruptedException {

        Reporter.log("******* Starting TC002_SignInDDT ******", true);
        try {
            HomePage hp = new HomePage(driver);
            Thread.sleep(4000);
            hp.clickProfile();
            Reporter.log("Clicked on Profile logo...", true);

            LoginPage lp = new LoginPage(driver);
            Reporter.log("Providing moblile number...", true);

            lp.setPhone(phoneno);
            lp.clickSendOtp();
            Reporter.log("Providing otp...", true);

            lp.setopt(otp);
            lp.clickLogin();

            Reporter.log("Validating expected message...", true);
            String validation = driver.getTitle();
            boolean targetpage = validation.equals("Login to Your Account | Access Personalized Services");
            LoginWithSession aws = new LoginWithSession(driver);

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetpage == true) {
                    Reporter.log("Login successfull...", true);
                    Thread.sleep(4000);
                    aws.clickProfile();
                    aws.clickLogout();
                    Assert.assertTrue(true);

                } else {
                    Reporter.log("Login unsuccessfull...", true);
                    Assert.assertTrue(false);
                }
            }

            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetpage == true) {
                    aws.clickProfile();
                    aws.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }

        } catch (Exception e) {
            Reporter.log("Invalid creadential...", true);
            driver.navigate().back();
        }
        Reporter.log("******* Finished TC002_SignInDDT ******", true);
    }

    @AfterClass
    public void teardown() {
        Reporter.log("Browser got closed...", true);
        driver.quit();
    }
}
