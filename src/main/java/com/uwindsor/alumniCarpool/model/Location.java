package com.uwindsor.alumniCarpool.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "users")
public class Location {
	@Id
	private String id;
	private String city, position, postcode;

	public Location(String city, String position, String postcode) {
		this.city = city;
		this.position = position;
		this.postcode = postcode;
	}
}
