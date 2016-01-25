package com.qantas.lounge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qantas.lounge.model.Airport;

@RestController
@RequestMapping("/api/airport")
public class AirportController{
	private class AirportWrapper{
		private List<Airport> airportList;

		public List<Airport> getAirportList() {
			return airportList;
		}

		public void setAirportList(List<Airport> airportList) {
			this.airportList = airportList;
		}
	}
	private AirportWrapper airportwrapper=null;
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public AirportWrapper findAllAirport()
	{	
		airportwrapper = new AirportWrapper();
		List<Airport> airports = new ArrayList<Airport>(); 
		airports.add(new Airport("SYD","Sydney"));
		airports.add(new Airport("MEL","Melbourne"));
		airports.add(new Airport("PER","Perth"));
		airports.add(new Airport("LON","London"));
		airports.add(new Airport("MAA","Chennai"));
		airports.add(new Airport("DEl","Delhi"));
		airportwrapper.setAirportList(airports);
		return airportwrapper;
    }
    @RequestMapping(value = "{code}",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Airport findByCode(@PathVariable("code") String code) {
    	Airport airportToBeRet=null;
    	if (code!=null && !code.isEmpty() && airportwrapper !=null && !airportwrapper.airportList.isEmpty())
    	{
    		for(Airport airport: airportwrapper.airportList)
    		{
    			if(airport!=null && airport.getCode().equalsIgnoreCase(code))
    			{
    				airportToBeRet = airport;
    			}
    		}
    	}
        return airportToBeRet;
    }
    
}
