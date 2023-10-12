package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TeamLeader;
import com.example.demo.repository.TeamLeaderRepository;



@Service
public class TeamLeaderService {
	@Autowired
    private  TeamLeaderRepository teamLeaderRepository;

    public TeamLeaderService(TeamLeaderRepository teamLeaderRepository) {
        this.teamLeaderRepository = teamLeaderRepository;
    }

    public List<TeamLeader> getAllTeamleader() {
        return teamLeaderRepository.findAll();
    }

    public Optional<TeamLeader> getTeamleaderById(int id) {
        return teamLeaderRepository.findById(id);
    }

    public TeamLeader createTeamleader(TeamLeader teamleader) {
        return teamLeaderRepository.save(teamleader);
    }

    public TeamLeader updateTeamleader(int id, TeamLeader updatedTeamleader) {
        Optional<TeamLeader> existingTeamleaderOptional = teamLeaderRepository.findById(id);

        if (existingTeamleaderOptional.isPresent()) {
        	TeamLeader existingTeamleader = existingTeamleaderOptional.get();
           
            existingTeamleader.setEmail(updatedTeamleader.getEmail());
            existingTeamleader.setPassword(updatedTeamleader.getPassword());
            

            return teamLeaderRepository.save(existingTeamleader);
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }

    public void deleteTeamleader(int id) {
        teamLeaderRepository.deleteById(id);
    }

}
