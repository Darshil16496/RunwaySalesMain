package package_salesorder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.FileUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.WebDriverUtility;
import com.crm.objectRepository.HomeLocatorsPage;
import com.crm.objectRepository.LoginLocatorsPage;
import com.crm.objectRepository.SalesLocatorsPage;

public class SearchSalesOrderTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
//		Random r = new Random();
//		int num = r.nextInt(500);
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
//		Properties pobj=new Properties();
//		pobj.load(fis);
//		String url = pobj.getProperty("Url");
//		String browser = pobj.getProperty("Browser");
//		String username = pobj.getProperty("Username");
//		String password = pobj.getProperty("Password");
		FileUtility file = new FileUtility();
		ExcelUtility excel = new ExcelUtility();
		JavaUtility j = new JavaUtility();
		WebDriverUtility web = new WebDriverUtility();
		
		
		String url = file.getDataFromProperties("Url");
		String username = file.getDataFromProperties("Username");
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
		
		//Actions ac=new Actions(cd);
		//Click on More 
		//WebElement more = cd.findElement(By.xpath("//a[text()='More']"));
//		more.click();
		HomeLocatorsPage hlp = new HomeLocatorsPage(cd);
		hlp.morehover(cd);
		hlp.salesOrderClick(cd);
	
		//Click on Sales Order Link
		//cd.findElement(By.linkText("Sales Order")).click();
		
		//Fetching Data from Excel
//		FileInputStream fis2=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
//		Workbook wb=WorkbookFactory.create(fis2);
//		Sheet sh=wb.getSheet("SalesOrder");
//		
//		DataFormatter df=new DataFormatter();
//		String SearchValue = df.formatCellValue(sh.getRow(0).getCell(0));
		String SearchValue=excel.readDatafromExcel("SalesOrder", 0, 0);
		//System.out.println(tdname);
		
		SalesLocatorsPage slp = new SalesLocatorsPage(cd);
		slp.salesOrderAction(SearchValue, "Organization Name", cd);
		//slp.ValidateSalesOrder(cd, SearchValue);
		//Enter Organization name in Search TextBox
//		cd.findElement(By.name("search_text")).sendKeys(SearchValue);
//		WebElement SerchBy=cd.findElement(By.id("bas_searchfield"));
		//SerchBy.click();
//		Select s = new Select(SerchBy);
//		s.selectByVisibleText("Organization Name");
//		web.select("Organization Name", SerchBy);
//		
//		cd.findElement(By.xpath("//input[@value=' Search Now ']")).click();
		
		
		//logout From Application
//		WebElement logout = cd.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		ac.moveToElement(logout).perform();
//		
//		cd.findElement(By.linkText("Sign Out")).click();
		hlp.HomeActionsLogout(cd);
		
		cd.close();
	}

}
