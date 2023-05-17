package com.example.Restaurantmanagementapi.controller;

import com.example.Restaurantmanagementapi.model.Admin;
import com.example.Restaurantmanagementapi.model.User;
import com.example.Restaurantmanagementapi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping(value = "/AddAdmin")
    public Admin addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }


    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public List<User> getAllUser(){
        return adminService.getAllUser();
    }

    @RequestMapping(value = "/getAllAdmin",method = RequestMethod.GET)
    public List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();
    }

}
