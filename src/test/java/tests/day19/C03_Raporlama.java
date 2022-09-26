package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Arrays;

public class C03_Raporlama extends TestBaseRapor {

    @Test
    public void test1() {

        extentTest = extentReports.createTest("Nutella testi", "sonuc sayisi 1000 den az olmali");

        // amazon sayfasina gidip
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon sayfasina gidildi");

        // nutella icin arama yapalim
        Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Arama kutusu locate edildi");

        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        extentTest.info("Nutella yazilip tiklatildi");

        // sonuc sayisinin 1000'den az oldugunu test edelim
        // System.out.println(Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText());
        String result = Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println(result);


        String[] str = result.split(" ");
        System.out.println(Arrays.toString(str));
        int sonucSayisi = Integer.parseInt(str[2]);
        System.out.println(sonucSayisi);
        Assert.assertTrue(sonucSayisi < 1000);
        extentTest.info("Sonuc sayisi 100'den az");
        extentTest.pass("Test PASSED");

    }

    @Test
    public void test2() {
        extentTest = extentReports.createTest("Samsung testi", "sonuc sayisi 1000 den az olmali");

        // amazon sayfasina gidip
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon sayfasina gidildi");

        // nutella icin arama yapalim
        Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Arama kutusu locate edildi");

        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung" + Keys.ENTER);
        extentTest.info("Samsung yazilip tiklatildi");

        // sonuc sayisinin 1000'den az oldugunu test edelim
        // System.out.println(Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText());
        String result = Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println(result);


        String[] str = result.split(" ");
        System.out.println(Arrays.toString(str));
        String str2 = str[3].toString().replaceAll(",", "");

        int sonucSayisi = Integer.parseInt(str2);
        System.out.println(sonucSayisi);
        Assert.assertTrue(sonucSayisi < 5000);
        extentTest.info("Sonuc sayisi 100'den az");
        extentTest.pass("Test PASSED");

    }

    @Test
    public void test3() {
        extentTest = extentReports.createTest("Java (Elektironic menusunde) testi", "sonuc sayisi 1000 den az olmali");

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon sayfasina gidildi");

        Select select = new Select(Driver.getDriver().findElement(By.id("searchDropdownBox")));
        select.selectByVisibleText("Electronics");
        extentTest.info("DropDown menusu locate edildi");

        WebElement searchBox = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Arama kutusu locate edildi");

        searchBox.sendKeys("Java"+Keys.ENTER);
        extentTest.info("Arama kutusuna Java yazilip Enter'landi");

        WebElement ilkUrun = Driver.getDriver().findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        extentTest.info("Ilk urun locate edildi");

        Assert.assertTrue(ilkUrun.getText().contains("Java"));
        extentTest.pass("Ilk urunde aranan kelime bulundu, Test PASSED");

    }


}
