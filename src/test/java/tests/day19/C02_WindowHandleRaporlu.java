package tests.day19;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_WindowHandleRaporlu extends TestBaseRapor {

    @Test
    public void testReusableMethots(){
        extentTest = extentReports.createTest("window handle test","yeni sayfada new window yazisini tets eder");

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("istenen adrese gidildi");

        Driver.getDriver().findElement(By.xpath("//a[text()='Click Here']")).click();
        extentTest.info("link'e tiklandi");

        ReusableMethods.switchToWindow("New Window");
        extentTest.info("yeni sayfaya gecildi");

        Assert.assertTrue(Driver.getDriver().findElement(By.tagName("h3")).isDisplayed());
        extentTest.pass("test edilen yazi locate edilip, goruldu");
    }
}
