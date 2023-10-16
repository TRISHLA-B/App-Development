package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Timeattendance;
import com.example.demo.repository.TimeattendanceRepository;


@Service
public class TimeattendanceService {
	@Autowired
    private TimeattendanceRepository timeattendanceRepository;

	public Page<Timeattendance> SortingAndPaging(int page,int size,String field){
		Pageable paging=PageRequest.of(page, size).withSort(Sort.by(field));
		return timeattendanceRepository.findAll(paging);
	}
	public Page<Timeattendance> Paging(int CurrentPage,int itemsPerPage){
		Pageable paging=PageRequest.of(CurrentPage,itemsPerPage);
		return timeattendanceRepository.findAll(paging);

	}

}
