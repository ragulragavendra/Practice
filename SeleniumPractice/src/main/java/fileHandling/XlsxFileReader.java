package fileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class XlsxFileReader {

	public static void main(String[] args) throws IOException {

		FileInputStream fileInput = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\data.xlsx"));
		
		Workbook workbook = WorkbookFactory.create(fileInput);
		
		Sheet sheet = workbook.getSheet("MySheet");
		
//		To get particular cell value
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(cell.getStringCellValue());
		
//		To print all cell value
		for(Row r:sheet ) {
			for(Cell c:r) {
				DataFormatter formatter = new DataFormatter();
				System.out.println(formatter.formatCellValue(c));
			}
		}
		
		 workbook.close();
	}

}
