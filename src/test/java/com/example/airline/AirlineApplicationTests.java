package com.example.airline;

import com.example.airline.dto.AirlineDTO;
import com.example.airline.dto.AirportDTO;
import com.example.airline.mapper.AirlineMapper;
import com.example.airline.mapper.AirportMapper;
import com.example.airline.models.Airline;
import com.example.airline.models.Airport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class AirlineApplicationTests {


	@Test
	void contextLoads() {
	}

	@Test
	void testAirlineDto() {
		AirlineMapper mapper = AirlineMapper.INSTANCE;

		Airline airline = new Airline();
		airline.setIdAirline(1L);
		airline.setName("Test Airline");
		airline.setCountryOfOrigin("Test Country");
		airline.setAirlineCode("CAX");


		// Converted values
		AirlineDTO airlineDTO = mapper.toAirlineDto(airline);
		Airline c_airline = mapper.fromAirlineDto(airlineDTO);

		Assertions.assertEquals(airline, c_airline);
		Assertions.assertEquals(airlineDTO, mapper.toAirlineDto(c_airline));
	}

	@Test
	void testAirportDto() {
		AirportMapper mapper = AirportMapper.INSTANCE;

		Airport airport = new Airport();
		airport.setIdAirport(1L);
		airport.setName("Test Airport");
		airport.setCity("Test City");
		airport.setCountry("Test Country");

		// Converted values
		AirportDTO airportDto = mapper.toAirportDto(airport);
		Airport c_airport = mapper.fromAirportDto(airportDto);

		Assertions.assertEquals(airport, c_airport);
		Assertions.assertEquals(airportDto, mapper.toAirportDto(c_airport));
	}

}
