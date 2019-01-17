package fr.insa.soa.ProjectRoomINSA;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	private final String USER_AGENT = " Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36";

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
  
   
    public String getContainer(String cnf, String con) {
    	
    	String response = "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">"
    			+ "<cnf>"
    			+ cnf
    			+ "</cnf>"
    			+ "<con>"
    			+ con
    			+ "</con>"
    			+ "</m2m:cin>";
    	 	
    	return response;
    }
    
    @GET
    @Path("luminosity")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLuminosity() throws IOException{
    	
    	String url = "http://localhost:8080/~/mn-cse/mn-name/AE_Room1/Luminosity/la";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		con.setRequestProperty("Host", "localhost:8080");
		con.setRequestProperty("Connection", "keep-alive");
		con.setRequestProperty("Content-Length", "0");
		
		con.setRequestProperty("Accept", "application/xml, text/xml, */*; q=0.01");
		con.setRequestProperty("Origin", "http://localhost:8080");
		con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		con.setRequestProperty("User-Agent", USER_AGENT);		
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Referer", "http://localhost:8080/webpage/welcome/index.html?context=/~&cseId=in-cse");
		con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		con.setRequestProperty("Accept-Language", "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
		

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
    	
		return response.toString();
    }
    
    @POST
    @Path("lamp/{state}")
    @Consumes(MediaType.TEXT_XML)
    public void setLamp(@PathParam("state") String state) throws Exception {
    	
    	String url = "http://localhost:8080/~/mn-cse/mn-name/AE_Room1/Lamp";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Host", "localhost:8080");
		con.setRequestProperty("Connection", "keep-alive");		
		con.setRequestProperty("Accept", "application/xml, text/xml, */*; q=0.01");
		con.setRequestProperty("Content-Type", "text/xml;ty=4");
		con.setRequestProperty("Origin", "http://localhost:8080");
		con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		con.setRequestProperty("User-Agent", USER_AGENT);		
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Referer", "http://localhost:8080/webpage/welcome/index.html?context=/~&cseId=in-cse");
		con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		con.setRequestProperty("Accept-Language", "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
		
		String urlParameters = getContainer("state",state);
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());

    	
    	
    }
    
    @GET
    @Path("lamp")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLamp() throws IOException{
    	
    	String url = "http://localhost:8080/~/mn-cse/mn-name/AE_Room1/Lamp/la";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		con.setRequestProperty("Host", "localhost:8080");
		con.setRequestProperty("Connection", "keep-alive");
		con.setRequestProperty("Content-Length", "0");	
		con.setRequestProperty("Accept", "application/xml, text/xml, */*; q=0.01");
		con.setRequestProperty("Origin", "http://localhost:8080");
		con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		con.setRequestProperty("User-Agent", USER_AGENT);		
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Referer", "http://localhost:8080/webpage/welcome/index.html?context=/~&cseId=in-cse");
		con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		con.setRequestProperty("Accept-Language", "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
		

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
    	
		return response.toString();
    }
    
    @GET
    @Path("temperature")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTemperature() throws IOException{
    	
    	String url = "http://localhost:8080/~/mn-cse/mn-name/AE_Room1/Temperature/la";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		con.setRequestProperty("Host", "localhost:8080");
		con.setRequestProperty("Connection", "keep-alive");
		con.setRequestProperty("Content-Length", "0");	
		con.setRequestProperty("Accept", "application/xml, text/xml, */*; q=0.01");
		con.setRequestProperty("Origin", "http://localhost:8080");
		con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		con.setRequestProperty("User-Agent", USER_AGENT);		
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Referer", "http://localhost:8080/webpage/welcome/index.html?context=/~&cseId=in-cse");
		con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		con.setRequestProperty("Accept-Language", "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
		

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
    	
		return response.toString();
    }
    
    @POST
    @Path("temperature/{state}")
    @Consumes(MediaType.TEXT_XML)
    public void setTemperature(@PathParam("state") String state) throws Exception {
    	
    	String url = "http://localhost:8080/~/mn-cse/mn-name/AE_Room1/Temperature";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Host", "localhost:8080");
		con.setRequestProperty("Connection", "keep-alive");		
		con.setRequestProperty("Accept", "application/xml, text/xml, */*; q=0.01");
		con.setRequestProperty("Content-Type", "text/xml;ty=4");
		con.setRequestProperty("Origin", "http://localhost:8080");
		con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		con.setRequestProperty("User-Agent", USER_AGENT);		
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Referer", "http://localhost:8080/webpage/welcome/index.html?context=/~&cseId=in-cse");
		con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		con.setRequestProperty("Accept-Language", "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
		
		String urlParameters = getContainer("float",state);
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());

    }
      
    @POST
    @Path("luminosity/{state}")
    @Consumes(MediaType.TEXT_XML)
    public void setLuminosity(@PathParam("state") String state) throws Exception {
    	
    	String url = "http://localhost:8080/~/mn-cse/mn-name/AE_Room1/Luminosity";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Host", "localhost:8080");
		con.setRequestProperty("Connection", "keep-alive");		
		con.setRequestProperty("Accept", "application/xml, text/xml, */*; q=0.01");
		con.setRequestProperty("Content-Type", "text/xml;ty=4");
		con.setRequestProperty("Origin", "http://localhost:8080");
		con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		con.setRequestProperty("User-Agent", USER_AGENT);		
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Referer", "http://localhost:8080/webpage/welcome/index.html?context=/~&cseId=in-cse");
		con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		con.setRequestProperty("Accept-Language", "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
		
		String urlParameters = getContainer("float",state);
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());

    }
    
    @GET
    @Path("heater")
    @Produces(MediaType.APPLICATION_JSON)
    public String getheater() throws IOException{
    	
    	String url = "http://localhost:8080/~/mn-cse/mn-name/AE_Room1/Heater/la";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		con.setRequestProperty("Host", "localhost:8080");
		con.setRequestProperty("Connection", "keep-alive");
		con.setRequestProperty("Content-Length", "0");	
		con.setRequestProperty("Accept", "application/xml, text/xml, */*; q=0.01");
		con.setRequestProperty("Origin", "http://localhost:8080");
		con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		con.setRequestProperty("User-Agent", USER_AGENT);		
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Referer", "http://localhost:8080/webpage/welcome/index.html?context=/~&cseId=in-cse");
		con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		con.setRequestProperty("Accept-Language", "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
		

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
    	
		return response.toString();
    }
    
    @POST
    @Path("heater/{state}")
    @Consumes(MediaType.TEXT_XML)
    public void setheater(@PathParam("state") String state) throws Exception {
    	
    	String url = "http://localhost:8080/~/mn-cse/mn-name/AE_Room1/Heater";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Host", "localhost:8080");
		con.setRequestProperty("Connection", "keep-alive");		
		con.setRequestProperty("Accept", "application/xml, text/xml, */*; q=0.01");
		con.setRequestProperty("Content-Type", "text/xml;ty=4");
		con.setRequestProperty("Origin", "http://localhost:8080");
		con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		con.setRequestProperty("User-Agent", USER_AGENT);		
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Referer", "http://localhost:8080/webpage/welcome/index.html?context=/~&cseId=in-cse");
		con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		con.setRequestProperty("Accept-Language", "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
		
		String urlParameters = getContainer("state",state);
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());

    }
    
    @GET
    @Path("window")
    @Produces(MediaType.APPLICATION_JSON)
    public String getWindow() throws IOException{
    	
    	String url = "http://localhost:8080/~/mn-cse/mn-name/AE_Room1/Window/la";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		con.setRequestProperty("Host", "localhost:8080");
		con.setRequestProperty("Connection", "keep-alive");
		con.setRequestProperty("Content-Length", "0");	
		con.setRequestProperty("Accept", "application/xml, text/xml, */*; q=0.01");
		con.setRequestProperty("Origin", "http://localhost:8080");
		con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		con.setRequestProperty("User-Agent", USER_AGENT);		
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Referer", "http://localhost:8080/webpage/welcome/index.html?context=/~&cseId=in-cse");
		con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		con.setRequestProperty("Accept-Language", "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
		

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
    	
		return response.toString();
    }
    
    @POST
    @Path("window/{state}")
    @Consumes(MediaType.TEXT_XML)
    public void setWindow(@PathParam("state") String state) throws Exception {
    	
    	String url = "http://localhost:8080/~/mn-cse/mn-name/AE_Room1/Window";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Host", "localhost:8080");
		con.setRequestProperty("Connection", "keep-alive");		
		con.setRequestProperty("Accept", "application/xml, text/xml, */*; q=0.01");
		con.setRequestProperty("Content-Type", "text/xml;ty=4");
		con.setRequestProperty("Origin", "http://localhost:8080");
		con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		con.setRequestProperty("User-Agent", USER_AGENT);		
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Referer", "http://localhost:8080/webpage/welcome/index.html?context=/~&cseId=in-cse");
		con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		con.setRequestProperty("Accept-Language", "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
		
		String urlParameters = getContainer("state",state);
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());

    }
    
    @GET
    @Path("presence")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPresence() throws IOException{
    	
    	String url = "http://localhost:8080/~/mn-cse/mn-name/AE_Room1/Presence/la";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		con.setRequestProperty("Host", "localhost:8080");
		con.setRequestProperty("Connection", "keep-alive");
		con.setRequestProperty("Content-Length", "0");	
		con.setRequestProperty("Accept", "application/xml, text/xml, */*; q=0.01");
		con.setRequestProperty("Origin", "http://localhost:8080");
		con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		con.setRequestProperty("User-Agent", USER_AGENT);		
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Referer", "http://localhost:8080/webpage/welcome/index.html?context=/~&cseId=in-cse");
		con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		con.setRequestProperty("Accept-Language", "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
		

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
    	
		return response.toString();
    }
    
    @POST
    @Path("presence/{state}")
    @Consumes(MediaType.TEXT_XML)
    public void setPresence(@PathParam("state") String state) throws Exception {
    	
    	String url = "http://localhost:8080/~/mn-cse/mn-name/AE_Room1/Presence";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Host", "localhost:8080");
		con.setRequestProperty("Connection", "keep-alive");		
		con.setRequestProperty("Accept", "application/xml, text/xml, */*; q=0.01");
		con.setRequestProperty("Content-Type", "text/xml;ty=4");
		con.setRequestProperty("Origin", "http://localhost:8080");
		con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		con.setRequestProperty("User-Agent", USER_AGENT);		
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Referer", "http://localhost:8080/webpage/welcome/index.html?context=/~&cseId=in-cse");
		con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		con.setRequestProperty("Accept-Language", "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
		
		String urlParameters = getContainer("state",state);
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());

    }
    
    
}
