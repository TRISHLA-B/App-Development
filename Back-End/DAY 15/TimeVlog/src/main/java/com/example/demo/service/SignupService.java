package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SignupModel;
import com.example.demo.repo.SignupRepo;

@Service
public class SignupService {
	
	@Autowired
	private SignupRepo sr;
	
	public List<SignupModel> getsignupDetails(){
		return sr.findAll();
	}
	
	public void postsignup(SignupModel sm) {
		sr.save(sm);
	}
}
