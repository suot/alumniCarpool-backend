package com.uwindsor.alumniCarpool.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.bson.codecs.BinaryCodec;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
@ToString
@Document(collection = "users")
public class User {
	@Id
	private String id;

	private String email;//Username
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	private BinaryCodec portrait; //GridFS+

	private List<String> roles; //All roles user registered
	private String currentRole; //The role user logged in with.

	private String almaMater; //User's alma mater
	private String studentId;
	private List<BinaryCodec> certificate; //Certificate of alumni, driver license, and so forth.

	private Integer rate;
	private List<String> tags;	//NoPet, FrontSeat, SUV...

	public User(String email, String password, String firstName, String lastName, String phone, BinaryCodec portrait, List<String> roles, String currentRole, String almaMater, String studentId, List<BinaryCodec> certificate, Integer rate, List<String> tags) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.portrait = portrait;
		this.roles = roles;
		this.currentRole = currentRole;
		this.almaMater = almaMater;
		this.studentId = studentId;
		this.certificate = certificate;
		this.rate = rate;
		this.tags = tags;
	}
}
