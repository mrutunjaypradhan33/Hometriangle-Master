package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC010_Managa_cunsolting extends BaseClass{
    @Test
    public void manageCunsolting() throws InterruptedException {
        Reporter.log("******* Starting TC010_Managa_cunsolting ******", true);
        try {
           driver.findElement(By.xpath("(//button[.//p[text()='What service do you need?']])[2]")).click();
           Reporter.log("Clicked on secrch text field...", true);
           driver.findElement(By.xpath("//input[@type='text']")).sendKeys("house construction");
           Reporter.log("Service enter into search text field...", true);
           driver.findElement(By.xpath("//a[normalize-space()='House Construction']")).click();
           Reporter.log("Clicked on service...", true);
           driver.findElement(By.xpath("/html/body/astro-island/section/div[4]/div[1]/div[1]/div[1]/div[2]/div/div/div/div[3]/div/div[1]/div[1]/div/div/div/div/div[2]/button")).click();//service page
           Thread.sleep(3000);
           Reporter.log("Clicked on add button...", true);
           driver.findElement(By.xpath("(//span[text()='Proceed to Details'])[1]")).click();//service page
           Reporter.log("Clicked on Proceed to Details button..", true);
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
        Reporter.log("******* Finshed TC010_Managa_cunsolting ******", true);
    }
    
}
