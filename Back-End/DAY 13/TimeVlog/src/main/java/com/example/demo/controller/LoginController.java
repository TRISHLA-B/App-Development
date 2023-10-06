 package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginModel;
import com.example.demo.model.SignupModel;
import com.example.demo.service.LoginService;
import com.example.demo.util.Jwtutil;

@RestController
public class LoginController {
	
	@Autowired
	public LoginService ls;
	
	@GetMapping("/getdetails")
	public List<LoginModel> getuserdetails()
	{
		return ls.getuserdetails();
	}
	
	@GetMapping("/getdetailsById/{id}")
	public Optional<LoginModel> getuserByID(@PathVariable int loginid){
		return ls.getuserByID(loginid);
	}
	
	@PostMapping("/postdetails")
	public void postDetails(@RequestBody LoginModel lm) {
		ls.postDetails(lm);
	}
	
	@PutMapping("/putdetails/{id}")
	public void putDetails(@PathVariable int loginid, @RequestBody LoginModel lm){
		lm.setLoginid(loginid);
		ls.putDetails(lm);
	}
	
	@DeleteMapping("/deleteByid/{id}")
	public void deleteById(@PathVariable int loginid){
		ls.deletedetailsById(loginid);
	}
	
	@PostMapping("/Token")
	public ResponseEntity<Boolean> l(@RequestBody LoginModel lm)
	{

		if(ls.authLogin(lm))
		{	
			Jwtutil tokenize = new Jwtutil();
//			System.out.println(tokenize.verify("eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzcmk7c3JpMzIxQCMiLCJpYXQiOjE2OTY0MTM4MzB9.WSdzxn51wFeP07ma7-1q4h6XNnUi22SEEzn05sTV1Yk");
			HttpHeaders responseHeaders = new HttpHeaders();
			
			responseHeaders.set("set-cookie" , ("session-id:"+tokenize.generateToken(lm)+";HttpOnly"));
			return ResponseEntity.ok().headers(responseHeaders).body(true);
		}
		
		return ResponseEntity.ok().body(false);
	}
		
		public boolean authLogin(LoginModel lm) {
			Optional<SignupModel> userOpt = ls.findByUsername(lm.getUsername());
			
			if (!userOpt.isPresent()) return false;
			if (!lm.getPassword().equals(userOpt.get().getPassword())) return false;

			return true;
		
		
	}
	
}
