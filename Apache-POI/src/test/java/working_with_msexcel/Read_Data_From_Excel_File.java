package working_with_msexcel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//script to read data from excel file using apache poi classes
public class Read_Data_From_Excel_File {

	public static void main(String[] args) throws IOException {

		// Create a FileInputStream to read the excel file & specify the excel file path
		FileInputStream fis = new FileInputStream(".\\Test_Data\\LoginData.xlsx");

		// Create a workbook instance for the excel file
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Retrieve a specific sheet named "Sheet1" from the workbook.
		XSSFSheet s = wb.getSheet("Sheet1");

		// Get the Number of Rows and Columns
		int rows_count = s.getLastRowNum();
		System.out.println(rows_count);
		int columns_count = s.getRow(1).getLastCellNum();
		System.out.println(columns_count);

		// Iterate through rows and columns to read data
		for (int r = 1; r <= rows_count; r++) {
			XSSFRow row = s.getRow(r);
			for (int c = 0; c < columns_count; c++) {
				XSSFCell cell_value = row.getCell(c);
				switch (cell_value.getCellType()) {
				case STRING:
					System.out.print(cell_value.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell_value.getNumericCellValue());
					break;
				}
				System.out.print(" | ");
			}
			// adds a newline character to move to the next row.
			System.out.println();

		}
		// Close the workbook and input stream
		wb.close();
		fis.close();
	}

}
