package package_practice_TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider = "data")
	
	public void getData(String Name, String From, String state) {
		System.out.println("StudName :- "+Name+" From :- "+From+" State :- "+state);
	}
	
	@DataProvider(name="data")
	public Object[][] data() {
		Object[][] obj = new Object[2][3];
		
		obj[0][0] = "Rupesh Singh";
		obj[0][1] = "Bharmpur";
		obj[0][2] = "Pakistan";
		
		obj[1][0] = "Kanhu Charan Gowda";
		obj[1][1] = "Bharmpur";
		obj[1][2] = "sbsdb";
		return obj;
	}
	
	@DataProvider(name = "data1")
	public Object[][] data1() {
		Object[][] obj1 = new Object[2][3];
		
		obj1[0][0] = "Rupesh Singh";
		obj1[0][1] = "Bharmpur";
		obj1[0][2] = "Pakistan";
		
		obj1[1][0] = "Kanhu Charan Gowda";
		obj1[1][1] = "Bharmpur";
		obj1[1][2] = "sbsdb";
		return obj1;
	}
}
