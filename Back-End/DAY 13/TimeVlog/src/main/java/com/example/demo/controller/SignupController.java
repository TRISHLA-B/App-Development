package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SignupModel;
import com.example.demo.service.SignupService;

@RestController
public class SignupController {

	@Autowired
	private SignupService ss;
	
	@GetMapping("/Signdetails")
	public List<SignupModel> getsignupDetails(){
		return ss.getsignupDetails();
	}
	
	@PostMapping("/postSignup")
	public void postsignup(@RequestBody SignupModel sm) {
		ss.postsignup(sm);
	}
	
}
