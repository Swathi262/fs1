package com.cg.flight.entity;

import java.util.List;

public class FlightDto {

	private Integer flightId;
	private String flightName;
	private Integer seats=10;
	private String source;
	private String destination;
	private String date;
	private Double price;
	private String arrival;
	private String departure;
	private List<String> seatNumbers=List.of("A101","A102","A103","A104","A105","A106","A107","A108","A109","A110");

}

//DTOs(data transfer objects) are primarily used for transferring data, often between different layers or components of an application.
//For example, they can be used to transfer data from a database to a service layer,
//from a service layer to a presentation layer, 
//or between microservices in a distributed system.

//dto-a design pattern used in software development to encapsulate the data that needs 
//to be transferred between different components or layers of an application.