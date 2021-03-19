//Encode decode JSON data.
//https://www.tutorialspoint.com/json_simple/
//jar: json-simple-1.1 There is also 2.2 version
package gr.hua.dit.oopii.lec5.streams;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JsonSimple {

	public static void json2Object() {
	    
	    String jsonAthens="{\n"
	    		+ "    \"coord\": {\n"
	    		+ "        \"lon\": 23.7162,\n"
	    		+ "        \"lat\": 37.9795\n"
	    		+ "    },\n"
	    		+ "    \"weather\": [\n"
	    		+ "        {\n"
	    		+ "            \"id\": 803,\n"
	    		+ "            \"main\": \"Clouds\",\n"
	    		+ "            \"description\": \"broken clouds\",\n"
	    		+ "            \"icon\": \"04n\"\n"
	    		+ "        }\n"
	    		+ "    ],\n"
	    		+ "    \"base\": \"stations\",\n"
	    		+ "    \"main\": {\n"
	    		+ "        \"temp\": 284.26,\n"
	    		+ "        \"feels_like\": 280.99,\n"
	    		+ "        \"temp_min\": 283.15,\n"
	    		+ "        \"temp_max\": 285.15,\n"
	    		+ "        \"pressure\": 1012,\n"
	    		+ "        \"humidity\": 54\n"
	    		+ "    },\n"
	    		+ "    \"visibility\": 10000,\n"
	    		+ "    \"wind\": {\n"
	    		+ "        \"speed\": 2.32,\n"
	    		+ "        \"deg\": 222,\n"
	    		+ "        \"gust\": 3.5\n"
	    		+ "    },\n"
	    		+ "    \"clouds\": {\n"
	    		+ "        \"all\": 75\n"
	    		+ "    },\n"
	    		+ "    \"dt\": 1616106000,\n"
	    		+ "    \"sys\": {\n"
	    		+ "        \"type\": 1,\n"
	    		+ "        \"id\": 6613,\n"
	    		+ "        \"country\": \"GR\",\n"
	    		+ "        \"sunrise\": 1616128215,\n"
	    		+ "        \"sunset\": 1616171733\n"
	    		+ "    },\n"
	    		+ "    \"timezone\": 7200,\n"
	    		+ "    \"id\": 264371,\n"
	    		+ "    \"name\": \"Athens\",\n"
	    		+ "    \"cod\": 200\n"
	    		+ "}";

	    JSONObject json_object = (JSONObject) JSONValue.parse(jsonAthens);

	    @SuppressWarnings("unchecked")
	    Set<String> keySet = json_object.keySet();
	    for (String key : keySet) {
	        Object value = json_object.get(key);
	        System.out.printf("%s=%s (%s)\n", key, value, value.getClass()
	                .getSimpleName());
	    }
	    
	    System.out.println("\n\nElement name: "+json_object.get("coord"));	//Output element 
	    JSONObject json_object2 = (JSONObject) json_object.get("coord");
	    System.out.println("Latitude: "+json_object2.get("lat"));			//Output inner element 
	    System.out.println("Longitude: "+json_object2.get("lon"));
	    
	    
	}
	
	public static void main(String[] args)  {
		
		json2Object();
	}
	
	
}
