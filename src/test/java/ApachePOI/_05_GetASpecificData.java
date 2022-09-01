package ApachePOI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Verilen Exceldeki password bilgisini bir metod aracılığıyla bularak yazdırınız,
 * yani metoda "password" kelimesi gönderilecek, dönen değer password'un kendisi olacak.
 * src/test/java/ApachePOI/resources/LoginData.xlsx
 */
public class _05_GetASpecificData {
    public static void main(String[] args) throws IOException {

        String path="ssrc/test/java/ApachePOI/resource/LoginData.xlsx";
        FileInputStream inputStream=new FileInputStream(path);

        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Login");


    }
//    public static String readPassword(Sheet sheet) throws IOException {
//
//        Row row
//
//        return ;
//    }
}
