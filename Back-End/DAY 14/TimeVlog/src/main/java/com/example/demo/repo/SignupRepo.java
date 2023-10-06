package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SignupModel;

@Repository
public interface SignupRepo extends JpaRepository<SignupModel, Integer> {

}
