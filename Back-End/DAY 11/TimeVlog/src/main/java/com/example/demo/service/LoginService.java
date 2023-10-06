package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LoginModel;
import com.example.demo.model.SignupModel;
import com.example.demo.repo.LoginRepo;

@Service
public class LoginService {

	@Autowired
	private LoginRepo loginrepo;
	
	public List<LoginModel> getuserdetails(){
		return loginrepo.findAll();
	}
	
	public Optional<LoginModel> getuserByID(int loginid){
		return loginrepo.findById(loginid);
	}
	
	public void postDetails(LoginModel lm){
		loginrepo.save(lm);
	}
	
	public LoginModel putDetails(LoginModel lm) {
		return loginrepo.save(lm);
	}
	
	public void deletedetailsById(int loginid) {
		loginrepo.deleteById(loginid);
	}

	public Optional<SignupModel> findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean authLogin(LoginModel lm) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
