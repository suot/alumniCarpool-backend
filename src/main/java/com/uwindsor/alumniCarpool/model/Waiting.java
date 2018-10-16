package com.uwindsor.alumniCarpool.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Data
@Document(collection = "waitings")
public class Waiting {
	@Id
	private String id;
	private User passenger;

	private String departureCity;
	private String departureLocation;

	private String arrivalCity;
	private String arrivalLocation;

	private String departureDate;
	private String departureTime;

	private Boolean valid; //remove -> invalid
	private Date creatingTime; // Generated automatically by db system.

	public Waiting(User passenger, String departureCity, String departureLocation, String arrivalCity, String arrivalLocation, String departureDate, String departureTime, Boolean valid) {
		this.passenger = passenger;
		this.departureCity = departureCity;
		this.departureLocation = departureLocation;
		this.arrivalCity = arrivalCity;
		this.arrivalLocation = arrivalLocation;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.valid = valid;
	}
}
