package com.uwindsor.alumniCarpool.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "seats")
public class Seat {
	@Id
	private String id;

	private String position; //Front, Back-1, Back-2.
	private Boolean reservation; //Whether it is already reserved by a passenger
	private User passenger;
	private Boolean rated;

	public Seat(String position, Boolean reservation, User passenger, Boolean rated) {
		this.position = position;
		this.reservation = reservation;
		this.passenger = passenger;
		this.rated = rated;
	}
}
