package airlines;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import airlines.pojos.Airline;

public class AirlineSample {
	
	@Test
	public void sample() throws JsonProcessingException {
		Airline payLoad = new Airline().toBuilder().name("khaja").build();
		ObjectMapper objectMapper = new ObjectMapper();
		String valueAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payLoad);
		System.out.println(valueAsString);
		Airline airline = new Airline();
		System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(airline));
		Airline createAirlinePayloadFromPojo = Payloads.getCreateAirlinePayloadFromPojo();
		System.out.println(createAirlinePayloadFromPojo);
	}

}
