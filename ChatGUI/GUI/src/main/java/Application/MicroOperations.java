package Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MicroOperations {
	
	public void saveUserDetails(String username)
	{
		
		StringBuffer requestBody=new StringBuffer();
		
		requestBody.append("{\n");
		requestBody.append("\"userid\"");
		requestBody.append(":");
		requestBody.append(" \"" + "12" + "\"");
		requestBody.append(",");
		requestBody.append("\n");
		requestBody.append("\"username\"");
		requestBody.append(":");
		requestBody.append(" \"" +username+ "\"");
		requestBody.append("\n");
		requestBody.append("}");
		
		Client client = Client.create();
		String URL = "http://localhost:8249/api/userdetails/chat";
		String method = "POST";
		
		WebResource webResource = client.resource(URL);
		try
		{
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, requestBody.toString());
			String responseBody = response.getEntity(String.class);
			System.out.println("The response is ::::::::::::::::"+responseBody);
		}
		catch (Exception ex) {
			// TODO: handle exception
			System.out.println("error"+ex);
		}
		
		
		
	}
	
	
	public String getuserid(String username) throws IOException
	{
		System.out.println("*******Inside the Getuserid Method");
		String jsonOutput = null;
		
		HttpURLConnection conn = null;
		URL url = new URL("http://localhost:8249/api/users/"+username+"/"+"chat");
		
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/json");
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		StringBuffer sb = new StringBuffer();
		String output = "";
		JsonNode resultNode;
		
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}
		jsonOutput = sb.toString();
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			resultNode = mapper.readTree(jsonOutput);
			return resultNode.path("userid").asText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
		
	}

}
