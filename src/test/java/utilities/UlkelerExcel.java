package utilities;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class UlkelerExcel {



    private UlkelerExcel(){

    }

    private static Workbook readUlkelerExcel;

    public static Workbook readUlkelerExcel() throws IOException {

        String patch = "src/test/java/recources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(patch);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        return readUlkelerExcel;
    }

    public static String getUlkelerDataFromExel(String sheet, int satir, int sutun) throws IOException {

     String data =   readUlkelerExcel().getSheet(sheet).getRow(satir).getCell(sutun).toString();

     return data;
    }


}
