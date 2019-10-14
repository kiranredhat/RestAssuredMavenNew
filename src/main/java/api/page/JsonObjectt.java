package api.page;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class JsonObjectt {
	@Test
	public void show()
	{
		String a="{"+
			    "\"accuracy\":50,"+
			    "\"name\":\"Frontline house\","+
			    "\"phone_number\":\"(+91) 983 893 3937\","+
			    "\"address\" : \"29, side layout, cohen 09\","+
			    "\"types\": [\"shoe park\",\"shop\"],"+
			    "\"website\" : \"http://google.com\","+
			    "\"language\" : \"French-IN\""+
			"}";
		
		String b="{"+
			    "\"one\":50,"+
			    "\"two\":\"Frontline house\","+
			    "\"three\":\"(+91) 983 893 3937\","+
			    "\"four\" : \"29, side layout, cohen 09\","+
			    "\"five\": [\"shoe park\",\"shop\"],"+
			    "\"six\" : \"http://google.com\","+
			    "\"seven\" : \"French-IN\""+
			"}";
	
		
		Map<String, String> hmp= new LinkedHashMap<String, String>();
		hmp.put("Prajakta", "Saavi");
		hmp.put("kiran", "sandip");
		
		Map<String, String> hmp1= new LinkedHashMap<String, String>();
		hmp1.put("Prajakta", "Saavi");
		hmp1.put("kiran", "sandip");
		String[] hmp2= {"Prajakta","Saavi"};
		

	JSONObject js=new JSONObject(hmp);
	js.put("NewTest", hmp2);
	
	
	js.put("kiran_name", "kiran_value");
	System.out.println(js);
	
	
	
	}
}
