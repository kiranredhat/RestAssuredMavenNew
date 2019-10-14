package api.common;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethod {
	public static XmlPath rowToXmlPath(Response s)
	{
		String responseString=s.asString();
		XmlPath x = new XmlPath(responseString);
		return x;
	}
	
	public static JsonPath rowToJsonPath(Response s)
	{
		String responseString=s.asString();
		JsonPath j = new JsonPath(responseString);
		return j;
	}
	
}
