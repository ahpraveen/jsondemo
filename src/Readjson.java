import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * Classname: Readjson
 * Author: Praveen Anna Haridas
 * Date: 26/Aug/2016
 * 
 */

public class Readjson {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		int strstatus;
		String strJson;
		strstatus = 0;
		System.out.println("Enter State abbrevation");
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String strabbr = br.readLine().toUpperCase();
	
		
			
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://services.groupkt.com/state/get/USA/all");	
			strJson = target.request(MediaType.APPLICATION_JSON).get(String.class);
				
			JSONParser parser = new JSONParser();
			try {
			Object obj = parser.parse(strJson);
			JSONObject jsonObject = (JSONObject) obj;
		
			JSONObject myobj = (JSONObject) jsonObject.get("RestResponse");		
			
			JSONArray msg = (JSONArray) myobj.get("result");
			
			for(int i=0; i<msg.size();i++)
			{
				JSONObject getVal = (JSONObject) msg.get(i);
				
				if(getVal.get("abbr").equals(strabbr))
				{			
				System.out.println("The Larget city    :" + getVal.get("largest_city"));
				System.out.println("The capital        :" + getVal.get("capital"));
				strstatus = 1;
				break;
				}
			}	
			if(strstatus == 0)
			{
				System.out.println("Invalid input - state abbrevation");
			}
	
		} 
		catch (ParseException e) {			
			e.printStackTrace();
		}
		}catch (IOException e1) {			
			e1.printStackTrace();
		}		
	}	
}
