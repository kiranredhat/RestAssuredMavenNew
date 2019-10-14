package api.page;
import io.restassured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher.*;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.assertion.BodyMatcher;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;


public class AddLocationXML {
@Test
public void postrequest() throws IOException
{
	RestAssured.baseURI="http://216.10.245.166";
	String postdata= GenerateStringFromResource("F:\\Selenium\\RestAssured\\xmlpayload.xml");
	Response res=given().
	param("key","qaclick123").
	body(postdata).
	when().
	get("/maps/api/place/add/xml").
	then().
	log().body().
	statusCode(200).
	contentType(ContentType.XML).
	body("response.status",equalTo("OK")).		
	extract().response();
	XmlPath x= api.common.ReusableMethod.rowToXmlPath(res);
	String responseParameter=x.getString("response.status");
	System.out.println(responseParameter);
}

public static String GenerateStringFromResource(String path) throws IOException
{
	return new String(Files.readAllBytes(Paths.get(path)));
}
}
