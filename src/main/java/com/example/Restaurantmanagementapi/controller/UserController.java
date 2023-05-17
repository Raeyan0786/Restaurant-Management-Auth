package com.example.Restaurantmanagementapi.controller;

import com.example.Restaurantmanagementapi.dto.SignInInput;
import com.example.Restaurantmanagementapi.dto.SignInOutput;
import com.example.Restaurantmanagementapi.dto.SignUpInput;
import com.example.Restaurantmanagementapi.dto.SignUpOutput;
import com.example.Restaurantmanagementapi.model.User;
import com.example.Restaurantmanagementapi.service.TokenService;
import com.example.Restaurantmanagementapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserService UserService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/signup")
    public SignUpOutput createUser(@RequestBody SignUpInput signUpInput)
    {
        return UserService.signup(signUpInput);
    }

    @PostMapping("/signIn")
    public SignInOutput createUser(@RequestBody SignInInput signInInput)
    {
        return UserService.signIn(signInInput);
    }


    @GetMapping("/getAll")
    public List<User> getAllUsers()
    {
        return UserService.getAllUser();
    }



    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User restaurant)
    {
        return UserService.updateUser(id, restaurant);
    }

}
