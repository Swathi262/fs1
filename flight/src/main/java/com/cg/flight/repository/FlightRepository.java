package com.cg.flight.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.flight.entity.Flight;


public interface FlightRepository extends MongoRepository<Flight, Integer>{

	List<Flight> findByFlightName(String flightName);

}
