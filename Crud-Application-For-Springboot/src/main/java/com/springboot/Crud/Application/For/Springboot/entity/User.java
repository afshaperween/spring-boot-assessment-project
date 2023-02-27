package com.springboot.Crud.Application.For.Springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name = "User_details")
public class User {

	@Id
	private Integer id;

	@Size(min = 5)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String name;

	@Column(unique = true)
	private String username;

	@Min(value = 10)
	private int mobile_number;

	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;

	@Size(min = 8, max = 10)
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
	private String password;

	public User() {
	}

	public User(int id, String name, String username, int mobile_number, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.mobile_number = mobile_number;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(int mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", mobile_number=" + mobile_number
				+ ", email=" + email + ", password=" + password + "]";
	}

}
