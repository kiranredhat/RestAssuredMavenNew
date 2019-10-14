package Extra;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference; 
/** * Java Program to convert JSON String to Map * * @author Javin Paul */
public class StringToHashMap { 
public static void main(String args[]) {
	
ObjectMapper mapper = new ObjectMapper();
try 
{ 
	File jsonFile = new File("map.json");
	Map<String, Object> mapObject = mapper.readValue(jsonFile, new TypeReference<Map<String, Object>>() { });
	System.out.println("name : " + mapObject.get("name"));
	System.out.println("city : " + mapObject.get("city")); 
	System.out.println("mobile : " + mapObject.get("mobile")); 
	System.out.print("friends : ");
	List<String> list = (List<String>) mapObject.get("friends");
	for (String name : list) 
		{ 
			System.out.print(name + " ");			
		} 
	} catch (JsonGenerationException e) { e.printStackTrace();
} catch (JsonMappingException e) { e.printStackTrace(); } 
catch (IOException e) { e.printStackTrace(); 
} 
} 
}

//Read more: https://javarevisited.blogspot.com/2017/04/how-to-convert-map-to-json-to-hashmap-in-java.html#ixzz5wPg2Krlg

