package com.uwindsor.alumniCarpool.model;

import lombok.Data;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "seats")
public class Seat {
	@Id
	private String id;

	private String position; //Front, Back-1, Back-2.
	private Boolean reserved; //Whether it is already reserved by a passenger
	private User passenger;
	private float rating;

	public Seat(){

	}

	public Seat(String position, Boolean reserved, User passenger, float rating) {
		this.position = position;
		this.reserved = reserved;
		this.passenger = passenger;
		this.rating = rating;
	}
}
