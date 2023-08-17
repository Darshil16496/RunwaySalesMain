package Package_TestngScripts;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.objectRepository.HomeLocatorsPage;
import com.crm.objectRepository.OppertunityLocatorsPage;

public class OpportunityTestNGTest extends BaseClass{
	@Test
	public void opportunityTest() throws Throwable {
		String oppertunity = eU.readDatafromExcel("opportunity", 1, 0);
		HomeLocatorsPage hlp = new HomeLocatorsPage(cd);
		hlp.opportunitiesClick();
		fail();
		OppertunityLocatorsPage olp = new OppertunityLocatorsPage(cd);
		String text = olp.oppertunityAction(oppertunity);
		System.out.println(text);
	}

}
