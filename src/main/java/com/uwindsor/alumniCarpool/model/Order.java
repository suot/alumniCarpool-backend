package com.uwindsor.alumniCarpool.model;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "orders")
public class Order {
	@Id
	private String id;

	private Car car;
	private String status;

	private Location departure;
	private Location arrival;
	private Date departureTime;

	private Date orderTime; //The insertion time generated in db automatically

	public Order(Car car, String status, Location departure, Location arrival, Date departureTime) {
		this.car = car;
		this.status = status;
		this.departure = departure;
		this.arrival = arrival;
		this.departureTime = departureTime;
	}
}
