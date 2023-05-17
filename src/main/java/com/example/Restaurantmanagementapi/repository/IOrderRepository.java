package com.example.Restaurantmanagementapi.repository;

import com.example.Restaurantmanagementapi.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Orders, Long> {
}
