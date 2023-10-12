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

import com.example.demo.entity.Adminprodetail;
import com.example.demo.repository.AdminprodetailRepository;
@RestController
@CrossOrigin("*")
@RequestMapping("/auth/project")
public class AdminprodetailController {
	
	
		 @Autowired
		private AdminprodetailRepository adminprodetailRepository;
		 @GetMapping(value="/get")
		    public Iterable<Adminprodetail> getAll(){
		        return adminprodetailRepository.findAll();
		    }
		    @GetMapping(value="/{currentPage}/{itemsPerPage}/{sortBy}/{sortOrder}")
		    public Page<Adminprodetail> getData(@PathVariable(value="currentPage") int page,
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
		       return  adminprodetailRepository.findAll(paging);
		    }
		    @PostMapping
		    public Adminprodetail createEmployee(@RequestBody Adminprodetail  event) {
		        return adminprodetailRepository.save(event);
		    }

		    @GetMapping("/{id}")
		    public ResponseEntity<Optional<Adminprodetail>> getEmployeeById(@PathVariable  int id){
		        Optional<Adminprodetail> event = adminprodetailRepository.findById(id);
		        return ResponseEntity.ok(event);
		    }

		    @PutMapping("/{id}")
			public Adminprodetail updateDetails(@RequestBody Adminprodetail  b)
			{
				System.out.println("Changes Made Have Been Successfully Updated");
				return adminprodetailRepository.save(b);		
			}
		    @DeleteMapping("/{id}")
			public String deleteDetails(@PathVariable int id)
			{
		    	adminprodetailRepository.deleteById(id);
				return "Id : "+id+" is deleted";
			}
		    @DeleteMapping
		    public String deleteAllDetails()
		    {
		    	adminprodetailRepository.deleteAll();
		    	return "All events has been deleted";
		    }
	}

