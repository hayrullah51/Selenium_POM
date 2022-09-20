package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcortHotelPage {

    WebDriver driver;

    ConcortHotelPage (){

    }

    public ConcortHotelPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement log_in;

    @FindBy(id = "UserName")
    public WebElement usernameBox;

    @FindBy(id = "Password")
    public WebElement passwordBox;

    @FindBy(id = "btnSubmit")
    public  WebElement logIn_Button;

    @FindBy(xpath = "//div[@class='validation-summary-errors']")
    public WebElement false_logIn;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement basariliGirisUserName;
}
