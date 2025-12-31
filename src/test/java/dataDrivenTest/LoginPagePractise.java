package dataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPagePractise extends BaseTest{
	
	LandingPage landing;
	@Test(dataProvider= "getDataFromExcel")
	public void purchaseOrder(String URL, String userName, String password) throws IOException, InterruptedException
	{
		
		landing = new LandingPage(driver);
		landing.goToURL(URL);
		productsList prodList = landing.login(userName,password);
		Checkout check = prodList.addProductToCart();
		FinalPage finalPage = check.checkProds();
		finalPage.destination();
		finalPage.purchase();
		
		
		
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws IOException

	{
		
		DataFormatter format = new DataFormatter();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Sayali\\OneDrive\\Desktop\\Sourabh_Automation\\ExcelSheets\\Excel1.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Object[][] data = null;
		
		
		for(int i=0; i<workbook.getNumberOfSheets();i++)
		{
			
			if(workbook.getSheetName(i).equalsIgnoreCase("sheet2"))
			{
				
 				XSSFSheet sheet = workbook.getSheetAt(i);
 				
 				int rowCount = sheet.getPhysicalNumberOfRows();
 				int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
 				data = new Object[rowCount-1][cellCount];
				
				for(int j=0;j<rowCount-1;j++)
				{
					
					 XSSFRow row = sheet.getRow(j+1);
					
					 
					 for(int k=0; k<cellCount;k++)
					 {
						 
						  XSSFCell cell =  row.getCell(k);	
						  data[j][k] = format.formatCellValue(cell);
						 
						 
					 }
												 
					
					
				}
 				
				
				
				
				
			}
			
			
		}
	
		return data;
		
	}

}
