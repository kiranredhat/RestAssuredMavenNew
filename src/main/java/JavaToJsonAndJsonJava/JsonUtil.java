package JavaToJsonAndJsonJava;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
public class JsonUtil
{
	private static ObjectMapper mapper;
static
{ 
	mapper =new ObjectMapper();	
}


public static String convertJavaToJson(Object object)
{
   String JsonResult="";
   try {
	JsonResult=mapper.writeValueAsString(object);
} catch (JsonGenerationException e) {
	// TODO Auto-generated catch block
	System.out.println("While converting java to json object");
	e.printStackTrace();
} catch (JsonMappingException e) {
	// TODO Auto-generated catch block
	System.out.println("While converting java to json object");
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	System.out.println("While converting java to json object");
	e.printStackTrace();
}
   return JsonResult;
}

public static <T> T convertJsonToJava (String jsonString,Class<T> cls){
	T result =null;
	try {
		result=mapper.readValue(jsonString, cls);
	} catch (JsonParseException e) {
		// TODO Auto-generated catch block
		System.out.println("While converting Json to Java object");
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		System.out.println("While converting Json to Java object");
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("While converting Json to Java object");
		e.printStackTrace();
	}
	return result;

}
}