package package_practice;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class CreateProjectTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		Row r = sh.createRow(2);
		Cell cell=r.createCell(0);
		cell.setCellValue("Darshil");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Book1.xlsx");
		wb.write(fos);
		fos.flush();
		wb.close();
		System.out.println("done");
//		
		
//		DataFormatter df=new DataFormatter();
//		
//		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
//		Workbook wb1=WorkbookFactory.create(fis1);
//		Sheet sh1=wb1.getSheet("Common");
//		int lastrow = sh1.getLastRowNum();
//		for(int i = 0;i<= lastrow;i++) {
//			short lastcell=sh1.getRow(i).getLastCellNum();
//			for(int j = 0;j<lastcell;j++) {
////				Cell value=sh1.getRow(i).getCell(j);
//			String tdname = df.formatCellValue(sh1.getRow(i).getCell(j));
//				System.out.print(tdname+" ");
//				
//			}
//			System.out.println();
//		}
	}

}
