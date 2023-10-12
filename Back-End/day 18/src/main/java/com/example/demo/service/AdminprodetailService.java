package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Adminprodetail;
import com.example.demo.repository.AdminprodetailRepository;


@Service
public class AdminprodetailService {
	@Autowired
    private AdminprodetailRepository adminprodetailRepository;

	public Page<Adminprodetail> SortingAndPaging(int page,int size,String field){
		Pageable paging=PageRequest.of(page, size).withSort(Sort.by(field));
		return adminprodetailRepository.findAll(paging);
	}
	public Page<Adminprodetail> Paging(int CurrentPage,int itemsPerPage){
		Pageable paging=PageRequest.of(CurrentPage,itemsPerPage);
		return adminprodetailRepository.findAll(paging);

	}
}
