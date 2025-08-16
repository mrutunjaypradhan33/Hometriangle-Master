package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC011_Booking extends BaseClass {
     @Test
    public void booking() throws InterruptedException {
        Reporter.log("******* Starting TC011_Booking ******", true);
        try {
            Reporter.log("Search for service...", true);
            driver.findElement(By.xpath("(//button[.//p[text()='What service do you need?']])[2]")).click();
            Reporter.log("Clicked on secrch text field...", true);
            driver.findElement(By.xpath("//input[@type='text']")).sendKeys("House cleaning");
            Reporter.log("Service enter into search text field...", true);
            driver.findElement(By.xpath("//a[normalize-space()='House Cleaning']")).click();
            Reporter.log("Clicked on service...", true);
            driver.findElement(By.xpath("/html/body/astro-island/section/div[4]/div[1]/div[1]/div[1]/div[2]/div/div/div/div[3]/div/div[1]/div[1]/div/div/div/div/div[2]/button")).click();//service page
            Thread.sleep(3000);
            Reporter.log("Clicked on add button...", true);
            driver.findElement(By.xpath("(//button[.//span[text()='Add']])[14]")).click();//service page
            Reporter.log("Clicked on add button...", true);
            driver.findElement(By.xpath("//span[text()='Done']")).click();//service page
            Reporter.log("Clicked on done button...", true);
            driver.findElement(By.xpath("(//span[text()='View Cart'])[1]")).click();//service page
            Reporter.log("Clicked on view cart button...", true);
            driver.findElement(By.xpath("//button[text()='Select Date & Time']")).click();//cart page
            Reporter.log("Clicked on select date & time button...", true);
            driver.findElement(By.xpath("//span[text()='10:00 AM']")).click();//cart page
            Reporter.log("Select time...", true);
            driver.findElement(By.xpath("//span[text()='Proceed ']")).click();//cart page
            Reporter.log("Clicked on proceed button...", true);
            Thread.sleep(1000);
            driver.findElement(By.xpath("(//button[text()='Confirm & Book Now'])[1]")).click();//cart page
            Reporter.log("Clicked on confirm & book now button...", true);
            String suc=driver.findElement(By.xpath("//h2[text()='Successfull!']")).getText();//cart page
                //cart page
                if (suc.equals("Successfull!")) {
                    System.out.println("Booking succefully...");
                } else{
                    System.out.println("Booking Unsuccessfull...");
                    Assert.assertTrue(false);
                }
                driver.findElement(By.xpath("//span[text()='✕']")).click();//cart page

        } catch (Exception e) {
            Assert.assertTrue(false);
        }
        Reporter.log("******* Finshed TC011_Booking ******", true);
    }
    
}
