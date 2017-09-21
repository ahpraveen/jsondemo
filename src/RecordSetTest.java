import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class RecordSetTest {

	public static void main (String s[]) 
	{
		String strJson;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://services.groupkt.com/state/get/USA/all");	
		strJson = target.request(MediaType.APPLICATION_JSON).get(String.class);
		
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(strJson);
				
		
			JSONArray jsonarray = (JSONArray)obj;

			for (int i=0; i<jsonarray.size(); i++) {

				JSONObject jsonObject= (JSONObject)jsonarray.get(i);
				String name = (String) jsonObject.get("name");
				System.out.println(name);
				long abbr = (Long) jsonObject.get("abbr");
				System.out.println(abbr);}				
			}
		
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}

