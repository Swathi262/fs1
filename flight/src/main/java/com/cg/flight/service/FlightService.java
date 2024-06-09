package com.cg.flight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.flight.entity.Flight;
import com.cg.flight.exception.FlightNotFoundException;


public interface FlightService {
	
	Flight addFlight(Flight flight);
	
	String deleteFlight(int flightId) throws FlightNotFoundException;
	
	List<Flight> viewAllFlight();
	
	List<Flight> searchFlight(String source,String destination) throws FlightNotFoundException;
	
	Flight updateFlight(int flightId,List<String> seatNumbers) throws FlightNotFoundException;
	
	List<Flight> viewFlightsByFlightName(String flightName) throws FlightNotFoundException;

	Flight viewFlightsByFlightId(int flightId) throws FlightNotFoundException;
	
	List<String> getSeatNumbers(int flightId) throws FlightNotFoundException;

	Integer getSeats(int flightId) throws FlightNotFoundException;

	Flight restoreSeats(int flightId,List<String> seatNumbers) throws FlightNotFoundException;

}
