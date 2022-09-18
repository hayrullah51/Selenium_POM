package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public  abstract class TestBase {
    //abstract yaparak bu class'dan obje olusturulmasinin onune geceriz
//biz test base class'i sadece extends ile inherit ederek kullanacagiz
    //dolayisiyla olusturdugumuz driver variable si icin protected access modifier'i seciyoruz
   protected WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @AfterClass
    public void tearDown() {
       // driver.quit();
    }
}
