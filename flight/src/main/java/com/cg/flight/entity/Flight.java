package com.cg.flight.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // bundles the features of @ToString , @EqualsAndHashCode ,
//@Getter / @Setter and @RequiredArgsConstructor together
@AllArgsConstructor //generates a constructor that includes parameters 
@NoArgsConstructor
@ToString //creates readable string representation of an object.
@Document(collection = "flight")
public class Flight {

	@Id //specifies primary-key field for MongoDB documents
	private Integer flightId;
	private String flightName;
	private Integer seats=10;
	private String source;
	private String destination;
	private String date;
	private Double price;	
	private String departure;	
	private String arrival;	
	private List<String> seatNumbers=List.of("A101","A102","A103","A104","A105","A106","A107","A108","A109","A110");
	
}
