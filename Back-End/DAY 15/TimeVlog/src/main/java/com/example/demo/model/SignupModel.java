package com.example.demo.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "signup")
public class SignupModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int signupid;

	public SignupModel(int signupid, String name, String email, String username, String password,
			String confirmpassword) {
		super();
		this.signupid = signupid;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}

	public SignupModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SignupModel [signupid=" + signupid + ", name=" + name + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", confirmpassword=" + confirmpassword + ", hashCode()=" + hashCode()
				+ ", getSignupid()=" + getSignupid() + ", getName()=" + getName() + ", getEmail()=" + getEmail()
				+ ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + ", getConfirmpassword()="
				+ getConfirmpassword() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Override
	public int hashCode() {
		return Objects.hash(confirmpassword, email, name, password, signupid, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignupModel other = (SignupModel) obj;
		return Objects.equals(confirmpassword, other.confirmpassword) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& signupid == other.signupid && Objects.equals(username, other.username);
	}

	@Column(name = "confirmpassword")
	private String confirmpassword;

	public int getSignupid() {
		return signupid;
	}

	public void setSignupid(int signupid) {
		this.signupid = signupid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

}
