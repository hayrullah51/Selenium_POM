package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C02_ConcortHotelLoginNegative extends TestBase {

    //1 ) Bir Class olustur : NegativeTest
    // 2) Bir test method olustur
    @Test
    public void negativeLogInTest(){

        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        // NegativeLoginTest() https://www.concorthotel.com/ adresine git
        driver.get("https://www.concorthotel.com");
        // login butonuna bas
        concortHotelPage.log_in.click();

        // test data username: manager1 , test data password : manager1!
        concortHotelPage.usernameBox.sendKeys("manager1");
        concortHotelPage.passwordBox.sendKeys("manager1!");
        concortHotelPage.logIn_Button.click();
        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(concortHotelPage.false_logIn.isDisplayed(),"Yetkisiz girisss");

    }

}
