package week5.day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelGetData {

	public static String[][] getData (String filename, String sheetNum) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
HSSFWorkbook wb=new HSSFWorkbook(new FileInputStream("./data/"+filename+".xlsx"));
HSSFSheet ws = wb.getSheet(sheetNum);
int rowsCount = ws.getLastRowNum();
int colsCount = ws.getRow(0).getLastCellNum();
String[][] data = new String[rowsCount][colsCount];

for (int i = 1; i <=rowsCount; i++) {
	for (int j = 0; j < colsCount; j++) {
String cellVal = ws.getRow(i).getCell(j).getStringCellValue();
	data[i-1][j]=cellVal;
	
	
	}
}
wb.close();
return data;



	}

}
