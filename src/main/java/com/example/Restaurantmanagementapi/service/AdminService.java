package com.example.Restaurantmanagementapi.service;

import com.example.Restaurantmanagementapi.model.Admin;
import com.example.Restaurantmanagementapi.model.User;
import com.example.Restaurantmanagementapi.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    IAdminRepository adminRepository;

    @Autowired
    UserService userService;

    public List<User> getAllUser() {

        return  userService.AllUser();
    }

    public List<Admin> getAllAdmin() {
      return adminRepository.findAll();
    }

    public Admin addAdmin(Admin admin) {
       return adminRepository.save(admin);
    }
}
