package com.easyLearing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="users1")
public class User {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
@NotBlank(message="username not blank")
	private String userName;
@Email(message="invalid email format")
	private String email;
@Pattern(regexp="(^$|[0-9]{10})",message="invalid mobile number")
	private String mobileNum;
	@Max(30)
	@Min(18)
	private int age;
	@NotBlank(message="nationality not blank")
	private String nationality;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public User() {
		super();
	}
	public User(int userId, @NotBlank(message = "username not blank") String userName,
			@Email(message = "invalid email format") String email,
			@Pattern(regexp = "(^$|[0-9]{10})", message = "invalid mobile number") String mobileNum,
			@Max(18) @Min(30) int age, @NotBlank(message = "nationality not blank") String nationality) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.mobileNum = mobileNum;
		this.age = age;
		this.nationality = nationality;
	}
	
	
	
}
