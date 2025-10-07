package testBase;

import java.util.Date;
import java.util.Properties;

import java.net.URL;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.text.SimpleDateFormat;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LoginWithSession;

public class BaseClass {
	public static WebDriver driver;
	public Properties p;

	@BeforeClass
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {
		WebDriverManager.chromedriver().setup();

		// Loading config.properties file
		FileReader file = new FileReader(
				"C:\\Users\\DELL\\.vscode\\hometriangle\\hometriangle\\src\\test\\resouces\\config.properties");
		p = new Properties();
		p.load(file);

		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// os
			if (os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("No matching os");
				return;
			}

			// browser
			switch (br.toLowerCase()) {
				case "chrome":
					capabilities.setBrowserName("chrome");
					break;
				case "edge":
					capabilities.setBrowserName("MicrosoftEdge");
					break;
				default:
					System.out.println("No matching browser");
					return;
			}

			driver = new RemoteWebDriver(new URL("http://192.168.68.63:4444"), capabilities);
		}

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@BeforeMethod
	public void login() throws InterruptedException {
        try{
		driver.get(p.getProperty("appURL"));
		HomePage hp = new HomePage(driver);
		hp.validation(driver.getCurrentUrl());
		// Thread.sleep(4000);
		// hp.clickCity();
		Thread.sleep(4000);
		hp.clickProfile();
		Reporter.log("Clicked on Profile logo...", true);

		LoginPage lp = new LoginPage(driver);
		Reporter.log("Providing moblile number...", true);

		lp.setPhone(p.getProperty("phoneNO"));
		lp.clickSendOtp();
		Reporter.log("Providing OTP...", true);

		lp.setopt(p.getProperty("otp"));
		lp.clickLogin();

		Thread.sleep(3000);
		Reporter.log("Validating expected message...", true);

		LoginWithSession lw = new LoginWithSession(driver);
		lw.validation(driver.getTitle());
		Reporter.log("Succefully naviget to Home page...");
		 } catch (Exception e) {
            Assert.assertTrue(false);
        }
	}

	@AfterMethod
	public void logout() {
        try{
		LoginWithSession aws = new LoginWithSession(driver);
		aws.clickProfile();
		aws.clickLogout();
		Reporter.log("Logout successfull...", true);
	} catch (Exception e) {
		Assert.assertTrue(false);
	}
	}

	@AfterClass
	public void teardown() {
        try{
		Reporter.log("Browser got closed...", true);
		driver.quit();
	    } catch (Exception e) {
		Assert.assertTrue(false);
	   }
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;
	}

}
