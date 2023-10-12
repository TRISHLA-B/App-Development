package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TeamLeader;
import com.example.demo.service.TeamLeaderService;



@CrossOrigin("*")
@RestController
@RequestMapping("/teamleader")
public class TeamLeaderController {
	@Autowired
    private  TeamLeaderService teamLeaderService;

    @GetMapping
    public List<TeamLeader> getAllStudents() {
        return teamLeaderService.getAllTeamleader();
    }

    @GetMapping("/{id}")
    public Optional<TeamLeader> getTeamleaderById(@PathVariable int id) {
        return teamLeaderService.getTeamleaderById(id);
    }

    @PostMapping
    public TeamLeader createStudent(@RequestBody TeamLeader student) {
        return teamLeaderService.createTeamleader(student);
    }

    @PutMapping("/{id}")
    public TeamLeader updateStudent(@PathVariable int id, @RequestBody TeamLeader updatedStudent) {
        return teamLeaderService.updateTeamleader(id, updatedStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteTeamleader(@PathVariable int id) {
        teamLeaderService.deleteTeamleader(id);

}
}
