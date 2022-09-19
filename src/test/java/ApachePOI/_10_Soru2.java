package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _10_Soru2 {
    public static void main(String[] args) throws IOException {
        /*  Soru 1:
         *  Çarpım tablosunu excele yazdırınız.
         *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
         *  sıfırdan excel oluşturarak.
         *  her bir onluktan sonra 1 satır ya da 1 sütun boşluk bırakarak alt alata
         */

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Sayfa1");

        for (int i=1; i<11; i++) {
            Row newRow=sheet.createRow(i);
            int column=0;
            for (int j=1; j<11; j++) {
                Cell newCell0 = newRow.createCell(column);
                newCell0.setCellValue(i);
                Cell newCell1 = newRow.createCell(column + 1);
                newCell1.setCellValue("*");
                Cell newCell2 = newRow.createCell(column + 2);
                newCell2.setCellValue(j);
                Cell newCell3 = newRow.createCell(column + 3);
                newCell3.setCellValue("=");
                Cell newCell4 = newRow.createCell(column + 4);
                newCell4.setCellValue(i * j);

                column=column+6;
            }
        }

        FileOutputStream outputStream=new FileOutputStream("src/test/java/ApachePOI/resource/CarpimTablosu_Yatay.xlsx");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("İşlem tamamlandı.");
    }
}
