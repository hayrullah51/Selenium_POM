package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

    WebDriver driver;

    public FacebookPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    FacebookPage(){

    }

    @FindBy(id="email")
    public WebElement emailGiris;

    @FindBy(id="pass")
    public WebElement passwordGiris;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement girisButonu;

    @FindBy(xpath = "//div[text()='Girdiğin şifre yanlış. ']")
    public WebElement yanlisSifreText;

    public void cookiesGec(){
        //cookies cikarsa driver.findElement(By.xpath("//")).click;
        //yapilacak
    }

}
