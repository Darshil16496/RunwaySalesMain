package package_practice_TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.genericUtility.ExcelUtility;

public class DataExcelTest {
		@Test(dataProvider = "dataProvider")
		public void fetchData(String details, String info) {
			System.out.println("Details----"+details+" Info---"+info);
		}
	
		
//		public Object[][] getDataFromExcelSheet() throws Throwable{
//			FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
//			Workbook book= WorkbookFactory.create(fis);
//			Sheet sh = book.getSheet("Details");
//			int lastRow = sh.getLastRowNum();
//			short lastCell = sh.getRow(0).getLastCellNum();
//			
//			Object[][] obj = new Object[lastRow+1][lastCell];
//			for (int i = 0; i <= lastRow; i++) {
//				
//				for (int j = 0; j < lastCell; j++) {
//						obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
//				}
//				
//			}
//			return obj;
//		}
		@DataProvider
		public Object[][] dataProvider() throws Throwable {
			ExcelUtility eu = new ExcelUtility();
			return eu.getDataFromExcelSheet("Details");
		}
		
}
