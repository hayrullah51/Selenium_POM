package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C01_ConcortHotelLoginPossitive extends TestBase {

    @Test
    public void possitiveLoginTest() {

        //2) Bir test method olustur NegativeLoginTest()
        // https://www.concorthotel.com/ adresine git login butonuna bas
        driver.get("https://www.concorthotel.com/");
        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        concortHotelPage.log_in.click();

        // test data username: manager1 , test data password : manager1!
        concortHotelPage.usernameBox.sendKeys("manager");
        concortHotelPage.passwordBox.sendKeys("manager1!");
        concortHotelPage.logIn_Button.click();

        //Degerleri girildiginde sayfaya girilebildigini test et
        Assert.assertTrue(concortHotelPage.basariliGirisUserName.isDisplayed(),"Giris Basarisiz!");


    }

}
