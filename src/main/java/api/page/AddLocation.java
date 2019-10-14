package api.page;
import io.restassured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.assertion.BodyMatcher;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class AddLocation {
@Test
public void postrequest()
{
	RestAssured.baseURI="http://216.10.245.166";
	
	Response res=given().
	param("key","qaclick123").
	body("{"+
	    "\"location\":{"+
	        "\"lat\" : -38.383494,"+
	        "\"lng\" : 33.427362"+
	    "},"+
	    "\"accuracy\":50,"+
	    "\"name\":\"Frontline house\","+
	    "\"phone_number\":\"(+91) 983 893 3937\","+
	    "\"address\" : \"29, side layout, cohen 09\","+
	    "\"types\": [\"shoe park\",\"shop\"],"+
	    "\"website\" : \"http://google.com\","+
	    "\"language\" : \"French-IN\""+
	"}").
	when().
	get("/maps/api/place/add/json").
	then().
	log().body().
	statusCode(200).
	contentType(ContentType.JSON).
	body("status",equalTo("OK")).
	extract().response();
	JsonPath js=res.jsonPath();
	
	
}
}
