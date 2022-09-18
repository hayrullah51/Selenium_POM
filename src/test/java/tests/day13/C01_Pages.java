package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C01_Pages extends TestBase {

    //amazon sayfasina gidip
    //nutella icin arama yapin
    //sonuc yazisini yazdirin ve sonus yazisinin nutella icerdigini kontrol edin

    @Test
    public void test(){
        driver.get("https://amazon.com");
        WebElement aramaCubugu = driver.findElement(By.id("twotabsearchtextbox"));

        aramaCubugu.sendKeys("Nutella");
        aramaCubugu.sendKeys(Keys.ENTER);
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
        Assert.assertTrue(sonucYazisi.getText().contains("Nutella"));

    }
    @Test
    public void testPOM(){
        driver.get("https://amazon.com");
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.aramaKutusu.sendKeys("Nutella"+Keys.ENTER);
        System.out.println(amazonPage.sonucYazisiElementi.getText());
        Assert.assertTrue(amazonPage.sonucYazisiElementi.getText().contains("Nutella"));
    }

}


