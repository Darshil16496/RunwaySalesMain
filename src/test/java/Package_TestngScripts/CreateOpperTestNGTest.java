package Package_TestngScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.objectRepository.HomeLocatorsPage;
import com.crm.objectRepository.OppertunityLocatorsPage;

public class CreateOpperTestNGTest extends BaseClass {

	@Test(retryAnalyzer = com.crm.genericUtility.RetImpClass.class)
	public void opportunityTest() throws IOException, Throwable {
		String potentialName = eU.readDatafromExcel("opportunity", 0, 0)+jU.getRandomNum();
		
		HomeLocatorsPage hlp = new HomeLocatorsPage(cd);
		hlp.opportunitiesClick();
		
		OppertunityLocatorsPage olp = new OppertunityLocatorsPage(cd);
		olp.createOpportunity();
		
		olp.createOpperunity(potentialName,cd);
		
		String text = olp.validateOppertunity(potentialName);
		System.out.println(text);
	}
}
