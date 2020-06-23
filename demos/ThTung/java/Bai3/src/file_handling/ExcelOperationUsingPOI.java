package file_handling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperationUsingPOI {
	public static XSSFSheet getSheet() throws IOException {
		FileInputStream fis = null;
		XSSFSheet sh1 = null;
		try {
			File src = new File("D:\\test.xlsx");
			fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			sh1 = wb.getSheetAt(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			fis.close();
		}
		return sh1;
	}
}