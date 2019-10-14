package api.page;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import api.common.Resources;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.*;

public class DeletePlace {
	Properties prop= new Properties();
	
	@BeforeMethod
	public void postHost() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\RestAssuredJava\\src\\Files\\env.properties");
		prop.load(fis);
	}
	
	@Test
	public void deleteRequest()
	{
		
		RestAssured.baseURI=prop.getProperty("HOST");
		
		
		
		Response res = given().
		param("key",prop.getProperty("KEY")).
		body(api.common.Payloads.AddPlacePayload()).
		when().
		get(api.common.Resources.getResourcesAddPlace()).
		then().
		//log().body().
		statusCode(200).
		contentType(ContentType.JSON).
		body("status",equalTo("OK")).	
		extract().response();
		String responseString=res.asString();
		JsonPath js = new JsonPath(responseString);
		String placeid= js.get("place_id");
		System.out.println("Your Place id is: " +placeid);
		

		//Delete Add Place
		String d= "\"place_id\":\""+placeid+"\"";
				
		Response res1 = given().
				param("key",prop.get("KEY")).
				body(d).
				when().
				get(Resources.getResourcesDeletePlace()).
				then().
				log().body().
				statusCode(200).
				contentType(ContentType.JSON).
				body("status",equalTo("OK")).	
				extract().response();		
		
	}

}
