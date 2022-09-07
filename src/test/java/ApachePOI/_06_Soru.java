package ApachePOI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06_Soru {
    /*
       Bir önceki soruda, Kullanıcıya 1.sütundaki tüm değerleri bir liste halinde kullanıcıya
       yanlarında bir numara olarak sunalım. Kullanıcı hangi numarayı girerse o satırın
       yanındaki tüm bilgiler gösterilsin.
       Username için 1
       Password için 2
    */
    public static void main(String[] args) throws IOException {

        String path="src/test/java/ApachePOI/resource/LoginData.xlsx";
        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Login");

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            System.out.println(i+1 + ". - " + sheet.getRow(i).getCell(0).toString());
        }

        System.out.print("Make a selection...:(1-" + sheet.getPhysicalNumberOfRows() + ") ");
        Scanner input = new Scanner(System.in);
        int selection=input.nextInt();
        String searchData=sheet.getRow(selection-1).getCell(0).toString();

        System.out.println(readExcelData(sheet,searchData));

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
        } return result;
    }

}
