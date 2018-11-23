package com.uwindsor.alumniCarpool.model;

import lombok.Data;
import org.bson.codecs.BinaryCodec;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "users")
public class User {
	@Id
	private String id;

	private String email;//Username
	private String password;
	private String firstName;
	private String lastName;
	private String gender;
	private String phone;
	private BinaryCodec avatar; //GridFS+

	private List<String> roles; //All roles user registered
	private String currentRole; //The role user logged in with.

	private String almaMater; //User's alma mater
	private String studentId;
	//private List<BinaryCodec> certificate; //Certificate of alumni, driver license, and so forth.
	private BinaryCodec certificate;

	private float rating; //everyone has a rate of 100 initially. When someone rate him/her at 5, he/she get a 1 score added up to the rate; if he/she gets a score of 3, his/her rate is deducted by 1.
	private int review; //how many passenger has reviewed this driver;
	private List<String> tags;	//NoPet, FrontSeat, SUV...

	private Car car;
	private boolean verified=false;


	public User() {
	}

}
