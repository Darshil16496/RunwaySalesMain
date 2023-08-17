package package_practice_TestNG;

import org.testng.annotations.Test;

public class FetchDataTest {
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "data")
	public void getDsata(String Name, String From,String state) {
		System.out.println("StudName :-"+Name+" From :-"+From+" State :- "+state);
	}
	
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "data1")
	public void getDsata1(String Name, String From,String state) {
		System.out.println("StudName :-"+Name+" From :-"+From+" State :- "+state);
	}
	
}
