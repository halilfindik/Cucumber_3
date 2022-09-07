package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        // var olan bir EXCEL dosyasına yazma işlemi

        String path="src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream=new FileInputStream(path); // okuma modynda açlıldı
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Sheet1");

        // Hafıza'da oluşturma ve yazma işlemleri yapılıyor
        Row newRow=sheet.createRow(0); // satır oluşturuldu 0.yerde
        Cell newCell=newRow.createCell(0); // yeni satırda ilk hücre oluşturuldu
        newCell.setCellValue("Hello World"); // veri hafızaya yazıldı, excel'e henüz aktarılmadı

        for (int i=0; i<10; i++) {
            newRow.createCell(i).setCellValue(i*10);
        }
        // sıra kaydetmeye geldi, bütün bilgiler hafızada buraya kadar, herşey WORKBOOK'DA
        inputStream.close();

        // Yazma işlemini YAZMA modunda açıp öyle yapacağız
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("İşlem tamamlandı.");
    }
}
