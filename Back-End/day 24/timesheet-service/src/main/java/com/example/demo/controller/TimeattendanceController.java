package com.example.demo.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Timeattendance;
import com.example.demo.repository.TimeattendanceRepository;
@RestController
@CrossOrigin("*")
@RequestMapping("attendance")
public class TimeattendanceController {
	@Autowired
	private TimeattendanceRepository timeattendanceRepository;
	 @GetMapping
	    public Iterable<Timeattendance> getAll(){
	        return timeattendanceRepository.findAll();
	    }
	    @GetMapping(value="/{currentPage}/{itemsPerPage}/{sortBy}/{sortOrder}")
	    public Page<Timeattendance> getData(@PathVariable(value="currentPage") int page,
	                                              @PathVariable(value= "itemsPerPage") int size,
	                                              @PathVariable(value= "sortBy") String field,
	                                              @PathVariable(value= "sortOrder") String direction) {
	    	Pageable paging;
	   if(direction.equals("asc")) {
	   paging=PageRequest.of(page-1, size).withSort(Sort.by(field));
	   }
	   else {
		   paging=PageRequest.of(page-1, size).withSort(Sort.by(field).descending());       
	   }
	       return  timeattendanceRepository.findAll(paging);
	    }
	    @PostMapping
	    public Timeattendance createEmployee(@RequestBody Timeattendance  event) {
	        return timeattendanceRepository.save(event);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Optional<Timeattendance>> getEmployeeById(@PathVariable  int id){
	        Optional<Timeattendance> event = timeattendanceRepository.findById(id);
	        return ResponseEntity.ok(event);
	    }

	    @PutMapping("/{id}")
		public Timeattendance updateDetails(@RequestBody Timeattendance  b)
		{
			System.out.println("Changes Made Have Been Successfully Updated");
			return timeattendanceRepository.save(b);		
		}
	    
	    @DeleteMapping("/{id}")
	    public String deleteDetails(@PathVariable int id) {
	    	timeattendanceRepository.deleteById(id);
	        return "Adminprodetail with ID " + id + " has been deleted";
	    }

	    @DeleteMapping
	    public String deleteAllDetails()
	    {
	    	timeattendanceRepository.deleteAll();
	    	return "All events has been deleted";
	    }
}
