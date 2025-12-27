package dataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class dataDriven {

	@Test
	public List<String> getDataFromExcel1(String testCaseName) throws IOException {

		List<String> al = new ArrayList<>();

		FileInputStream fis = new FileInputStream(
				"C:/Users/Sayali/OneDrive/Desktop/Sourabh_Automation/ExcelSheets/Excel1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		int sheets = wb.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {

			if (wb.getSheetName(i).equalsIgnoreCase("sheet1")) {

				XSSFSheet sheet = wb.getSheetAt(i);

				Iterator<Row> rows = sheet.rowIterator();

				while (rows.hasNext()) {

					Row row = rows.next();

					if (row.getCell(0).getStringCellValue().equalsIgnoreCase("testcases")) {

						Iterator<Cell> cells = row.cellIterator();

						int k = 0;
						int column = 0;

						while (cells.hasNext()) {

							Cell cell = cells.next();

							if (cell.getStringCellValue().equalsIgnoreCase("testcases")) {

								column = k;
								while (rows.hasNext()) {

									Row r = rows.next();
									Cell rcell0 = r.getCell(column);
									if (rcell0.getStringCellValue().equalsIgnoreCase(testCaseName)) {

										Iterator<Cell> c = r.cellIterator();
										while (c.hasNext()) {

											Cell cl = c.next();
											if(cl.getCellType().equals(CellType.STRING))
											{
												
												String cellValue = cl.getStringCellValue();
												al.add(cellValue);	
												
												
											}
											
											else
											{
												
												 double cellNumericValue = cl.getNumericCellValue();
												 String cellValue = NumberToTextConverter.toText(cellNumericValue);
												 
												 al.add(cellValue);
												
											}
											
											
											
											
											
											
											

										}

									}

								}

							}

							k++;

						}

					}

				}

			}

		}

		return al;

	}

}
