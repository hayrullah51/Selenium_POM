package tests.day19;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_ReusableMethodsKullanimi {

    @Test
    public void test(){
        // https://the-internet.herokuapp.com/windows adrese gidelim
        // click here yazisina basalim
        // yeni sayfada New Window yazisinin gorundugunu test edelim
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaHandleDegeri = Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.xpath("//a[text()='Click Here']")).click();
       Set<String> windowHandleSet = Driver.getDriver().getWindowHandles();
       String ikinciSayfaHandleDegeri = "";

        for (String each:windowHandleSet
             ) {
            if (!each.equals(ikinciSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandleDegeri);

        Assert.assertTrue(Driver.getDriver().findElement(By.tagName("h3")).isDisplayed());
        System.out.println(Driver.getDriver().getTitle());

        Driver.getDriver().close();


    }

    @Test
    public void testReusableMethots(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.xpath("//a[text()='Click Here']")).click();
        ReusableMethods.switchToWindow("New Window");
        ReusableMethods.waitFor(5);
       Assert.assertTrue(Driver.getDriver().findElement(By.tagName("h3")).isDisplayed());
    }

}
