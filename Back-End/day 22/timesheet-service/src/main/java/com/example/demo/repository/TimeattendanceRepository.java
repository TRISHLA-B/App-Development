package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Timeattendance;

public interface TimeattendanceRepository extends JpaRepository<Timeattendance, Integer>{

}
