package Package_TestngScripts;

import static org.testng.Assert.fail;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.objectRepository.HomeLocatorsPage;
import com.crm.objectRepository.ValidateCampaignPage;
@Listeners(com.crm.genericUtility.ListenerImpClass.class)
public class CampaignTestNG extends BaseClass{

	@Test(groups = {"smoke"})
	public void campaignTest() throws Throwable {
		//ExcelUtility eu = new ExcelUtility();
		String Campaigns = eU.readDatafromExcel("Campaign", 0, 0);
		System.out.println(Campaigns);
		HomeLocatorsPage hlp = new HomeLocatorsPage(cd);
		hlp.morehover(cd);
		hlp.campaignsClick();
		fail();
		ValidateCampaignPage vcp= new ValidateCampaignPage(cd);
		String text = vcp.CampaignAction(Campaigns);
		System.out.println(text);
		//hlp.HomeActionsLogout(cd);
	}
}
