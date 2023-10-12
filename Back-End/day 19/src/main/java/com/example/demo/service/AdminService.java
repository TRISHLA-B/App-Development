package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;



import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

	@Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllMember() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getMemberById(int id) {
        return adminRepository.findById(id);
    }

    public Admin createInstructor(Admin Admin) {
        return adminRepository.save(Admin);
    }

    public Admin updateMember(int id, Admin updatedMember) {
        Optional<Admin> existingMemberOptional = adminRepository.findById(id);

        if (existingMemberOptional.isPresent()) {
          Admin existingMember = existingMemberOptional.get();
            existingMember.setEmail(updatedMember.getEmail());
            existingMember.setPassword(updatedMember.getPassword());

            return adminRepository.save(existingMember);
        } else {
            return null;
        }
    }

    public void deleteInstructor(int id) {
    	adminRepository.deleteById(id);
    }
}
