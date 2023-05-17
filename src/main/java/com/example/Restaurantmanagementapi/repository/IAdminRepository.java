package com.example.Restaurantmanagementapi.repository;

import com.example.Restaurantmanagementapi.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends JpaRepository<Admin,Long> {

}
