package api.common;

import org.testng.annotations.DataProvider;

public class BaseSelenium {
	
	@DataProvider (name="getDatafromArray")
	public Object[][] getDataArray()
	{
		return new Object [][] {{"adfsdf","445"},{"afdds","334"},{"adfsd","366"}};
	}

}
