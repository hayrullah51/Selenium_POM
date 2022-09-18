package tests.day13;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C03_Pages  extends TestBase {

    @Test
    public void test(){
        driver.get("https://amazon.com");
        //dropDown Menusunden books'u secelim

        AmazonPage amazonPage = new AmazonPage(driver);
        Select select = new Select(amazonPage.dropDownMenu);
        select.selectByVisibleText("Books");
        amazonPage.aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        System.out.println(amazonPage.sonucYazisiElementi.getText());
        Assert.assertTrue(amazonPage.ilkUrun.getText().contains("Java"),"Aranan urunde Java ismi gecmiyor!!!");



    }

}
