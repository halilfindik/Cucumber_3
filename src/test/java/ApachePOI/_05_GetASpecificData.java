package ApachePOI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Verilen Exceldeki password bilgisini bir metod aracılığıyla bularak yazdırınız,
 * yani metoda "password" kelimesi gönderilecek, dönen değer password'un kendisi olacak.
 * src/test/java/ApachePOI/resources/LoginData.xlsx
 */
public class _05_GetASpecificData {
    public static void main(String[] args) throws IOException {

        String path="src/test/java/ApachePOI/resource/LoginData.xlsx";
        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Login");

        System.out.println(readExcelData(sheet,"Password"));

    }
    public static List<String> readExcelData(Sheet sheet, String searchData) {
        List<String> result = new ArrayList<>();
        int rowCount=sheet.getPhysicalNumberOfRows();
        for (int i=0; i<rowCount; i++) {
            Row row=sheet.getRow(i);
            int cellCount=row.getPhysicalNumberOfCells();
            for (int j = 0; j < cellCount-1; j++) {
                String firstRowData=row.getCell(0).toString().toLowerCase();
                if (firstRowData.equals(searchData.toLowerCase())) {
                    result.add(row.getCell(j+1).toString());
                }
            }
        }
        return result;
    }
}
