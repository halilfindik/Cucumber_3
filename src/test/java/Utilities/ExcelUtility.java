package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {
    // kendisine verilen path'deki excelin istenilen sheetindeki
    // verilen kolon kadar bilgisini okuyup ArrayList formatında geri döndüren fonksiyonu yazınız
    // getListData("src/test/java/ApachePOI/resources/ApacheExcel2.xlsx","testCitizen", 2); 0-2

    public static void main(String[] args) throws IOException {
        System.out.println(getExcelListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen", 4));
    }

    // TODO: kendisine verilen path, scenario, browserTipi, zaman parametreleri ile
    // TODO: yeni bir excele bütün raporu yazacak. dosyanın varlığını veya yokluğu kontrol etmeyi googdan bulunuz

    public static void writeToExcel(String path, Scenario scenario, String browserName, String time) {

        File file=new File(path);

        if (!file.exists()){  // ! olunca YOKSA
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sayfa1");
            Row newRow = sheet.createRow(0);

            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(scenario.getName());

            newCell = newRow.createCell(1);
            newCell.setCellValue(scenario.getStatus().toString());

            newCell = newRow.createCell(2);
            newCell.setCellValue(browserName);

            newCell = newRow.createCell(3);
            newCell.setCellValue(time);

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();  // hafıza boşaltıldı
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            FileInputStream inputStream= null; // okuma modunda açıldı
            Workbook workbook=null;
            try {
                inputStream = new FileInputStream(path);
                workbook= WorkbookFactory.create(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Sheet sheet=workbook.getSheetAt(0);

            int rowCount = sheet.getPhysicalNumberOfRows(); // 6 satır var  0-5
            Row newRow = sheet.createRow(rowCount); // en son satırın altına açıldı

            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(scenario.getName());

            newCell = newRow.createCell(1);
            newCell.setCellValue(scenario.getStatus().toString());

            newCell = newRow.createCell(2);
            newCell.setCellValue(browserName);

            newCell = newRow.createCell(3);
            newCell.setCellValue(time);

            try {
                inputStream.close();
                FileOutputStream outputStream=new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();  // hafıza boşaltıldı
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static List<List<String>> getExcelListData(String path, String sheetName, int cellCount) {
        List<List<String>> result = new ArrayList<>();

        Workbook workbook= null;
        try {
            FileInputStream inputStream=new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i=0; i<rowCount; i++) {
            Row row=sheet.getRow(i);
            List<String> rowData=new ArrayList<>();
            for (int j = 0; j < cellCount; j++) {
                rowData.add(row.getCell(j).toString());
            }
            result.add(rowData);
        }
        return result;
    }}
