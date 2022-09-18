package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {

    //facebook sayfasina gidelim
    //kullanici adi : hayrullah
    //sifre : 12345
    //yazdigimizda giris yapamadigimizi test edin

    @Test
    public void testPOM(){
        driver.get("https://facebook.com");
        FacebookPage facebookPage = new FacebookPage(driver);

        facebookPage.cookiesGec();//cookies cikarsa bu method'u cagir!!!

        facebookPage.emailGiris.sendKeys("hayrullah");
        facebookPage.passwordGiris.sendKeys("12345");
        facebookPage.girisButonu.click();
        Assert.assertTrue(facebookPage.yanlisSifreText.isDisplayed(),"Giris yapildi,Test FAILED");

    }
}
