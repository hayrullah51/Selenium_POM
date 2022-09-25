package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

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

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsLinki;

    @FindBy(xpath ="//span[text()='Add Hotelroom ']")
    public WebElement addHotelRoomButonu;

    @FindBy(id="IDHotel")
    public WebElement addRoomIdDropdown;

    @FindBy(id="IDGroupRoomType")
    public WebElement addRoomType;

    @FindBy(id="btnSubmit")
    public WebElement addRoomSaveButonu;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement addRoomSuccessfulYazisi;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement addRoomAllertOkButonu;

    @FindBy(linkText = "Hotelrooms")
    public WebElement addroomHotelRoomsLinki;

    @FindBy(xpath ="//span[text()='List Of Hotelrooms']")
    public WebElement addRoomHotelRoomListyazisi;

    @FindBy(xpath = "//thead/tr[1]/th")
    public List<WebElement> basliklarListesi;

    @FindBy(xpath = "//tbody")
    public WebElement tBodyTumu;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement birinciSatir;

    @FindBy(xpath = "//tbody/tr//td[4]")
    public List<WebElement> dorduncuSutunListesi;


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

    public String printData(int satir, int sutun) {
        // ornekteki haliyle 3.satir, 5.sutundaki elemani yazdiralim
        //  String xpath= //tbody//tr[3]//td[5]
        // degismeyecek kisimlari String, degisecek kisimlari ise parametre ismi olarak yazdik
        String xpath= "//tbody//tr[" + satir +"]//td["+ sutun + "]";
        //System.out.println(xpath);

        // satir no : 3, sutun no : 5
        //System.out.println("satir no : "+ satir+ " sutun no : " + sutun);

        // @FindBy notasyonu parametreli calismadigi icin onceki yontemle locate edelim
        String istenenData = Driver.getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println("satir no  "+ satir+ ", sutun no : " + sutun + "'deki data : " + istenenData );

        return istenenData;
    }



}
