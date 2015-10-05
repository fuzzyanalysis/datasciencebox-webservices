package com.datasciencebox.rs.webservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/***
 * This client object is created with the necessary client details for connecting 
 * to a web service and downloading its contents given a url string and query 
 * parameters.
 * 
 * @author donkey
 *
 */
public class ExternalWebClient {

	private URL url;
	private String query;
	
	/**
	 * Constructor
	 * 
	 * @param urlString
	 * @param query
	 */
	public ExternalWebClient(String urlString, String query){
		
		try {
			this.url = new URL(urlString);
			this.query = query;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	/**
	 * Method for retrieving web service content
	 * 
	 * @return
	 */
	public String getWebserviceValue(){
		
		try {

			// make the connection
			URLConnection urlc = this.url.openConnection();
			
			// use post mode
			urlc.setDoOutput(true);
			urlc.setAllowUserInteraction(false);
			
			// send query
			PrintStream ps = new PrintStream(urlc.getOutputStream());
			ps.print(query);;
			ps.close();
			
			//get result
			BufferedReader br = new BufferedReader(new InputStreamReader (urlc.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String l = null;
			while ((l = br.readLine()) != null){
				sb.append(l);
			}
			br.close();
			
			return sb.toString();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}
