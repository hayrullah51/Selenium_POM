package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    WebDriver driver;
    //Bir page sayfasi olusturdugumuzda mutlaka yapmamiz gereken sey
    //bir constructor olusturup driver'e ilk degeri atamaktir (instantiate) !!!

   public AmazonPage(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(driver,this);
    }

    public AmazonPage(){

    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisiElementi;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
    public WebElement ilkUrun;

    @FindBy(id="searchDropdownBox")
    public WebElement dropDownMenu;
}
