package tests.SmokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLoginTest {

    @Test
    public void positiveLoginTest(){
        // Bir test method olustur positiveLoginTest()
        //https://qa-environment.concorthotel.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        QAConcortPage qaConcortPage = new QAConcortPage();
        //login butonuna bas
        qaConcortPage.log_in.click();
        qaConcortPage.usernameBox.sendKeys("CHQAValidUsername");
        qaConcortPage.passwordBox.sendKeys("CHQAValidPassword");
        qaConcortPage.logIn_Button.click();

        //test data username: manager ,
        //test data password : Manager1!
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(qaConcortPage.basariliGirisUserName.isDisplayed());
        Driver.closeDriver();


    }
}
