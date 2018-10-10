package com.uwindsor.alumniCarpool.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Getter
@Setter
@ToString
@Document(collection = "posts")
public class Post {
	@Id
	private String id;
	private User poster;
	private Location departure;
	private Location arrival;
	private Date departureTime;
	private Boolean valid;			//remove -> invalid

	private Date postTime;

	public Post(User poster, Location departure, Location arrival, Date departureTime, Boolean valid) {
		this.poster = poster;
		this.departure = departure;
		this.arrival = arrival;
		this.departureTime = departureTime;
		this.valid = valid;
	}
}
