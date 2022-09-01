package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {
        
        // Dosya yolu alındı
        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        //String path="src\\test\\java\\ApachePOI\\resource\\ApacheExcel2.xlsx"; aynı şey

        // JAVA: Dosya okuma işlemcisine dosyanının yolunu veriyoruz,
        // böylece program ile dosya arasında bağlantıyı sağlıyor
        FileInputStream fileInputStream=new FileInputStream(path);

        // Dosya okuma işlemcisi üzerinden çalışma kitabını alıyorum
        // hafızada workbook'u alıp oluşturdu
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        // istediğim isimdeki çalışma sayfasını alıyorum
        Sheet sheet= workbook.getSheet("Sheet1");
        // Sheet sheet = workbook.getSheetAt(0);

        // istenen satırı alıyoruz
        Row row = sheet.getRow(0);

        // istenen satırdaki istenen hücre alnır
        Cell cell = row.getCell(0);

        System.out.println("cell = " + cell);
        

    }
}
