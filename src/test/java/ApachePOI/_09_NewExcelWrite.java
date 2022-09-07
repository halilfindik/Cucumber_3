package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _09_NewExcelWrite {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Sayfa1");

        Row newRow=sheet.createRow(0); // satır oluşturuldu 0.yerde
        Cell newCell=newRow.createCell(0); // yeni satırda ilk hücre oluşturuldu
        newCell.setCellValue("Hello World"); // veri hafızaya yazıldı, excel'e henüz aktarılmadı

        for (int i=0; i<10; i++) {
            newRow.createCell(i).setCellValue(i*10);
        }

        String newExcelPath="src/test/java/ApachePOI/resource/NewExcel.xlsx";
        FileOutputStream outputStream=new FileOutputStream(newExcelPath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("İşlem tamamlandı.");


    }
}
