package fileHandling;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsxFileWritter {

	public static void main(String[] args) throws IOException {
		
		Workbook workbook = new XSSFWorkbook();
		
		Sheet sheet = workbook.createSheet("Sheet1");
		
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Hi");
		
		FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\output.xlsx");
        workbook.write(fileOut);
        
        workbook.close();
		

	}

}
