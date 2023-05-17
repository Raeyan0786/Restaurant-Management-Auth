package com.example.Restaurantmanagementapi.repository;

import com.example.Restaurantmanagementapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {


    User findFirstByuserContact(String userContact);


    User findByUserId(Long userId);
}
