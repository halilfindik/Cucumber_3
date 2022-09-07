package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _10_Soru {
    public static void main(String[] args) throws IOException {
     /*  Soru 1:
     *  Çarpım tablosunu excele yazdırınız.
     *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
     *  sıfırdan excel oluşturarak.
     *  her bir onluktan sonra 1 satır ya da 1 sütun boşluk bırakarak alt alata
     */

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Sayfa1");

        int row=0;

        for (int i=1; i<11; i++) {
            for (int j=1; j<11; j++) {
                Row newRow=sheet.createRow(row+i);
                Cell newCell0 = newRow.createCell(0);
                newCell0.setCellValue(i);
                Cell newCell1 = newRow.createCell(1);
                newCell1.setCellValue("*");
                Cell newCell2 = newRow.createCell(2);
                newCell2.setCellValue(j);
                Cell newCell3 = newRow.createCell(3);
                newCell3.setCellValue("=");
                Cell newCell4 = newRow.createCell(4);
                newCell4.setCellValue(i*j);
                row++;
            }
        }

        FileOutputStream outputStream=new FileOutputStream("src/test/java/ApachePOI/resource/CarpimTablosu.xlsx");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("İşlem tamamlandı.");
    }
}
