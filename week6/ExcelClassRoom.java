package week5.day1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelClassRoom {

	public static String[][] readData(String filename, String sheetName) throws IOException {
		// TODO Auto-generated method stub

		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream("./data/"+filename+".xlsx"));
		HSSFSheet ws = wb.getSheet(sheetName);
		int rowCount = ws.getLastRowNum();
		int colCount = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				String text = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]=text;
			}

		}
		wb.close();
		return data;

	}

}
