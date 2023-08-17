package Package_TestngScripts;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.objectRepository.CampaignLocatorsPage;
import com.crm.objectRepository.HomeLocatorsPage;

@Listeners(com.crm.genericUtility.ListenerImpClass.class)
public class CreateCampaignMandatoryTest extends BaseClass{

	@Test
	public void campaignTestNG() throws Throwable, Throwable {
		String campaignName=eU.readDatafromExcel("Campaign", 0, 0)+jU.getRandomNum();
		HomeLocatorsPage hlp = new HomeLocatorsPage(cd);
		hlp.morehover(cd);
		hlp.campaignsClick();	
		CampaignLocatorsPage clp = new CampaignLocatorsPage(cd);
		clp.campaignAction(campaignName);
		fail();
		String text = clp.validateCompaign(campaignName);
		System.out.println(text);
		
	}
}
