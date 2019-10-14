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

/**
 * Java Program to convert Map to JSON String
 *
 * @author Javin Paul
 */

public class Testing { 

  public static void main(String args[]) { 

  ObjectMapper objectMapper = new ObjectMapper();

  Map<String, Object> mapObject = new HashMap<String, Object>();

  mapObject.put("name", "John");
  mapObject.put("city", "London");
  mapObject.put("mobile", 847339282);

  List<Object> friends = new ArrayList<Object>();

  friends.add("Rick");
  friends.add("Ron");
  friends.add("Victor");

  mapObject.put("friends", friends);

  try {
  objectMapper.writeValue(new File("map.json"), mapObject); 

  } catch (JsonGenerationException e) {
  e.printStackTrace();
  } catch (JsonMappingException e) {
  e.printStackTrace();
  } catch (IOException e) {
  e.printStackTrace();
  }

  }
}


//Read more: https://javarevisited.blogspot.com/2017/04/how-to-convert-map-to-json-to-hashmap-in-java.html#ixzz5xmsKXlDD