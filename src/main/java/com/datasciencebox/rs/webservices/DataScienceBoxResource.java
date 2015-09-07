package com.datasciencebox.rs.webservices;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

@Path("/dsbws")
public class DataScienceBoxResource {

	@Path("/test")
	@GET()
	@Produces("text/text")
	public String test(){
		return "The web services works.";
	}
	
	@Path("/geolocation/{ip}")
	@GET()
	@Produces("application/json")
	public Location getGeolocation(@PathParam("ip") final String ip) {
	    
		// get Server location
		
		String currentDir = new File(".").getAbsolutePath();
		System.out.println(currentDir);
		
		Location location = null;
		
		try {
			LookupService cl = new LookupService("GeoLiteCity.dat",
					LookupService.GEOIP_MEMORY_CACHE
							| LookupService.GEOIP_CHECK_CACHE);
			location = cl.getLocation(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return location;
		
	}
}
