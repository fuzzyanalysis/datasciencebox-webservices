package com.datasciencebox.rs.webservices;

import java.io.File;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/rest")
public class DSBResources {
	
	@Path("/test")
	@GET()
	@Produces("text/html")
	public String test(){
		return "<html><body>The web services work.</body></html>";
	}
	
	@Path("/geolocation/{ip}")
	@GET()
	@Produces("application/json")
	public String getGeolocation(@PathParam("ip") final String ip) {
	    
		// get Server location		
		String currentDir = new File(".").getAbsolutePath();
		System.out.println(currentDir);
				
		try {

			ExternalWebClient wc = new ExternalWebClient("", "");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return "";
		
	}
	
}
