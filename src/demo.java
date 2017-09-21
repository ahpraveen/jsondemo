import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// client
		// target
		// response
		
		//String strStateabbr = "AL";
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://services.groupkt.com/state/get/USA/all");	
		System.out.println(target.request(MediaType.APPLICATION_JSON).get(String.class));		
	}

}
