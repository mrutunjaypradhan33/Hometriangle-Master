package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC009_Cunsolting extends BaseClass {
    @Test
    public void cunsolting() throws InterruptedException {
        Reporter.log("******* Starting TC009_Cunsolting ******", true);
        try {
            Reporter.log("Search for service...", true);
           driver.findElement(By.xpath("(//button[.//p[text()='What service do you need?']])[2]")).click();
           Reporter.log("Clicked on secrch text field...", true);
           driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Microwave Oven Repair & Services");
           Reporter.log("Service enter into search text field...", true);
           driver.findElement(By.xpath("//a[normalize-space()='Microwave Oven Repair & Services']")).click();
           Reporter.log("Clicked on service...", true);
           driver.findElement(By.xpath("//button[@data-hk='s00-0-0-11-12-0']")).click();//service page
        //    Thread.sleep(3000);
           Reporter.log("Clicked on add button...", true);
           driver.findElement(By.xpath("/html/body/astro-island/section/div[4]/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/button")).click();;//service page
           Reporter.log("Clicked on Proceed button..", true);
           Thread.sleep(1000);
           driver.findElement(By.xpath("//button[contains(text(), 'Confirm Consultation')]")).click();//cart page
           Reporter.log("Clicked on confirm Consultation button...", true);
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
        Reporter.log("******* Finshed TC009_Cunsolting ******", true);
    }
    
}
