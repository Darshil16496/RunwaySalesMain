package Package_TestngScripts;

import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.objectRepository.HomeLocatorsPage;
import com.crm.objectRepository.SalesLocatorsPage;

public class SearchSalesTestNGTest extends BaseClass{
	@Test(groups = "smoke")
	public void searchTest() throws Throwable, Throwable {
		HomeLocatorsPage hlp = new HomeLocatorsPage(cd);
		hlp.morehover(cd);
		hlp.salesOrderClick(cd);
		
		String SearchValue=eU.readDatafromExcel("SalesOrder", 0, 0);
		SalesLocatorsPage slp = new SalesLocatorsPage(cd);
		slp.salesOrderAction(SearchValue, "Organization Name", cd);
		
		System.out.println("Hello Your Script is Successfully Executed");
		
	}
}
