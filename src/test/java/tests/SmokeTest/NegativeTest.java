package tests.SmokeTest;

import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeTest {

    QAConcortPage qaConcortPage = new QAConcortPage();



    @Test(priority = 1)
    public void yanlisSifre() throws InterruptedException {

        qaConcortPage = new QAConcortPage();
        qaConcortPage.giris();
        qaConcortPage.log_in.click();
        qaConcortPage.usernameBox.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));
        qaConcortPage.logIn_Button.click();
        Assert.assertTrue(qaConcortPage.false_logIn.isDisplayed());
    }

    @Test(priority = 2)
    public void yanlisKulllanici(){
        //qaConcortPage'e yeni bir deger atamaliyim ve testler sirali sekilde gitmeli
        qaConcortPage = new QAConcortPage();
        qaConcortPage.usernameBox.clear();
        qaConcortPage.passwordBox.clear();
        qaConcortPage.usernameBox.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.logIn_Button.click();
        Assert.assertTrue(qaConcortPage.false_logIn.isDisplayed());

    }



    @Test(priority = 3)
    public void yanlisSifreKullanici(){

        qaConcortPage = new QAConcortPage();
        //once yanlisSifre()'de girdigim verileri temizlemeliyim
        qaConcortPage.usernameBox.clear();
        qaConcortPage.passwordBox.clear();
        qaConcortPage.usernameBox.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));
        Assert.assertTrue(qaConcortPage.false_logIn.isDisplayed());
        Driver.closeDriver();


    }



}
