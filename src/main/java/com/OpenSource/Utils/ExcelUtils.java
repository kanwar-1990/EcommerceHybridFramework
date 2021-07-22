
package com.OpenSource.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	private static Workbook book;
	private static Sheet sheet;

	// . is upto the project and is necessary to add
	public static String TEST_DATA_SHEET_PATH = "./src/main/java/com/OpenSource/TestData/OpenSourceTestData.xlsx";

	public static Object[][] getTestData(String sheetName) {

		Object data[][] = null; // Since the scope of the code was in try only so had to create object on a
								// method level

		try {
			// fileinput stream will connect with the excel sheet
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);

			book = WorkbookFactory.create(ip); // inside the java memory it will create exact replica of excel sheet

			sheet = book.getSheet(sheetName);// after reaching the workbook we are entering inside the sheet

			// to store the data since its in row and column , we can create an object

			// Array is created-- in the Excel sheet with the sheet reference we can first
			// take up the last colum
			// from sheet get the last row number for column, and for row take from the
			// zerot row till the last cell number , Since in any excel sheet column are
			// allways static

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			// to iterate now
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}
