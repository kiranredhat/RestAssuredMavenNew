package api.common;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class HashMapToJson {
	
	public void HashmapToJson()
	{
		Map<String, Object> data = new HashMap<String, Object>();
	    data.put( "name", "Mars" );
	    data.put( "age", 32 );
	    data.put( "city", "NY" );
	    Response res=given().
	    		body(data).
	    		
	    		when().
	    		post("/Library/Addbook.php").
	    		
	    		then().
	    		log().all().
	    		assertThat().statusCode(200).
	    		extract().response();
	    
	    
	    
//	    JSONObject json = new JSONObject();
//	    json.putAll( data );
//	    System.out.printf( "JSON: %s", json.toString(2) );
	}

}
