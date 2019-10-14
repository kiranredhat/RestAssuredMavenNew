package api.page;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class Basic {
	@Test
	public void getresponse1()
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		Response res=given().
		param("location","-33.8670522,151.1957362").
		param("key","AIzaSyB8oea3pmmB3OvB3l21M_fyeQPYM4FxXKM").
		param("radius","1500").
		when().
		get("/maps/api/place/nearbysearch/json").
		
		then().
		log().all().
		assertThat().statusCode(200).
		contentType(ContentType.JSON).
//		body("results[0].geometry.location.lat", equalTo("-33.86882")).
//		header("server", "scaffolding on HTTPServer2").
		extract().response();
		JsonPath js=api.common.ReusableMethod.rowToJsonPath(res);
		int count =js.get("results.size()");
		for (int i=0; i<=count; i++)
		{
			String str=js.get("results["+i+"].name");
			System.out.println(str);
		}
		
	}

	
}
