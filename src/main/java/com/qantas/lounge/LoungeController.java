package com.qantas.lounge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qantas.lounge.model.HaulType;
import com.qantas.lounge.model.Lounge;
import com.qantas.lounge.model.LoungeAvailability;

@RestController
@RequestMapping("/api/lounge")
public class LoungeController {
	@RequestMapping(value = "/hauls/{airportcode}",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<HaulType> getHaulTypes(@PathVariable("airportcode") String code)
	{	
		List<HaulType> haulTypes= new ArrayList<HaulType>();
		HaulType haul=new HaulType();
		haul.setDescrption("Domestic lounge descrption");
		haul.setHaulType("Domestic");
		HaulType haul1=new HaulType();
		haul1.setDescrption("International lounge descrption");
		haul1.setHaulType("International");

		if(code !=null && !code.isEmpty())
		{
			if(code.equalsIgnoreCase("SYD"))
			{
				haulTypes.add(haul);
				haulTypes.add(haul1);
			}
			else if(code.equalsIgnoreCase("MEL"))
			{
				haulTypes.add(haul);
			}
		}
		return haulTypes;
    }
	
	@RequestMapping(value = "/{haultype}",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Lounge getLoungeDetails(@PathVariable("haultype") String code)
	{	
		Lounge lounge = new Lounge();
		if(code !=null && !code.isEmpty())
		{
			if (code.equalsIgnoreCase("Domestic") || code.equalsIgnoreCase("Dom"))
			{
				HaulType haul=new HaulType();
				haul.setDescrption("Domestic lounge descrption");
				haul.setHaulType("Domestic");
				lounge.setHaulType(haul);
				List<LoungeAvailability> loungeAvailabilities= new ArrayList<LoungeAvailability>();
				LoungeAvailability loungeavail = new LoungeAvailability();
				loungeavail.setFrom("10:00 AM");
				loungeavail.setTo("12:00 PM");
				loungeavail.setPrice("150");
				loungeavail.setGst("20");
				LoungeAvailability loungeavail1 = new LoungeAvailability();
				loungeavail1.setFrom("01:00 PM");
				loungeavail1.setTo("03:00 PM");
				loungeavail1.setPrice("170");
				loungeavail1.setGst("35");
				loungeAvailabilities.add(loungeavail);
				loungeAvailabilities.add(loungeavail1);
				lounge.setLoungeAvailability(loungeAvailabilities);
			}
			else if (code.equalsIgnoreCase("International") || code.equalsIgnoreCase("Int")){
				HaulType haul=new HaulType();
				haul.setDescrption("International lounge descrption");
				haul.setHaulType("International");
				lounge.setHaulType(haul);
				List<LoungeAvailability> loungeAvailabilities= new ArrayList<LoungeAvailability>();
				LoungeAvailability loungeavail = new LoungeAvailability();
				loungeavail.setFrom("10:00 AM");
				loungeavail.setTo("12:00 PM");
				loungeavail.setPrice("150");
				loungeavail.setGst("20");
				LoungeAvailability loungeavail1 = new LoungeAvailability();
				loungeavail1.setFrom("01:00 PM");
				loungeavail1.setTo("03:00 PM");
				loungeavail1.setPrice("170");
				loungeavail1.setGst("35");
				LoungeAvailability loungeavail2 = new LoungeAvailability();
				loungeavail2.setFrom("02:00 PM");
				loungeavail2.setTo("04:00 PM");
				loungeavail2.setPrice("180");
				loungeavail2.setGst("40");
				loungeAvailabilities.add(loungeavail);
				loungeAvailabilities.add(loungeavail1);
				loungeAvailabilities.add(loungeavail2);
				lounge.setLoungeAvailability(loungeAvailabilities);
			}
		}
		return lounge;
    }
}
