package com.example.Restaurantmanagementapi.repository;

import com.example.Restaurantmanagementapi.model.AuthenticationToken;
import com.example.Restaurantmanagementapi.model.Orders;
import com.example.Restaurantmanagementapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo  extends JpaRepository<AuthenticationToken, Long> {

    AuthenticationToken findByUser(User user);

    AuthenticationToken findFirstByToken(String token);

}
