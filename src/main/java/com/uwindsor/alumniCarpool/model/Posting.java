package com.uwindsor.alumniCarpool.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "postings")
public class Posting {
	@Id
	private String id;
	private User passenger;

	private String departureCity;
	private String departureLocation;

	private String arrivalCity;
	private String arrivalLocation;

	private String departureDate;
	private String departureTime;

	private Date creatingTime; // Generated automatically by db system.

	public Posting(){

	}

	public Posting(User passenger, String departureCity, String departureLocation, String arrivalCity, String arrivalLocation, String departureDate, String departureTime) {
		this.passenger = passenger;
		this.departureCity = departureCity;
		this.departureLocation = departureLocation;
		this.arrivalCity = arrivalCity;
		this.arrivalLocation = arrivalLocation;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
	}
}
