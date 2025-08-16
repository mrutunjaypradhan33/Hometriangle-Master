package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class TC012_NearMePage {
    
        public static WebDriver driver;
        public Properties p;
    
        @BeforeClass
        @Parameters({ "os", "browser" })
        public void setup(String os, String br) throws IOException {
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
            driver.get("https://hometriangle.com/near-me/house-cleaning");
        }
        @Test
        public void verify_signin() {
            Reporter.log("****** Stated TC012_NearMePage ******", true);
            try {
                String validation = driver.getTitle();
                Reporter.log("Capture the Title...", true);
                Reporter.log("Validate the title...", true);
                if (validation.equals("Expert House Cleaning Services | Sparkling Clean Homes")) {
                    Assert.assertTrue(true);
                    Reporter.log("Successfully navigate to Near me page...", true);
                } else {
                    Assert.assertTrue(false);
                    Reporter.log("Unsuccessfull navigate to Near me page...", true);
                }
                driver.quit();
            } catch (Exception e) {
                Assert.assertTrue(false);
            }
            Reporter.log("******* Finshed TC012_NearMePage ******", true);
        }
    
    }



    

