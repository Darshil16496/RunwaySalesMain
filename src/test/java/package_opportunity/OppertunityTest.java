package package_opportunity;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.FileUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.WebDriverUtility;
import com.crm.objectRepository.HomeLocatorsPage;
import com.crm.objectRepository.LoginLocatorsPage;
import com.crm.objectRepository.OppertunityLocatorsPage;

public class OppertunityTest {

	public static void main(String[] args) throws Throwable, IOException {
		// TODO Auto-generated method stub
		FileUtility file = new FileUtility();
		JavaUtility j = new JavaUtility();
		WebDriverUtility web= new WebDriverUtility();
		ExcelUtility excel = new ExcelUtility();
//		Random r = new Random();
//		int num = r.nextInt(500);
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
//		Properties pobj=new Properties();
//		pobj.load(fis);
//		String url = pobj.getProperty("Url");
//		String browser = pobj.getProperty("Browser");
//		String username = pobj.getProperty("Username");
//		String password = pobj.getProperty("Password");
		String url=file.getDataFromProperties("Url");
		String username=file.getDataFromProperties("Username");
		String password = file.getDataFromProperties("Password");
		
		//Launching Browser
		WebDriver cd = new ChromeDriver();	
		//cd.manage().window().maximize();
		web.maximizeWindow(cd);
		
		//cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		web.pageLoad(cd);

		cd.get(url);
//		cd.findElement(By.name("user_name")).sendKeys(username);
//		cd.findElement(By.name("user_password")).sendKeys(password);
//		cd.findElement(By.id("submitButton")).click();
		LoginLocatorsPage llp = new LoginLocatorsPage(cd);
		llp.loginAction(username, password);
		
//		FileInputStream fis2=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
//		Workbook wb=WorkbookFactory.create(fis2);
//		Sheet sh=wb.getSheet("opportunity");
//		
//		DataFormatter df=new DataFormatter();
//		String oppertunity = df.formatCellValue(sh.getRow(1).getCell(0));		
		
		String oppertunity = excel.readDatafromExcel("opportunity", 1, 0);
		//System.out.println(oppertunity);
//		cd.findElement(By.linkText("Opportunities")).click();
		HomeLocatorsPage hlp = new HomeLocatorsPage(cd);
		hlp.opportunitiesClick();
		
//		WebElement verifyOppertunity=cd.findElement(By.xpath("//a[@class='hdrLink']"));
//		String verify = verifyOppertunity.getText();
//
//		if(verify.equals(oppertunity)) {
//			System.out.println("Yes you navigated to the Campaigns Page");
//		}else {
//			System.out.println("No you didn't navigated to the Campaigns Page");
//		}
//		Thread.sleep(3000);
//		cd.close();
		
		OppertunityLocatorsPage olp = new OppertunityLocatorsPage(cd);
		String text = olp.oppertunityAction(oppertunity);
		System.out.println(text);
		
		hlp.HomeActionsLogout(cd);
		cd.close();
	}

}
