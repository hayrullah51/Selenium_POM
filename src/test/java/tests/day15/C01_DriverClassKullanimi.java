package tests.day15;


import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;


public class C01_DriverClassKullanimi {

    @Test
    public  void test(){

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //Driver driver = new Driver();
        //driver class'indan obje uretilemesin istedigimiz icin Driver class'i SINGLETON yapiyoruz
        // bunun icin default contructer yerine parametresiz cons. olusturduk
        // ve access modifier'i private seciyoruz

        // Driver driver=new Driver("ben istedim ama olmadi");
        // Driver class'inda parametreli constructor olmadigi icin kullanamayiz





        Driver.closeDriver();

    }
}
