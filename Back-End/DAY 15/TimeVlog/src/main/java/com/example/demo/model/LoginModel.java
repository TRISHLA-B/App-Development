package com.example.demo.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.Data;

@Entity
@Table(name = "login")
public class LoginModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loginid;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	public int getLoginid() {
		return loginid;
	}

	public LoginModel() {
		super();
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(loginid, password, username);
	}

	public LoginModel(int loginid, String username, String password) {
		super();
		this.loginid = loginid;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginModel [loginid=" + loginid + ", username=" + username + ", password=" + password
				+ ", getLoginid()=" + getLoginid() + ", hashCode()=" + hashCode() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginModel other = (LoginModel) obj;
		return loginid == other.loginid && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
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

}
