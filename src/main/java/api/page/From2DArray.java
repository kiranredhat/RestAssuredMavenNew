package api.page;
import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.common.BaseSelenium;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class From2DArray extends BaseSelenium {
	@Test(dataProvider="getDatafromArray")
	public void getData(String isbn, String aisle) 
	{
		RestAssured.baseURI="http://216.10.245.166";
		Response res=given().
		body(api.common.Payloads.AddBook(isbn, aisle)).		
		when().
		get("/Library/Addbook.php").
		
		then().
		log().body().
		assertThat().statusCode(200).
		extract().response();
//		JsonPath js =ReusableMethod.rowToJsonPath(res);
//		String str=js.get("ID");
//		System.out.println(str);
	}
}
