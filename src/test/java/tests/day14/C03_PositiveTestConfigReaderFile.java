package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.CongiReader;
import utilities.TestBase;

public class C03_PositiveTestConfigReaderFile extends TestBase {

        @Test
    public void positiveTestConfig(){

            // https://www.concorthotel.com/ adresine git login butonuna bas
            driver.get(CongiReader.getProperty("CHUrl"));

            ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
            concortHotelPage.log_in.click();
            // test data username: manager1 , test data password : manager1!
            concortHotelPage.usernameBox.sendKeys(CongiReader.getProperty("CHValidUsername"));
            concortHotelPage.passwordBox.sendKeys(CongiReader.getProperty("CHValidPassword"));
            concortHotelPage.logIn_Button.click();

            //Degerleri girildiginde sayfaya girilebildigini test et
            Assert.assertTrue(concortHotelPage.basariliGirisUserName.isDisplayed());


        }





}
