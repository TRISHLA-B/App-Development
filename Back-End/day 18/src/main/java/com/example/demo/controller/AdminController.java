package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;




@RestController
@RequestMapping("/admin")

   


public class AdminController {
	 @Autowired
	    private AdminService adminService;

	    @GetMapping
	    public List<Admin> getAllInstructors() {
	        return adminService.getAllMember();
	    }

	    @GetMapping("/{id}")
	    public Admin getInstructorById(@PathVariable int id) {
	        Optional<Admin> instructor = adminService.getMemberById(id);
	        return instructor.orElse(null); // Return null if instructor is not found
	    }


	    @PutMapping("/{id}")
	    public Admin updateInstructor(@PathVariable int id, @RequestBody Admin updatedInstructor) {
	    	Admin updated = adminService.updateMember(id, updatedInstructor);
	        return updated;
	    }

	    @DeleteMapping("/{id}")
	    public void deleteInstructor(@PathVariable int id) {
	    	adminService.deleteInstructor(id);
	    }

}
