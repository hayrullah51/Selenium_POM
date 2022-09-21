package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class QAConcortPage {

    WebDriver driver;

    public QAConcortPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement log_in;

    @FindBy(id = "UserName")
    public WebElement usernameBox;

    @FindBy(id = "Password")
    public WebElement passwordBox;

    @FindBy(id = "btnSubmit")
    public WebElement logIn_Button;

    @FindBy(xpath = "//div[@class='validation-summary-errors']")
    public WebElement false_logIn;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement basariliGirisUserName;

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotel_management;

    @FindBy(xpath = "//a[@href='/admin/HotelAdmin']")
    public WebElement hotel_list;

    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement add_hotel;

    @FindBy(id = "Code")
    public WebElement addHotelCode_box;

    @FindBy(id = "btnSubmit")
    public WebElement save_button;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement succesfullyAddHotelText;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement okButton_addedHotel;


    public void giris() throws InterruptedException {
        QAConcortPage qaConcortPage = new QAConcortPage();
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        Driver.getDriver().findElement(By.xpath("//button[@id='details-button']")).click();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("//a[@id='proceed-link']")).click();
        qaConcortPage.log_in.click();
        qaConcortPage.usernameBox.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.logIn_Button.click();


    }

}
